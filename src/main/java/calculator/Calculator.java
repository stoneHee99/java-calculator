package calculator;

import java.io.IOException;
import java.util.Scanner;

public class Calculator {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static int add(String str) {
        if (isBlank(str)) {
            return 0;
        }

        String delimeter = getDelimiter(str);
        String numbersPart = getNumbersPart(str, delimeter);

        String[] numbers = splitNumbers(numbersPart, delimeter);
        return calculateSum(numbers);
    }

    private static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    private static String getDelimiter(String str) {
        if (str.startsWith("//")) {
            int delimiterIndex = str.indexOf("\\n");
            return str.substring(2, delimiterIndex);
        }
        return DEFAULT_DELIMITER;
    }

    private static String getNumbersPart(String str, String delimiter) {
        if (str.startsWith("//")) {
            int delimiterIndex = str.indexOf("\\n");
            return str.substring(delimiterIndex + 2);
        }
        return str;
    }

    private static String[] splitNumbers(String numbersPart, String delimiter) {
        return numbersPart.split(delimiter);
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += parseNumber(number.trim());
        }
        return sum;
    }

    private static int parseNumber(String number) {
        int num = toInt(number);
        validatePositive(num);
        return num;
    }

    private static int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println(number);
            throw new RuntimeException("숫자 이외의 값이 포함되어 있습니다.", e);
        }
    }

    private static void validatePositive(int num) {
        if (num < 0) {
            throw new RuntimeException("음수를 입력할 수 없습니다");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (scanner) {
            System.out.println("숫자들을 입력하세요: ");
            String input = scanner.nextLine();
            int result = add(input);
            System.out.println("합계: " + result);
        } catch (RuntimeException e) {
            System.out.println("오류 발생: " + e.getMessage());
        }

    }
}
