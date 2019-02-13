/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodsys;
import java.util.ArrayList;
/**
 *
 * @author Neto
 */
public class Desenvolvimento extends Projeto {
    public void addColaborador(Colaborador novo) {
        this.collabs.add(novo);
    }
    public void removeColaborador(int index) {
        this.collabs.remove(index);
    }
    public boolean contem(String nome) {
        int t = collabs.size();
        for(int i = 0 ; i < t ; i ++) {
            if(collabs.get(i).getName().equals(nome)) {
                return true;
            }
        }
        return false;
    }
    public int indice(String nome) {
        int t = collabs.size();
        for(int i = 0 ; i < t ; i ++) {
            if(collabs.get(i).getName().equals(nome)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return  super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean paraAndamento() {
        int t = collabs.size();
        for(int i = 0 ; i < t ; i ++) {
            if(collabs.get(i).getClass().equals(AlunoDeGraduação.class)) {
                if(((AlunoDeGraduação)collabs.get(i)).estAnd()) {
                return false;
                }
            }
        }
        return true;
    }
    public Desenvolvimento(String name, double money, String agency, String objective, String description,ArrayList<Colaborador>colabs) {
        super(name, money, agency, objective, description,colabs);
    }
    
}
