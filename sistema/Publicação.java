/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;
import java.util.*;
/**
 *
 * @author Neto
 */
public class Publicação {
    private String title;
    private String conference;
    private ArrayList<String> authors;
    private String associated_project;//maybe doesn't have
    private GregorianCalendar  publication;
    public void setTitle (String title) {
        this.title = title;
    }
    public String getTitle () {
        return title;
    }
    public void setConference (String conference) {
        this.conference = conference;
    }
    public String getConference() {
        return  conference;
    }
    public void addAuthor(String authorName) {
        this.authors.add(authorName);
    }
    public String getAuthor(int index) {
        return authors.get(index);
    }
    public void setAssociated(String project_name) {
        this.associated_project = project_name;
    }
    public String getAssociated() {
        return associated_project;
    }
    public void setDay() {
        this.publication = new GregorianCalendar();
    }
    public GregorianCalendar getDay() {
        return publication;
    }
    public Publicação (Scanner input,String related) {
        System.out.println("Type the publication's name");
        setTitle(input.nextLine());
        System.out.println("Type how many authors '"+this.title +"' have");
        int t = input.nextInt();
        input.nextLine();
        System.out.println("Type the authors' names");
        this.authors = new ArrayList<>();
        for(int i = 0 ; i<t ; i ++) {
            System.out.println(t-i+" missing");
            addAuthor(input.nextLine()); 
        }
        setDay();
        System.out.println("Type the conference this project was publicated");
        setConference(input.nextLine());
        if(related.equals("0")) {
            setAssociated("None");
        }
        else {
            setAssociated(related);
        }
    }
}
