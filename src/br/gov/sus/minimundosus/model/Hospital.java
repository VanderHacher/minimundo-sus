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
public class Hospital {

    private int codigo;
    private String nome;
    private String endereco;
    private List<Empregado> empregados = new ArrayList<Empregado>();
    private List<Internacao> internacoes = new ArrayList<Internacao>();
    private static List<Hospital> hospitais = new ArrayList<Hospital>();

    public Hospital(){}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Empregado> getEmpregados() {
        return empregados;
    }

    public void setEmpregados(List<Empregado> empregados) {
        this.empregados = empregados;
    }

    public List<Internacao> getInternacoes() {
        return internacoes;
    }

    public void setInternacoes(List<Internacao> internacoes) {
        this.internacoes = internacoes;
    }

    public static void inserir(Hospital hospital){
        hospitais.add(hospital);
    }

    public static Hospital getHospital(int codigo){
        for (Iterator<Hospital> it = hospitais.iterator(); it.hasNext();) {
            Hospital hospital = it.next();
            if (hospital.getCodigo() == codigo)
                return hospital;
        }
        return null;
    }

    public static List<Hospital> list(){
        return hospitais;
    }

    public List<Empregado> listMedicoEnfermeiro(){
        return empregados;
    }

    public List<Paciente> listPacienteInternado(){
        List<Paciente> pacientes = new ArrayList<Paciente>();
        for (Iterator<Internacao> e = internacoes.iterator(); e.hasNext();) {
               Internacao internacao = e.next();
               pacientes.add(internacao.getPaciente());
        }
        return pacientes;
    }

    public static void vincularEmpregadoHospital(Empregado empregado, Hospital hospital) throws Exception{

        int qtdeVinculo = 0;

        for (Iterator<Hospital> h = Hospital.list().iterator(); h.hasNext();) {
            Hospital hosp = h.next();

            for (Iterator<Empregado> e = hosp.getEmpregados().iterator(); e.hasNext();) {
               Empregado emp = e.next();
               //Verifica se já existe a associação
               if (hosp.equals(hospital) && emp.equals(empregado)){
                    throw new Exception("Empregado já associado a este hospital");
               }

               //Contabiliza se já existe 3 vínculos com hospitais
               if (emp.equals(empregado)){
                   qtdeVinculo++;

                   if (qtdeVinculo == 3)
                        throw new Exception("Empregado pode ter no máximo 3 vínculos");
               }
            }
        }

        hospital.getEmpregados().add(empregado);
    }

    public void listHospitalEmpregadoVinculado(Empregado emp){

        for (Iterator<Hospital> h = Hospital.list().iterator(); h.hasNext();) {
            Hospital hospital = h.next();

            for (Iterator<Empregado> e = hospital.getEmpregados().iterator(); e.hasNext();) {
                Empregado empregado = e.next();

                if (empregado.equals(emp)){
                    System.out.printf("\n");
                    System.out.printf("Nome: %s\n", hospital.getNome());
                    System.out.printf("Endereço: %s\n", hospital.getEndereco());
                }
            }
        }
    }

    public void inserirInternacao(Internacao internacao){
        internacoes.add(internacao);
    }

}
