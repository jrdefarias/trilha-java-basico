import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = getIntInput(scanner, "Digite o número da conta: ", "Número da conta inválido. Por favor, insira um número inteiro.");

        String branch = getStringInput(scanner, "Digite o número da agência: ", "O número da agência não pode ser vazio. Por favor, insira um valor válido.");

        String customerName = getStringInput(scanner, "Digite o nome do cliente: ", "O nome do cliente não pode ser vazio. Por favor, insira um nome válido.");

        double balance = getDoubleInput(scanner, "Digite o saldo da conta: ", "Saldo da conta inválido. Por favor, insira um valor numérico.");

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        String formattedBalance = currencyFormat.format(balance);

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco. Sua agência é %s, conta %d e seu saldo %s já está disponível para saque.%n", customerName, branch, number, formattedBalance);
    }

    private static int getIntInput(Scanner scanner, String prompt, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }

    private static String getStringInput(Scanner scanner, String prompt, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (!input.trim().isEmpty()) {
                return input;
            }
            System.out.println(errorMessage);
        }
    }

    private static double getDoubleInput(Scanner scanner, String prompt, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }
}
