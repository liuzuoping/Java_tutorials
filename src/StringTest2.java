import java.util.Scanner;

public class StringTest2 {
    public StringTest2() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = sc.nextLine();
        int bigCount = 0;
        int smallCount = 0;
        int numberCount = 0;

        for(int x = 0; x < s.length(); ++x) {
            char ch = s.charAt(x);
            if (ch >= 'A' && ch <= 'Z') {
                ++bigCount;
            } else if (ch >= 'a' && ch <= 'z') {
                ++smallCount;
            } else if (ch >= '0' && ch <= '9') {
                ++numberCount;
            }
        }

        System.out.println("大写：" + bigCount);
        System.out.println("小写：" + smallCount);
        System.out.println("数字：" + numberCount);
    }
}