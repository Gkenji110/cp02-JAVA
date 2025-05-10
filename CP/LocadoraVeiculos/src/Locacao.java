import java.time.LocalDate;

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

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
}
