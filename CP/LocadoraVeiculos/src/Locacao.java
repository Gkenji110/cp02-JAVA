import java.time.LocalDate;

public class Locacao {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Locacao(Cliente cliente, Veiculo veiculo) {
        if (!veiculo.isDisponivel()) {
            throw new IllegalArgumentException("Veículo não está disponível");
        }
        this.cliente = cliente;
        this.veiculo = veiculo;
        veiculo.setDisponivel(false);
    }

    public void finalizarLocacao() {
        veiculo.setDisponivel(true);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
}

