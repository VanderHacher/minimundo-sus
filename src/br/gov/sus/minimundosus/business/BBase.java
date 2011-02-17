/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.business;

import br.gov.sus.minimundosus.entity.*;
import br.gov.sus.minimundosus.persistence.*;

/**
 *
 * @author Ricardo
 */
public class BBase {

    public Empregado getEmpregado(int matricula){
        return EmpregadoDAO.getEmpregado(matricula);
    }
    


    public Paciente getPaciente(int codigo){
        return PacienteDAO.getPaciente(codigo);
    }

}
