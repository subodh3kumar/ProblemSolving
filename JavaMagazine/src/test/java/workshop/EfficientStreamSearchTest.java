package workshop;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EfficientStreamSearchTest {

    private static final List<String> source = List.of("Java 11", "Exam");

    @Test
    @Order(1)
    @DisplayName("search stream data using peek() - fail")
    public void searchStreamDataUsingPeek() {
        long start = System.nanoTime();
        List<String> result = List.of();
        source.stream().peek(value -> {
            if (value.contains("Java")) {
                result.add(value);
            }
        }).count();
        long end = System.nanoTime();
        System.out.println("total time taken [peek]: " + (end - start) + " ns");
        System.out.println((result.size() > 0) ? "found" : "not found");
    }

    @Test
    @Order(2)
    @DisplayName("search stream data using filter()")
    public void searchStreamDataUsingFilter() {
        long start = System.nanoTime();
        Optional<String> result = source.stream().filter(value -> value.contains("Java")).findAny();
        long end = System.nanoTime();
        System.out.println("total time taken [filter]: " + (end - start) + " ns");
        if (result.isPresent()) {
            System.out.println(result.get());
        }
    }

    @Test
    @Order(3)
    @DisplayName("search stream data using anyMatch()")
    public void searchStreamDataUsingAnyMatch() {
        long start = System.nanoTime();
        boolean result = source.stream().anyMatch(value -> value.contains("Java"));
        long end = System.nanoTime();
        System.out.println("total time taken [anyMatch]: " + (end - start) + " ns");
        System.out.println(result ? "found" : "not found");
    }

    @Test
    @Order(4)
    @DisplayName("search stream data using collect()")
    public void searchStreamDataUsingCollect() {
        long start = System.nanoTime();
        List<String> result = source.stream().filter(value -> value.contains("Java")).collect(Collectors.toList());
        long end = System.nanoTime();
        System.out.println("total time taken [collect]: " + (end - start) + " ns");
        if (!result.isEmpty()) {
            result.forEach(System.out::println);
        }
    }
}