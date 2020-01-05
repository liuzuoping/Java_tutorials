import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class MenuDemo {

    public static void main(String[] args) {
        final Frame f = new Frame("多级菜单");
        f.setBounds(500, 250, 400, 300);
        MenuBar mb = new MenuBar();
        Menu m1 = new Menu("文件");
        Menu m2 = new Menu("更改名称");
        final MenuItem mi1 = new MenuItem("好好学习");
        final MenuItem mi2 = new MenuItem("天天向上");
        MenuItem mi3 = new MenuItem("恢复标题");
        MenuItem mi4 = new MenuItem("打开记事本");
        MenuItem mi5 = new MenuItem("退出系统");
        m2.add(mi1);
        m2.add(mi2);
        m2.add(mi3);
        m1.add(m2);
        m1.add(mi4);
        m1.add(mi5);
        mb.add(m1);
        f.setMenuBar(mb);
        final String title = f.getTitle();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        mi5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mi4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Runtime r = Runtime.getRuntime();

                try {
                    r.exec("notepad");
                } catch (IOException var4) {
                    var4.printStackTrace();
                }

            }
        });
        mi1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setTitle(mi1.getLabel());
            }
        });
        mi2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setTitle(mi2.getLabel());
            }
        });
        mi3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setTitle(title);
            }
        });
        f.setVisible(true);
    }
}

