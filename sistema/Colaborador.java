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
    private ArrayList<Projetos> projects;
    private ArrayList <Publicação> publications;
    private ArrayList<Orientação> orientations;
    public void addProject(Projetos project) {
        this.projects.add(project);
    }
    public Projetos getProject(int index) {
        return projects.get(index);
    }
    public ArrayList<Projetos> getProjects() {
        return projects;
    }        
    public void addPublication(Publicação nova) {
        this.publications.add(nova);
    }
    public Publicação getPublication(int index) {
        return publications.get(index);
    }
    public int separe_pub (int start,int end) {
        GregorianCalendar gc = this.publications.get(start).getDay();
        int pivot = gc.get(GregorianCalendar.YEAR);
        int i = start, f = end;
        while(i<=f) {
            if(this.publications.get(i).getDay().get(GregorianCalendar.YEAR) >= pivot) {
                i++;
            }
            else if (pivot > this.publications.get(f).getDay().get(GregorianCalendar.YEAR)) {
                f--;
            }
            else {
                Publicação aux =  this.publications.get(i);
                this.publications.set(i,publications.get(f));
                this.publications.set(f,aux);
                i++;
                f--;
            }
                
        }
        this.publications.set(start,publications.get(f));
        this.publications.set(f,this.publications.get(start));
        return f;
    }
    public void orderPublications(int start,int end) {
        if(start<end) {
            int pos = this.separe_pub(start,end);
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
    public void PrintC() {
        System.out.println("Name : "+ this.name);
        int t = this.projects.size();
        Projetos[] one,two,three;
        one = new Projetos[t];
        two = new Projetos[t];
        three = new Projetos[t];
        int first,second,third;
        first = second = third = 0;
        for(int i = 0 ; i < t ; i ++) {
            switch (this.projects.get(i).getState()) {
                case 1:
                    one[first] = this.projects.get(i);
                    first ++;
                    break;
                case 2:
                    two[second] = this.projects.get(i);
                    second++;
                    break;
                case 3:
                    three[third] = this.projects.get(i);
                    third ++ ;
                    break;
                default:
                    break;
            }
        }
        System.out.println("In elaboration projects :");
        for(int i = 0 ; i < first ; i++) {
            System.out.println(one[i].getName());
        }
        System.out.println("In progress projects :");
        for(int i = 0 ; i < second ; i ++) {
            System.out.println(two[i].getName());
        }
        this.quicksort(three,0,third-1);
        System.out.println("Complete projects");
        for(int i = 0 ; i < third;i++) {
            System.out.println(three[i].getName());
        }
        System.out.println("Publications");
        int p = this.publications.size();
        this.orderPublications(0,p-1);
        for(int i = 0 ; i < p ; i ++) {
            System.out.println(this.publications.get(i).getTitle());
        }
        if(this.type == 1) {
            System.out.println("Orientations");
            int o = this.orientations.size();
            for(int i = 0 ; i < o ; i ++) {
                System.out.println(this.orientations.get(i).getOrientated());
            }
        }
    }
    public void quicksort(Projetos [] projects,int start,int end) {
        if(start<end) {
            int pos = this.partition(projects,start,end);
            quicksort(projects,start,pos-1);
            quicksort(projects,pos+1,end);   
        }
    }
    public int partition(Projetos [] projects,int start,int end) {
            GregorianCalendar gc = projects[start].getEnd();
        int pivot = gc.get(GregorianCalendar.YEAR);
        int i = start, f = end;
        while(i<=f) {
            if(projects[i].getEnd().get(GregorianCalendar.YEAR) >= pivot) {
                i++;
            }
            else if (pivot > projects[f].getEnd().get(GregorianCalendar.YEAR)) {
                f--;
            }
            else {
                Projetos aux =  projects[i];
                projects[i] = projects[f];
                projects[f] = aux;
                i++;
                f--;
            }
                
        }
        this.publications.set(start,publications.get(f));
        this.publications.set(f,this.publications.get(start));
        return f;
    }
}