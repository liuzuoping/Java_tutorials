

import java.util.Scanner;

public class StringTest {
    public StringTest() {
    }

    public static void main(String[] args) {
        for(int x = 0; x < 3; ++x) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String name = sc.nextLine();
            System.out.println("请输入密码：");
            String pwd = sc.nextLine();
            if ("admin".equals(name) && "admin".equals(pwd)) {
                System.out.println("登录成功");
                break;
            }

            if (2 - x == 0) {
                System.out.println("帐号被锁定，请与班长联系");
            } else {
                System.out.println("登录失败，你还有" + (2 - x) + "次机会");
            }
        }

    }
}
