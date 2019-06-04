import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HelloWorld {
  private JPanel rootPanel;
  private JLabel helloLable2;
  private JButton helloButton;
  private JTextField textField;
  private JLabel helloLabel;

  public HelloWorld() {
    helloButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        String greeting = "Hello " + textField.getText();
        helloLabel.setText(greeting);
      }
    });
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("HelloWorld");
    frame.setContentPane(new HelloWorld().rootPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
