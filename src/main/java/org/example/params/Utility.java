package org.example.params;

/*
    Utility mechanisms:
    - object class
    - static methods
    - singleton
 */

public class Utility {

    // 1. Check if number is odd (= impar)
    // odd = impar, even = par
    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    // 2. Round a double value to nearest integer
    public static double roundDouble(double value) {
        return Math.round(value);
    }

    // 3. Check if a string is palindrome
    // (un numar sau un text care de la stanga la dreapta e identic)
    // StringBuilder este un wrapper peste String, asa cum Integer este peste int.
    public static boolean isPalindrome(String text) {
        if(text == null) return false;
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equalsIgnoreCase(reversed);
    }

    // 4. Convert string to uppercase
    // trim = elimina caracterele albe de la stanga sau dreapta stringului -> "       alune   " -> "alune"
    public static String toUpperCase(String input)  {
        return input.trim().toUpperCase();
    }

    // 5. Check if an object is an instance of a given class
    // Object = universal parent for all Java classes -> can override toString, hashCode, equals
    public static boolean isInstanceOf(Object obj, Class<?> cls) {
        return cls.isInstance(obj);
    }

}
