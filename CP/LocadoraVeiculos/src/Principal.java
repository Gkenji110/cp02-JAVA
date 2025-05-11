import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        ArrayList<Locacao> locacoes = new ArrayList<>();
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
            if (clienteJaPossuiLocacao(locacoes, cliente.getCpf())) {
                System.out.println("O cliente já possui uma locação ativa. Não é possível alugar outro veículo.");
                continue;
            }
            LocalDate dataFim = obterData();

            locacoes.add(new Locacao(cliente, veiculo, dataFim));
            System.out.println("\nVeículo alugado com sucesso!");
        }
        scanner.close();
    }

    private static Veiculo cadastrarVeiculo(ArrayList<Locacao> locacoes) {
        System.out.println("Cadastro de veículo:");
        String placa, modelo;
        while (true) {
            System.out.print("Digite a placa: ");
            placa = scanner.nextLine();
            System.out.print("Digite o modelo: ");
            modelo = scanner.nextLine();
            if (veiculoJaAlugado(locacoes, placa, modelo)) {
                System.out.println("Já existe uma locação registrada com esse veículo (placa e modelo). Digite outro.");
            } else {
                break;
            }
        }
        return new Veiculo(placa, modelo);
    }

    private static boolean veiculoJaAlugado(ArrayList<Locacao> locacoes, String placa, String modelo) {
        for (Locacao loc : locacoes) {
            if (loc.getVeiculo().getPlaca().equalsIgnoreCase(placa) &&
                loc.getVeiculo().getModelo().equalsIgnoreCase(modelo)) {
                return true;
            }
        }
        return false;
    }

    private static boolean clienteJaPossuiLocacao(ArrayList<Locacao> locacoes, String cpf) {
        for (Locacao loc : locacoes) {
            if (loc.getCliente().getCpf().equalsIgnoreCase(cpf)) {
                return true;
            }
        }
        return false;
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
                System.out.print("A data que pretende devolver (formato dd/MM/yyyy):" );
                String dataString = scanner.nextLine();
                return LocalDate.parse(dataString, formatter);
            } catch (Exception e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }
    }
}