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

    private String codigoSeguroSocial;
    private Internacao[] internacao;

    public String getCodigoSeguroSocial() {
        return codigoSeguroSocial;
    }

    public void setCodigoSeguroSocial(String codigoSeguroSocial) {
        this.codigoSeguroSocial = codigoSeguroSocial;
    }

    public Internacao[] getInternacao() {
        return internacao;
    }

    public void setInternacao(Internacao[] internacao) {
        this.internacao = internacao;
    }

}
