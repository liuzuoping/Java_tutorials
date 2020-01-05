import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseDemo {
    public MouseDemo() {
    }

    public static void main(String[] args) {
        final Frame f = new Frame("更改背景色");
        f.setBounds(500, 250, 400, 300);
        f.setLayout(new FlowLayout());
        Button redButton = new Button("红色");
        Button greenButton = new Button("绿色");
        Button blueButton = new Button("蓝色");
        Button whiteButton = new Button("复原");
        f.add(redButton);
        f.add(greenButton);
        f.add(blueButton);
        f.add(whiteButton);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        redButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                f.setBackground(Color.RED);
            }
        });
        redButton.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e) {
                f.setBackground(Color.WHITE);
            }
        });
        f.setVisible(true);
    }
}
