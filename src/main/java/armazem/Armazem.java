package armazem;

import Ingredientes.Ingrediente;

import java.util.TreeMap;

public class Armazem {
    private TreeMap<Ingrediente,Integer> estoque = new TreeMap<>();

    public void cadastrarIngredienteEmEstoque(Ingrediente ingrediente){
        if(estoque.containsKey(ingrediente)){
            throw new IllegalArgumentException("Ingrediente já cadastrado");
        }
        estoque.put(ingrediente,0);
    }

    public void descadastrarIngredienteEmEstoque(Ingrediente ingrediente){
        if(!(estoque.containsKey(ingrediente))){
            throw new IllegalArgumentException("Ingrediente não encontrado");
        }
        estoque.remove(ingrediente);
    }

    public void adicionarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade){
        if(!(estoque.containsKey(ingrediente))){
            throw new IllegalArgumentException("Ingrediente não encontrado");
        }
        if(quantidade <= 0){
            throw new IllegalArgumentException("Quantidade inválida");
        }
        estoque.replace(ingrediente,quantidade);
    }

    public void reduzirQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade){
        var quantidadeEstoque = estoque.get(ingrediente);

        if(quantidadeEstoque == null){
            throw new IllegalArgumentException("Ingrediente não encontrado");
        }

        if ((quantidadeEstoque < quantidade )|| (quantidade <= 0)){
            throw new IllegalArgumentException("Quantidade inválida");
        }
        estoque.replace(ingrediente, quantidadeEstoque - quantidade);
    }

    public Integer consultarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente){
        var quantidadeEstoque = estoque.get(ingrediente);
        if(quantidadeEstoque == null){
            throw new IllegalArgumentException("Ingrediente não encontrado");
        }
        return quantidadeEstoque;
    }

    public TreeMap<Ingrediente, Integer> getEstoque() {
        return estoque;
    }

}
