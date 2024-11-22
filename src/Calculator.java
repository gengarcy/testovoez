import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();

        try {
            int result = calculate(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("throws Exception // " + e.getMessage());
        }
    }

    public static int calculate(String input) throws Exception {

        input = input.trim();


        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("неверный формат ввода");
        }

        int a = parseOperand(parts[0]);
        String operator = parts[1];
        int b = parseOperand(parts[2]);


        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new Exception("Деление на ноль невозможно");
                }
                return a / b;
            default:
                throw new Exception("Неизвестный оператор");
        }
    }

    private static int parseOperand(String operand) throws Exception {
        try {
            int value = Integer.parseInt(operand);
            if (value < 1 || value > 10) {
                throw new Exception("Операнды должны быть в диапазоне от 1 до 10");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new Exception("Операнды должны быть целыми числами");
        }
    }
}