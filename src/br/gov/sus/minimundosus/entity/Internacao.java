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
    private Paciente paciente;
    private Date dataInicio;
    private Date dataFim;

    private List<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();
    private List<Medico> medicos = new ArrayList<Medico>();

    public Internacao(){}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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

    public List<Enfermeiro> getEnfermeiros() {
        return enfermeiros;
    }

    public void setEnfermeiros(List<Enfermeiro> enfermeiros) {
        this.enfermeiros = enfermeiros;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }




}
