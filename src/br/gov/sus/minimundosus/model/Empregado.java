/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public abstract class Empregado extends Pessoa{

    private int matricula;
    private static List<Empregado> empregados = new ArrayList<Empregado>();

    public Empregado(){}

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }



    public static void inserir(Empregado empregado){
        empregados.add(empregado);
    }

    public static Empregado getEmpregado(int matricula){
        for (Iterator<Empregado> it = empregados.iterator(); it.hasNext();) {
            Empregado empregado = it.next();
            if (empregado.getMatricula() == matricula)
                return empregado;
        }
        return null;
    }

    public static List<Empregado> list(){
        return empregados;
    }

  

}
