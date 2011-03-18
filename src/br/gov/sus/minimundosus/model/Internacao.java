/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
    private Medico medicoResponsavel;

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }
    private static List<Internacao> internacoes = new ArrayList<Internacao>();

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

    public static void inserir(Internacao Internacao){
        internacoes.add(Internacao);
    }

    public static Internacao getInternacao(int codigo){
        for (Iterator<Internacao> it = internacoes.iterator(); it.hasNext();) {
            Internacao internacao = it.next();
            if (internacao.getCodigo() == codigo)
                return internacao;
        }
        return null;
    }

    public static List<Internacao> list(){
        return internacoes;
    }

    public void incluirInternacao(Internacao internacao, Hospital hospital){
        internacoes.add(internacao);
        hospital.getInternacoes().add(internacao);
    }

    public void incluirMedicoInternacao(Medico medico){
        medicos.add(medico);
    }

    public void incluirEnfermeiroInternacao(Enfermeiro enfermeiro){
        enfermeiros.add(enfermeiro);
    }

    public List<Empregado> listMedicoEnfermeiro(){

        List<Empregado> listEmpregado = new ArrayList<Empregado>();

        for (Iterator<Medico> m = medicos.iterator(); m.hasNext();) {
            Medico medico = m.next();
            listEmpregado.add(medico);
        }

        for (Iterator<Enfermeiro> e = enfermeiros.iterator(); e.hasNext();) {
            Enfermeiro enfermeiro = e.next();
            listEmpregado.add(enfermeiro);
        }
        
        return listEmpregado;
    }

    public static List<Internacao> listInternacaoPaciente(Paciente paciente){
        List<Internacao> internacaoPaciente = new ArrayList<Internacao>();
        for (Iterator<Internacao> it = internacoes.iterator(); it.hasNext();) {
            Internacao internacao = it.next();
            if (internacao.getPaciente().equals(paciente)) {
                internacaoPaciente.add(internacao);
            }
        }
        return internacaoPaciente;
    }
}
