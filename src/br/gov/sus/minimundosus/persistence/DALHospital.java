/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.persistence;

import br.gov.sus.minimundosus.entity.Hospital;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class DALHospital {

    List<Hospital> hospitais = new ArrayList<Hospital>();

    public void Inserir(Hospital hospital){
        hospitais.add(hospital);
    }

    public Hospital getHospital(int codigo){
        for (Iterator<Hospital> it = hospitais.iterator(); it.hasNext();) {
            Hospital hospital = it.next();
            if (hospital.getCodigo() == codigo)
                return hospital;
        }
        return null;
    }

    public List<Hospital> List(){
        return hospitais;
    }
}
