/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.business;

import br.gov.sus.minimundosus.entity.Empregado;
import br.gov.sus.minimundosus.entity.Hospital;
import br.gov.sus.minimundosus.persistence.EmpregadoDAO;
import br.gov.sus.minimundosus.persistence.HospitalDAO;
import java.util.Iterator;


/**
 *
 * @author Ricardo
 */
public class BEmpregado extends BBase{

    public void incluirEmpregado(Empregado empregado){
        EmpregadoDAO.inserir(empregado);
    }


    public void vincularEmpregadoHospital(Empregado empregado, Hospital hospital) throws Exception{

        int qtdeVinculo = 0;

        for (Iterator<Hospital> h = HospitalDAO.list().iterator(); h.hasNext();) {
            Hospital hosp = h.next();

            for (Iterator<Empregado> e = hosp.getEmpregados().iterator(); e.hasNext();) {
               Empregado emp = e.next();
               //Verifica se já existe a associação
               if (hosp.equals(hospital) && emp.equals(empregado)){
                    throw new Exception("Empregado já associado a este hospital");
               }

               //Contabiliza se já existe 3 vínculos com hospitais
               if (emp.equals(empregado)){
                   qtdeVinculo++;

                   if (qtdeVinculo == 3)
                        throw new Exception("Empregado pode ter no máximo 3 vínculos");
               }
            }                        
        }

        hospital.getEmpregados().add(empregado);
    }

}
