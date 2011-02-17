/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.entity;

/**
 *
 * @author Ricardo
 */
public class Paciente extends Pessoa{

    private int codigoSeguroSocial;

    public Paciente(){}

    public int getCodigoSeguroSocial() {
        return codigoSeguroSocial;
    }

    public void setCodigoSeguroSocial(int codigoSeguroSocial) {
        this.codigoSeguroSocial = codigoSeguroSocial;
    }



}
