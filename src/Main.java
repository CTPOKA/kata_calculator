import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            String expression = scan.nextLine();

            if (expression.equals("exit"))
                break;

            String result = calc(expression);
            System.out.println(result);
        }
    }

    public static String calc(String expression) throws IllegalArgumentException {
        String[] terms = expression.split(" ");

        if (terms.length != 3) {
            throw new IllegalArgumentException("Формат математической операции не удовлетворяет условию - два операнда и один оператор");
        }

        String operator = terms[1];
        String operand1 = terms[0];
        String operand2 = terms[2];

        return Calculator.calculate(operator, operand1, operand2);
    }
}