import java.util.ArrayList;
import java.util.List;

public class ListaDePassagens {
    private List<Voo> voosDisponiveis;

    public ListaDePassagens() {
        this.voosDisponiveis = new ArrayList<>();
    }

    public void adicionarVoo(Voo voo) {
        voosDisponiveis.add(voo);
    }

    public List<Voo> getVoosDisponiveis() {
        return voosDisponiveis;
    }
}



