import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

public class HintTextField extends JTextField {

  public HintTextField(final String hint) {
    // set text to hint and color to gray
    setText(hint);
    setForeground(Color.GRAY);

    this.addFocusListener(new FocusAdapter() {
      // if the TextField has focus set the text to empty string
      // and set the color to black
      @Override
      public void focusGained(FocusEvent e) {
        if (getText().equals(hint)) {
          setText("");
          setForeground(Color.BLACK);
        } else {
          setText(getText());
        }
      }

      // if the TextField does not have focus set the
      // text to the hint and the color to gray
      @Override
      public void focusLost(FocusEvent e) {
        if (getText().equals(hint) || getText().length() == 0) {
          setText(hint);
          setForeground(Color.GRAY);
        } else {
          setText(getText());
          setForeground(Color.BLACK);
        }
      }
    });
  }
}
