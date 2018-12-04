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
public class Orientação {
    private String orientator;
    private String orientated;
    public void setOrientator(String professor) {
        this.orientator = professor;
    }
    public String getOrientator() {
        return orientator;
    }
    public void setOrientated(String student) {
        this.orientated = student;
    }
    public String getOrientated() {
        return orientated;
    }
    public Orientação(Scanner input) {
        System.out.println("Type the Orientator's name");
        setOrientator(input.nextLine());
        System.out.println("Type the student's name");
        setOrientated(input.nextLine());
    }
}
