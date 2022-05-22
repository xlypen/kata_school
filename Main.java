import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n1, n2;
    static char operation;
    static int result;
    public static void main(String[] args) throws Exception {
        String enter = sc.nextLine();
        char[] charArray = new char[10];
        for (int i = 0; i < enter.length(); i++) {
            charArray[i] = enter.charAt(i);
            if (charArray[i] == '+') {
                operation = '+';
            }
            if (charArray[i] == '-') {
                operation = '-';
            }
            if (charArray[i] == '*') {
                operation = '*';
            }
            if (charArray[i] == '/') {
                operation = '/';
            }
        }
        String massCharString = String.valueOf(charArray);
        String[] stringArray = massCharString.split("[+-/*]");
        if (stringArray.length < 2) {
            throw new Exception("не является математической операцией");
        }
        if (stringArray.length > 2) {
            throw new Exception("не удовлетворяет заданию");
        }
        String left = stringArray[0].trim();
        String right = stringArray[1].trim();
        n1 = romanToArabian(left);
        n2 = romanToArabian(right);
        if (n1 == -1 && n2 > -1 || n2 == -1 && n1 > -1) {
            throw new Exception("разные системы счисления");
        }
        if (n1 < 0 && n2 < 0) {
            result = 0;
        } else {
            result = calculated(n1, n2, operation);
            if (result < 0) {
                throw new Exception("в римской системе нет отрицательных чисел");
            }
            String resultRoman = convertNumToRoman(result);
            System.out.println(resultRoman);
            return;
        }
        n1 = Integer.parseInt(left);
        n2 = Integer.parseInt(right);
        if ((n1 < 1) || (10 < n1) || (n2 < 1) || (10 < n2)) {
            throw new Exception("Возможен ввод только от 1 до 10");
        } else {
            result = calculated(n1, n2, operation);
            System.out.println(result);
        }
    }
    static int romanToArabian(String romanNum) {
        return switch (romanNum) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }
    static String convertNumToRoman(int numArab) {
        String[] roman = new String[]{"RomanNull", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        final String s = roman[numArab];
        return s;
    }
    static int calculated(int num1, int num2, char operator){
        int result = switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };
        return result;
    }
}