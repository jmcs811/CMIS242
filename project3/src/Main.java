/////////////////////////////////////////////
// File: Main.java
// Author: Justin Casey
// Date: June 25, 2019
// Purpose: This class defines
//          the gui and handles the
//          file writing on exit.
//

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main extends JFrame {

  // constructor
  private Main() {
    super("Justin Project 3");

    // Creating the GUI elements
    JPanel main = new JPanel();

    main.setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();

    JRadioButton iterButton = new JRadioButton("Iterative");
    JRadioButton recrButton = new JRadioButton("Recursive");

    JLabel inputLabel = new JLabel("Enter a Number: ");
    JTextField inputField = new JTextField("");
    JButton calculateButton = new JButton("calculate");
    JLabel resultLabel = new JLabel("Result: ");
    JTextField resultField = new JTextField("");
    JLabel efficiencyLabel = new JLabel("Efficiency: ");
    JTextField efficiencyField = new JTextField("");

    // setting fields to uneditable
    resultField.setEditable(false);
    efficiencyField.setEditable(false);

    // set iterbutton to the default
    iterButton.setSelected(true);

    // Adding all of the elements to the layout
    constraints.fill = GridBagConstraints.HORIZONTAL;

    constraints.insets = new Insets(0, 5, 5, 0);
    constraints.gridx = 1;
    constraints.gridy = 0;
    main.add(iterButton, constraints);

    constraints.insets = new Insets(5, 5, 5, 0);
    constraints.gridx = 1;
    constraints.gridy = 1;
    main.add(recrButton, constraints);

    constraints.insets = new Insets(5, 0, 5, 5);
    constraints.gridx = 0;
    constraints.gridy = 2;
    main.add(inputLabel, constraints);

    constraints.insets = new Insets(5, 5, 5, 0);
    constraints.gridx = 1;
    constraints.gridy = 2;
    main.add(inputField, constraints);

    constraints.insets = new Insets(5, 5, 5, 0);
    constraints.gridx = 1;
    constraints.gridy = 3;
    main.add(calculateButton, constraints);

    constraints.insets = new Insets(5, 0, 5, 5);
    constraints.gridx = 0;
    constraints.gridy = 4;
    main.add(resultLabel, constraints);

    constraints.insets = new Insets(5, 5, 5, 0);
    constraints.gridx = 1;
    constraints.gridy = 4;
    main.add(resultField, constraints);

    constraints.insets = new Insets(5, 0, 0, 5);
    constraints.gridx = 0;
    constraints.gridy = 5;
    main.add(efficiencyLabel, constraints);

    constraints.insets = new Insets(5, 5, 0, 0);
    constraints.gridx = 1;
    constraints.gridy = 5;
    main.add(efficiencyField, constraints);

    // Creating and adding radio buttons
    // to a button group
    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(iterButton);
    buttonGroup.add(recrButton);

    // creating the action listener for the calculate btn
    class CalculateButtonListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        try {
          int input = getInput(inputField);
          if (iterButton.isSelected()) {
            resultField.setText(String.valueOf(Sequence.computeIterative(input)));
          } else {
            resultField.setText(String.valueOf(Sequence.computeRecursive(input)));
          }
          efficiencyField.setText(String.valueOf(Sequence.getEfficiency()));
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(null, "Please Enter a number!");
        }
      }
    }

    // add the listener to the button
    calculateButton.addActionListener(new CalculateButtonListener());
    add(main);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(250, 300);
    setVisible(true);

    new WriteOnExit();

  }

  // writes to a file on exit
  class WriteOnExit extends WindowAdapter {

    WriteOnExit() {
      addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
          FileWriter fileWriter = null;
          try {
            fileWriter = new FileWriter("efficiency-results");
            fileWriter.append("Number, Iterative, Recursive\n");
            for (int i = 0; i <= 10; i++) {
              fileWriter.append(Integer.toString(i));
              fileWriter.append(",");
              Sequence.computeIterative(i);
              fileWriter.append(String.valueOf(Sequence.getEfficiency()));
              fileWriter.append(",");
              Sequence.computeRecursive(i);
              fileWriter.append(String.valueOf(Integer.toString(Sequence.getEfficiency())));
              fileWriter.append("\n");
            }

            fileWriter.close();
          } catch (IOException ex) {
            ex.printStackTrace();
          }
        }
      });
    }
  }

  // helper method to get input
  private int getInput(JTextField input) {
    return Integer.parseInt(input.getText());
  }

  public static void main(String[] args) {
    new Main();
  }
}
