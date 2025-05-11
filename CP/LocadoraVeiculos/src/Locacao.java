import java.time.LocalDate;
import java.util.List;

public class Locacao {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Locacao(Cliente cliente, Veiculo veiculo, LocalDate dataFim) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = LocalDate.now();
        this.dataFim = dataFim;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public static boolean veiculoJaAlugado(List<Locacao> locacoes, Veiculo veiculo) {
        for (Locacao loc : locacoes) {
            if (loc.getVeiculo().EhmesmoVeiculo(veiculo)) {
                return true;
            }
        }
        return false;
    }

    public static boolean clienteJaPossuiLocacao(List<Locacao> locacoes, String cpf) {
        for (Locacao loc : locacoes) {
            if (loc.getCliente().getCpf().equalsIgnoreCase(cpf)) {
                return true;
            }
        }
        return false;
    }
}