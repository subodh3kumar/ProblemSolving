package workshop;

public class RemoveOddIndexUnderscore {

    private static final String EMPTY = "";

    public String removeUnderscoreFromOddIndex(String word) {
        if (word == null || EMPTY.equals(word.trim())) {
            throw new NullPointerException("empty string");
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (!(i % 2 != 0 && word.charAt(i) == '_')) {
                result.append(word.charAt(i));
            }
        }
        return result.toString();
    }
}
