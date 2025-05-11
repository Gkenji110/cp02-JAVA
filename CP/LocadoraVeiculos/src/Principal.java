import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        List<Locacao> locacoes = new ArrayList<>();
        String controlador = "1";

        while (controlador.equals("1")) {
            System.out.print("Digite 1 para continuar, 0 para sair: ");
            controlador = scanner.nextLine();
            if (!controlador.equals("1")) {
                System.out.println("Encerrando o programa...");
                break;
            }

            Veiculo veiculo = cadastrarVeiculo(locacoes);
            Cliente cliente = cadastrarCliente();

            if (Locacao.clienteJaPossuiLocacao(locacoes, cliente.getCpf())) {
                System.out.println("O cliente já possui uma locação ativa. Não é possível alugar outro veículo.");
                continue;
            }

            LocalDate dataFim = obterData();

            locacoes.add(new Locacao(cliente, veiculo, dataFim));
            System.out.println("\nVeículo alugado com sucesso!");
        }

        scanner.close();
    }

    private static Veiculo cadastrarVeiculo(List<Locacao> locacoes) {
        System.out.println("Cadastro de veículo:");
        Veiculo veiculo;
        while (true) {
            System.out.print("Digite a placa: ");
            String placa = scanner.nextLine();
            System.out.print("Digite o modelo: ");
            String modelo = scanner.nextLine();
            veiculo = new Veiculo(placa, modelo);

            if (Locacao.veiculoJaAlugado(locacoes, veiculo)) {
                System.out.println("Já existe uma locação registrada com esse veículo. Digite outro.");
            } else {
                break;
            }
        }
        return veiculo;
    }

    private static Cliente cadastrarCliente() {
        System.out.println("\nCadastro de cliente:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        return new Cliente(nome, cpf);
    }

    private static LocalDate obterData() {
        while (true) {
            try {
                System.out.print("A data que pretende devolver (formato dd/MM/yyyy): ");
                String dataString = scanner.nextLine();
                return LocalDate.parse(dataString, formatter);
            } catch (Exception e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }
    }
}