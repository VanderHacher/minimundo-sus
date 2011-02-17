/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.business;

import br.gov.sus.minimundosus.entity.*;
import br.gov.sus.minimundosus.persistence.InternacaoDAO;
import br.gov.sus.minimundosus.persistence.PacienteDAO;

/**
 *
 * @author Ricardo
 */
public class BInternacao extends BBase{

    public void incluirPaciente(Paciente paciente){
        PacienteDAO.inserir(paciente);
    }

    public void incluirInternacao(Internacao internacao){
        InternacaoDAO.inserir(internacao);
    }

    public void incluirMedicoInternacao(Medico medico, Internacao internacao){
        internacao.getMedicos().add(medico);
    }

    public void incluirEnfermeiroInternacao(Enfermeiro enfermeiro, Internacao internacao){
        internacao.getEnfermeiros().add(enfermeiro);
    }
    
}
