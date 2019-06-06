import javax.swing.JFrame;

public class FrameMaker extends JFrame {

  static final int WIDTH = 300;
  static final int HEIGHT = 300;

  public FrameMaker() {
    super("Yikes");
    setFrame(WIDTH, HEIGHT);
  }

  public FrameMaker(String title) {
    super(title);
    setFrame(WIDTH, HEIGHT);
  }

  public FrameMaker(String title, int width, int height) {
    super(title);
    setFrame(width, height);
  }

  public void display() {
    setVisible(true);
  }

  private void setFrame(int width, int height) {
    setSize(width, HEIGHT);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
