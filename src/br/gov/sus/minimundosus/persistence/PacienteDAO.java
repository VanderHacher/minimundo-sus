/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.persistence;

import br.gov.sus.minimundosus.entity.Paciente;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ricardo
 * Esta classe é um Mock para persistence em banco de dados
 */
public class PacienteDAO {

    private static List<Paciente> pacientes = new ArrayList<Paciente>();

    public static void inserir(Paciente empregado){
        pacientes.add(empregado);
    }
    
    public static Paciente getPaciente(int codigoSeguroSocial){
        for (Iterator<Paciente> it = pacientes.iterator(); it.hasNext();) {
            Paciente paciente = it.next();
            if (paciente.getCodigoSeguroSocial() == codigoSeguroSocial)
                return paciente;
        }
        return null;
    }

    public static List<Paciente> list(){
        return pacientes;
    }
}
