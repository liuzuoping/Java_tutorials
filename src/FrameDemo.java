import java.awt.Frame;

public class FrameDemo {
    public FrameDemo() {
    }

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setTitle("百度一下,你就知道");
        f.setSize(400, 300);
        f.setVisible(true);
        f.setLocation(500, 200);
    }
}
