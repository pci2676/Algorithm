package programers.dfs_bfs;

public class ConvertWord {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}) == 4);
        System.out.println(solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}) == 0);
    }

    static class Solution {

        private static boolean[] isVisit;
        private static int changeCount;
        private static int size;
        private static String[] staticWords;

        public int solution(String begin, String target, String[] words) {
            size = words.length;
            staticWords = words;
            changeCount = Integer.MAX_VALUE;
            isVisit = new boolean[size];

            for (int i = 0; i < size; i++) {
                isVisit[i] = true;
                bfs(begin, words[i], target, 0);
                isVisit[i] = false;
            }

            if (changeCount == Integer.MAX_VALUE) {
                return 0;
            }
            return changeCount;
        }

        private void bfs(String begin, String word, String target, int count) {
            if (begin.equals(target)) {
                if (changeCount > count) {
                    changeCount = count;
                }
                return;
            }
            if (!canConvert(begin, word)) {
                return;
            }

            for (int i = 0; i < size; i++) {
                if (isVisit[i]) {
                    continue;
                }
                isVisit[i] = true;
                bfs(word, staticWords[i], target, count + 1);
                isVisit[i] = false;
            }

        }

        private boolean canConvert(String original, String convert) {
            int count = 0;
            String[] originals = original.split("");
            String[] converts = convert.split("");
            for (int i = 0; i < originals.length; i++) {
                if (!originals[i].equals(converts[i])) {
                    count++;
                    if (count >= 2) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
