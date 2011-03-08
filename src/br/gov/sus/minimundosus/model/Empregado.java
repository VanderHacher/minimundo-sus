/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public abstract class Empregado extends Pessoa{

    private int matricula;
    private static List<Empregado> empregados = new ArrayList<Empregado>();

    public Empregado(){}

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }



    public static void inserir(Empregado empregado){
        empregados.add(empregado);
    }

    public static Empregado getEmpregado(int matricula){
        for (Iterator<Empregado> it = empregados.iterator(); it.hasNext();) {
            Empregado empregado = it.next();
            if (empregado.getMatricula() == matricula)
                return empregado;
        }
        return null;
    }
    public static List<Empregado> List(){
        return empregados;
    }

    public void vincularEmpregadoHospital(Empregado empregado, Hospital hospital) throws Exception{

        int qtdeVinculo = 0;

        for (Iterator<Hospital> h = Hospital.list().iterator(); h.hasNext();) {
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
