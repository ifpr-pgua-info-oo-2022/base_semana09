package projeto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**************/
/*REPITA COMIGO:*/
/*NÃO PRECISO ALTERAR ESSE ARQUIVO*/
/*NÃO PRECISO ALTERAR ESSE ARQUIVO*/
/*NÃO PRECISO ALTERAR ESSE ARQUIVO*/
/*NÃO PRECISO ALTERAR ESSE ARQUIVO*/

/*ESTA CLASSE POSSUI UMA SÉRIE DE TESTES AUTOMATIZADOS
 *PARA VERIFICAR SE O CÓDIGO QUE VOCÊ CRIOU ESTÁ FUNCIONANDO
 *E FAZENDO AQUILO QUE É ESPERADO.
 *O QUE VOCÊ PRECISA NESTE FAZER É CLICAR NA SETINHA
 * VERDE QUE FICA AO LADO DO NOME DE CADA MÉTODO.
 * SE O VSCODE INDICAR QUE EXISTEM ERROS DE COMPILAÇÃO,
 * PODE CLICAR NO CANTO INFERIOR DIREITO NO BOTÃO DE PROCEED.
 * A DICA É COMEÇAR A RESOLVER CADA UM DOS TESTES NA SEQUÊNCIA.
 * O OBJETIVO É DEIXAR TODOS OS TESTES PASSANDO (CHECK VERDE) AO FINAL
 * DA ATIVIDADE.
*/




public class AppTest 
{

   
    @Test
    @DisplayName("A classe produto possui todos os atributos com os tipos definidos")
    public void testaTiposAtributosLivro()throws NoSuchFieldException{
        Class<Produto> clazz = Produto.class;
        
        Field nome = clazz.getDeclaredField("nome");
        Field peso = clazz.getDeclaredField("peso");
        Field valor = clazz.getDeclaredField("valor");
        Field quantidade = clazz.getDeclaredField("quantidade");
        
        
        
        assertEquals(true,nome.getType()==String.class,"O tipo do nome não é String");
        assertEquals(true,peso.getType().getTypeName()=="double","O tipo do peso não é double");
        assertEquals(true,valor.getType().getTypeName()=="double","O tipo do valor não é double");
        assertEquals(true,quantidade.getType().getTypeName()=="int","O tipo da quantidade não é int");
        
    }


    @Test
    @DisplayName("A classe Produto possui todos os atributos e são privados")
    public void testaAtributosLivro()throws NoSuchFieldException{
        Class<Produto> clazz = Produto.class;
        
        Field nome = clazz.getDeclaredField("nome");
        Field peso = clazz.getDeclaredField("peso");
        Field valor = clazz.getDeclaredField("valor");
        Field quantidade = clazz.getDeclaredField("quantidade");
    
        
        
        assertTrue(Modifier.isPrivate(nome.getModifiers()),"O atributo nome não está privado");
        assertTrue(Modifier.isPrivate(peso.getModifiers()),"O atributo peso não está privado");
        assertTrue(Modifier.isPrivate(valor.getModifiers()),"O atributo valor não está privado");
        assertTrue(Modifier.isPrivate(quantidade.getModifiers()),"O atributo quantidade não está privado");
    

    }

    @Test
    @DisplayName("Na classe Produto existe somente um método construtor definido")
    public void testaConstrutorProduto(){

        String nome = "Produto";
        double peso = 1.0;
        double valor = 1.0;
        int quantidade = 1;
        
        Produto produto = new Produto(nome,peso,valor,quantidade);
        
        assertEquals(1, Produto.class.getDeclaredConstructors().length,"A classe Produto possui mais de um construtor");

    }   

    @Test
    @DisplayName("Na classe Produto existe os getters e os atributos estão com valores corretos")
    public void testaGettersEInicializacaoLivro(){

        String nome = "Produto";
        double peso = 1.0;
        double valor = 1.0;
        int quantidade = 1;
        
        Produto produto = new Produto(nome,peso,valor,quantidade);

        assertEquals(produto.getNome(), nome,"O getter do nome não está correto");
        assertEquals(produto.getPeso(), peso,0.0001,"O getter do peso está correto");
        assertEquals(produto.getValor(), valor,0.0001,"O getter do valor não está correto");
        assertEquals(produto.getQuantidade(), quantidade,"O getter da quantidade não está correto");
        
    }


    @Test
    @DisplayName("Na classe Produto existe os setters e os atributos são atualizados com valores corretos")
    public void testaSettersEAtualizacaoLivro(){

        
        String nome = "Produto";
        double peso = 1.0;
        double valor = 1.0;
        int quantidade = 1;
        
        Produto produto = new Produto(nome,peso,valor,quantidade);


        nome = "Produto Mudou";
        peso = 2.0;
        valor = 2.0;
        quantidade = 2;

        produto.setNome(nome);
        produto.setPeso(peso);
        produto.setValor(valor);
        produto.setQuantidade(quantidade);

        assertEquals(produto.getNome(), nome,"O setter do nome não está correto");
        assertEquals(produto.getPeso(), peso,0.0001,"O setter do peso está correto");
        assertEquals(produto.getValor(), valor,0.0001,"O setter do valor não está correto");
        assertEquals(produto.getQuantidade(), quantidade,"O setter da quantidade não está correto");
     
    }


    @Test
    @DisplayName("A classe Estoque existe e possui os atributos corretos e privados")
    public void testaEstoqueDeclaradoCorreto() throws NoSuchFieldException{
        Class clazz = Estoque.class;

        Field estoque = clazz.getDeclaredField("estoque");

        assertEquals(true, estoque.getType() == ArrayList.class,"O tipo do estoque está errado");
        

        assertEquals(true, Modifier.isPrivate(estoque.getModifiers()),"O atributo estoque não está privado");
        
    }

    @Test
    @DisplayName("A classe Estoque possui somente o construtor declarado")
    public void testaInstanciarEstoque(){

        Estoque estoque = new Estoque();
        
        assertEquals(1, Estoque.class.getDeclaredConstructors().length,"A classe Estoque possui mais de um construtor");

    }

    @Test
    @DisplayName("A classe Estoque permite tem um método getEstoque")
    public void testaGetEstoque(){
        
        Estoque estoque = new Estoque();

        ArrayList<Produto> lista = estoque.getEstoque();

        assertNotNull(lista,"O retorno do método getEstoque não pode ser null. Você inicializou o ArrayList?");
        assertEquals(0, lista.size(),"A quantidade de elementos da lista deveria ser 0");

    }


    @Test
    @DisplayName("A classe Estoque permite registrar um produto e armazena no arraylist")
    public void testaCadastrarProduto(){
        String nome = "Produto";
        double peso = 1.0;
        double valor = 1.0;
        int quantidade = 1;
        
        
        Estoque estoque = new Estoque();
        
        boolean ret = estoque.cadastrarProduto(nome,peso,valor,quantidade);
        
        assertEquals(true,ret,"O método cadastrarProduto deve retornar true neste caso");
        assertEquals(1, estoque.getEstoque().size(),"Depois de cadastrar um produto o tamanho da lista deve ser 1");
        assertEquals(nome, estoque.getEstoque().get(0).getNome(),"O nome do produto cadastrado deve estar na lista");

    }


    @Test
    @DisplayName("A classe Estoque não permite registrar dois produtos com o mesmo nome")
    public void testaNaoCadastrarProdutoRepetido(){
        Estoque estoque = new Estoque();
        
        String nome1 = "Produto";
        double peso1 = 1.0;
        double valor1 = 1.0;
        int quantidade1 = 1;
        
        String nome2 = "Produto";
        double peso2 = 1.0;
        double valor2 = 1.0;
        int quantidade2 = 1;
        
        
        
        boolean ret1 = estoque.cadastrarProduto(nome1,peso1,valor1,quantidade1);
        boolean ret2 = estoque.cadastrarProduto(nome2,peso2,valor2,quantidade2);
        
        assertEquals(true,ret1,"O retorno do método cadastrarProduto deve ser true neste caso");
        assertEquals(false, ret2,"O retorno do método cadastrarProduto deve ser false");
        assertEquals(1, estoque.getEstoque().size(),"O tamanho da lista deve ser 1 depois de cadastrar um livro");
    
    }

    @Test
    @DisplayName("A classe Estoque permite buscar um produto pelo nome")
    public void testaBuscarLivroTitulo(){
        Estoque estoque = new Estoque();
        
        String nome1 = "Produto";
        double peso1 = 1.0;
        double valor1 = 1.0;
        int quantidade1 = 1;
        
        String nome2 = "Produto 2";
        double peso2 = 2.0;
        double valor2 = 2.0;
        int quantidade2 = 2;
        
        
        
        estoque.cadastrarProduto(nome1,peso1,valor1,quantidade1);
        estoque.cadastrarProduto(nome2,peso2,valor2,quantidade2);
        
        Produto produto = estoque.buscarProduto(nome1);

        assertEquals(nome1,produto.getNome(),"O produto não foi encontrado corretamente");
    }

    @Test
    @DisplayName("A classe Estoque retorna null buscar um produto por um noe que não existe")
    public void testaNullBuscarLivroTituloNaoCadastrado(){
        Estoque estoque = new Estoque();
        
        String nome1 = "Produto";
        double peso1 = 1.0;
        double valor1 = 1.0;
        int quantidade1 = 1;
        
        String nome2 = "Produto 2";
        double peso2 = 2.0;
        double valor2 = 2.0;
        int quantidade2 = 2;
        
        
        
        estoque.cadastrarProduto(nome1,peso1,valor1,quantidade1);
        estoque.cadastrarProduto(nome2,peso2,valor2,quantidade2);
        
        Produto produto = estoque.buscarProduto("Produto 3");

        assertNull(produto,"O produto não deveria ter sido encontrado");
    }

    @Test
    @DisplayName("A classe Estoque retorna o produto com o maior valor")
    void testaBuscaMaiorValor(){
        Estoque estoque = new Estoque();
        
        String nome1 = "Produto";
        double peso1 = 1.0;
        double valor1 = 1.0;
        int quantidade1 = 1;
        
        String nome2 = "Produto 2";
        double peso2 = 2.0;
        double valor2 = 2.0;
        int quantidade2 = 2;

        String nome3 = "Produto 3";
        double peso3 = 3.0;
        double valor3 = 3.0;
        int quantidade3 = 3;
        
        
        estoque.cadastrarProduto(nome1,peso1,valor1,quantidade1);
        estoque.cadastrarProduto(nome3,peso3,valor3,quantidade3);
        estoque.cadastrarProduto(nome2,peso2,valor2,quantidade2);

        Produto produto = estoque.maiorPreco();

        assertNotNull(produto,"O produto retornado não pode ser null");
        assertEquals(nome3,produto.getNome(),"O produto encontrado não está correto");
    }

}