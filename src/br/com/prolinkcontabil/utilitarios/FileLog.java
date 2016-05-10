/*
 * Todos direitos reservados a Tiago Dias.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.prolinkcontabil.utilitarios;

import br.com.prolinkcontabil.model.ModelDiretorios;

/**
 *
 * @author Tiago
 */
public class FileLog {
    public boolean gravaLog(ModelDiretorios diretorio){
        return !diretorio.getDiretorioDoLog().trim().equals("");
    }
}
