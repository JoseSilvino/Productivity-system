/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodsys;
import java.util.*;
/**
 *
 * @author Neto
 */
public class Colaborador {
    private String name;
    private String e_mail;
    ArrayList<Projeto> projetos;
    ArrayList<Publicação> publicações;
    public String getName() {
        return name;
    }

    public String getE_mail() {
        return e_mail;
    }
    public static void OrderPublications(ArrayList<Publicação> pubs){
        Collections.sort(pubs, (Publicação first, Publicação second) -> {
            if(first.day.get(Calendar.YEAR) > second.day.get(Calendar.YEAR)) return -1;
            else if(first.day.get(Calendar.YEAR) < second.day.get(Calendar.YEAR)) return 1;
            else return 0;
        });
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    } 

    public ArrayList<Publicação> getPublicações() {
        return publicações;
    }

    public ArrayList<Projeto> getProjetos() {
        return projetos;
    }
    public  void OrderProjects(ArrayList<Projeto> projects) {
        Collections.sort(projects , new Comparator<Projeto>() {
        @Override
        public int  compare(Projeto first, Projeto second) {
                if(((Concluido)first).getEnd().get(Calendar.YEAR) > ((Concluido)second).getEnd().get(Calendar.YEAR)) return -1;
                else if (((Concluido)first).getEnd().get(Calendar.YEAR) < ((Concluido)second).getEnd().get(Calendar.YEAR)) return 1;
                else {
                    if(((Concluido)first).getEnd().get(Calendar.MONTH) > ((Concluido)second).getEnd().get(Calendar.MONTH)) return -1;
                    else if(((Concluido)first).getEnd().get(Calendar.MONTH) < ((Concluido)second).getEnd().get(Calendar.MONTH)) return 1;
                    else {
                        if(((Concluido)first).getEnd().get(Calendar.DAY_OF_MONTH) > ((Concluido)second).getEnd().get(Calendar.DAY_OF_MONTH)) return -1;
                        else if(((Concluido)first).getEnd().get(Calendar.DAY_OF_MONTH) < ((Concluido)second).getEnd().get(Calendar.DAY_OF_MONTH)) return 1;
                        else return 0;
                    }
                }
        }
    });
    }
    public ArrayList<Projeto> getProjetosFinished() {
        ArrayList<Projeto> proj = new ArrayList<>();
        for(int i = 0 ; i < this.projetos.size();i ++) {
            if(projetos.get(i).getClass().equals(Concluido.class)) {
                proj.add(projetos.get(i));
            }
        }
        return proj;
    }
    public Colaborador(String name,String e_mail) {
        this.name = name;
        this.e_mail = e_mail;
        this.projetos = new ArrayList<>();
        this.publicações = new ArrayList<>();
    }
    public void addPub(Publicação nova) {
        this.publicações.add(nova);
    }
    public void addProjeto(Projeto novo) {
        projetos.add(novo);
    }
    public void remvProjeto(Projeto proj) {
        int t = projetos.size();
        for(int i = 0 ; i <t ; i ++) {
            if(projetos.get(i).equals(proj)) {
                projetos.remove(i);
            }
        }
    }
    public String ProjetosStr() {
        String s = "";
        ArrayList<Projeto> desen = new ArrayList<>();
        ArrayList<Projeto> conc = new ArrayList<>();
        ArrayList<Projeto> and = new ArrayList<>();
        for(int i = 0 ; i < this.projetos.size() ; i ++) {
            if(projetos.get(i).getClass().equals(Desenvolvimento.class)) {
                desen.add((Desenvolvimento)projetos.get(i));
            }
            else if(projetos.get(i).getClass().equals(Andamento.class)) {
                and.add((Andamento)projetos.get(i));
            }
            else if(projetos.get(i).getClass().equals(Concluido.class)) {
                conc.add((Concluido)projetos.get(i));
            }
        }
        this.OrderProjects(conc);
        s = s + "-Em desenvolvimento : \n";
        for(int i = 0 ; i < desen.size(); i ++) {
            s = s + desen.get(i).toString() + "\n";
        }
        s = s +"-Em andamento :\n";
        for(int i = 0 ; i < and.size() ;  i++) {
            s = s + and.get(i).toString() + "\n";
        }
        s = s + "-Concluidos :\n";
        for(int i = 0 ; i < conc.size() ;i ++) {
            s = s + conc.get(i).toString() + "\n";
        }
        return s;
    }
    public String PublStr() {
        String s = "";
        return s;
    }
    @Override
    public String toString() {
        return "Nome :"+this.name + " E-mail: " + e_mail +"\n" + "Projetos : \n"+this.ProjetosStr() + PublStr();
    }
}
