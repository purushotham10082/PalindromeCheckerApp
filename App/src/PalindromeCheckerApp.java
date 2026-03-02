import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class palindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
        scanner.close();
    }

    public static boolean isPalindrome(String str) {
        if (str == null || str.length() <= 1) return true;

        Node head = convertToLinkedList(str);

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalfHead = reverseList(slow);
        Node firstHalfHead = head;

        Node temp = secondHalfHead;
        boolean isPalin = true;
        while (temp != null) {
            if (firstHalfHead.data != temp.data) {
                isPalin = false;
                break;
            }
            firstHalfHead = firstHalfHead.next;
            temp = temp.next;
        }

        reverseList(secondHalfHead);

        return isPalin;
    }

    private static Node convertToLinkedList(String str) {
        if (str.isEmpty()) return null;
        Node head = new Node(str.charAt(0));
        Node current = head;
        for (int i = 1; i < str.length(); i++) {
            current.next = new Node(str.charAt(i));
            current = current.next;
        }
        return head;
    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}