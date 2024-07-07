public class Passagem {
    private Voo voo;
    private String nomePassageiro;
    private double preco;

    public Passagem(Voo voo, String nomePassageiro, double preco) {
        this.voo = voo;
        this.nomePassageiro = nomePassageiro;
        this.preco = preco;
    }

    public Voo getVoo() {
        return voo;
    }

    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "=== Passagem ===\n" +
                "Voo #" + voo.getNumeroVoo() + "\n" +
                "Origem: " + voo.getOrigem() + "\n" +
                "Destino: " + voo.getDestino() + "\n" +
                "Data: " + voo.getData() + "\n" +
                "Passageiro: " + nomePassageiro + "\n" +
                "Preço: R$ " + preco + "\n" +
                "================";
    }
}


