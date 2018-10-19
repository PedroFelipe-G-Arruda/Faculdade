package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pedro Arruda
 */
public class ConexaoBD {

    private Connection con;
    private static ConexaoBD instancia;

    private ConexaoBD() throws PersistenciaException {
        try {
            Class.forName("org.postgresql.Drive");
            String url = "jdbc:postgresql://localhost:5432/academioco";
            con = DriverManager.getConnection(url, "postgres", "postgres");
        } catch (SQLException ex) {
            throw new PersistenciaException("Erro ao conctar o banco de dados - " + ex.toString());
        } catch (ClassNotFoundException ex) {
            throw new PersistenciaException("Drive do bando de dados não localizado - " + ex.toString());
        }
    }

    private static ConexaoBD getInstancia() throws PersistenciaException {
        if (instancia == null) {
            instancia = new ConexaoBD();
        }
        return instancia;
    }

    public Connection getConexao() {
        return con;
    }

    public void desconectar() throws PersistenciaException {
        try {
            con.close();
        } catch (SQLException ex) {
            throw new PersistenciaException("Erro as desconctar o banco de dados - " + ex.toString());
        }
    }
}
