import java.util.Scanner;

public class StringTest3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = sc.nextLine();
        String result = reverse(s);
        System.out.println(result);
    }

    public static String reverse(String s) {
        String result = "";
        char[] chs = s.toCharArray();

        for(int x = chs.length - 1; x >= 0; --x) {
            result = result + chs[x];
        }

        return result;
    }
}