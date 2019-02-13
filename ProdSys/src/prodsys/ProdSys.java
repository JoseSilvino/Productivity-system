/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodsys;
import java.util.*;
import my.GUI.ProdSysGui;
/**
 *
 * @author Neto
 */
public class ProdSys {
    /**
     * @param args the command line arguments
     * Creates the project,collab and publication hashmaps
     * and calls the Graphic User Inteface
     */
    public static void main(String[] args) {
        ArrayList<Projeto> projects = new ArrayList<>();
        HashMap<String,Colaborador>collabs = new HashMap<>();
        ArrayList<Publicação> publications = new ArrayList<>();
        ProdSysGui gui = new ProdSysGui();
        gui.collabs = collabs;
        gui.projects = projects;
        gui.publications = publications;
        gui.orientations = new ArrayList<>();
        gui.setVisible(true);
        // TODO code application logic here
    }
    
}
