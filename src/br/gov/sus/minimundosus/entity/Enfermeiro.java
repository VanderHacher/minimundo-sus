/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.entity;

/**
 *
 * @author Ricardo
 */
public class Enfermeiro extends Empregado{

    private String cargo;

    public Enfermeiro(){}

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
}
