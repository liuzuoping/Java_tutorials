import java.util.Scanner;

class GuessNumberDemo {
    GuessNumberDemo() {
    }

    public static void main(String[] var0) {
        int var1 = (int)(Math.random() * 100.0D) + 1;

        while(true) {
            while(true) {
                Scanner var2 = new Scanner(System.in);
                System.out.println("请输入一个数据：(1-100)");
                int var3 = var2.nextInt();
                if (var3 > var1) {
                    System.out.println("你猜的数据" + var3 + "大了");
                } else {
                    if (var3 >= var1) {
                        System.out.println("恭喜你，猜中了");
                        return;
                    }

                    System.out.println("你猜的数据" + var3 + "小了");
                }
            }
        }
    }
}