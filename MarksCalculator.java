import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MarksCalculator extends JFrame implements ActionListener {

    private final JTextField subject1Field;
    private final JTextField subject2Field;
    private final JTextField subject3Field;
    private final JTextField subject4Field;
    private final JTextField subject5Field;
    private final JLabel totalMarksLabel;
    private final JLabel averagePercentageLabel;
    private final JLabel gradeLabel;

    public MarksCalculator() {
        setTitle("Marks Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("Subject 1 Marks:"));
        subject1Field = new JTextField();
        add(subject1Field);

        add(new JLabel("Subject 2 Marks:"));
        subject2Field = new JTextField();
        add(subject2Field);

        add(new JLabel("Subject 3 Marks:"));
        subject3Field = new JTextField();
        add(subject3Field);

        add(new JLabel("Subject 4 Marks:"));
        subject4Field = new JTextField();
        add(subject4Field);

        add(new JLabel("Subject 5 Marks:"));
        subject5Field = new JTextField();
        add(subject5Field);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        add(calculateButton);

        totalMarksLabel = new JLabel("Total Marks: ");
        add(totalMarksLabel);

        averagePercentageLabel = new JLabel("Average Percentage: ");
        add(averagePercentageLabel);

        gradeLabel = new JLabel("Grade: ");
        add(gradeLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MarksCalculator calculator = new MarksCalculator();
            calculator.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int subject1 = Integer.parseInt(subject1Field.getText());
            int subject2 = Integer.parseInt(subject2Field.getText());
            int subject3 = Integer.parseInt(subject3Field.getText());
            int subject4 = Integer.parseInt(subject4Field.getText());
            int subject5 = Integer.parseInt(subject5Field.getText());

            int totalMarks = subject1 + subject2 + subject3 + subject4 + subject5;
            double averagePercentage = totalMarks / 5.0;

            totalMarksLabel.setText("Total Marks: " + totalMarks);
            averagePercentageLabel.setText("Average Percentage: " + averagePercentage);

            String grade;
            if (averagePercentage >= 90) {
                grade = "A";
            } else if (averagePercentage >= 80) {
                grade = "B";
            } else if (averagePercentage >= 70) {
                grade = "C";
            } else if (averagePercentage >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            gradeLabel.setText("Grade: " + grade);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for all subjects.");
        }
    }
}

