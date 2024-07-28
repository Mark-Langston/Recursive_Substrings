import java.util.Scanner;

public class Main {

    // Substring method
    public static void generateSubstrings(String str, String current, StringBuilder result) {
        if (str.length() == 0) {
            if (current.length() > 0) {
                result.append(current).append(";");
            }
            return;
        }

        // Semicolon seperated values, easier to read
        if (current.length() > 0) {
            result.append(current).append(";");
        }

        // Recursion for the remaining substring
        for (int i = 0; i < str.length(); i++) {
            generateSubstrings(str.substring(i + 1), current + str.charAt(i), result);
        }
    }

    // Helper method
    public static String generateAllSubstrings(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            generateSubstrings(str.substring(i), "", result);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Recursive Substrings\n");

        Scanner scanner = new Scanner(System.in);
        String word;

        while (true) {
            System.out.print("Enter a word: ");
            word = scanner.nextLine();

            String substrings = generateAllSubstrings(word);
            System.out.println("Substrings of \"" + word + "\": " + substrings);

            System.out.print("Do you want to enter another word? (yes/no): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }
        scanner.close();
    }
}