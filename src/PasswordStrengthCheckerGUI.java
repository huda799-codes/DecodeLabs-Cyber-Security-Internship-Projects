import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;

public class PasswordStrengthCheckerGUI extends JFrame {

    private final JPasswordField passwordField;
    private final JLabel resultLabel;
    private final JLabel lengthLabel;
    private final JLabel uppercaseLabel;
    private final JLabel lowercaseLabel;
    private final JLabel digitLabel;
    private final JLabel symbolLabel;
    private final JProgressBar strengthBar;

    public PasswordStrengthCheckerGUI() {

        setTitle("Password Strength Checker");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(30, 50, 30, 50));

        // ---------------- TITLE ----------------
        JLabel titleLabel = new JLabel("PASSWORD STRENGTH CHECKER");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitleLabel =
                new JLabel("Analyze your password security");
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel passwordLabel = new JLabel("Enter Password:");
        passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(500, 40));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));


        JCheckBox showPassword = new JCheckBox("Show Password");

        showPassword.addActionListener(e -> {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('•');
            }
        });

        JButton checkButton = new JButton("CHECK STRENGTH");
        checkButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkButton.setMaximumSize(new Dimension(250, 45));

        resultLabel = new JLabel("Enter a password to begin");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 22));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        strengthBar = new JProgressBar(0, 5);
        strengthBar.setValue(0);
        strengthBar.setStringPainted(true);
        strengthBar.setMaximumSize(new Dimension(500, 30));

        lengthLabel = new JLabel("○ At least 8 characters");
        uppercaseLabel = new JLabel("○ Contains an uppercase letter");
        lowercaseLabel = new JLabel("○ Contains a lowercase letter");
        digitLabel = new JLabel("○ Contains a number");
        symbolLabel = new JLabel("○ Contains a special character");

        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(5));
        mainPanel.add(subtitleLabel);

        mainPanel.add(Box.createVerticalStrut(30));

        mainPanel.add(passwordLabel);
        mainPanel.add(Box.createVerticalStrut(5));
        mainPanel.add(passwordField);
        mainPanel.add(Box.createVerticalStrut(5));
        mainPanel.add(showPassword);

        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(checkButton);

        mainPanel.add(Box.createVerticalStrut(25));
        mainPanel.add(resultLabel);

        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(strengthBar);

        mainPanel.add(Box.createVerticalStrut(25));

        mainPanel.add(lengthLabel);
        mainPanel.add(Box.createVerticalStrut(8));
        mainPanel.add(uppercaseLabel);
        mainPanel.add(Box.createVerticalStrut(8));
        mainPanel.add(lowercaseLabel);
        mainPanel.add(Box.createVerticalStrut(8));
        mainPanel.add(digitLabel);
        mainPanel.add(Box.createVerticalStrut(8));
        mainPanel.add(symbolLabel);

        add(mainPanel);

        checkButton.addActionListener(e -> checkPassword());

        setVisible(true);
    }

    private void checkPassword() {

        char[] password = passwordField.getPassword();


        if (password.length == 0) {
            resultLabel.setText("Please enter a password");
            strengthBar.setValue(0);
            resetRequirementLabels();

            Arrays.fill(password, '\0');
            return;
        }

        boolean validLength = password.length >= 8;
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;

        for (char ch : password) {

            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }
            else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            }
            else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            else {
                hasSymbol = true;
            }
        }

        lengthLabel.setText(
                validLength
                        ? "✓ At least 8 characters"
                        : "✗ At least 8 characters"
        );

        uppercaseLabel.setText(
                hasUppercase
                        ? "✓ Contains an uppercase letter"
                        : "✗ Contains an uppercase letter"
        );

        lowercaseLabel.setText(
                hasLowercase
                        ? "✓ Contains a lowercase letter"
                        : "✗ Contains a lowercase letter"
        );

        digitLabel.setText(
                hasDigit
                        ? "✓ Contains a number"
                        : "✗ Contains a number"
        );

        symbolLabel.setText(
                hasSymbol
                        ? "✓ Contains a special character"
                        : "✗ Contains a special character"
        );

        int score = 0;

        if (validLength) score++;
        if (hasUppercase) score++;
        if (hasLowercase) score++;
        if (hasDigit) score++;
        if (hasSymbol) score++;

        strengthBar.setValue(score);


        if (!validLength) {
            resultLabel.setText("WEAK");
        }
        else if (score == 5) {
            resultLabel.setText("STRONG");
        }
        else if (score >= 3) {
            resultLabel.setText("MEDIUM");
        }
        else {
            resultLabel.setText("WEAK");
        }

        // Clear the temporary password array
        Arrays.fill(password, '\0');
    }

    private void resetRequirementLabels() {

        lengthLabel.setText("○ At least 8 characters");
        uppercaseLabel.setText("○ Contains an uppercase letter");
        lowercaseLabel.setText("○ Contains a lowercase letter");
        digitLabel.setText("○ Contains a number");
        symbolLabel.setText("○ Contains a special character");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new PasswordStrengthCheckerGUI()
        );
    }
}