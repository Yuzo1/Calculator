import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String input = null;
        while (true) {
            System.out.println("Введите 2 числа от 1 до 10 и оператор через пробел:");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            String output = calc(input);
            System.out.println("Ответ: " + output);
        }
    }
    public static String calc(String input) throws Exception {
        String[] arabic = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String str = input.trim();
        if (!str.matches("\\w+\\s[+\\-*/]\\s\\w+")) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String[] letters = str.split(" ");
        String let1 = letters[0];
        String let2 = letters[2];
        String let3 = letters[1];
        int i1 = 0;
        int i2 = 0;
//        if (input != let1,let2,let3){
//            throw new Exception("jkgjg");
//
//        }
        if (let1.matches("[IVX][IVX]?[IVX]?") && let2.matches("[IVX][IVX]?[IVX]?") && let3.matches("[+\\-*/]")) {
            for (int i = 0; i<10; i++) {
                if (let1.equals(arabic[i]))
                    i1 = i + 1;
                if (let2.equals(arabic[i])) {
                    i2 = i + 1;
                }
            }
            if (i1!=0 && i2 != 0) {
                int i3 = 0;
                if (let3.equals("+")) {
                    i3 = i1 + i2;
                } else if (let3.equals("-")) {
                    i3 = i1 - i2;
                } else if (let3.equals("*")) {
                    i3 = i1 * i2;
                } else if (let3.equals("/")) {
                    i3 = i1 / i2;
                }
                if (i3>=1 && i3<=100){
                    str = arabic[i3-1];
                }else {
                    throw new Exception("В римской системе нет отрицательных чисел");
                }
            }else {
                throw new Exception("Вы ввели числа не от I до X");
            }
        } else if (((let1.matches("[1-9]")) || (let1.equals("10"))) && ((let2.matches("[1-9]")) || (let2.equals("10"))) && let3.matches("[+\\-*/]")) {
            int r1 = Integer.parseInt(let1);
            int r2 = Integer.parseInt(let2);
            int r3 = 0;
            switch (let3) {
                case "+":
                    r3 = r1 + r2;
                    break;
                case "-":
                    r3 = r1 - r2;
                    break;
                case "*":
                    r3 = r1 * r2;
                    break;
                case "/":
                    r3 = r1 / r2;
                    break;

            }
            str = String.valueOf(r3);
        } else {
            throw new Exception("Используются одновременно разные системы счисления");
        }

        return str;
    }
}