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
 * Esta classe é um Mock para persistence em banco de dados
 */
public class HospitalDAO {

    private static List<Hospital> hospitais = new ArrayList<Hospital>();

    public static void inserir(Hospital hospital){
        hospitais.add(hospital);
    }

    public static Hospital getHospital(int codigo){
        for (Iterator<Hospital> it = hospitais.iterator(); it.hasNext();) {
            Hospital hospital = it.next();
            if (hospital.getCodigo() == codigo)
                return hospital;
        }
        return null;
    }

    public static List<Hospital> list(){
        return hospitais;
    }
}
