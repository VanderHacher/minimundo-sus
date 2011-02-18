/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.business;

import br.gov.sus.minimundosus.entity.*;
import br.gov.sus.minimundosus.persistence.InternacaoDAO;
import br.gov.sus.minimundosus.persistence.PacienteDAO;
import java.util.Iterator;

/**
 *
 * @author Ricardo
 */
public class BInternacao {

    public void incluirInternacao(Internacao internacao, Hospital hospital){
        InternacaoDAO.inserir(internacao);
        hospital.getInternacoes().add(internacao);
    }

    public void incluirMedicoInternacao(Medico medico, Internacao internacao){
        internacao.getMedicos().add(medico);
    }

    public void incluirEnfermeiroInternacao(Enfermeiro enfermeiro, Internacao internacao){
        internacao.getEnfermeiros().add(enfermeiro);
    }

    public Internacao getInternacao(int codigo){
        return InternacaoDAO.getInternacao(codigo);
    }

    public void listMedicoEnfermeiro(Internacao internacao){

        System.out.printf("Relação de Médicos e Enfermeiros que deram atendimento a Internação\n");

        System.out.printf("\n");

         System.out.printf("Paciente: %s\n", internacao.getPaciente().getNome());

        System.out.printf("Médicos:\n");
        for (Iterator<Medico> m = internacao.getMedicos().iterator(); m.hasNext();) {
            Medico medico = m.next();
            System.out.printf(" Nome: %s", medico.getNome());
            System.out.printf(" - Matrícula: %s", medico.getMatricula());
            System.out.printf(" - Especialidade: %s\n", medico.getEspecialidade());
        }

        System.out.printf("\n");

        System.out.printf("Enfermeiros:\n");
        for (Iterator<Enfermeiro> e = internacao.getEnfermeiros().iterator(); e.hasNext();) {
            Enfermeiro enfermeiro = e.next();
            System.out.printf(" Nome: %s", enfermeiro.getNome());
            System.out.printf(" - Matrícula: %s", enfermeiro.getMatricula());
            System.out.printf(" - Cargo: %s\n", enfermeiro.getCargo());
        }
    }
}
