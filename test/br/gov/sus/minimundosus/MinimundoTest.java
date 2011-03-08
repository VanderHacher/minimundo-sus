/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus;

import java.util.List;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import br.gov.sus.minimundosus.business.*;
import br.gov.sus.minimundosus.model.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo
 */
public class MinimundoTest {

    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    BPaciente bPaciente = new BPaciente();
    BEmpregado bEmpregado = new BEmpregado();
    BHospital bHospital = new BHospital();
    BInternacao bInternacao = new BInternacao();

    public MinimundoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Teste de Inclusão de Empregado
     */
    @Test
    public void testIncluirEmpregado() throws ParseException {
        System.out.println("==testIncluirEmpregado================================");

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

    }

    /**
    * Teste de Inclusão de Hospital
    */
    @Test
    public void testIncluirHospital() {
        System.out.println("==testIncluirHospital=================================");

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

    }
        
    /**
    * Teste de Vincular Empregado ao Hospital
    */
    @Test
    public void testVincularEmpregadoHospital() throws Exception {
        System.out.println("==testVincularEmpregadoHospital=======================");

        bEmpregado.vincularEmpregadoHospital(bEmpregado.getEmpregado(1), bHospital.getHospital(1));
        bEmpregado.vincularEmpregadoHospital(bEmpregado.getEmpregado(2), bHospital.getHospital(1));
        bEmpregado.vincularEmpregadoHospital(bEmpregado.getEmpregado(3), bHospital.getHospital(1));
        bEmpregado.vincularEmpregadoHospital(bEmpregado.getEmpregado(4), bHospital.getHospital(1));
        bEmpregado.vincularEmpregadoHospital(bEmpregado.getEmpregado(5), bHospital.getHospital(1));
        bEmpregado.vincularEmpregadoHospital(bEmpregado.getEmpregado(6), bHospital.getHospital(1));

        bEmpregado.vincularEmpregadoHospital(bEmpregado.getEmpregado(1), bHospital.getHospital(2));
        bEmpregado.vincularEmpregadoHospital(bEmpregado.getEmpregado(2), bHospital.getHospital(2));
        bEmpregado.vincularEmpregadoHospital(bEmpregado.getEmpregado(3), bHospital.getHospital(2));
        bEmpregado.vincularEmpregadoHospital(bEmpregado.getEmpregado(4), bHospital.getHospital(2));
        bEmpregado.vincularEmpregadoHospital(bEmpregado.getEmpregado(5), bHospital.getHospital(2));
        bEmpregado.vincularEmpregadoHospital(bEmpregado.getEmpregado(6), bHospital.getHospital(2));

    }


    /**
    * Teste de consultar hospital pelo código
    */
    @Test
    public void testGetHospital() {
        System.out.println("==testGetHospital=====================================");
        int codigo = 1;
        BHospital instance = new BHospital();
        Hospital result = instance.getHospital(codigo);
        assertNotNull(result);
    }

    /**
    * Teste de inclusão de paciente
    */
    @Test
    public void testIncluirPaciente() throws ParseException {
        System.out.println("==testIncluirPaciente=================================");

        Paciente p1 = new Paciente();
        p1.setCodigoSeguroSocial(1);
        p1.setCpf(8888);
        p1.setDataNascimento((Date)formatter.parse("07/07/1965"));
        p1.setNome("Juliana Paes");
        bPaciente.incluirPaciente(p1);

        Paciente p2 = new Paciente();
        p2.setCodigoSeguroSocial(2);
        p2.setCpf(9999);
        p2.setDataNascimento((Date)formatter.parse("08/08/1966"));
        p2.setNome("Fernando Moura");
        bPaciente.incluirPaciente(p2);
        
    }

    /**
    * Teste de de consulta de paciente pelo código
    */
    @Test
    public void testGetPaciente() {
        System.out.println("==testGetPaciente=====================================");
        int codigo = 0;
       
        Paciente expResult = null;
        Paciente result = bPaciente.getPaciente(codigo);
        assertEquals(expResult, result);
    }

    /**
    * Teste de inclusão de internação
    */
    @Test
    public void testIncluirInternacao() throws ParseException {
        System.out.println("==testIncluirInternacao===============================");
        
        Internacao i1 = new Internacao();
        i1.setCodigo(1);
        i1.setPaciente(bPaciente.getPaciente(1));
        i1.setDataInicio((Date)formatter.parse("01/01/2011"));
        i1.setDataFim((Date)formatter.parse("05/01/2011"));
        bInternacao.incluirInternacao(i1, bHospital.getHospital(1));

        Internacao i2 = new Internacao();
        i2.setCodigo(2);
        i2.setPaciente(bPaciente.getPaciente(2));
        i2.setDataInicio((Date)formatter.parse("04/01/2011"));
        i2.setDataFim((Date)formatter.parse("07/01/2011"));
        bInternacao.incluirInternacao(i2, bHospital.getHospital(2));

        bInternacao.incluirMedicoInternacao((Medico)bEmpregado.getEmpregado(1), bInternacao.getInternacao(1));
        bInternacao.incluirMedicoInternacao((Medico)bEmpregado.getEmpregado(2), bInternacao.getInternacao(1));
        bInternacao.incluirMedicoInternacao((Medico)bEmpregado.getEmpregado(1), bInternacao.getInternacao(2));

        bInternacao.incluirEnfermeiroInternacao((Enfermeiro)bEmpregado.getEmpregado(4), bInternacao.getInternacao(2));
        bInternacao.incluirEnfermeiroInternacao((Enfermeiro)bEmpregado.getEmpregado(5), bInternacao.getInternacao(2));

    }

    /**
    * Teste de listar os pacientes internados em um hospital
    */
    @Test
    public void testListPacienteInternadoHospital() {
        System.out.println("==testListPacienteInternadoHospital===================");

        Hospital hospital = bHospital.getHospital(1);

        bPaciente.listPacienteInternadoHospital(hospital);
    }

    /**
    * Teste de listar os médicos e enfermeiros de um hospital
    */
    @Test
    public void testListMedicoEnfermeiroHospital() {
        System.out.println("==testListMedicoEnfermeiroHospital====================");

        Hospital hospital = bHospital.getHospital(1);

        bHospital.listMedicoEnfermeiro(hospital);
    }

    /**
    * Teste de listar os médicos e enfermeiros de uma internação
    */
    @Test
    public void testListMedicoEnfermeiroInternacao() {
        System.out.println("==testListMedicoEnfermeiroInternacao==================");

        Internacao internacao = bInternacao.getInternacao(2);

        bInternacao.listMedicoEnfermeiro(internacao);
    }

    /**
    * Teste de listar os hospitais que o empregado mantém vínculo
    */
    @Test
    public void testListHospitalEmpregadoVinculado() {
        System.out.println("==testListHospitalEmpregadoVinculado==================");

        Empregado empregado = bEmpregado.getEmpregado(1);

        bHospital.listHospitalEmpregadoVinculado(empregado);
    }





}