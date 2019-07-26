package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        String[] arr = {"가", "나", "다"};

        List<List<String>> BAD = Arrays.stream(arr)
                .map(Test::boom)
                .collect(Collectors.toList());

        List<String> GOOD = Arrays.stream(arr)
                .map(Test::boom)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println("BAD : " + BAD);
        System.out.println("GOOD : " + GOOD);
    }

    private static List<String> boom(String something) {
        String one = something + "a";
        String two = something + "b";
        String three = something + "c";
        String[] arr = {one, two, three};
        return new ArrayList<>(Arrays.asList(arr));
    }
}
