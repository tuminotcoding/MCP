public class Voo {
    private static int proximoNumero = 1;

    private int numeroVoo;
    private String origem;
    private String destino;
    private String data;
    private double preco;

    public Voo(String origem, String destino, String data, double preco) {
        this.numeroVoo = proximoNumero++;
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.preco = preco;
    }

    public int getNumeroVoo() {
        return numeroVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public String getData() {
        return data;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Voo #" + numeroVoo + " de " + origem + " para " + destino + " em " + data + " - Preço: R$ " + preco;
    }
}





