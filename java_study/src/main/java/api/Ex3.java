package api;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.printf("%b", checkPalindrome(str));
    }

    private static boolean checkPalindrome(String str) {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i)!= str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
