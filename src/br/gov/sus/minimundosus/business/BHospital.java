/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.business;

import br.gov.sus.minimundosus.entity.Empregado;
import br.gov.sus.minimundosus.entity.Hospital;
import br.gov.sus.minimundosus.persistence.HospitalDAO;
import java.util.Iterator;


/**
 *
 * @author Ricardo
 */
public class BHospital {

    public void incluirHospital(Hospital hospital){
        HospitalDAO.inserir(hospital);
    }

    public Hospital getHospital(int codigo){
        return HospitalDAO.getHospital(codigo);
    }

    public void listMedicoEnfermeiro(Hospital hospital){

        System.out.printf("Relação de Médicos e Enfermeiros\n");
        System.out.printf("\n");

        for (Iterator<Empregado> e = hospital.getEmpregados().iterator(); e.hasNext();) {
            Empregado empregado = e.next();            
            System.out.printf("Nome: %s - Matrícula: %d\n", empregado.getNome(), empregado.getMatricula());

        }
    }

    public void listHospitalEmpregadoVinculado(Empregado emp){

        System.out.printf("Relação de Hospital que Médicos ou Enfermeiros mantém vínculo\n");

        for (Iterator<Hospital> h = HospitalDAO.list().iterator(); h.hasNext();) {
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
}
