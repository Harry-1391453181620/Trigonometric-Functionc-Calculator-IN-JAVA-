import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class TrigonometricGUI
{
    private JFrame frame;
    private JTextField angleTextField;
    private JTextField valueTextField;
    private JTextField cotTextField;
    private JTextArea resultTextArea;
    private final TrigonometricFunctionsDefinitions utils = new TrigonometricFunctionsDefinitions();
    private final DecimalFormat df = new DecimalFormat("#.##########");
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TrigonometricGUI::new);
    }
    public TrigonometricGUI() {
        createAndShowGUI();
    }
    public void createAndShowGUI() {
        frame = new JFrame("Trigonometric Functions Calculator");
        frame.setSize(650,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.png")));

        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel angleLabel = new JLabel("Angle (degrees): ");
        angleTextField = new JTextField(12);
        addComponent(inputPanel, angleLabel, 0, 0, gbc);
        addComponent(inputPanel, angleTextField, 1, 0, gbc);

        JLabel valueLabel = new JLabel("Arcsine and Arccosine Value(-1 <= x <= 1): ");
        valueTextField = new JTextField(12);
        addComponent(inputPanel, valueLabel, 0, 1, gbc);
        addComponent(inputPanel, valueTextField, 1, 1, gbc);

        JLabel cotLabel = new JLabel("Cotangent Value: ");
        cotTextField = new JTextField(12);
        addComponent(inputPanel, cotLabel, 0, 2, gbc);
        addComponent(inputPanel, cotTextField, 1, 2, gbc);

        JButton calculateButton = new JButton("Calculate all");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 14));
        calculateButton.setBackground(new Color(9, 67, 120, 232));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.addActionListener(new CalculateButtonListener());
        gbc.gridwidth = 2;
        addComponent(inputPanel, calculateButton, 0, 3, gbc);

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        resultTextArea.setLineWrap(true);
        resultTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void addComponent(JPanel panel, Component component, int x, int y, GridBagConstraints gbc) {
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(component, gbc);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            resultTextArea.setText("");
            try {
                if (!angleTextField.getText().trim().isEmpty()) {
                    double angleDeg = Double.parseDouble(angleTextField.getText());
                    resultTextArea.append("------------------Trigonometric Functions calculate(angle: " + angleDeg + "°)------------------\n");
                    resultTextArea.append("sinθ = " + df.format(utils.sin(angleDeg)) + "\n");
                    resultTextArea.append("cosθ = " + df.format(utils.cos(angleDeg)) + "\n");
                    resultTextArea.append("tanθ = " + df.format(utils.tan(angleDeg)) + "\n");
                    resultTextArea.append("cotθ = " + df.format(utils.cot(angleDeg)) + "\n");
                    resultTextArea.append("secθ = " + df.format(utils.sec(angleDeg)) + "\n");
                    resultTextArea.append("cscθ = " + df.format(utils.csc(angleDeg)) + "\n\n");
                }
                if (!valueTextField.getText().trim().isEmpty()) {
                    double value = Double.parseDouble(valueTextField.getText());
                    resultTextArea.append("------------------Inverse Trigonometric Functions calculate(value: " + value + ")------------------\n");
                    resultTextArea.append("arcsin(x) = " + df.format(utils.arcsin(value)) + "°\n");
                    resultTextArea.append("arccos(x) = " + df.format(utils.arccos(value)) + "°\n\n");
                }
                if (!cotTextField.getText().trim().isEmpty()) {
                    double cotValue = Double.parseDouble(cotTextField.getText());
                    resultTextArea.append("------------------Inverse Trigonometric Functions calculate(value: " + cotValue + ")------------------\n");
                    resultTextArea.append("arccot(x) = " + df.format(utils.arccot(cotValue)) + "°\n");
                }
                if (valueTextField.getText().trim().isEmpty() &&
                        angleTextField.getText().trim().isEmpty() &&
                        cotTextField.getText().trim().isEmpty()) {
                    resultTextArea.append("tip: Please entre at east one value in the text field.\n");
                }
            } catch (NumberFormatException ex) {
                resultTextArea.append("Error: Invalid input. Please enter a valid number.\n");
            } catch (IllegalArgumentException ex) {
                resultTextArea.append("Error: " + ex.getMessage() + "\n");
            }
        }
    }
}
