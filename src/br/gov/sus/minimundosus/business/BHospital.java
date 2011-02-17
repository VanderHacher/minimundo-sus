/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.business;

import br.gov.sus.minimundosus.entity.Hospital;
import br.gov.sus.minimundosus.persistence.HospitalDAO;


/**
 *
 * @author Ricardo
 */
public class BHospital extends BBase{

    public void incluirHospital(Hospital hospital){
        HospitalDAO.inserir(hospital);
    }

  
}
