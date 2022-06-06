package com.sadatmalik.educativeio.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sm@creativefusion.net
 */
public class StringSegmentation {
    public static boolean canSegmentString(String inputString, Set<String> dictionary) {
        if (inputString.equals(""))
            return true;

        // check each word in dictionary for a match
        // progress the counter if so - and recursively call self with the new inputString substring
        for (String s : dictionary) {
            if (wordMatch(inputString, s))
                return canSegmentString(inputString.substring(s.length()), dictionary);
        }

        return false;
    }

    public static boolean wordMatch(String inputString, String s) {
        if (s.length() > inputString.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            if (inputString.charAt(i) != s.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] inputStr = {"hellonow", "nowok", "applepie", "applejuice"};
        String[][] wordsDictionary =
                {{"hello", "hell", "on", "now"}, {"hello", "hell", "on", "now"},
                        {"apple", "pear", "pier", "pie"}, {"apple", "pear", "pier", "pie"}};

        for (int i = 0; i < inputStr.length; i++) {
            Set<String> dict = new HashSet<>(Arrays.asList(wordsDictionary[i]));

            if (canSegmentString(inputStr[i], dict))
                System.out.println("   Result: String can be segmented");
            else
                System.out.println("   Result: String can not be segmented");
            System.out.println(
                    "---------------------------------------------------------------------------------------------------\n");
        }

    }
}
