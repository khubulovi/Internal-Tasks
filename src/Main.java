import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //task1
        int[] numbers = {1, 2, 3, 4, 5, 1, 2, 3, 4};
        System.out.println(findSingleNumber(numbers));

        //task2
        int amount = 32;
        Map<Integer, Integer> change = minSplit(amount);
        for (Map.Entry<Integer, Integer> entry : change.entrySet()
        ) {
            System.out.println("The coin: " + entry.getKey() + " / Amount of Coins: " + entry.getValue());
        }

        //task3
        String[] words = {"Programmer", "Programming", "Programms"};
        System.out.println(longestPrefix(words));

        //task4
        String first = "1101";
        String second = "1011";
        System.out.println(sumOfBinaryStrings(first, second));

        //task5
        int stairsCount = 6;
        int result = countVariants(stairsCount);
        String message = String.format("Number of ways to go up: %d stairs: %d", stairsCount, result);
        System.out.println(message);

        //task6
        StructureDeleting<Integer> structure = new StructureDeleting<>();

        structure.add(1);
        structure.add(2);
        structure.add(3);
        structure.add(4);

        System.out.println("Initial elements:");
        structure.printElements();

        structure.delete(2);

        System.out.println("Elements after deleting :");
        structure.printElements();
    }

    //task1
    public static int findSingleNumber(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result ^= number;
        }
        return result;
    }

    //task2
    public static Map<Integer, Integer> minSplit(int amount) {
        int[] coins = {50, 20, 10, 5, 1};
        Map<Integer, Integer> change = new HashMap<>();
        for (int coin : coins
        ) {
            int count = amount / coin;
            if (count > 0) {
                change.put(coin, count);
                amount %= coin;
            }
        }
        return change;
    }

    //task3
    public static String longestPrefix(String[] array) {
        if (array.length == 0) return "There no names in it";

        String prefix = array[0];

        for (int i = 1; i < array.length; i++) {
            while (!array[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    //task4
    public static String sumOfBinaryStrings(String first, String second) {
        StringBuilder result = new StringBuilder();

        int carry = 0;
        int i = first.length() - 1;
        int j = second.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += first.charAt(i--) - '0';
            }

            if (j >= 0) {
                sum += second.charAt(j--) - '0';
            }

            result.insert(0, sum % 2);
            carry = sum / 2;
        }
        return result.toString();
    }

    //task5
    public static int countVariants(int n) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;

        int[] variants = new int[n + 1];
        variants[0] = 1;
        variants[1] = 1;
        variants[2] = 2;

        for (int i = 3; i <= n; i++) {
            variants[i] = variants[i - 1] + variants[i - 2];
        }
        return variants[n];
    }
}
