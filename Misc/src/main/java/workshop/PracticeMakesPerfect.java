package workshop;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * convert array
 * ['p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e']
 * to
 * ['p', 'r', 'a', 'c', 't', 'i', 'c', 'e', ' ', 'm' 'a', 'k', 'e', 's', ' ', 'p', 'e', 'r', 'f', 'e', 'c', 't']
 */

public class PracticeMakesPerfect {

    public static void main(String[] args) {
        System.out.println("practice makes perfect");
        char[] array = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};

        swap(array);

        final var line = new String(array);
        System.out.println("input: " + line);

        final var words = line.split(String.valueOf(' '));

        final R collect = Arrays.stream(words).map(w -> w.chars()).collect(char[]::new);

        swap(words);
        for (String word: words) {
            array = word.toCharArray();
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    private static void swap(String[] words) {
        int i = 0;
        int j = words.length - 1;
        while (j > i) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }
    }
}
