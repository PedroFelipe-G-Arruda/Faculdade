package persistencia;

public class PersistenciaException extends Exception {

    public PersistenciaException() {
        super("Erro ocorrido na conexão do banco de dados");
    }

    public PersistenciaException(String msg) {
        super(msg);
    }
}
