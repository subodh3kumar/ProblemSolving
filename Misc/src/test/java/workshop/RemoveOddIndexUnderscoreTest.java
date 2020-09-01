package workshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RemoveOddIndexUnderscoreTest {

    private RemoveOddIndexUnderscore obj;

    @BeforeEach
    public void init() {
        obj = new RemoveOddIndexUnderscore();
    }

    @Test
    public void testNullPointerException() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> obj.removeUnderscoreFromOddIndex(null));
        assertThat(exception.getMessage()).isEqualTo("empty string");
    }

    @Test
    public void testRemoveOddIndexUnderscore() {
        String result = obj.removeUnderscoreFromOddIndex("a_b_c_d");
        assertThat(result).isEqualTo("abcd");
    }
}