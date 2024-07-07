import java.util.List;

public class Cliente extends Pessoa {
    private CarrinhoDeCompras carrinho;

    public Cliente(String nome) {
        super(nome);
        this.carrinho = new CarrinhoDeCompras();
    }

    public void adicionarPassagem(Passagem passagem) {
        carrinho.adicionarPassagem(passagem);
    }

    public void removerPassagem(Passagem passagem) {
        carrinho.removerPassagem(passagem);
    }

    public List<Passagem> getCarrinho() {
        return carrinho.getPassagens();
    }

    public double calcularTotalCarrinho() {
        return carrinho.calcularTotal();
    }

    public void finalizarCompra() {
        carrinho.finalizarCompra();
    }
}

