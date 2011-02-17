/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.entity;

/**
 *
 * @author Ricardo
 */
public abstract class Empregado extends Pessoa{

    private int matricula;

    public Empregado(){}

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }


}
