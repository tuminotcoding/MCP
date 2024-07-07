import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Passagem> passagens;

    public CarrinhoDeCompras() {
        this.passagens = new ArrayList<>();
    }

    public void adicionarPassagem(Passagem passagem) {
        passagens.add(passagem);
    }

    public void removerPassagem(Passagem passagem) {
        passagens.remove(passagem);
    }

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public double calcularTotal() {
        double total = 0;
        for (Passagem passagem : passagens) {
            total += passagem.getPreco();
        }
        return total;
    }

    public void finalizarCompra() {
        passagens.clear();
    }
}


