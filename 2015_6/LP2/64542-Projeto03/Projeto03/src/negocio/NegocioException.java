package negocio;

public class NegocioException extends Exception {

    public NegocioException() {
        super("Erro ocorrido no Roteiro de Transação");
    }

    public NegocioException(String msg) {
        super(msg);
    }
}
