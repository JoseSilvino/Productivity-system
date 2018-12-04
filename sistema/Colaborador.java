/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

/**
 *
 * @author Neto
 */
import java.util.*;
public class Colaborador {
    private String name;
    private int type;
    private String e_mail;
      /*type 1 : professor
      type 2 : graduation studend
      type 3 : mastering student
      type 4 : PhD studend
      type 5 : researchers */
    private ArrayList<String> projects;
    private ArrayList <Publicação> publications;
    private ArrayList<Orientação> orientations;
    public void addPublication(Publicação nova) {
        this.publications.add(nova);
    }
    public Publicação getPublication(int index) {
        return publications.get(index);
    }
    public void orderProjects(ArrayList<Projetos> projects) {
        
    }
    public int separe (int start,int end) {
        GregorianCalendar gc = this.publications.get(start).getDay();
        int pivot = gc.get(GregorianCalendar.YEAR);
        int i = start, f = end;
        while(i<=f) {
            if(this.publications.get(i).getDay().get(GregorianCalendar.YEAR) <= pivot) {
                i++;
            }
            else if (pivot < this.publications.get(f).getDay().get(GregorianCalendar.YEAR)) {
                f--;
            }
            else {
                Publicação aux =  this.publications.get(i);
                publications.set(i,publications.get(f));
                publications.set(f,aux);
                i++;
                f--;
            }
                
        }
        return f;
    }
    public void orderPublications(int start,int end) {
        if(start<end) {
            int pos = this.separe(start,end);
            orderPublications(start,pos-1);
            orderPublications(pos+1,end);
        }
    }
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
    public String getE_mail() {
        return e_mail;
    }
    public void addOrientation(Orientação student) {
        if(this.type == 1) {
            this.orientations.add(student);
        }
        else {
            System.err.println("This Collaborator isn't a professor");
        }
    }
    public Orientação getOrientation(int index) {
        if(this.type == 1) {
            return orientations.get(index);
        }
        else {
            System.err.println("This Collaborator isn't a professor");
            return null;
        }
    }
    public void setName(String name) {
        this.name = name ;
    }
    public String getName() {
        return name ;
    }
    public void setType (int type) {
        this.type = type ;
    }
    public int getType () {
        return type ;
    }
    public Colaborador(Scanner input) {
        System.out.println("Type the collaborator's name");
        setName(input.nextLine());
        System.out.println("Type the collaborator's e_mail");
        setE_mail(input.nextLine());
        System.out.println("type 1 : professor\n"+"type 2 : graduation studend\n"+"type 3 : mastering student\n"+"type 4 : PhD studend\n"+"type 5 : researchers");
        if(input.hasNextInt()) {
        setType(input.nextInt());
        input.nextLine();
        this.projects = new ArrayList<>();
        this.publications = new ArrayList<>();
        if(this.type == 1) {
            this.orientations = new ArrayList<>();
        }
        }
        else{
            System.out.println("Error , number missing");
        }
    }

}