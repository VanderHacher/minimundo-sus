/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.persistence;

import br.gov.sus.minimundosus.entity.Empregado;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ricardo
 * Esta classe é um Mock para persistence em banco de dados
 */
public class EmpregadoDAO {

    private static List<Empregado> empregados = new ArrayList<Empregado>();

    public static void inserir(Empregado empregado){
        empregados.add(empregado);
    }

    public static Empregado getEmpregado(int matricula){
        for (Iterator<Empregado> it = empregados.iterator(); it.hasNext();) {
            Empregado empregado = it.next();
            if (empregado.getMatricula() == matricula)
                return empregado;
        }
        return null;
    }
    public static List<Empregado> List(){
        return empregados;
    }
}
