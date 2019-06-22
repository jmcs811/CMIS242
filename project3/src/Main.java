import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main extends JFrame {

    private Main() {
        super("Justin Project 3");

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
        JLabel efficiencyLabel = new JLabel("Efficieny: ");
        JTextField efficiencyField = new JTextField("");

        resultField.setEditable(false);
        efficiencyField.setEditable(false);

        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.insets = new Insets(0,5,5,0);
        constraints.gridx = 1;
        constraints.gridy = 0;
        main.add(iterButton, constraints);

        constraints.insets = new Insets(5,5,5,0);
        constraints.gridx = 1;
        constraints.gridy = 1;
        main.add(recrButton, constraints);

        constraints.insets = new Insets(5,0,5,5);
        constraints.gridx = 0;
        constraints.gridy = 2;
        main.add(inputLabel, constraints);

        constraints.insets = new Insets(5,5,5,0);
        constraints.gridx = 1;
        constraints.gridy = 2;
        main.add(inputField, constraints);

        constraints.insets = new Insets(5,5,5,0);
        constraints.gridx = 1;
        constraints.gridy = 3;
        main.add(calculateButton, constraints);

        constraints.insets = new Insets(5,0,5,5);
        constraints.gridx = 0;
        constraints.gridy = 4;
        main.add(resultLabel, constraints);

        constraints.insets = new Insets(5,5,5,0);
        constraints.gridx = 1;
        constraints.gridy = 4;
        main.add(resultField, constraints);

        constraints.insets = new Insets(5,0,0,5);
        constraints.gridx = 0;
        constraints.gridy = 5;
        main.add(efficiencyLabel, constraints);

        constraints.insets = new Insets(5,5,0,0);
        constraints.gridx = 1;
        constraints.gridy = 5;
        main.add(efficiencyField, constraints);

        add(main);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
