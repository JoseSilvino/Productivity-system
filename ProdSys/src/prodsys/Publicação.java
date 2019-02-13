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
public class Publicação {
    private String Content;
    private ArrayList<String> authors;
    public java.util.Calendar day;
    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getContent() {
        return Content;
    }

    @Override
    public String toString() {
        return Content + " " + authors;
    }

    public void setAuthor(String author) {
        this.authors.add(author);
    }
    public String getAuthor(int i) {
        return authors.get(i);
    }
    public int AuthorsNumber() {
        return authors.size();
    }
    public Publicação (String content,ArrayList<String>authors) {
        this.Content = content;
        this.authors = authors;
        this.day = java.util.Calendar.getInstance();
    }
    
}
