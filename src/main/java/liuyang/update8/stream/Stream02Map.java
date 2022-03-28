package liuyang.update8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author :liuyang(wx)
 * @date :2022/3/28 10:51
 */
public class Stream02Map {
    public static void main(String[] args) {
        final List<String> strings = Arrays.asList("11", "22", "33", "44");
        strings.stream().map(i -> new A(i)).collect(Collectors.toList()).forEach(System.out::println);
    }
}

@Data
@AllArgsConstructor
class A {
    String foo;
}