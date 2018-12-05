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
public class Laboratório {
    private ArrayList <Projetos> projects;
    private ArrayList <Colaborador> collaborators;
    private ArrayList <Publicação> publications;
    private ArrayList <Orientação> orientations;
    private GregorianCalendar today;
    public void addProject(Projetos newp) {
        this.projects.add(newp);
    }
    public void addCollab(Colaborador newc) {
        this.collaborators.add(newc);
    }
    public void addPub(Publicação newp) {
        this.publications.add(newp);
    }
    public int SearchProject(String name) {
        int t = this.projects.size();
        for(int i =0 ; i<t ; i++) {
            if(this.projects.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public int SearchCollab(String name) {
        int t = this.collaborators.size(); 
        for ( int i = 0 ; i < t ; i ++ ) {
            if(this.collaborators.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public void ProjectsDecision(Scanner input) { 
        System.out.println("Type the project's name");
        int index = SearchProject(input.nextLine());
        if(index == -1) {
            System.out.println("This project doesn't exist");
        }
        else {
            System.out.println("Type 1 to add a collaborator(only in elaboration process)\n" + "Type 2 to change the project's state\n" + "Type 3 to add a associated publication to the project (only if the project is in progress)\n");
            if(input.hasNextInt()) {
                int dec = input.nextInt();
                input.nextLine();
                switch (dec) {
                    case 1:
                        if(this.projects.get(index).getState() == 1) {
                            int collab = SearchCollab(input.nextLine());
                            this.projects.get(index).setMember(this.collaborators.get(collab));
                            this.collaborators.get(collab).addProject(this.projects.get(index));
                        }   break;
                    case 2:
                        if(!haveMemberInBoth(index)&&this.projects.get(index).getState()==1) {
                            this.projects.get(index).changeState(2);
                        }
                        else if(this.projects.get(index).getState()==2) {
                            if(this.projects.get(index).getPubSize()!=0) {
                                this.projects.get(index).changeState(3);
                                this.projects.get(index).setEnd(this.today);
                            }
                        }
                        break;
                        case(3) :
                            if(2 == this.projects.get(index).getState()) {
                                Publicação new_pub = new Publicação(input,this.projects.get(index).getName());
                                this.projects.get(index).addPub(new_pub);
                                this.publications.add(new_pub);
                            }
                            break;
                    default:
                        System.out.println("You typed a invalid character");
                        break;
                }
            }
        }
    }
    public int Search_By_State(int state) {
        int t = this.projects.size(),number = 0;
        for(int i =0 ;i<t;i++) {
            if(this.projects.get(i).getState() == state) {
                number++;
            }      
        }
        return number;
    }
    public void Print_Relatory() {
        System.out.println(+this.collaborators.size()+" collaborators");
        System.out.println(Search_By_State(1)+" In elaboration projects");
        System.out.println(Search_By_State(2)+" in progress projects");
        System.out.println(Search_By_State(3)+" finished projects");
        System.out.println(this.projects.size()+" projects");
        System.out.println(this.publications.size()+" publications");
        System.out.println(this.orientations.size()+" orientations");
    }
    public Laboratório (Scanner input) {
        System.out.println("Type 0 to close the program\n"+"Type 1 to add a collaborator\n"+"Type 2 to add a project\n"+"Type 3 to add a publication(only the ones not related to a project)\n"+"Type 4 to add a orientation\n"+"Type 5 to change a project's state/edit project(if the project is in elaboration)\n"+"Type 6 to Consult by  Collaborator/Project\n"+"Type 7 to Lab's production relatory\n");
        if(input.hasNextInt()) {
            this.collaborators = new ArrayList<>();
            this.projects = new ArrayList<>();
            this.publications = new ArrayList<>();
            this.orientations = new ArrayList<>();
            this.today = new GregorianCalendar();
            while(true) {
          int dec = input.nextInt();
          input.nextLine();
          if(dec == 1) {
              addCollab(new Colaborador(input));
          }
          else if(dec ==  2) {
              Projetos new_project = new Projetos(input,this.collaborators);
              new_project.setStart(this.today);
              addProject(new_project);
              new_project.addAllCollabs();
          }
          else if(dec == 3) {
            Publicação pub = new Publicação(input,"0");
            pub.setDay(this.today);
              addPub(pub);
          }
          else if(dec == 4) {
              this.orientations.add(new Orientação(input));
              int s = this.orientations.size()-1;
              int index = -1 ,t = this.collaborators.size();
              for(int i = 0;i < t;i ++) {
                  if(this.collaborators.get(i).getName().equals(this.orientations.get(s).getOrientator())) {
                      index = i;
                      break;
                  }
              }
              if(index != -1) { 
              this.collaborators.get(index).addOrientation(this.orientations.get(s));
              }
          }
          else if(dec == 5) {
              ProjectsDecision(input);
            }
          else if(dec == 6) {
              System.out.println("Type 1 to search by collaborator\nType 2 to search by project");
              int new_dec = input.nextInt();
              input.nextLine();
              if(new_dec == 1) {
                  System.out.println("Type the collaborator's name");
                  String collaborator = input.nextLine();
                  int collaborator_index = SearchCollab(collaborator);
                  this.collaborators.get(collaborator_index).PrintC();
              }
              if(new_dec == 2) {
                  System.out.println("Type the project's name");
                  String project = input.nextLine();
                  int index = SearchProject(project);
                  Projetos now = this.projects.get(index);
                  System.out.println("Project's name : "+now.getName());
                  int t = now.getMemberSize();
                  System.out.println("Members : ");
                  for(int i = 0 ; i < t ; i ++) {
                  System.out.println(now.getMember(i).getName());
                  }
                  System.out.println("");
                  int tp = now.getPubSize();
                  now.orderPublications(0,tp-1);
                  System.out.println("Publications");
                  for(int i = 0 ; i < tp ; i ++) {
                      System.out.println(now.getPub(i));
                  }
              }
                  
          }
          else if(dec == 7) {
              Print_Relatory();
              this.today.add(GregorianCalendar.DAY_OF_MONTH,1);
          }
          else {
              break;
          }
          System.out.println("Type 0 to close the program\n"+"Type 1 to add a collaborator\n"+"Type 2 to add a project\n"+"Type 3 to add a publication(only the ones not related to a project)\n"+"Type 4 to add a orientation\n"+"Type 5 to change a project's state/edit project(if the project is in elaboration)\n"+"Type 6 to Consult by  Collaborator/Project\n"+"Type 7 to Lab's production relatory\n");
        }
      }
    }
    public boolean haveMemberInBoth(int index) {
        Projetos Searching = this.projects.get(index);
        int SearchingSz = Searching.getMemberSize();
        int t = this.projects.size();
        for(int i = 0 ; i < t ; i++ ) {
            if(this.projects.get(i).getState() == 2 ) {
                Projetos aux = this.projects.get(i); 
                int tamAux = aux.getMemberSize();
                for(int j = 0 ; j < tamAux ; j++) {
                    for(int k = 0 ; k < SearchingSz ; k ++) {
                        if(aux.getMember(j).getName().equals(Searching.getMember(k).getName())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}