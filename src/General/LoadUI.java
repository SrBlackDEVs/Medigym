package General;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class LoadUI {
    public static JLabel forImage = new JLabel();
    public static JLabel forClock = new JLabel();
    public static JTextField CI = new JTextField();
    public static JTextField CIfield;
    public static String CIText;
    private static int count = 0; // Letters counter

    /**
     * @throws InterruptedException
     * @wbp.parser.entryPoint
     */
    public static void Window() throws InterruptedException {
        new ArrayManagment.getValues();

        Color blueL = new Color(87, 148, 247);
        Color testing = new Color(192, 192, 192);

        JFrame window = new JFrame();
        window.setUndecorated(true);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setLayout(null);
        forClock.setText("00:00:00");
        forClock.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        forClock.setBounds(425, 83, 448, 109);
        forClock.setForeground(testing);
        forClock.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);

        new Clock();
        forImage.setIcon(new ImageIcon(LoadUI.class.getResource("/General/recurs/DARK.png")));

        forImage.setBounds(0, 0, 1366, 768);

        CIfield = new JTextField();
        CIfield.setOpaque(false);
        CIfield.setBounds(479, 475, 439, 48);
        CIfield.setColumns(1);
        CIfield.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        CIfield.setForeground(blueL);
        CIfield.setBorder(null);

        CIfield.setToolTipText("Ingrese su cedula para ingresar. \n Sin puntos ni guiones");
        new Popup();

        CIfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                count = count + 1;
                int key = e.getKeyChar();

                if (key == 8) {
                    count = count - 2;
                }
                if (CIfield.getText().length() >= 8) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
                boolean num = key >= 48 && key <= 58;

                if (!num) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();

                }

                if (key == 10) { // Enter presionado
                    if (!CIfield.getText().isEmpty() && CIfield.getText().length() >= 8) {
                        CIText = CIfield.getText();
                        count = 0;
                        CIfield.setText(null);
                        int position = ArrayManagment.getValues.SearchArray(ArrayManagment.getValues.ci, CIText);

                        if (position != -1) {

                            try {
                                ArdUNO.Ard();
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                            if (ArdUNO.connection) {
                                Popup.Visible = true;
                                Popup.NameLabel.setText("Ocurrió un error. \n Vuelva a intentarlo por favor.");
                            }
                        }
                    } else {

                    }
                }
            }
        });
        window.getContentPane().add(CIfield);
        window.getContentPane().add(forClock);
        window.getContentPane().add(forImage);

        // Style

        window.setVisible(true);

    }
}