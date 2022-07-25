package armazem;

import Ingredientes.Fruta;
import Ingredientes.Ingrediente;
import Ingredientes.TipoFruta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArmazemTest {

    @Test
    public void cadastrarIngredienteEmEstoque(){

        Armazem armazem = new Armazem();
        Ingrediente abacate = new Fruta(TipoFruta.Abacate);
        armazem.cadastrarIngredienteEmEstoque(abacate);

        assertNotNull(armazem.getEstoque().get(abacate));
        assertEquals(armazem.getEstoque().get(abacate),0);
    }

    @Test
    public void cadastrarIngredienteEmEstoqueQueJaExiste(){
        Armazem armazem = new Armazem();
        Ingrediente abacate = new Fruta(TipoFruta.Abacate);
        armazem.cadastrarIngredienteEmEstoque(abacate);
        try{
            armazem.cadastrarIngredienteEmEstoque(abacate);
            fail("Exceção não encontrada");
        }catch (Throwable e){
            assertEquals("Ingrediente já cadastrado",e.getMessage());
            assertEquals(IllegalArgumentException.class,e.getClass());
        }
    }

    @Test
    public void descadastrarIngredienteEmEstoque(){
        Armazem armazem = new Armazem();
        Ingrediente morango = new Fruta(TipoFruta.Morango);
        armazem.cadastrarIngredienteEmEstoque(morango);
        armazem.descadastrarIngredienteEmEstoque(morango);

        assertNull(armazem.getEstoque().get(morango));
    }
    @Test
    public void descadastrarIngredienteEmEstoqueQueNaoExiste(){
        Armazem armazem = new Armazem();
        Ingrediente morango = new Fruta(TipoFruta.Morango);
        try {
            armazem.descadastrarIngredienteEmEstoque(morango);
            fail("Exceção não encontrada");
        }catch (Throwable e){
            assertEquals("Ingrediente não encontrado", e.getMessage());
            assertEquals(IllegalArgumentException.class,e.getClass());
        }
    }

    @Test
    public void adicionarQuantidadeDoIngredienteEmEstoque(){
        Armazem armazem = new Armazem();
        Ingrediente morango = new Fruta(TipoFruta.Morango);
        armazem.cadastrarIngredienteEmEstoque(morango);
        armazem.adicionarQuantidadeDoIngredienteEmEstoque(morango,2);

        assertEquals(armazem.getEstoque().get(morango),2);
    }

    @Test
    public void adicionarQuantidadeDoIngredienteEmEstoqueQueNaoExiste(){
        Armazem armazem = new Armazem();
        Ingrediente morango = new Fruta(TipoFruta.Morango);
        try {
            armazem.adicionarQuantidadeDoIngredienteEmEstoque(morango,1);
            fail("Exceção não encontrada");
        }catch (Throwable e){
            assertEquals("Ingrediente não encontrado", e.getMessage());
            assertEquals(IllegalArgumentException.class,e.getClass());
        }
    }
    @Test
    public void adicionarQuantidadeDoIngredienteEmEstoqueQuantidadeInvalida(){
        Armazem armazem = new Armazem();
        Ingrediente morango = new Fruta(TipoFruta.Morango);
        armazem.cadastrarIngredienteEmEstoque(morango);
        try {
            armazem.adicionarQuantidadeDoIngredienteEmEstoque(morango,-5);
            fail("Exceção não encontrada");
        }catch (Throwable e){
            assertEquals("Quantidade inválida", e.getMessage());
            assertEquals(IllegalArgumentException.class,e.getClass());
        }
    }

    @Test
    public void reduzirQuantidadeDoIngredienteEmEstoque(){
        Armazem armazem = new Armazem();
        Ingrediente morango = new Fruta(TipoFruta.Morango);
        armazem.cadastrarIngredienteEmEstoque(morango);
        armazem.adicionarQuantidadeDoIngredienteEmEstoque(morango,2);

        armazem.reduzirQuantidadeDoIngredienteEmEstoque(morango,1);

        assertEquals(1,armazem.getEstoque().get(morango));
    }
    @Test
    public void reduzirQuantidadeDoIngredienteEmEstoqueQueNaoExiste(){
        Armazem armazem = new Armazem();
        Ingrediente morango = new Fruta(TipoFruta.Morango);

        try {
            armazem.reduzirQuantidadeDoIngredienteEmEstoque(morango,1);
            fail("Exceção não encontrada");
        }catch (Throwable e){
            assertEquals("Ingrediente não encontrado", e.getMessage());
            assertEquals(IllegalArgumentException.class,e.getClass());
        }

    }
    @Test
    public void reduzirQuantidadeDoIngredienteEmEstoqueQuantidadeInvalida(){
        Armazem armazem = new Armazem();
        Ingrediente morango = new Fruta(TipoFruta.Morango);
        armazem.cadastrarIngredienteEmEstoque(morango);
        armazem.adicionarQuantidadeDoIngredienteEmEstoque(morango,2);

        try {
            armazem.reduzirQuantidadeDoIngredienteEmEstoque(morango,3);
            fail("Exceção não encontrada");
        }catch (Throwable e){
            assertEquals("Quantidade inválida", e.getMessage());
            assertEquals(IllegalArgumentException.class,e.getClass());
        }

    }

    @Test
    public void consultarQuantidadeDoIngredienteEmEstoque(){
        Armazem armazem = new Armazem();
        Ingrediente morango = new Fruta(TipoFruta.Morango);
        armazem.cadastrarIngredienteEmEstoque(morango);
        armazem.adicionarQuantidadeDoIngredienteEmEstoque(morango,5);


        assertEquals(armazem.getEstoque().get(morango),armazem.consultarQuantidadeDoIngredienteEmEstoque(morango));
    }
    @Test
    public void consultarQuantidadeDoIngredienteEmEstoqueQueNaoExiste(){
        Armazem armazem = new Armazem();
        Ingrediente morango = new Fruta(TipoFruta.Morango);

        try {
            armazem.consultarQuantidadeDoIngredienteEmEstoque(morango);
            fail("Exceção não encontrada");
        }catch (Throwable e){
            assertEquals("Ingrediente não encontrado", e.getMessage());
            assertEquals(IllegalArgumentException.class,e.getClass());
        }
    }

}