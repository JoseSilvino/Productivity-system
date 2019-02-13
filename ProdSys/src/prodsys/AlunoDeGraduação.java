/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodsys;

/**
 *
 * @author Neto
 */
public class AlunoDeGraduação extends Colaborador {
    public boolean estAnd() {
        int t = this.projetos.size();
        for(int i = 0 ; i <t;i++) {
            if(projetos.get(i).getClass().equals(Andamento.class)) {
                return true;
            }
        }
        return false;
    }
    public AlunoDeGraduação( String name, String e_mail) {
        super(name, e_mail);
    }
}
