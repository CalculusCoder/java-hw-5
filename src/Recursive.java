public class Recursive {
    // method checks if word is a palindrome
    public boolean isPalindrome(String str) {
        // Base case
        if (str.length() <= 1) {
            return true;
        } else {
            // Check if the first and last characters are the same
            boolean checkFirstLast = str.charAt(0) == str.charAt(str.length() - 1);

            // recursively check the substring except the first and last characters
            boolean checkSubString = isPalindrome(str.substring(1, str.length() - 1));

            return checkFirstLast && checkSubString;
        }
    }
}
