import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame {

  private String id;
  private String name;
  private String major;
  private String selection;
  private HashMap<String, Student> studentDB = new HashMap<>();

  private Main() {
    super("Project 4");

    JPanel main = new JPanel();

    main.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    // TextFields
    JTextField idTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JTextField majorTextField = new JTextField();

    // labels
    JLabel idLabel = new JLabel("ID: ");
    JLabel nameLabel = new JLabel("NAME: ");
    JLabel majorLabel = new JLabel("MAJOR: ");
    JLabel selectLabel = new JLabel("PICK SELECTION: ");

    JButton processButton = new JButton("Process Request");

    c.fill = GridBagConstraints.HORIZONTAL;
    String[] selectOptions = {"Insert", "Delete", "Find", "Update"};
    JComboBox<String> selectCombobox = new JComboBox<String>(selectOptions);

    // Add idLabel
    c.insets = new Insets(0, 0, 5, 5);
    c.gridx = 0;
    c.gridy = 0;
    main.add(idLabel, c);

    // Add idTxt
    c.insets = new Insets(0, 5, 5, 0);
    c.gridx = 1;
    c.gridy = 0;
    main.add(idTextField, c);

    // Add nameLabel
    c.insets = new Insets(5, 0, 5, 5);
    c.gridx = 0;
    c.gridy = 1;
    main.add(nameLabel, c);

    // Add nameTxt
    c.insets = new Insets(5, 5, 5, 0);
    c.gridx = 1;
    c.gridy = 1;
    main.add(nameTextField, c);

    // Add majorLabel
    c.insets = new Insets(5, 0, 5, 5);
    c.gridx = 0;
    c.gridy = 2;
    main.add(majorLabel, c);

    // Add majorTxt
    c.insets = new Insets(5, 5, 5, 0);
    c.gridx = 1;
    c.gridy = 2;
    main.add(majorTextField, c);

    // Add selectLabel
    c.insets = new Insets(5, 0, 5, 5);
    c.gridx = 0;
    c.gridy = 3;
    main.add(selectLabel, c);

    // Add selectCombo
    c.insets = new Insets(5, 5, 5, 0);
    c.gridx = 1;
    c.gridy = 3;
    main.add(selectCombobox, c);

    // Add processBtn
    c.insets = new Insets(5, 0, 0, 5);
    c.gridx = 0;
    c.gridy = 4;
    main.add(processButton, c);

    // Add Main Panel
    add(main);

    processButton.addActionListener((ActionEvent e) -> {
      id = idTextField.getText();
      name = nameTextField.getText();
      major = majorTextField.getText();
      selection = selectCombobox.getSelectedItem().toString();

      try {
        if (id.isEmpty()) {
          throw new NullPointerException();
        } else {
          switch (selection) {
            case "Insert":
              if (studentDB.containsKey(id)) {
                JOptionPane.showMessageDialog(null,
                    "Student already exists!");
              } else {
                studentDB.put(id, new Student(name, major));
                JOptionPane.showMessageDialog(null,
                    name + " added to the the database");
              }
              break;
            case "Delete":
              if (!studentDB.containsKey(id)) {
                JOptionPane.showMessageDialog(null,
                    "Student does not exist");
              } else {
                studentDB.remove(id);
                JOptionPane.showMessageDialog(null,
                    name + " removed from the database");
              }
              break;

            case "Find":
              if (!studentDB.containsKey(id)) {
                JOptionPane.showMessageDialog(null,
                    "ID does not exits",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
              } else {
                studentDB.get(id);
                String student = studentDB.get(id).toString();
                JOptionPane.showMessageDialog(null,
                    "Student Found!\n" + student,
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
              }
              break;

            case "Update":
              if (studentDB.containsKey(id)) {
                String grade = (String) JOptionPane.showInputDialog(null,
                    "Choose Grade: ", "", JOptionPane.QUESTION_MESSAGE);
                if (grade != null) {
                  String creditHours = (String) JOptionPane.showInputDialog(null,
                      "Choose Credits: ", "", JOptionPane.QUESTION_MESSAGE);
                  if (creditHours != null) {
                    studentDB.get(id).courseCompleted(grade, Integer.parseInt(creditHours));
                    JOptionPane.showMessageDialog(null,
                        "Student info updated");
                  } else {
                    JOptionPane.showMessageDialog(null,
                        "credits value is empty",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                  }
                } else {
                  JOptionPane.showMessageDialog(null,
                      "Grade value is empty",
                      "Error",
                      JOptionPane.ERROR_MESSAGE);
                }
              } else {
                JOptionPane.showMessageDialog(null,
                    "ID does not exits",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
              }
              break;
          }
        }
      } catch (NullPointerException npe) {
        JOptionPane.showMessageDialog(null,
            "The id field is empty",
            "Error",
            JOptionPane.ERROR_MESSAGE);
      }

      idTextField.setText("");
      nameTextField.setText("");
      majorTextField.setText("");
    });

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(350, 200);
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);

  }

  public static void main(String[] args) {

    new Main();

  }
}
