import java.io.File;

public class GetAllFileNameDemo {
    public static int count1 = 0;
    public static int count2 = 0;

    public GetAllFileNameDemo() {
    }

    public static void main(String[] args) {
        File srcFolder = new File("D:\\pics_multi");
        getAllJavaFilePath(srcFolder);
        System.out.println("共学习了" + count1 + "个java文件");
        System.out.println("共学习了" + count2 + "个avi文件");
    }

    public static void getAllJavaFilePath(File srcFolder) {
        File[] fileArray = srcFolder.listFiles();
        File[] var5 = fileArray;
        int var4 = fileArray.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            File file = var5[var3];
            if (file.isDirectory()) {
                getAllJavaFilePath(file);
            } else if (file.getName().endsWith(".java")) {
                ++count1;
                System.out.println(file.getAbsolutePath());
            } else if (file.getName().endsWith(".avi")) {
                ++count2;
                System.out.println(file.getName());
            }
        }

    }
}
