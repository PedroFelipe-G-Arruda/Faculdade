package negocio;

public class ProdutoException extends Exception	{
	public static final long serialVersionUID = 3618174444238755471L;
	public static final String NOME_OBRIGATORIO = "Nome do produto eh de preenchimento obrigatorio.";
	public static final String NOME_TAMANHO = "Nome do produto deve possuir entre 5 a 60 caracteres.";
	public static final String QTDE_NEGATIVA = "Quantidade do produto nao pode ser menor do que zero (0).";
	public static final String QTDE_POSITIVA = "Produtos em estoque nao podem ser excluidos";
	public static final String VALOR_UNITARIO = "Valor do produto nao pode ser negativo";
	public static final String TIPO_OBRIGATORIO = "Tipo do produto eh de preenchimento obrigatorio";

	public ProdutoException(String msg) {
		super(msg);
	}
}
