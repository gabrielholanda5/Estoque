package estoque;

import java.util.ArrayList;

public class ControleEstoque {
	
	private ArrayList<Produto> produtos;
	
	
	public ControleEstoque() {
		produtos = new ArrayList<Produto>();
	}
	
	public void addProduto(String nome, int quantidade) {
		
		// Percorre a lista, se encontrar um produto com o mesmo nome, ele atualiza a quantidade.
		for(Produto p : produtos) {
			if(p.getNome().equalsIgnoreCase(nome)) {
				p.setQuantidade(p.getQuantidade() + quantidade);
				// encerra o metodo apos achamar o produto e att a qtd.
				return;
			}
			
		}
		// Caso nao encontre o produto, ele cria um.
		produtos.add(new Produto(nome, quantidade));
	}
	
	public void removerProduto(String nome) {
		
		// Procura um produto na lista com o mesmo nome que o user digitou, caso encontre, ele remove o produto.
		for(int i = 0; i < produtos.size(); i++) {
			if(produtos.get(i).getNome().equalsIgnoreCase(nome)) {
				produtos.remove(i);
				// encerra o metodo apos encontrar e remover o produto.
				return;
			}
		}
		
		// executado caso nao encontre o produto digitado pelo user
		System.out.println("Esse produto não existe");
	}
	
	public void venderProduto(String nome, int quantidade) {
		
		// caso nao tenha nada na lista, a mensagem é exibida.
		if(produtos.isEmpty()) {
			System.out.println("Não há produtos!!!");
			// encerra o metodo caso nao tenha nada na lista.
			return;
		}
		// será executado caso tenha algo na lista
		else {
			for(Produto p : produtos) {
				if(p.getNome().equalsIgnoreCase(nome)) {
					// executado caso encontre o produto digitado pelo usuario e a quantidade em estoque seja maior ou igual a qual o usuario quer vender
					if(p.getQuantidade() >= quantidade) {
						p.setQuantidade(p.getQuantidade() - quantidade);
						System.out.println("Quantidade atualizada");
					}
					// executado caso a quantidade que o user quer vender seja maior do que a que tem em estoque
					else {
						System.out.println("Quantidade no estoque é inferior!!!");
					}
					
					return;
				}
			}
		}
		// é executado caso nao encontre esse produto na lista.
		System.out.println("Produto nao encontrado!!!");
	}
	
	public void mostrarProdutos() {
		
		// verifica se a lista produtos tem algum produto, se tiver vazia ele imprime a mensagem .
		if(produtos.isEmpty()) {
			System.out.println("Não ha produtos!!!");
			// encerra o metodo caso nao tenha nenhum produto.
			return;
		}
		// executado caso tenha algum produto na lista
		else {
			for(Produto p : produtos) {
				System.out.println(p.getNome() + " - " + p.getQuantidade());
			}
		}
	}
	
	
}
