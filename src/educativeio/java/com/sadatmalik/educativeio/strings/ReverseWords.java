package com.sadatmalik.educativeio.strings;

/**
 * @author sm@creativefusion.net
 */
public class ReverseWords {

    public static String reverseWords(char[] sentence) {
        // TODO: Write - Your - Code
        String[] words = new String(sentence).split(" ");
        int k = 0;
        for (int i = words.length-1; i >= 0; i-- ) {
            String s = words[i];
            for (int j = 0; j < s.length(); j++) {
                sentence[k] = s.charAt(j);
                k++;
            }
            if (k < sentence.length) {
                sentence[k] = ' ';
                k++;
            }
        }
        return String.valueOf(sentence);
    }
}