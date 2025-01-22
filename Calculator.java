import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    
    // Creating frame for the GUI
    private JFrame frame;
    private JTextField textField1, textField2, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, clearButton;
    
    public static void main(String[] args) {
        // Running the application
        SwingUtilities.invokeLater(() -> new Calculator().createGUI());
    }

    public void createGUI() {
        // Frame setup
        frame = new JFrame("Simple Calculator");
        frame.setSize(900,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Text fields for user input
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        resultField = new JTextField(15);
        resultField.setEditable(false);
        
        // Buttons for operations
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        clearButton = new JButton("Clear");
	

        // Adding components to the frame
        frame.add(new JLabel("Enter first number:"));
        frame.add(textField1);
        frame.add(new JLabel("Enter second number:"));
        frame.add(textField2);
        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(multiplyButton);
        frame.add(divideButton);
        frame.add(new JLabel("Result:"));
        frame.add(resultField);
        frame.add(clearButton);

        // Setting visibility of the frame
        frame.setVisible(true);

        // Action listeners for buttons
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation('+');
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation('-');
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation('*');
            }
        });

        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation('/');
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                resultField.setText("");
            }
        });
    }

    // Method to perform the calculation
    private void performOperation(char operator) {
        try {
            double num1 = Double.parseDouble(textField1.getText());
            double num2 = Double.parseDouble(textField2.getText());
            double result = 0;

            // Based on the operator, perform the respective operation
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        resultField.setText("Error: Div by 0");
                        return;
                    }
                    break;
            }

            // Display the result
            resultField.setText(String.valueOf(result));

        } catch (NumberFormatException e) {
            resultField.setText("Invalid input");
        }
    }
}
