import java.awt.*;
import javax.swing.*;

public class ATM extends JFrame{
  static final int WIDTH = 350;
  static final int HEIGHT = 200;
  static final int TEXT_WIDTH = 200;
  static final int TEXT_HEIGHT = 25;

  // Declare all buttons
  private JButton withdrawButton = new JButton("Withdraw");
  private JButton depositButton = new JButton("Deposit");
  private JButton transferButton = new JButton("Transfer");
  private JButton balanceButton = new JButton("Button");

  // Declare all radio buttons
  private JRadioButton checkingRadioButton = new JRadioButton("Checking");
  private JRadioButton savingRadioButton = new JRadioButton("Savings");

  // Declare input field
  private JTextField amount = new HintTextField("Enter Amount to Transfer");

  // Declare button groip
  private ButtonGroup radioButtons = new ButtonGroup();

  private JOptionPane frame = new JOptionPane();

  public ATM() {
    super("Justin ATM");
    setLayout(new GridBagLayout());
    setFrame(WIDTH, HEIGHT);

    GridBagConstraints layout = new GridBagConstraints();
    layout.gridy = 2;

    // Creating the required JFrames
    JPanel buttonPanel = new JPanel();
    JPanel inputPanel = new JPanel();

    // adding button panel to the JFrame
    add(buttonPanel);
    buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));

    // adding inputPanel to JFrame
    add(inputPanel, layout);
    inputPanel.setLayout(new GridLayout(1, 1));

    // adding all buttons to the button panel
    buttonPanel.add(withdrawButton);
    buttonPanel.add(depositButton);
    buttonPanel.add(transferButton);
    buttonPanel.add(balanceButton);

    // adding all radio buttons to radio button group
    radioButtons.add(checkingRadioButton);
    radioButtons.add(savingRadioButton);

    // add the radio buttons to the button panel
    buttonPanel.add(checkingRadioButton);
    buttonPanel.add(savingRadioButton);

    // setting default selected radio button
    checkingRadioButton.setSelected(true);

    // setting width for the input field
    amount.setPreferredSize(new Dimension(TEXT_WIDTH, TEXT_HEIGHT));

    // adding input field to the input panel
    inputPanel.add(amount);
  }

  public void setFrame(int width, int height) {
    setSize(width, height);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void display() {
    setVisible(true);
  }

  public static void main(String[] args) {
    ATM window = new ATM();
    window.display();
  }
}