package workshop;

/**
 * convert array
 * ['p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e']
 * to
 * ['p', 'r', 'a', 'c', 't', 'i', 'c', 'e', ' ', 'm' 'a', 'k', 'e', 's', ' ', 'p', 'e', 'r', 'f', 'e', 'c', 't']
 */

public class PracticeMakesPerfect {

    public static void main(String[] args) {
        char[] array = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};

        System.out.println("before swap: " + String.copyValueOf(array));
        wordReverseInPlace(array);
        System.out.println("after swap: " + String.copyValueOf(array));
    }

    private static void wordReverseInPlace(char[] array) {
        reverseChars(array, 0, array.length - 1);
        reverseWords(array);
    }

    private static void reverseWords(char[] array) {
        int start, end;
        int current = 0;
        while (current < array.length) {
            start = current;
            end = indexOf(array, start);
            if (end == -1) {
                reverseChars(array, start, array.length - 1);
                current = array.length;
            } else {
                reverseChars(array, start, end - 1);
                current = end + 1;
            }
        }
    }

    private static int indexOf(char[] array, int start) {
        for (int i = start; i < array.length; i++) {
            if (array[i] == ' ') {
                return i;
            }
        }
        return -1;
    }

    private static void reverseChars(char[] array, int start, int end) {
        while (end > start) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
