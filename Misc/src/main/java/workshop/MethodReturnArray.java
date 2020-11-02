package workshop;

public class MethodReturnArray {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;

        if (a + b == c) {
            System.out.println(method()[0]); //Here is the main point
        }
    }

    private static String[] method() {
        String[] array = new String[1];
        String sb = """
                Be a
                Java programmer
                """;
        array[0] = sb;
        return array;
    }
}
