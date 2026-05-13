package FarmaStock;

import java.util.ArrayList; // Importamos o ArrayList para usar a lista

public class Estoque {

    // A lista de produtos fica DENTRO do Estoque
    // Só o Estoque pode mexer nela diretamente (private)
    private ArrayList<Produto> produtos;

    // Construtor: quando criamos um Estoque, a lista começa vazia
    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    // Método para cadastrar um novo produto
    // Recebe os dados, cria o objeto Produto e adiciona na lista
    public void cadastrarProduto(String nome, int quantidade, double preco) {
        Produto novo = new Produto(nome, quantidade, preco);
        produtos.add(novo);
        System.out.println("✅ Produto '" + nome + "' cadastrado com sucesso!");
    }

    // Método para listar todos os produtos cadastrados
    public void listarProdutos() {

        // .isEmpty() verifica se a lista está vazia
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return; // Sai do método sem executar o resto
        }

        // for-each: percorre cada produto da lista um por vez
        // "Produto p" é uma variável temporária que representa o produto atual
        for (Produto p : produtos) {
            System.out.println("Produto: " + p.getNome() +
                               " | Quantidade: " + p.getQuantidade() +
                               " | Preço: " + p.getPreco());
        }
    }
    // Método auxiliar — busca um produto pelo nome
// Retorna o produto se encontrar, ou null se não existir
private Produto buscarPorNome(String nome) {

    for (Produto p : produtos) {

        // .equalsIgnoreCase() compara dois textos ignorando maiúsculas/minúsculas
        // Assim "coca-cola" e "Coca-Cola" são considerados iguais
        if (p.getNome().equalsIgnoreCase(nome)) {
            return p; // Encontrou! Retorna o produto
        }
    }

    return null; // Não encontrou nenhum produto com esse nome
}

// Método para registrar ENTRADA de produtos
public void registrarEntrada(String nome, int quantidade) {

    // Usamos o método auxiliar para encontrar o produto
    Produto p = buscarPorNome(nome);

    // Se o retorno foi null, o produto não existe
    if (p == null) {
        System.out.println("❌ Produto '" + nome + "' não encontrado.");
        return;
    }

    // Pega a quantidade atual e soma com a nova entrada
    p.setQuantidade(p.getQuantidade() + quantidade);
    System.out.println("✅ Entrada registrada! Nova quantidade de '" 
                        + nome + "': " + p.getQuantidade());
}

// Método para registrar SAÍDA de produtos
public void registrarSaida(String nome, int quantidade) {

    Produto p = buscarPorNome(nome);

    if (p == null) {
        System.out.println("Produto '" + nome + "' não encontrado.");
        return;
    }

    // Verifica se tem estoque suficiente antes de subtrair
    if (quantidade > p.getQuantidade()) {
        System.out.println("Estoque insuficiente! Disponível: " 
                            + p.getQuantidade());
        return;
    }

    // Pega a quantidade atual e subtrai a saída
    p.setQuantidade(p.getQuantidade() - quantidade);
    System.out.println("Saída registrada! Nova quantidade de '" 
                        + nome + "': " + p.getQuantidade());
}
}