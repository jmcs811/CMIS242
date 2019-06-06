import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ATM extends JFrame {

  static final int WIDTH = 350;
  static final int HEIGHT = 200;
  static final int TEXT_WIDTH = 200;
  static final int TEXT_HEIGHT = 25;

  // init accounts
  private Account checking = new Account(100);
  private Account savings = new Account(50);

  // Declare all buttons
  private JButton withdrawButton = new JButton("Withdraw");
  private JButton depositButton = new JButton("Deposit");
  private JButton transferButton = new JButton("Transfer");
  private JButton balanceButton = new JButton("Balance");

  // Declare all radio buttons
  private JRadioButton checkingRadioButton = new JRadioButton("Checking");
  private JRadioButton savingRadioButton = new JRadioButton("Savings");

  // Declare input field
  private JTextField amount = new HintTextField("Enter Amount to Transfer");

  // Declare button groip
  private ButtonGroup radioButtons = new ButtonGroup();

  private JOptionPane frame = new JOptionPane();

  // Constructor
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

    // set action listeners
    balanceButton.addActionListener(new BalanceButtonListener());
    withdrawButton.addActionListener(new WithdrawButtonListener());
    depositButton.addActionListener(new DepositButtonListener());
    transferButton.addActionListener(new TransferButtonListener());
  }

  /*
   * Action Listeners for the 4 buttons
   */

  private class BalanceButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      if (checkingRadioButton.isSelected()) {
        showMessage(checking.getBalance(), "in checking account");
      } else {
        showMessage(savings.getBalance(), "in savings account");
      }
    }
  }

  private class WithdrawButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
  }

  private class DepositButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      double input = getInput();
      if (isValidInput(input)) {
        if (checkingRadioButton.isSelected()) {
          checking.deposit(input);
          showMessage(input, "deposited into checking");
        } else {
          savings.deposit(input);
          showMessage(input, "deposited into savings");
        }
      } else {
        showMessage("Invalid Input: Enter a multiple of 20");
      }
      clearTextField();
    }
  }

  private class TransferButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      double input = getInput();
      if (isValidInput(input)) {
        if (checkingRadioButton.isSelected()) {
          try {
            savings.transferTo(checking, input);
            showMessage(input, "transferred to checking");
          } catch (InsufficientFunds insufficientFunds) {
            insufficientFunds.printStackTrace();
          }
        } else {
          try {
            checking.transferTo(savings, input);
            showMessage(input, "transferred to savings");
          } catch (InsufficientFunds insufficientFunds) {
            insufficientFunds.printStackTrace();
          }
        }
      } else {
        showMessage("Invalid Input: Enter a multiple of 20");
      }
      clearTextField();
    }
  }

  public double getInput() {
    try {
      return Double.parseDouble(amount.getText());
    } catch (NumberFormatException e) {
      showMessage("Please Enter a number!");
      clearTextField();
      return 0;
    }
  }

  public void clearTextField() {
    amount.setText("");
  }

  public boolean isValidInput(double input) {
    return (input % 20) == 0 && (input > 0);
  }

  public void showMessage(double amount, String message) {
    JOptionPane.showMessageDialog(frame, amount + " " + message);
  }

  public void showMessage(String message) {
    JOptionPane.showMessageDialog(frame, message);
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