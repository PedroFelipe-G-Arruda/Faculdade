/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execucao;

/**
 *
 * @author Pedro Arruda
 */
public class Principal {
    private static AlunoNegocio alunoNegocio;

 public static void main (String[]args){ 
     try{
 alunoNegocio = new AlunoNegocio();
 }catch (NegocioException ex ){
 System.out.println("Camada de negocio e persistencia nao iniciada − " + ex.getMessage());
}

 if(alunoNegocio != null){
 EnumMenuAluno opcao = EnumMenuAluno.Sair;
 do {
 try{ 
     opcao = exibirMenu();
 switch (opcao){
     case IncluirAluno:
        incluirAluno();
        break;
 case AlterarAluno:
 alterarAluno();
 break;
 case ExcluirAluno:
 excluirAluno();
 break;
 case PesqMatricula:
 pesquisarPorMatricula();
 break;
 case PesqNome :
 pesquisarPorNome();
 }
 } catch (NegocioException ex ) {
 System.out.println("Operacao nao realizada corretamente − " + ex.getMessage());
 }
 }while (opcao != EnumMenuAluno.Sair);
 }
 System.exit(0) ;
 }

 /∗∗
 ∗Inclui um novo aluno na base de dados
 ∗
 ∗ @throws NegocioException
 ∗/
 private static void incluir Aluno () throws NegocioException {

 AlunoVO alunoTemp = lerDados();
 alunoNegocio.inserir(alunoTemp);
 }
/∗∗
 ∗ Permite a alteracao dos dados de um aluno por meio da matricula
 ∗ fornecida.
 ∗
 ∗ @throws NegocioException
 ∗/
 private static void alterarAluno()throws NegocioException{
 int matricula = 0 ;
 try{ 
     matricula = Integer.parseInt( JOptionPane.show InputDialog (null , " Forneca a matricula do Aluno " , " Leitura de Dados " , JOptionPane.QUESTION_MESSAGE));
 } catch (Exception ex ) {
 JOptionPane.showMessageDialog(null, "Digitacao inconsistente − " + ex.getMessage());
 }

 AlunoVO alunoVO = alunoNegocio.pesquisaMatricula(matricula);
 if(alunoVO != null) {
 AlunoVO alunoTemp = lerDados(alunoVO); 
 alunoNegocio.alterar( alunoTemp ) ;
 } else {
 JOptionPane.showMessageDialog(null, " Aluno nao localizado");
 }
 }

 /∗∗
 ∗Exclui um aluno por meio de uma matricula fornecida. 
 ∗
 ∗ @throws NegocioException
 ∗/
 private static void excluirAluno() throws NegocioException {
 int matricula = 0 ;
 try{ 
     matricula = Integer.parseInt(JOptionPane.showInputDialog(null, " Forneca a matricula do Aluno " , " Leitura de Dados " , JOptionPane.QUESTION_MESSAGE));
} catch (Exception ex ) {
JOptionPane.showMessageDialog(null, "Digitacao inconsistente − " + ex.getMessage());
}
 AlunoVO alunoVO = alunoNegocio.pesquisaMatricula(matricula);
if(alunoVO != null) {
 alunoNegocio.excluir(alunoVO.getMatricula());
 } else {
 JOptionPane.showMessageDialog(null,"Aluno nao localizado");
 }
 }

 /∗∗
 ∗ Pesquisa um alun o por meio da matricula.
 ∗
 ∗ @throws NegocioException
 ∗/
 private static void pesquisarPorMatricula()throws NegocioException {
 int matricula = 0 ;
 try{
 matricula = Integer.parseInt(JOptionPane.showInputDialog(null,"Forneca a matricula do Aluno","Leitura de Dados",JOptionPane.QUESTION_MESSAGE) ) ;
 } c a t ch ( Ex c ep t i on ex ) {
 JOpt ionPane . showM essag eD ia log ( n u l l , " D i g i t a c a o i n c o n s i s t e n t e − " + ex . g etM essag e ( ) ) ;
 }

 AlunoVO alunoVO = a lun oN e g o c i o . p e s q u i s aM a t r i c u l a ( m a t r i c u l a ) ;
 i f ( alunoVO != n u l l ) {
 mostrarDados ( alunoVO ) ;
 } e l s e {
 JOpt ionPane . showM essag eD ia log ( n u l l , " Aluno nao l o c a l i z a d o " ) ;
 }
 }

 /∗∗
 ∗ Le um nome ou p a r t e de um nome de um a lun o e bus ca no banco de dados
 ∗ a l u n o s que possuem e s s e nome , ou que i n i c i am com a p a r t e do nome
 ∗ f o r n e c i d a . Caso nao s e j a f o r n e c i d o nenhum v a l o r de en t r ad a s e r a r e t o r n a d o
 ∗ o s 10 p r imm e i r o s a l u n o s o rd en ad o s p e l o nome .
 ∗
 ∗ @throws N e g o c i oE x c ep t i on
 ∗/
 p r i v a t e s t a t i c v o id pesqu isarPorNome ( ) throws N e g o c i oE x c ep t i on {

 S t r i n g nome = JOpt ionPane . show Inpu tD i a lo g ( n u l l , " ForneÃ§a o nome do Aluno " , " L e i t u r a de
Dados " , JOpt ionPane .QUESTION_MESSAGE) ;
 i f ( nome != n u l l ) {
 L i s t <AlunoVO> l istaA lunoVO = a lun oN e g o c i o . p esqu isaPart eNom e ( nome ) ;

 i f ( l istaA lunoVO . s i z e ( ) > 0 ) {
 f o r (AlunoVO alunoVO : l istaA lunoVO ) {
 mostrarDados ( alunoVO ) ;
 }
 } e l s e {
 JOpt ionPane . showM essag eD ia log ( n u l l , " Aluno nao l o c a l i z a d o " ) ;
 }
 } e l s e {
 JOpt ionPane . showM essag eD ia log ( n u l l , "Nome nao pode s e r nu l o " ) ;
 }
 }

 /∗∗
 ∗ Ex ibe no c o n s o l e da a p l i c a c a o o s dados dos a l u n o s r e c e b i d o s p e l o
 ∗ param etro alunoVO .
 ∗
 ∗ @param alunoVO
 ∗/
 p r i v a t e s t a t i c v o id mostrarDados (AlunoVO alunoVO ) {
 i f ( alunoVO != n u l l ) {
 System . out . p r i n t l n ( " M a t r i c u l a : " + alunoVO . g e tM a t r i c u l a ( ) ) ;
 System . out . p r i n t l n ( "Nome : " + alunoVO . getNome ( ) ) ;
 System . out . p r i n t l n ( "Nome da Mae : " + alunoVO . getNomeMae ( ) ) ;
 System . out . p r i n t l n ( "Nome da Pa i : " + alunoVO . getNomePai ( ) ) ;
 System . out . p r i n t l n ( " Sexo : " + alunoVO . g e tS ex o ( ) . name ( ) ) ;
 i f ( alunoVO . g e tEnd e r e c o ( ) != n u l l ) {
 System . out . p r i n t l n ( " Logradouro : " + alunoVO . g e tEnd e r e c o ( ) . g e t L o g r ad ou r o ( ) ) ;
 System . out . p r i n t l n ( " Numero : " + alunoVO . g e tEnd e r e c o ( ) . getNumero ( ) ) ;
 System . out . p r i n t l n ( " B a i r r o : " + alunoVO . g e tEnd e r e c o ( ) . g e t B a i r r o ( ) ) ;
 System . out . p r i n t l n ( " C idade : " + alunoVO . g e tEnd e r e c o ( ) . g e tC id ad e ( ) ) ;
 System . out . p r i n t l n ( "UF: " + alunoVO . g e tEnd e r e c o ( ) . g e tU f ( ) ) ;
 System . out . p r i n t l n ( "−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−" ) ;
 }
 }
 }

 /∗∗
 ∗ Le o s dados de um a lun o e x i b i n d o o s dados a t u a i s r e c e b i d o s p e l o param etro
 ∗ alunoTemp . Na a l t e r a c a o p e rm i t e que o s dados a t u a i s do a l u n o s se jam
 ∗ v i s u a l i z a d o s . Na in c lusÃ£o sÃ£o e x i b i d o s o s dados i n i c i a l i z a d o s no AlunoVO .
 ∗
 ∗ @param alunoTemp
 ∗ @return
 ∗/
 p r i v a t e s t a t i c AlunoVO l e rD ad o s (AlunoVO alunoTemp ) {

 S t r i n g nome , nomeMae , nomePai , l o g r ad ou r o , b a i r r o , c i d a d e ;
 i n t numero ;
 EnumSexo s e x o ;
 EnumUF u f ;

 t r y {
 nome = JOpt ionPane . sh ow Inpu tD ia log ( " Forn eca o nome do Aluno " , alunoTemp . getNome ( ) . t r im ( )
) ;
 alunoTemp . setNome ( nome ) ;
 nomeMae = JOpt ionPane . show Inpu tD ia l og ( " Forn eca o nome da mae do Aluno " , alunoTemp .
getNomeMae ( ) . t r im ( ) ) ;
 alunoTemp . setNomeMae (nomeMae ) ;

 nomePai = JOpt ionPane . sh ow Inpu tD ia lo g ( " Forn e ca o nome do p a i do Aluno " , alunoTemp .
getNomePai ( ) . t r im ( ) ) ;
 alunoTemp . setNomePa i ( nomePai ) ;

 s e x o = ( EnumSexo ) JOpt ionPane . show Inpu tD i a l og ( n u l l , " E s c o lh a uma Opcaoo " , " L e i t u r a de
Dados " ,
 JOpt ionPane .QUESTION_MESSAGE, n u l l , EnumSexo . v a l u e s ( ) , alunoTemp . g e tS ex o ( ) ) ;
 alunoTemp . s e t S e x o ( s e x o ) ;

 l o g r a d o u r o = JOpt ionPane . show Inpu tD i a l og ( " ForneÃ§a o l o g r a d o u r o do e n d e r e c o " , alunoTemp .
g e tEnd e r e c o ( ) . g e t L o g r ad ou r o ( ) . t r im ( ) ) ;
 alunoTemp . g e tEnd e r e c o ( ) . s e t L o g r ad o u r o ( l o g r a d o u r o ) ;

 numero = I n t e g e r . p a r s e I n t ( JOpt ionPane . sh ow Inpu tD ia lo g ( " ForneÃ§a o numero no e n d e r e c o " ,
alunoTemp . g e tEnd e r e c o ( ) . getNumero ( ) ) ) ;
 alunoTemp . g e tEnd e r e c o ( ) . setNumero ( numero ) ;

 b a i r r o = JOpt ionPane . show Inpu tD i a lo g ( " ForneÃ§a o b a i r r o no e n d e r e c o " , alunoTemp .
g e tEnd e r e c o ( ) . g e t B a i r r o ( ) . t r im ( ) ) ;
 alunoTemp . g e tEnd e r e c o ( ) . s e t B a i r r o ( b a i r r o ) ;

 c i d a d e = JOpt ionPane . show Inpu tD ia l og ( " ForneÃ§a a c i d a d e no e n d e r e c o " , alunoTemp .
g e tEnd e r e c o ( ) . g e tC id ad e ( ) . t r im ( ) ) ;
 alunoTemp . g e tEnd e r e c o ( ) . s e tC id ad e ( c i d a d e ) ;

 u f = (EnumUF) JOpt ionPane . show Inpu tD i a lo g ( n u l l , " E s c o lh a uma Opcao " , " L e i t u r a de Dados " ,
 JOpt ionPane .QUESTION_MESSAGE, n u l l , EnumUF . v a l u e s ( ) , alunoTemp . g e tEnd e r e c o ( ) .
g e tU f ( ) ) ;
 alunoTemp . g e tEnd e r e c o ( ) . s e tU f ( u f ) ;
} c a t ch ( Ex c ep t i on ex ) {
 System . out . p r i n t l n ( " D i g i t a c a o i n c o n s i s t e n t e − " + ex . g etM essag e ( ) ) ;
 }
 r e t u r n alunoTemp ;
 }

 /∗∗
 ∗ C r i a uma nova i n t a n c i a de AlunoVO e chama o metodo l e r d a d o s (AlunoVO
 ∗ alunoVO ) .
 ∗
 ∗ @return
 ∗/
 p r i v a t e s t a t i c AlunoVO l e rD ad o s ( ) {
 AlunoVO alunoTemp = new AlunoVO ( ) ;
 r e t u r n l e rD ad o s ( alunoTemp ) ;
 }

 /∗∗
 ∗ Ex ibe a s op c o e s por meio de uma t e l a de d i a l o g o .
 ∗
 ∗ @return
 ∗/
 p r i v a t e s t a t i c EnumMenuAluno ex ib irM enu ( ) {
 EnumMenuAluno opcao ;

 opcao = ( EnumMenuAluno ) JOpt ionPane . sh ow Inpu tD ia lo g ( n u l l , " E s c o lh a uma Opcao " , "Menu" ,
 JOpt ionPane .QUESTION_MESSAGE, n u l l , EnumMenuAluno . v a l u e s ( ) , EnumMenuAluno . v a l u e s ( )
[ 0 ] ) ;
 i f ( opcao == n u l l ) {
 JOpt ionPane . showM essag eD ia log ( n u l l , "Nenhuma Opcao E s c o l h i d a " ) ;
 opcao = EnumMenuAluno . S a i r ;
 }
 r e t u r n opcao ;
 }
}
