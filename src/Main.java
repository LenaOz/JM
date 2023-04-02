import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение (два числа): ");
        String input = scanner.nextLine();
        System.out.println(calc(input));
        String result = scanner.nextLine();
        System.out.println(calc(result));
    }

    public static String calc(String input) throws Exception {
        int num1;
        int num2;
        String result;
        boolean isRoman;

        String[] operands = input.split("[+\\-*/]");


       if (operands.length == 1) {
       throw new Exception("Строка не является математической операцией");
       } else if (operands.length != 2) {
       throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
       }


        String operator = defineOperator(input);


        if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
            num1 = Roman.convertToArabian(operands[0]);
            num2 = Roman.convertToArabian(operands[1]);
            isRoman = true;
        } else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[1]);
            isRoman = false;
        } else {
            throw new Exception("Числа должны быть в одном формате (оба римские или оба арабские)");
        }


        if (num1 > 10 || num2 > 10) throw new Exception("Числа должны быть от 1 до 10 включительно");



       int resultArabian = simpleCalc(num1, num2, operator);
       if (isRoman) {
            if (resultArabian < 1) {
                throw new Exception("В римской системе нет отрицательных чисел");
            }
            result = Roman.convertToRoman(resultArabian);
        } else {
            result = String.valueOf(resultArabian);
        }
        return result;
    }

    

        static String defineOperator(String input) {
            if (input.contains("+")) {
                return "+";}
            else if (input.contains("-")) {
                return "-";}
            else if (input.contains("*")) {
                return "*";}
            else if (input.contains("/")) {
                return "/";}
            else return "";
        }


        static int simpleCalc(int num1, int num2, String operator) {
            if (operator.equals("+")) return num1 + num2;
            else if (operator.equals("-")) return num1 - num2;
            else if (operator.equals("*")) return num1 * num2;
            else if (operator.equals("/")) return num1 / num2;
            else return -0;
        }



    }



class Roman {
    static String [] numRoman = new String [] {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                                               "XI", "XII", "XII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                                               "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "xxx",
                                               "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                                               "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                                               "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                                               "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                                               "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXVIII", "LXXIX", "LXXX",
                                               "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                                               "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};




         public static boolean isRoman (String number) {
               for (int i = 0; i < numRoman.length; i++) {
                   if (number.equals(numRoman[i])) {
                       return true;
                   }
               }
                return false;
            }

            public static int convertToArabian (String roman) {
               for (int i = 0; i <= numRoman.length; i++) {
                  if (roman.equals(numRoman[i])) {
                       return i;
                  }
               }
                 return -0;
            }

    public static String convertToRoman (int resultArabian) {
                return numRoman[resultArabian];
    }
}