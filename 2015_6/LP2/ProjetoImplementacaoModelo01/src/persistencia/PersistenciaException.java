/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author Pedro Arruda
 */
public class PersistenciaException extends Exception {

    public PersistenciaException() {
        super("Erro ocorrido na conexão do banco de dados");
    }

    public PersistenciaException(String msg) {
        super(msg);
    }

}
