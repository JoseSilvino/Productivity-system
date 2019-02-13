/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodsys;
import java.util.*;
/**
 *
 * @author Neto
 */
public class Professor  extends Colaborador{
    private final ArrayList<String> orientations;
    public boolean addOrientation(String orient) {
        return orientations.add(orient);
    }
    public String getOrientation(int index) {
        return orientations.get(index);
    }
    public int OrientationSize() {
        return orientations.size();
    }
    public Professor(String name,String e_mail) {
        super(name,e_mail);
        orientations = new ArrayList<>();
    }
    @Override
    public String toString() {
        String s = "Orientações : ";
        for(int i = 0 ; i < orientations.size();i++) {
            s = s + orientations.get(i);
        }
        return super.toString() + s;
    }
}
