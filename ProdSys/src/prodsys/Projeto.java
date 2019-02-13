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
public class Projeto {
    private String name;
    protected final ArrayList<Colaborador> collabs;
    private double money;
    private String agency;
    private String objective;
    private String description;
    @Override
    public String toString() {
        String s = "";
        int t = collabs.size();
        for(int i = 0 ; i <t ; i ++) {
            s = s  + collabs.get(i).getName()+"\n";
        }
        return name + " " + description + " " + objective+"\n" + s + "\n";
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }
    public String getObjective() {
        return objective;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }
    public String getAgency() {
        return agency;
    }

    public Colaborador getCollab(int i) {
        return collabs.get(i);
    }
    public void setCollab(Colaborador collab) {
        this.collabs.add(collab);
    }
    public String getDescription() {
        return description;
    }
    public int CollabSize() {
        return collabs.size();
    }
    public ArrayList<Colaborador> getCollabs() {
        return collabs;
    }
    /**
     *
     * @param name
     * @param money
     * @param agency
     * @param objective
     * @param description
     * @param colabs
     */
    public Projeto(String name, double money, String agency, String objective, String description ,ArrayList<Colaborador> colabs) {
        this.name = name;
        this.collabs = colabs;
        this.money = money;
        this.agency = agency;
        this.objective = objective;
        this.description = description;
    }
    
    
}
