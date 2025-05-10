import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Locacao> locacoes = new ArrayList<>();
        String controlador = "1";

        while (controlador.equals("1")) {
            System.out.println("Digite 1 para continuar, 0 para sair:");
            controlador = scanner.nextLine();

            if (!controlador.equals("1")) {
                System.out.println("Encerrando o programa...");
                break;
            }

            System.out.println("Cadastro de veículo:");
            String placa;
            while (true) {
                System.out.print("Digite a placa: ");
                placa = scanner.nextLine();

                boolean placaJaExiste = false;
                for (Locacao loc : locacoes) {
                    if (loc.getVeiculo().getPlaca().equalsIgnoreCase(placa)) {
                        placaJaExiste = true;
                        break;
                    }
                }

                if (placaJaExiste) {
                    System.out.println("Já existe uma locação registrada com essa placa. Digite outra.");
                } else {
                    break;
                }
            }

            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();

            System.out.print("A data que pretende devolver (formato dd/MM/yyyy): ");
            String dataFimString = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataFim = LocalDate.parse(dataFimString, formatter);
            Veiculo veiculo = new Veiculo(placa, modelo);

            System.out.println("\nCadastro de cliente:");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            Cliente cliente = new Cliente(nome, cpf);

            Locacao locacao = new Locacao(cliente, veiculo, dataFim);
            locacoes.add(locacao);
            System.out.println("\nVeículo alugado com sucesso!");
        }
        scanner.close();
    }
}
