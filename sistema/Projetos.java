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
public class Projetos {
        private String name;
	private int state;
        /*
        *1 = In elaboration
        *2 = in progress
        *3 = Finished
        */
	private ArrayList <Colaborador> members;
        private ArrayList <Publicação> publications;
        private double money;
        private String agency;
        private GregorianCalendar start;
        private GregorianCalendar end;
        private String objective;
        private String description;
        public ArrayList<Colaborador> getMembers() {
            return members;
        }
        public int getPubSize() {
            return this.publications.size();
        }
        public int getMemberSize() {
            return members.size();
        }
        public void setStart(GregorianCalendar today) {
            this.start = today;
        }
        public void setEnd(GregorianCalendar today) {
            this.end = today;
        }
        public GregorianCalendar getEnd() {
            return end;
        }
        public void setObjective(String objective) {
            this.objective = objective;
        }
        public String getObjective () {
            return objective;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public String getDescription() {
            return description;
        }
        public int getState() {
            return state;
        }
        public void changeState(int new_state) {
            this.state = new_state;
        }
        public void setMoney(Double money) {
            this.money = money;
        }
        public double getMoney() {
            return money;
        }
        public String getName() {
            return name;
        }
        public Colaborador getMember(int index) {
            return members.get(index);
        }
        public Publicação getPub(int index) {
            return publications.get(index);
        }
        public void addPub(Publicação nova) {
            this.publications.add(nova);
        }
	public void setMember(Colaborador new_member) {
            if(this.state == 1) {
		this.members.add(new_member);
            }
            else {
                System.out.println("This project isn't in elaboration");
            }
        }
        public Colaborador SearchCollabs(String name , ArrayList<Colaborador> collabs) {
            int t = collabs.size();
            for(int i = 0 ; i< t ; i++) {
                if(collabs.get(i).getName().equals(name)) {
                    return collabs.get(i);
                }
            }
            return null;
        }
        public void addAllCollabs() {
            int t = this.members.size();
                for(int i = 0 ;i < t; i ++) {
                    this.members.get(i).addProject(this);
                }
        }
	public Projetos(Scanner input,ArrayList<Colaborador> collabs) {
                System.out.println("Type the project's name");
                this.name = input.nextLine();
                System.out.println("Type how many collaborators the project will have");
                int t = input.nextInt();
                input.nextLine();
                this.members = new ArrayList<>();
                boolean can = false;
                for(int i = 0 ;i < t ;i++) {
                    System.out.println("Type the "+(t-i)+" other members");
                    this.members.add(SearchCollabs(input.nextLine(),collabs));
                    if(collabs.get(this.members.size()-1).getType() == 1 ) {
                        can = true;
                    }
                        
                }
                if(can) {
                    this.state = 1;
                    System.out.println("Type the agency that will financiate the project");
                    this.agency = input.nextLine();
                    System.out.println("Type how many money will be used to financiate");
                    if(input.hasNextDouble()) {
                        setMoney(input.nextDouble());
                        input.nextLine();
                        System.out.println("Type the project's description");
                        setDescription(input.nextLine());
                        System.out.println("Type the project's objective");
                        setObjective(input.nextLine());
                        this.publications = new ArrayList<>();
                    }                  
                    else {
                        System.out.println("This isn't a valid number (try use a , instead a .)");
                    }
                }
                else {
                    System.out.println("you can't  create this project , because you don't have a professor");
                }
    }
        public int separe (int start,int end) {
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
            int pos = this.separe(start,end);
            orderPublications(start,pos-1);
            orderPublications(pos+1,end);
        }
    }
}
