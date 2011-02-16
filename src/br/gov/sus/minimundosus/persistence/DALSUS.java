/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.persistence;

import br.gov.sus.minimundosus.entity.*;

/**
 *
 * @author Ricardo
 */
public class DALSUS {

    private Hospital[] hospital;
    private Enfermeira[] enfermeira;
    private Medico[] medico;
    private Paciente[] paciente;
    private Internacao[] internacao;

    public Enfermeira[] getEnfermeira() {
        return enfermeira;
    }

    public void setEnfermeira(Enfermeira[] enfermeira) {
        this.enfermeira = enfermeira;
    }

    public Hospital[] getHospital() {
        return hospital;
    }

    public void setHospital(Hospital[] hospital) {
        this.hospital = hospital;
    }

    public Internacao[] getInternacao() {
        return internacao;
    }

    public void setInternacao(Internacao[] internacao) {
        this.internacao = internacao;
    }

    public Medico[] getMedico() {
        return medico;
    }

    public void setMedico(Medico[] medico) {
        this.medico = medico;
    }

    public Paciente[] getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente[] paciente) {
        this.paciente = paciente;
    }

    
}
