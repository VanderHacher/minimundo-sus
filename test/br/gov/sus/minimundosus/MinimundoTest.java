/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus;

import java.util.List;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
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

    @Test
    public void testIncluirMedico() throws ParseException {
        Medico m1 = new Medico();
        m1.setCpf(11111);
        m1.setDataNascimento((Date)formatter.parse("25/01/1980"));
        m1.setEspecialidade("Cardiologista");
        m1.setMatricula(1);
        m1.setNome("João da Silva");
        Medico.inserir(m1);

        assertTrue(Medico.list().contains(m1));
       
        Medico m2 = new Medico();
        m2.setCpf(22222);
        m2.setDataNascimento((Date)formatter.parse("20/01/1965"));
        m2.setEspecialidade("Cardiologista");
        m2.setMatricula(2);
        m2.setNome("José Torres");
        Medico.inserir(m2);

        assertTrue(Medico.list().contains(m2));

        Medico m3 = new Medico();
        m3.setCpf(33333);
        m3.setDataNascimento((Date)formatter.parse("20/01/1966"));
        m3.setEspecialidade("Otorrinolaringologista");
        m3.setMatricula(3);
        m3.setNome("José Torres");
        Medico.inserir(m3);

        assertTrue(Medico.list().contains(m3));
    }

    @Test
    public void testListarMedico() {
        assertTrue(!Medico.list().isEmpty());
    }

    @Test
    public void testIncluirEnfermeiro() throws ParseException {
        Enfermeiro e1 = new Enfermeiro();
        e1.setCpf(44444);
        e1.setDataNascimento((Date)formatter.parse("20/01/1970"));
        e1.setCargo("Auxiliar");
        e1.setMatricula(4);
        e1.setNome("Maria das Neves");
        Medico.inserir(e1);

        assertTrue(Medico.list().contains(e1));

        Enfermeiro e2 = new Enfermeiro();
        e2.setCpf(5555);
        e2.setDataNascimento((Date)formatter.parse("20/01/1970"));
        e2.setCargo("Chefe");
        e2.setMatricula(5);
        e2.setNome("João Barreto");
        Medico.inserir(e2);

        assertTrue(Medico.list().contains(e2));

        Enfermeiro e3 = new Enfermeiro();
        e3.setCpf(66666);
        e3.setDataNascimento((Date)formatter.parse("20/05/1978"));
        e3.setCargo("Chefe");
        e3.setMatricula(6);
        e3.setNome("João Barreto");
        Medico.inserir(e3);

        assertTrue(Medico.list().contains(e3));

    }

    @Test
    public void testListarEnfermeiro() {
        assertTrue(!Medico.list().isEmpty());
    }

    @Test
    public void testBuscaEmpregadoPorMatriculaExistenteRetornaNaoNulo(){
        assertNotNull(Empregado.getEmpregado(5));
    }

    @Test
    public void testBuscaEmpregadoPorMatriculaExistenteRetornaNulo(){
        assertNull(Empregado.getEmpregado(-5));
    }

    @Test
    public void testIncluirHospital() {

        Hospital h1 = new Hospital();
        h1.setCodigo(1);
        h1.setNome("Hospital Ferreira Machado");
        h1.setEndereco("Rua Rocha Leão, 1 - Caju");
        Hospital.inserir(h1);

        assertTrue(Hospital.list().contains(h1));

        Hospital h2 = new Hospital();
        h2.setCodigo(2);
        h2.setNome("Hospital Geral de Guarus");
        h2.setEndereco("Rua José Carlos Pereira Pinto, 300");
        Hospital.inserir(h2);

        assertTrue(Hospital.list().contains(h2));

        Hospital h3 = new Hospital();
        h3.setCodigo(3);
        h3.setNome("Hospital São João");
        h3.setEndereco("Rua Martins, 300");
        Hospital.inserir(h3);

        assertTrue(Hospital.list().contains(h3));

        Hospital h4 = new Hospital();
        h4.setCodigo(4);
        h4.setNome("Hospital Pessanha");
        h4.setEndereco("Rua Pessanha, 300");
        Hospital.inserir(h4);

        assertTrue(Hospital.list().contains(h4));
    }

    @Test
    public void testBuscaHospitalPorCodigoExistenteRetornaNaoNulo(){
        assertNotNull(Hospital.getHospital(1));
    }

    @Test
    public void testBuscaHospitalPorCodigoExistenteRetornaNulo(){
        assertNull(Hospital.getHospital(11));
    }

    @Test
    public void testVincularEmpregadoAoHospital() throws Exception {

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(1), Hospital.getHospital(1));
        assertNotNull(Hospital.getHospital(1).getEmpregados().contains(Empregado.getEmpregado(1)));
        
        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(2), Hospital.getHospital(1));
        assertNotNull(Hospital.getHospital(1).getEmpregados().contains(Empregado.getEmpregado(2)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(3), Hospital.getHospital(1));
        assertNotNull(Hospital.getHospital(1).getEmpregados().contains(Empregado.getEmpregado(3)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(4), Hospital.getHospital(1));
        assertNotNull(Hospital.getHospital(1).getEmpregados().contains(Empregado.getEmpregado(4)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(5), Hospital.getHospital(1));
        assertNotNull(Hospital.getHospital(1).getEmpregados().contains(Empregado.getEmpregado(5)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(6), Hospital.getHospital(1));
        assertNotNull(Hospital.getHospital(1).getEmpregados().contains(Empregado.getEmpregado(6)));


        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(1), Hospital.getHospital(2));
        assertNotNull(Hospital.getHospital(2).getEmpregados().contains(Empregado.getEmpregado(1)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(2), Hospital.getHospital(2));
        assertNotNull(Hospital.getHospital(2).getEmpregados().contains(Empregado.getEmpregado(2)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(3), Hospital.getHospital(2));
        assertNotNull(Hospital.getHospital(2).getEmpregados().contains(Empregado.getEmpregado(3)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(4), Hospital.getHospital(2));
        assertNotNull(Hospital.getHospital(2).getEmpregados().contains(Empregado.getEmpregado(4)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(5), Hospital.getHospital(2));
        assertNotNull(Hospital.getHospital(2).getEmpregados().contains(Empregado.getEmpregado(5)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(6), Hospital.getHospital(2));
        assertNotNull(Hospital.getHospital(2).getEmpregados().contains(Empregado.getEmpregado(6)));

    }

    @Test
    public void testIncluirPaciente() throws ParseException {

        Paciente p1 = new Paciente();
        p1.setCodigoSeguroSocial(1);
        p1.setCpf(8888);
        p1.setDataNascimento((Date)formatter.parse("07/07/1965"));
        p1.setNome("Juliana Paes");
        Paciente.inserir(p1);

        assertTrue(Paciente.list().contains(p1));

        Paciente p2 = new Paciente();
        p2.setCodigoSeguroSocial(2);
        p2.setCpf(9999);
        p2.setDataNascimento((Date)formatter.parse("08/08/1966"));
        p2.setNome("Fernando Moura");
        Paciente.inserir(p2);

        assertTrue(Paciente.list().contains(p2));

    }

    @Test
    public void testBuscaPacientePorCodigoExistenteRetornaNaoNulo(){
        assertNotNull(Paciente.getPaciente(1));
    }

    @Test
    public void testBuscaPacientePorCodigoExistenteRetornaNulo(){
        assertNull(Paciente.getPaciente(61));
    }

    @Test
    public void testIncluirInternacao() throws ParseException {

        Internacao i1 = new Internacao();
        i1.setCodigo(1);
        i1.setPaciente(Paciente.getPaciente(1));
        i1.setDataInicio((Date)formatter.parse("01/01/2011"));
        i1.setDataFim((Date)formatter.parse("05/01/2011"));
        Internacao.inserir(i1);
        Hospital.getHospital(1).inserirInternacao(i1);

        assertTrue(Internacao.list().contains(i1));

        Internacao i2 = new Internacao();
        i2.setCodigo(2);
        i2.setPaciente(Paciente.getPaciente(2));
        i2.setDataInicio((Date)formatter.parse("04/01/2011"));
        i2.setDataFim((Date)formatter.parse("07/01/2011"));
        Internacao.inserir(i2);
        Hospital.getHospital(2).inserirInternacao(i2);
        
        assertTrue(Internacao.list().contains(i2));

    }

    @Test(expected=Exception.class)
    public void testVinculaMedicoAHospitalJaVinculadoGeraExcetion() throws Exception{
        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(3), Hospital.getHospital(2));
    }

    @Test(expected=Exception.class)
    public void testVinculaMedicoAHospitalExecendoLimiteDeVinculacaoGeraExcetion() throws Exception{
        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(3), Hospital.getHospital(3));
        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(3), Hospital.getHospital(4));
    }

    @Test
    public void testIncluirMedicoNaInternacao(){

        Internacao.getInternacao(1).incluirMedicoInternacao((Medico)Empregado.getEmpregado(1));
        assertTrue(Internacao.getInternacao(1).getMedicos().contains((Medico)Empregado.getEmpregado(1)));

        Internacao.getInternacao(1).incluirMedicoInternacao((Medico)Empregado.getEmpregado(2));
        assertTrue(Internacao.getInternacao(1).getMedicos().contains((Medico)Empregado.getEmpregado(2)));

        Internacao.getInternacao(2).incluirMedicoInternacao((Medico)Empregado.getEmpregado(1));
        assertTrue(Internacao.getInternacao(2).getMedicos().contains((Medico)Empregado.getEmpregado(1)));

        Internacao.getInternacao(2).incluirEnfermeiroInternacao((Enfermeiro)Empregado.getEmpregado(4));
        assertTrue(Internacao.getInternacao(2).getEnfermeiros().contains((Enfermeiro)Empregado.getEmpregado(4)));

        Internacao.getInternacao(2).incluirEnfermeiroInternacao((Enfermeiro)Empregado.getEmpregado(5));
        assertTrue(Internacao.getInternacao(2).getEnfermeiros().contains((Enfermeiro)Empregado.getEmpregado(5)));

    }

    @Test
    public void testListarPacienteInternadoHospital() {

        Hospital hospital = Hospital.getHospital(1);

        List<Paciente> listPaciente = new ArrayList<Paciente>();
        assertTrue(hospital.listPacienteInternado().getClass().equals(listPaciente.getClass()));
   
    }

    @Test
    public void testListarMedicoEnfermeiroDeUmHospital() {

        Hospital hospital = Hospital.getHospital(1);

        List<Empregado> listEmpregado = new ArrayList<Empregado>();
        assertTrue(hospital.listMedicoEnfermeiro().getClass().equals(listEmpregado.getClass()));

    }

    @Test
    public void testListMedicoEnfermeiroInternacao() {

        Internacao internacao = Internacao.getInternacao(1);

        List<Empregado> listEmpregado = new ArrayList<Empregado>();
        assertTrue(internacao.listMedicoEnfermeiro().getClass().equals(listEmpregado.getClass()));

    }

    @Test
    public void testListHospitalEmpregadoVinculado() {

        Empregado empregado = Empregado.getEmpregado(1);

        List<Hospital> listHospital = new ArrayList<Hospital>();
        assertTrue(empregado.listHospitalEmpregadoVinculado().getClass().equals(listHospital.getClass()));
   
    }

}