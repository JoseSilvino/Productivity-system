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

public class Concluido extends Projeto {
    private ArrayList<Publicação> publications;
    private java.util.Calendar start;
    private java.util.Calendar end;

    public Calendar getEnd() {
        return end;
    }
    
    public String OrderPub() {
        Colaborador.OrderPublications(publications);
        String s = "";
        for(int i = 0 ; i < publications.size();i++) {
            s = s + publications.get(i) + "\n";
        }
        return s;
    }
    @Override
    public String toString() {
        return super.toString() + OrderPub(); //To change body of generated methods, choose Tools | Templates.
    }
    public Concluido(String name, double money, String agency, String objective, String description,ArrayList<Colaborador> colabs,ArrayList<Publicação> pubs,java.util.Calendar today,java.util.Calendar start) {
        super(name, money, agency, objective, description,colabs);
        this.publications = pubs;
        this.end = today;
        this.start = start;
    }
    
}
