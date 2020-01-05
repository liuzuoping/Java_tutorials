package cn;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class StudentDemo {
    public StudentDemo() {
    }

    public static void main(String[] args) throws IOException {
        TreeSet<Student> ts = new TreeSet(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                int num = s2.getSum() - s1.getSum();
                int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;
                return num2;
            }
        });
        System.out.println("学生录入开始----------------------");

        for(int x = 1; x <= 5; ++x) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入第" + x + "个学生的姓名：");
            String name = sc.nextLine();
            System.out.println("请输入第" + x + "个学生的语文成绩：");
            int chinese = sc.nextInt();
            System.out.println("请输入第" + x + "个学生的数学成绩：");
            int math = sc.nextInt();
            System.out.println("请输入第" + x + "个学生的英语成绩：");
            int english = sc.nextInt();
            Student s = new Student();
            s.setName(name);
            s.setChinese(chinese);
            s.setMath(math);
            s.setEnglish(english);
            ts.add(s);
        }

        System.out.println("学生录入结束----------------------");
        BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"));
        bw.write("姓名,语文成绩,数学成绩,英语成绩");
        bw.newLine();
        bw.flush();
        Iterator var11 = ts.iterator();

        while(var11.hasNext()) {
            Student s = (Student)var11.next();
            StringBuilder sb = new StringBuilder();
            sb.append(s.getName()).append(",").append(s.getChinese()).append(",").append(s.getMath()).append(",").append(s.getEnglish());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }

        bw.close();
        System.out.println("数据成功写入文件");
    }
}

