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

    public void listMedicoEnfermeiro(){

        System.out.printf("Relação de Médicos e Enfermeiros que deram atendimento a Internação\n");

        System.out.printf("\n");

         System.out.printf("Paciente: %s\n", this.getPaciente().getNome());

        System.out.printf("Médicos:\n");
        for (Iterator<Medico> m = medicos.iterator(); m.hasNext();) {
            Medico medico = m.next();
            System.out.printf(" Nome: %s", medico.getNome());
            System.out.printf(" - Matrícula: %s", medico.getMatricula());
            System.out.printf(" - Especialidade: %s\n", medico.getEspecialidade());
        }

        System.out.printf("\n");

        System.out.printf("Enfermeiros:\n");
        for (Iterator<Enfermeiro> e = enfermeiros.iterator(); e.hasNext();) {
            Enfermeiro enfermeiro = e.next();
            System.out.printf(" Nome: %s", enfermeiro.getNome());
            System.out.printf(" - Matrícula: %s", enfermeiro.getMatricula());
            System.out.printf(" - Cargo: %s\n", enfermeiro.getCargo());
        }
    }

}
