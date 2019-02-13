/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodsys;
import java.util.ArrayList;
import java.util.Calendar;
/**
 *
 * @author Neto
 */
public class Andamento extends Projeto {
    private final ArrayList<Publicação> publications;
    private java.util.Calendar start;
    public void addPub(Publicação nova) {
        publications.add(nova);
    }
    public void removePub(int index) {
        publications.remove(index);
    }
    public int getPubSize() {
        return publications.size();
    }
    public ArrayList<Publicação> getPubs() {
        return publications;
    }

    public Calendar getStart() {
        return start;
    }
    public String OrderPub() {
        String s = "";
        Colaborador.OrderPublications(publications);
        for(int i = 0 ; i < publications.size() ;i++) {
        s = s + publications.get(i) + "\n";
        }
        return s;
    }
    @Override
    public String toString() {
        return super.toString() + OrderPub(); //To change body of generated methods, choose Tools | Templates.
    }
    public Andamento(String name, double money, String agency, String objective, String description,ArrayList<Colaborador> colabs, java.util.Calendar start) {
        super(name, money, agency, objective, description,colabs);
        publications = new ArrayList<>();
        this.start = start;
    }
    
}
