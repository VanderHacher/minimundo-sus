/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.entity;

import java.util.ArrayList;
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


    
}
