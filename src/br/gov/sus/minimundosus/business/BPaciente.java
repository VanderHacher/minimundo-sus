/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.business;

import br.gov.sus.minimundosus.entity.Paciente;
import br.gov.sus.minimundosus.persistence.PacienteDAO;
import java.util.List;


/**
 *
 * @author Ricardo
 */
public class BPaciente extends BBase{

    public void incluirPaciente(Paciente paciente){
        PacienteDAO.inserir(paciente);
    }

    public List<Paciente> list(){
        return PacienteDAO.list();
    }
}
