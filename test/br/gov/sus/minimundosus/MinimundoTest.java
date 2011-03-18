/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus;

import java.util.Iterator;
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
    private static final int MEDICO_01 = 1;
    private static final int MEDICO_02 = 2;
    private static final int MEDICO_03 = 3;
    private static final int ENFERMEIRO_04 = 4;
    private static final int ENFERMEIRO_05 = 5;
    private static final int ENFERMEIRO_06 = 6;
    private static final int HOSPITAL_01 = 1;
    private static final int HOSPITAL_02 = 2;
    private static final int HOSPITAL_03 = 3;
    private static final int HOSPITAL_04 = 4;
    private static final int PACIENTE_01 = 1;
    private static final int PACIENTE_02 = 2;
    private static final int INTERNACAO_01 = 1;
    private static final int INTERNACAO_02 = 2;
  
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
        m1.setMatricula(MEDICO_01);
        m1.setNome("João da Silva");
        Medico.inserir(m1);

        assertTrue(Medico.list().contains(m1));
       
        Medico m2 = new Medico();
        m2.setCpf(22222);
        m2.setDataNascimento((Date)formatter.parse("20/01/1965"));
        m2.setEspecialidade("Cardiologista");
        m2.setMatricula(MEDICO_02);
        m2.setNome("José Torres");
        Medico.inserir(m2);

        assertTrue(Medico.list().contains(m2));

        Medico m3 = new Medico();
        m3.setCpf(33333);
        m3.setDataNascimento((Date)formatter.parse("20/01/1966"));
        m3.setEspecialidade("Otorrinolaringologista");
        m3.setMatricula(MEDICO_03);
        m3.setNome("José Torres");
        Medico.inserir(m3);

        assertTrue(Medico.list().contains(m3));
    }

    @Test
    public void testListarEmpregado() {
        assertFalse(Empregado.list().isEmpty());
    }

    @Test
    public void testIncluirEnfermeiro() throws ParseException {
        Enfermeiro e1 = new Enfermeiro();
        e1.setCpf(44444);
        e1.setDataNascimento((Date)formatter.parse("20/01/1970"));
        e1.setCargo("Auxiliar");
        e1.setMatricula(ENFERMEIRO_04);
        e1.setNome("Maria das Neves");
        Enfermeiro.inserir(e1);

        assertTrue(Medico.list().contains(e1));

        Enfermeiro e2 = new Enfermeiro();
        e2.setCpf(5555);
        e2.setDataNascimento((Date)formatter.parse("20/01/1970"));
        e2.setCargo("Chefe");
        e2.setMatricula(ENFERMEIRO_05);
        e2.setNome("João Barreto");
        Enfermeiro.inserir(e2);

        assertTrue(Medico.list().contains(e2));

        Enfermeiro e3 = new Enfermeiro();
        e3.setCpf(66666);
        e3.setDataNascimento((Date)formatter.parse("20/05/1978"));
        e3.setCargo("Chefe");
        e3.setMatricula(ENFERMEIRO_06);
        e3.setNome("João Barreto");
        Enfermeiro.inserir(e3);

        assertTrue(Enfermeiro.list().contains(e3));

    }

    @Test
    public void testBuscaEmpregadoPorMatriculaExistenteRetornaNaoNulo(){
        assertNotNull(Empregado.getEmpregado(ENFERMEIRO_05));
    }

    @Test
    public void testBuscaEmpregadoPorMatriculaInexistenteRetornaNulo(){
        assertNull(Empregado.getEmpregado(0));
    }

    @Test
    public void testIncluirHospital() {

        Hospital h1 = new Hospital();
        h1.setCodigo(HOSPITAL_01);
        h1.setNome("Hospital Ferreira Machado");
        h1.setEndereco("Rua Rocha Leão, 1 - Caju");
        Hospital.inserir(h1);

        assertTrue(Hospital.list().contains(h1));

        Hospital h2 = new Hospital();
        h2.setCodigo(HOSPITAL_02);
        h2.setNome("Hospital Geral de Guarus");
        h2.setEndereco("Rua José Carlos Pereira Pinto, 300");
        Hospital.inserir(h2);

        assertTrue(Hospital.list().contains(h2));

        Hospital h3 = new Hospital();
        h3.setCodigo(HOSPITAL_03);
        h3.setNome("Hospital São João");
        h3.setEndereco("Rua Martins, 300");
        Hospital.inserir(h3);

        assertTrue(Hospital.list().contains(h3));

        Hospital h4 = new Hospital();
        h4.setCodigo(HOSPITAL_04);
        h4.setNome("Hospital Pessanha");
        h4.setEndereco("Rua Pessanha, 300");
        Hospital.inserir(h4);

        assertTrue(Hospital.list().contains(h4));
    }

    @Test
    public void testBuscaHospitalPorCodigoExistenteRetornaNaoNulo(){
        assertNotNull(Hospital.getHospital(HOSPITAL_01));
    }

    @Test
    public void testBuscaHospitalPorCodigoInexistenteRetornaNulo(){
        assertNull(Hospital.getHospital(0));
    }

    @Test
    public void testVincularEmpregadoAoHospital() throws Exception {

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(MEDICO_01), Hospital.getHospital(HOSPITAL_01));
        assertNotNull(Hospital.getHospital(HOSPITAL_01).getEmpregados().contains(Empregado.getEmpregado(MEDICO_01)));
        
        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(MEDICO_02), Hospital.getHospital(HOSPITAL_01));
        assertNotNull(Hospital.getHospital(HOSPITAL_01).getEmpregados().contains(Empregado.getEmpregado(MEDICO_02)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(MEDICO_03), Hospital.getHospital(HOSPITAL_01));
        assertNotNull(Hospital.getHospital(HOSPITAL_01).getEmpregados().contains(Empregado.getEmpregado(MEDICO_03)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(ENFERMEIRO_04), Hospital.getHospital(HOSPITAL_01));
        assertNotNull(Hospital.getHospital(HOSPITAL_01).getEmpregados().contains(Empregado.getEmpregado(ENFERMEIRO_04)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(ENFERMEIRO_05), Hospital.getHospital(HOSPITAL_01));
        assertNotNull(Hospital.getHospital(HOSPITAL_01).getEmpregados().contains(Empregado.getEmpregado(ENFERMEIRO_05)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(ENFERMEIRO_06), Hospital.getHospital(HOSPITAL_01));
        assertNotNull(Hospital.getHospital(HOSPITAL_01).getEmpregados().contains(Empregado.getEmpregado(ENFERMEIRO_06)));


        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(MEDICO_01), Hospital.getHospital(HOSPITAL_02));
        assertNotNull(Hospital.getHospital(HOSPITAL_02).getEmpregados().contains(Empregado.getEmpregado(1)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(MEDICO_02), Hospital.getHospital(HOSPITAL_02));
        assertNotNull(Hospital.getHospital(HOSPITAL_02).getEmpregados().contains(Empregado.getEmpregado(2)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(MEDICO_03), Hospital.getHospital(HOSPITAL_02));
        assertNotNull(Hospital.getHospital(HOSPITAL_02).getEmpregados().contains(Empregado.getEmpregado(3)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(ENFERMEIRO_04), Hospital.getHospital(HOSPITAL_02));
        assertNotNull(Hospital.getHospital(HOSPITAL_02).getEmpregados().contains(Empregado.getEmpregado(4)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(ENFERMEIRO_05), Hospital.getHospital(HOSPITAL_02));
        assertNotNull(Hospital.getHospital(HOSPITAL_02).getEmpregados().contains(Empregado.getEmpregado(5)));

        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(ENFERMEIRO_06), Hospital.getHospital(HOSPITAL_02));
        assertNotNull(Hospital.getHospital(HOSPITAL_02).getEmpregados().contains(Empregado.getEmpregado(6)));

    }

    @Test
    public void testIncluirPaciente() throws ParseException {

        Paciente p1 = new Paciente();
        p1.setCodigoSeguroSocial(PACIENTE_01);
        p1.setCpf(8888);
        p1.setDataNascimento((Date)formatter.parse("07/07/1965"));
        p1.setNome("Juliana Paes");
        Paciente.inserir(p1);

        assertTrue(Paciente.list().contains(p1));

        Paciente p2 = new Paciente();
        p2.setCodigoSeguroSocial(PACIENTE_02);
        p2.setCpf(9999);
        p2.setDataNascimento((Date)formatter.parse("08/08/1966"));
        p2.setNome("Fernando Moura");
        Paciente.inserir(p2);

        assertTrue(Paciente.list().contains(p2));

    }

    @Test
    public void testBuscaPacientePorCodigoExistenteRetornaNaoNulo(){
        assertNotNull(Paciente.getPaciente(PACIENTE_01));
    }

    @Test
    public void testBuscaPacientePorCodigoInexistenteRetornaNulo(){
        assertNull(Paciente.getPaciente(0));
    }

    @Test
    public void testIncluirInternacao() throws ParseException {

        Internacao i1 = new Internacao();
        i1.setCodigo(INTERNACAO_01);
        i1.setPaciente(Paciente.getPaciente(1));
        i1.setMedicoResponsavel((Medico)Empregado.getEmpregado(1));
        i1.setDataInicio((Date)formatter.parse("01/01/2011"));
        i1.setDataFim((Date)formatter.parse("05/01/2011"));
        Internacao.inserir(i1);
        Hospital.getHospital(HOSPITAL_01).inserirInternacao(i1);

        assertTrue(Internacao.list().contains(i1));

        Internacao i2 = new Internacao();
        i2.setCodigo(INTERNACAO_02);
        i2.setPaciente(Paciente.getPaciente(2));
        i2.setMedicoResponsavel((Medico)Empregado.getEmpregado(2));
        i2.setDataInicio((Date)formatter.parse("04/01/2011"));
        i2.setDataFim((Date)formatter.parse("07/01/2011"));
        Internacao.inserir(i2);
        Hospital.getHospital(HOSPITAL_02).inserirInternacao(i2);
        
        assertTrue(Internacao.list().contains(i2));

    }

    @Test
    public void testVinculacaoHospitalInternacao()
    {
        assertTrue(Hospital.getHospital(1).getInternacoes().contains(Internacao.getInternacao(INTERNACAO_01)));
        assertTrue(Hospital.getHospital(2).getInternacoes().contains(Internacao.getInternacao(INTERNACAO_02)));
    }

    @Test(expected=Exception.class)
    public void testVinculaMedicoAHospitalJaVinculadoGeraException() throws Exception{
        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(MEDICO_03), Hospital.getHospital(HOSPITAL_02));
    }

    @Test(expected=Exception.class)
    public void testVinculaMedicoAHospitalExecendoLimiteDeVinculacaoGeraException() throws Exception{
        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(MEDICO_03), Hospital.getHospital(HOSPITAL_03));
        Hospital.vincularEmpregadoHospital(Empregado.getEmpregado(MEDICO_03), Hospital.getHospital(HOSPITAL_04));
    }

    @Test
    public void testIncluirMedicoEnfermeiroNaInternacao(){

        Internacao.getInternacao(INTERNACAO_01).incluirMedicoInternacao((Medico)Empregado.getEmpregado(MEDICO_01));
        assertTrue(Internacao.getInternacao(INTERNACAO_01).getMedicos().contains((Medico)Empregado.getEmpregado(MEDICO_01)));

        Internacao.getInternacao(INTERNACAO_01).incluirMedicoInternacao((Medico)Empregado.getEmpregado(MEDICO_02));
        assertTrue(Internacao.getInternacao(INTERNACAO_01).getMedicos().contains((Medico)Empregado.getEmpregado(MEDICO_02)));

        Internacao.getInternacao(INTERNACAO_02).incluirMedicoInternacao((Medico)Empregado.getEmpregado(MEDICO_01));
        assertTrue(Internacao.getInternacao(INTERNACAO_02).getMedicos().contains((Medico)Empregado.getEmpregado(MEDICO_01)));

        Internacao.getInternacao(INTERNACAO_02).incluirEnfermeiroInternacao((Enfermeiro)Empregado.getEmpregado(ENFERMEIRO_04));
        assertTrue(Internacao.getInternacao(INTERNACAO_02).getEnfermeiros().contains((Enfermeiro)Empregado.getEmpregado(ENFERMEIRO_04)));

        Internacao.getInternacao(INTERNACAO_02).incluirEnfermeiroInternacao((Enfermeiro)Empregado.getEmpregado(ENFERMEIRO_05));
        assertTrue(Internacao.getInternacao(INTERNACAO_02).getEnfermeiros().contains((Enfermeiro)Empregado.getEmpregado(ENFERMEIRO_05)));

    }

    @Test
    public void testListarInternacaoHospitalComPacienteMedicoResponsavel() {

        Hospital hospital = Hospital.getHospital(HOSPITAL_01);

        List<Internacao> listInternacao = hospital.getInternacoes();
        
        for (Iterator<Internacao> it = listInternacao.iterator(); it.hasNext();) {
            Internacao internacao = it.next();
            assertNotNull(internacao.getMedicoResponsavel());
            assertNotNull(internacao.getPaciente());
            assertNotNull(internacao.getDataInicio());
            assertNotNull(internacao.getDataFim());
        }
   
    }

    @Test
    public void testListarMedicoEnfermeiroDeUmHospital() {

        Hospital hospital = Hospital.getHospital(HOSPITAL_01);

        List<Empregado> listEmpregado = new ArrayList<Empregado>();
        assertTrue(hospital.listMedicoEnfermeiro().getClass().equals(listEmpregado.getClass()));
        //???

    }

    @Test
    public void testListMedicoEnfermeiroInternacaoPaciente() {

        Paciente p1 = Paciente.getPaciente(PACIENTE_02);
        Internacao internacao = Internacao.getInternacao(INTERNACAO_02);

        assertTrue(internacao.getPaciente().equals(p1));

        List<Empregado> listEmpregado = internacao.listMedicoEnfermeiro();
        // ???
        assertTrue(internacao.listMedicoEnfermeiro().getClass().equals(listEmpregado.getClass()));

    }

    @Test
    public void testListHospitalEmpregadoVinculado() {

        Empregado empregado01 = Empregado.getEmpregado(MEDICO_01);
        Empregado empregado02 = Empregado.getEmpregado(ENFERMEIRO_04);

        List<Hospital> listHospital = new ArrayList<Hospital>();
        assertTrue(empregado01.listHospitalEmpregadoVinculado().getClass().equals(listHospital.getClass()));
        //???
        assertTrue(empregado02.listHospitalEmpregadoVinculado().getClass().equals(listHospital.getClass()));
        //???
    }

}