package kakao2020.q1;

import java.util.HashSet;
import java.util.Set;

public class Q1 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("aabbaccc") == 7);
        System.out.println(solution.solution("ababcdcdababcdcd") == 9);
        System.out.println(solution.solution("abcabcdede") == 8);
        System.out.println(solution.solution("abcabcabcabcdededededede") == 14);
        System.out.println(solution.solution("xababcdcdababcdcd") == 17);
    }

}

class Solution {
    public int solution(String s) {
        StringCompressor stringCompressor = new StringCompressor(s);
        return stringCompressor.getShortLength();
    }
}

class StringCompressor {

    private String original;
    private int maxBound;
    private Set<String> compressed = new HashSet<>();

    public StringCompressor(String original) {
        this.original = original;
        this.maxBound = original.length() / 2;

        compress();
    }

    private void compress() {
        for (int wordLength = 1; wordLength <= maxBound; wordLength++) {

            StringBuilder compressed = new StringBuilder();
            String buffer = original.substring(0, wordLength);
            int count = 1;

            String last = "";
            for (int startIndex = wordLength; startIndex < original.length(); startIndex += wordLength) {
                String word;

                if (startIndex + wordLength >= original.length()) {
                    last = original.substring(startIndex);
                    word = original.substring(startIndex);
                } else {
                    word = original.substring(startIndex, startIndex + wordLength);
                }

                if (buffer.equals(word)) {
                    count++;
                    continue;
                }

                if (count != 1) {
                    compressed.append(count);
                    count = 1;
                }
                compressed.append(buffer);

                buffer = word;
            }
            if (count != 1) {
                compressed.append(count);
            }
            compressed.append(last);

            this.compressed.add(compressed.toString());
        }
    }

    public int getShortLength() {
        return compressed.stream()
                .map(String::length)
                .min(Integer::compareTo)
                .orElse(original.length());
    }
}


//데이터 처리 전문가가 되고 싶은 어피치는 문자열을 압축하는 방법에 대해 공부를 하고 있습니다. 최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데,
// 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현하는 알고리즘을 공부하고 있습니다.
//간단한 예로 aabbaccc의 경우 2a2ba3c(문자가 반복되지 않아 한번만 나타난 경우 1은 생략함)와 같이 표현할 수 있는데,
// 이러한 방식은 반복되는 문자가 적은 경우 압축률이 낮다는 단점이 있습니다.
// 예를 들면, abcabcdede와 같은 문자열은 전혀 압축되지 않습니다.
// 어피치는 이러한 단점을 해결하기 위해 문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현할 수 있는지 방법을 찾아보려고 합니다.
//
//예를 들어, ababcdcdababcdcd의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만,
// 2개 단위로 잘라서 압축한다면 2ab2cd2ab2cd로 표현할 수 있습니다.
// 다른 방법으로 8개 단위로 잘라서 압축한다면 2ababcdcd로 표현할 수 있으며,
// 이때가 가장 짧게 압축하여 표현할 수 있는 방법입니다.
//
//다른 예로, abcabcdede와 같은 경우,
// 문자를 2개 단위로 잘라서 압축하면 abcabc2de가 되지만,
// 3개 단위로 자른다면 2abcdede가 되어 3개 단위가 가장 짧은 압축 방법이 됩니다.
// 이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다.
//
//압축할 문자열 s가 매개변수로 주어질 때,
// 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중
// 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//s의 길이는 1 이상 1,000 이하입니다.
//s는 알파벳 소문자로만 이루어져 있습니다.