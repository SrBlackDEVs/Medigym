package login;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.event.*;

public class mainWindow {
    public static JTextField emailField;
    public static JPasswordField passField;
    public static String passwordS;
    private static JLabel errorLabel = new JLabel("");
    public static JButton loginButton = new JButton("");
    public static JFrame window = new JFrame();

    /**
     * @wbp.parser.entryPoint
     */
    public static void Window() {

        Color blueL = new Color(87, 148, 247);

        window.setTitle("Inicio de sesion");
        window.setSize(1366, 768);

        window.setResizable(false);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setLayout(null);

        // Components style

        JLabel forImage = new JLabel("");
        forImage.setBorder(null);
        forImage.setIcon(new ImageIcon(mainWindow.class.getResource("/login/recurs/loginDark.png")));
        forImage.setBounds(0, 0, 1366, 768);

        emailField = new JTextField();
        emailField.setAlignmentX(0.0f);
        emailField.setAlignmentY(Component.TOP_ALIGNMENT);
        emailField.setHorizontalAlignment(SwingConstants.LEFT);
        emailField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        emailField.setBorder(null);
        emailField.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        emailField.setBounds(470, 278, 432, 39);
        emailField.setForeground(blueL);
        emailField.setOpaque(false);

        errorLabel.setForeground(Color.red);
        errorLabel.setBounds(470, 300, 432, 40);
        window.getContentPane().add(errorLabel);

        emailField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                int numKey = e.getKeyChar();
                String text = emailField.getText();

                if (Character.isUpperCase(key)) {
                    char lower = Character.toLowerCase(key);
                    e.consume();

                    emailField.setText(text + lower);
                }
                if (numKey == 32) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }

                if (numKey == 10) {
                    passField.requestFocus();
                }
            }
        });

        passField = new JPasswordField();
        passField.setBorder(null);
        passField.setFont(new Font("Sitka Text", Font.PLAIN, 16));
        passField.setBounds(470, 392, 432, 39);
        passField.setForeground(blueL);
        passField.setOpaque(false);

        loginButton.setFocusPainted(false);
        // loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setBounds(454, 476, 461, 69);
        // loginButton.setOpaque(false);

        window.getContentPane().add(loginButton);
        window.getContentPane().add(emailField);
        window.getContentPane().add(passField);
        window.getContentPane().add(forImage);

        window.setVisible(true);

        loginButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!emailField.getText().isEmpty()) {
                    char[] password = passField.getPassword();
                    String pass = new String(password);

                    if (!pass.equals("") && pass.length() >= 8) {
                        Database.Read();

                        if (Database.Read()) {
                            window.dispose();
                            detectHover.detThread = false;
                            try {
                                General.Init.Pane();
                            } catch (InterruptedException e1) {
                            }
                        } else {
                            errorLabel.setText("Email o contraseña erroneas");
                        }
                    } else {
                        errorLabel.setText("La contraseña no puede ser menor a 8 caracteres");
                    }
                } else {
                    errorLabel.setText("El email no puede estar vacío");
                }

            }

            public void mousePressed(MouseEvent pressed) {
                loginButton.setBorderPainted(true);
                loginButton.setBorder(new MatteBorder(1, 1, 1, 1, blueL));

            }

            public void mouseReleased(MouseEvent released) {
                loginButton.setBorder(null);
                loginButton.setBorderPainted(false);

            }
        });
        new detectHover();
    }
}