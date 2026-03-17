import java.util.*;

public class PalindromeCheckerApp {

    static boolean reverseCheck(String str) {
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    static boolean twoPointerCheck(String str) {
        String s = str.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    static boolean stackCheck(String str) {
        String s = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray())
            stack.push(c);

        for (char c : s.toCharArray()) {
            if (c != stack.pop())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        long start, end;

        start = System.nanoTime();
        boolean r1 = reverseCheck(input);
        end = System.nanoTime();
        long time1 = end - start;

        start = System.nanoTime();
        boolean r2 = twoPointerCheck(input);
        end = System.nanoTime();
        long time2 = end - start;

        start = System.nanoTime();
        boolean r3 = stackCheck(input);
        end = System.nanoTime();
        long time3 = end - start;

        System.out.println("Reverse Method: " + (r1 ? "Palindrome" : "Not Palindrome") + " | Time: " + time1 + " ns");
        System.out.println("Two Pointer Method: " + (r2 ? "Palindrome" : "Not Palindrome") + " | Time: " + time2 + " ns");
        System.out.println("Stack Method: " + (r3 ? "Palindrome" : "Not Palindrome") + " | Time: " + time3 + " ns");

        sc.close();
    }
}