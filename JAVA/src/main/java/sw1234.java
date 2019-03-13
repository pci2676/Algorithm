//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class sw1234 {
//
//    static String line;
//    static String[] lineArr;
//    static String REG = "(00|11|22|33|44|55|66|77|88|99)";
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        for (int t = 1; t <= 10; t++) {
//            line = br.readLine();
//            lineArr = line.split(" ");
//            String answer = lineArr[1];
//
//            while (true) {
//                int length = answer.length();
//                answer = answer.replaceAll(REG, "");
//                if(length==answer.length())
//                    break;
//            }
//            System.out.println("#" + t + " " + answer);
//        }
//    }
//}
