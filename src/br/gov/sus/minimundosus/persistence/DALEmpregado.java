/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.persistence;

import br.gov.sus.minimundosus.entity.Empregado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class DALEmpregado {

    List<Empregado> empregados = new ArrayList<Empregado>();

    public void Inserir(Empregado empregado){
        empregados.add(empregado);
    }

    public List<Empregado> List(){
        return empregados;
    }
}
