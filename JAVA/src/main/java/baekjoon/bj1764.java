package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class bj1764 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String[] line = br.readLine().split(" ");
        int det_count = Integer.valueOf(line[0]);
        int bo_count = Integer.valueOf(line[1]);

        Set<String> dets = new HashSet<>();
        Set<String> bos = new HashSet<>();

        for (int i = 0; i < det_count; i++) {
            dets.add(br.readLine());
        }
        for (int i = 0; i < bo_count; i++) {
            bos.add(br.readLine());
        }

        if (det_count >= bo_count) {
            findDetBo(bos, dets);
        } else {
            findDetBo(dets, bos);
        }
    }

    private static void findDetBo(Set<String> standard, Set<String> compare) {

        List<String> detbos = standard.stream()
                .filter(s -> compare.contains(s))
                .sorted()
                .collect(Collectors.toList());

        System.out.println(detbos.size());
        detbos.stream()
                .forEach(s -> System.out.println(s));
    }
}
