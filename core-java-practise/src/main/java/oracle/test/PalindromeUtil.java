package oracle.test;

/**
 * Checks if a string is a palindrome.
 *
 * Palindrome is a word, phrase or sentence that reads the same backward or
 * forward. For example, the following string is a palindrome: "Madam, I'm Adam."
 */
public class PalindromeUtil {
    /**
     * Checks whether passed String is a palindrome or not.
     *
     * Requirements:
     * - Limit the amount of additional consumed memory to O(1).
     * - Limit complexity to O(n).
     *
     * @return true if passed string is palindrome, false - otherwise
     */
    public static boolean isPalindrome(String str) {
        checkForEmpty(str);
        String reversedString=reverseString(str);
        return reversedString.equals(str)?true:false;
    }

    private static void checkForEmpty(String str){
        if(str==null||str.trim().length()==0){
            throw new IllegalArgumentException("String can not be empty");
        }
    }

    private static String reverseString(String str){
        char[] characters=str.toCharArray();
        int startIndex=0;
        int endIndex=str.length()-1;

        while(startIndex<endIndex){
            char temp=characters[startIndex];
            characters[startIndex]=characters[endIndex];
            characters[endIndex]=temp;
            startIndex++;endIndex--;
        }
        return new String(characters);
    }

}
