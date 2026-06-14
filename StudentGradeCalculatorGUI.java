import javax.swing.*;
import java.awt.*;

public class StudentGradeCalculatorGUI extends JFrame {

    private JTextField nameField;

    private JTextField mathField;
    private JTextField englishField;
    private JTextField physicsField;
    private JTextField csField;
    private JTextField urduField;

    private JTextArea resultArea;

    public StudentGradeCalculatorGUI() {

        setTitle("Student Grade System");
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(new Color(245, 245, 255));

        JLabel title = new JLabel("STUDENT RESULT SYSTEM", SwingConstants.CENTER);
        title.setBounds(100, 10, 450, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(new Color(40, 60, 120));
        add(title);

        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(50, 70, 150, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200, 70, 350, 25);
        add(nameField);

        // Subjects
        mathField = createField("Math Marks:", 110);
        englishField = createField("English Marks:", 150);
        physicsField = createField("Physics Marks:", 190);
        csField = createField("Computer Marks:", 230);
        urduField = createField("Urdu Marks:", 270);

        // Buttons
        JButton calcBtn = new JButton("Calculate Result");
        calcBtn.setBounds(150, 320, 150, 35);
        calcBtn.setBackground(new Color(76, 175, 80));
        calcBtn.setForeground(Color.WHITE);
        add(calcBtn);

        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(330, 320, 150, 35);
        clearBtn.setBackground(new Color(255, 152, 0));
        clearBtn.setForeground(Color.WHITE);
        add(clearBtn);

        resultArea = new JTextArea();
        resultArea.setBounds(50, 380, 550, 120);
        resultArea.setFont(new Font("Monospaced", Font.BOLD, 13));
        resultArea.setBackground(new Color(30, 30, 30));
        resultArea.setForeground(Color.GREEN);
        resultArea.setEditable(false);
        add(resultArea);

        calcBtn.addActionListener(e -> calculate());
        clearBtn.addActionListener(e -> clear());

        setVisible(true);
    }

    private JTextField createField(String label, int y) {

        JLabel l = new JLabel(label);
        l.setBounds(50, y, 150, 25);
        add(l);

        JTextField field = new JTextField();
        field.setBounds(200, y, 350, 25);
        add(field);

        return field;
    }

    private void calculate() {

        try {

            String name = nameField.getText();

            int math = Integer.parseInt(mathField.getText());
            int english = Integer.parseInt(englishField.getText());
            int physics = Integer.parseInt(physicsField.getText());
            int cs = Integer.parseInt(csField.getText());
            int urdu = Integer.parseInt(urduField.getText());

            int total = math + english + physics + cs + urdu;
            double percentage = total / 5.0;

            String grade;

            if (percentage >= 90) grade = "A+ (Excellent)";
            else if (percentage >= 80) grade = "A (Very Good)";
            else if (percentage >= 70) grade = "B (Good)";
            else if (percentage >= 60) grade = "C (Average)";
            else if (percentage >= 50) grade = "D (Pass)";
            else grade = "F (Fail)";

            resultArea.setText(
                    "===== STUDENT REPORT CARD =====\n" +
                    "Name       : " + name + "\n" +
                    "Math       : " + math + "\n" +
                    "English    : " + english + "\n" +
                    "Physics    : " + physics + "\n" +
                    "Computer   : " + cs + "\n" +
                    "Urdu       : " + urdu + "\n" +
                    "--------------------------------\n" +
                    "Total      : " + total + "/500\n" +
                    "Percentage : " + percentage + "%\n" +
                    "Grade      : " + grade + "\n" +
                    "================================"
            );

        } catch (Exception ex) {
            resultArea.setText("ERROR: Please enter valid numeric marks in all fields!");
        }
    }

    private void clear() {

        nameField.setText("");
        mathField.setText("");
        englishField.setText("");
        physicsField.setText("");
        csField.setText("");
        urduField.setText("");
        resultArea.setText("");
    }

    public static void main(String[] args) {
        new StudentGradeCalculatorGUI();
    }
}