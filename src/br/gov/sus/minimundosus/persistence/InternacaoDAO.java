/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.gov.sus.minimundosus.persistence;

import br.gov.sus.minimundosus.entity.Empregado;
import br.gov.sus.minimundosus.entity.Internacao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ricardo
 * Esta classe é um Mock para persistence em banco de dados
 */
public class InternacaoDAO {

    private static List<Internacao> internacoes = new ArrayList<Internacao>();

    public static void inserir(Internacao Internacao){
        internacoes.add(Internacao);
    }

    public static Internacao getInternacao(int codigo){
        for (Iterator<Internacao> it = internacoes.iterator(); it.hasNext();) {
            Internacao internacao = it.next();
            if (internacao.getCodigo() == codigo)
                return internacao;
        }
        return null;
    }
    
    public static List<Internacao> list(){
        return internacoes;
    }
}
