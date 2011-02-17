/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus;

import br.gov.sus.minimundosus.business.*;
import br.gov.sus.minimundosus.entity.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
/**
 *
 * @author Ricardo
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, Exception {
        // TODO code application logic here

        initEntitades();
        
        int opcao = -1;

        while(opcao != 0)
        {
            System.out.println("===============================================================");
            System.out.println("|   MINIMUNDO-SUS                                             |");
            System.out.println("===============================================================");
            System.out.println("| Opções :                                                    |");
            System.out.println("|     1. Relação de Pacientes                                 |");
            System.out.println("|     2. Relação de Empregados                                |");
            System.out.println("|     3. Relação de Médicos e Enfermeiros de uma internação   |");
            System.out.println("|     4. Relação de Médicos e Enfermeiros de um hospital      |");
            System.out.println("|     0. Sair                                                 |");
            System.out.println("===============================================================");
            System.out.println("Digite uma opção:");
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            try {
                opcao = Integer.parseInt(buffer.readLine());
                executeAction(opcao);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void executeAction(int opcao) throws IOException {
        switch (opcao) {
            case 1:
                System.out.println("Informe o código do hospital:");
                BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
                listarPacienteInternadoHospital(Integer.parseInt(buffer.readLine()));
                break;
            case 2:
              System.out.println("Option 2 selected");
              break;
            case 3:
              System.out.println("Exit selected");
              break;
            default:
              System.out.println("Opção Inválida");
              break;
        }
    }

    private static void listarPacienteInternadoHospital(int codigoHospital){

        BHospital bHospital = new BHospital();
        Hospital hospital = bHospital.getHospital(codigoHospital);
        
        for (Iterator<Internacao> i = hospital.getInternacoes().iterator(); i.hasNext();) {
            Internacao internacao = i.next();
            System.out.printf("Nome Paciente: {0}", internacao.getPaciente().getNome());
            System.out.printf("Cód. Seguro Social: {0}", internacao.getPaciente().getCodigoSeguroSocial());
            
        }
    }

    public static void initEntitades() throws ParseException, Exception {

        BEmpregado bEmpregado = new BEmpregado();

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Medico m1 = new Medico();
        m1.setCpf(11111);
        m1.setDataNascimento((Date)formatter.parse("25/01/1980"));
        m1.setEspecialidade("Cardiologista");
        m1.setMatricula(1);
        m1.setNome("João da Silva");
        bEmpregado.incluirEmpregado(m1);

        Medico m2 = new Medico();
        m2.setCpf(22222);
        m2.setDataNascimento((Date)formatter.parse("20/01/1965"));
        m2.setEspecialidade("Cardiologista");
        m2.setMatricula(2);
        m2.setNome("José Torres");
        bEmpregado.incluirEmpregado(m2);

        Medico m3 = new Medico();
        m3.setCpf(33333);
        m3.setDataNascimento((Date)formatter.parse("20/01/1966"));
        m3.setEspecialidade("Otorrinolaringologista");
        m3.setMatricula(3);
        m3.setNome("José Torres");
        bEmpregado.incluirEmpregado(m3);

        Enfermeiro e1 = new Enfermeiro();
        e1.setCpf(44444);
        e1.setDataNascimento((Date)formatter.parse("20/01/1970"));
        e1.setCargo("Auxiliar");
        e1.setMatricula(4);
        e1.setNome("Maria das Neves");
        bEmpregado.incluirEmpregado(e1);

        Enfermeiro e2 = new Enfermeiro();
        e2.setCpf(5555);
        e2.setDataNascimento((Date)formatter.parse("20/01/1970"));
        e2.setCargo("Chefe");
        e2.setMatricula(5);
        e2.setNome("João Barreto");
        bEmpregado.incluirEmpregado(e2);

        Enfermeiro e3 = new Enfermeiro();
        e3.setCpf(66666);
        e3.setDataNascimento((Date)formatter.parse("20/05/1978"));
        e3.setCargo("Chefe");
        e3.setMatricula(6);
        e3.setNome("João Barreto");
        bEmpregado.incluirEmpregado(e3);

        BHospital bHospital = new BHospital();

        Hospital h1 = new Hospital();
        h1.setCodigo(1);
        h1.setNome("Hospital Ferreira Machado");
        h1.setEndereco("Rua Rocha Leão, 1 - Caju");
        bHospital.incluirHospital(h1);

        Hospital h2 = new Hospital();
        h2.setCodigo(2);
        h2.setNome("Hospital Geral de Guarus");
        h2.setEndereco("Rua José Carlos Pereira Pinto, 300");
        bHospital.incluirHospital(h2);

        //Vincula os médicos e enfermeiros aos hospitais
        bEmpregado.vincularEmpregadoHospital(e1, h1);
        bEmpregado.vincularEmpregadoHospital(e2, h1);
        bEmpregado.vincularEmpregadoHospital(e3, h1);
        bEmpregado.vincularEmpregadoHospital(m1, h1);
        bEmpregado.vincularEmpregadoHospital(m2, h1);
        bEmpregado.vincularEmpregadoHospital(m3, h1);
        bEmpregado.vincularEmpregadoHospital(e1, h2);
        bEmpregado.vincularEmpregadoHospital(e2, h2);
        bEmpregado.vincularEmpregadoHospital(e3, h2);
        bEmpregado.vincularEmpregadoHospital(m1, h2);
        bEmpregado.vincularEmpregadoHospital(m2, h2);
        bEmpregado.vincularEmpregadoHospital(m3, h2);

        BPaciente bPaciente = new BPaciente();

        Paciente p1 = new Paciente();
        p1.setCodigoSeguroSocial(7654);
        p1.setCpf(9999);
        p1.setDataNascimento((Date)formatter.parse("07/07/1965"));
        p1.setNome("Juliana Paes");
        bPaciente.incluirPaciente(p1);

        Paciente p2 = new Paciente();
        p2.setCodigoSeguroSocial(3456);
        p2.setCpf(9999);
        p2.setDataNascimento((Date)formatter.parse("08/08/1966"));
        p2.setNome("Fernando Moura");
        bPaciente.incluirPaciente(p2);

        BInternacao bInternacao = new BInternacao();

        Internacao i1 = new Internacao();
        i1.setCodigo(1);
        i1.setPaciente(p1);
        i1.setDataInicio((Date)formatter.parse("01/01/2011"));
        i1.setDataFim((Date)formatter.parse("05/01/2011"));
        bInternacao.incluirInternacao(i1, h1);

        bInternacao.incluirEnfermeiroInternacao(e3, i1);
        bInternacao.incluirMedicoInternacao(m3, i1);
        bInternacao.incluirMedicoInternacao(m2, i1);

        Internacao i2 = new Internacao();
        i2.setCodigo(1);
        i2.setPaciente(p1);
        i2.setDataInicio((Date)formatter.parse("04/01/2011"));
        i2.setDataFim((Date)formatter.parse("07/01/2011"));
        bInternacao.incluirInternacao(i2, h2);

        //Incluir Enfermeiro/Médico a internação
        bInternacao.incluirEnfermeiroInternacao(e1, i2);
        bInternacao.incluirEnfermeiroInternacao(e2, i2);
        bInternacao.incluirMedicoInternacao(m1, i2);



    }

}
