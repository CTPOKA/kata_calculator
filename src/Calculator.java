class Calculator {
    public static String calculate(String operator, String operand1, String operand2) throws IllegalArgumentException {
        if (isCorrectArabicNumber(operand1) && isCorrectArabicNumber(operand2)) {
            int a = Integer.parseInt(operand1);
            int b = Integer.parseInt(operand2);

            switch (operator) {
                case "+":
                    return String.valueOf(a + b);
                case "-":
                    return String.valueOf(a - b);
                case "/":
                    return String.valueOf(a / b);
                case "*":
                    return String.valueOf(a * b);
            }
        } else if (isCorrectRomanNumber(operand1) && isCorrectRomanNumber(operand2)) {
            int a = romanToInt(operand1);
            int b = romanToInt(operand2);

            switch (operator) {
                case "+":
                    return intToRoman(a + b);
                case "-":
                    return intToRoman(a - b);
                case "/":
                    return intToRoman(a / b);
                case "*":
                    return intToRoman(a * b);
            }
        }

        throw new IllegalArgumentException("Формат математической операции не удовлетворяет условию - два операнда (римские или арабские числа от 1 до 10) и один оператор (+, -, /, *)");
    }

    private static boolean isCorrectArabicNumber(String str) {
        try {
            int number = Integer.parseInt(str);
            return number >= 1 && number <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isCorrectRomanNumber(String str) {
        try {
            int number = romanToInt(str);
            return number >= 1 && number <= 10;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static int romanToInt(String str) throws IllegalArgumentException {
        String[] romanNums = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        for (int i = 0; i < romanNums.length; i++) {
            if (romanNums[i].equals(str))
                return i + 1;
        }

        throw new IllegalArgumentException("Некорректное римское число");
    }

    private static String intToRoman(int num) throws IllegalArgumentException {
        if (num < 1 || num > 3999)
            throw new IllegalArgumentException("В римской системе нет числа " + num);

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] +
                hundreds[(num % 1000) / 100] +
                tens[(num % 100) / 10] +
                ones[num % 10];
    }
}
