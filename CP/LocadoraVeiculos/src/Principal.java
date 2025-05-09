import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de veículo:");
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        Veiculo veiculo = new Veiculo("placa", "modelo", true);

        System.out.println("\nCadastro de cliente:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf);

        System.out.println("\nRealizando locação...");
        Locacao locacao = new Locacao(cliente, veiculo);
        System.out.println("Veículo alugado com sucesso!");

        // Finalização
        System.out.println("\nFinalizando locação...");
        locacao.finalizarLocacao();
        System.out.println("Locação finalizada com sucesso!");
    }
}
