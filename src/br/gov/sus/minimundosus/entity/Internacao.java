/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class Internacao {

    private int codigo;
    private Date dataInicio;
    private Date dataFim;
    List<Enfermeira> enfermeiros = new ArrayList<Enfermeira>();
    List<Medico> medicos = new ArrayList<Medico>();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public List<Enfermeira> getEnfermeiros() {
        return enfermeiros;
    }

    public void setEnfermeiros(List<Enfermeira> enfermeiros) {
        this.enfermeiros = enfermeiros;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }




}
