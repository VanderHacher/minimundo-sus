/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.business;

import br.gov.sus.minimundosus.entity.Hospital;
import br.gov.sus.minimundosus.entity.Internacao;
import br.gov.sus.minimundosus.entity.Medico;
import br.gov.sus.minimundosus.entity.Paciente;
import br.gov.sus.minimundosus.persistence.PacienteDAO;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author Ricardo
 */
public class BPaciente {

    public void incluirPaciente(Paciente paciente){
        PacienteDAO.inserir(paciente);
    }

    public Paciente getPaciente(int codigo){
        return PacienteDAO.getPaciente(codigo);
    }
    
    public void listPacienteInternadoHospital(Hospital hospital){

        System.out.printf("Relação dos Pacientes\n");

        for (Iterator<Internacao> i = hospital.getInternacoes().iterator(); i.hasNext();) {
            Internacao internacao = i.next();
            System.out.printf("\n");
            System.out.printf("Nome Paciente: %s\n", internacao.getPaciente().getNome());            
            System.out.printf("Idade: %s\n", calculaIdade(internacao.getPaciente().getDataNascimento()));
            System.out.printf("Cód. Seguro Social: %s\n", internacao.getPaciente().getCodigoSeguroSocial());
            System.out.printf("Período: %1$te/%1$tm/%1$tY a %2$te/%2$tm/%2$tY\n",
                    internacao.getDataInicio(), internacao.getDataFim());
            System.out.printf("Quantidade de Médicos Responsáveis: %d\n", internacao.getMedicos().size());
            for (Iterator<Medico> m = internacao.getMedicos().iterator(); m.hasNext();) {
                Medico medico = m.next();
                System.out.printf(" - %s\n", medico.getNome());
            }
        }
    }

     public int calculaIdade(java.util.Date dataNasc){
        Calendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.setTime(dataNasc);

        // Cria um objeto calendar com a data atual
        Calendar today = Calendar.getInstance();

        // Obtém a idade baseado no ano
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

        dateOfBirth.add(Calendar.YEAR, age);

        //se a data de hoje é antes da data de Nascimento, então diminui 1(um)
        if (today.before(dateOfBirth)) {
            age--;
        }
        return age;

    }
}
