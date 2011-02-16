/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.entity;

import java.util.Date;

/**
 *
 * @author Ricardo
 */
public abstract class Pessoa {

    private int cpf;
    private String nome;
    private Date dataNascimento;

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
