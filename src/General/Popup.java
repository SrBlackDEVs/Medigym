package General;

import java.awt.Color;
import javax.swing.*;
import java.awt.Font;

public class Popup extends javax.swing.JFrame implements Runnable {

    /*
     */
    private static final long serialVersionUID = 6015754714780779838L;
    /*
     */
    private static Color letters = new Color(192, 192, 192);
    private static Color back = new Color(15, 19, 25);
    public static boolean Visible = true;
    public static JLabel NameLabel = new JLabel("Bienvenido");
    Thread Threadpop;

    public Popup() {
        Threadpop = new Thread(this);
        Threadpop.start();

        Visible = false;
        setLocation(300, 280);
        setAlwaysOnTop(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setBackground(back);
        getContentPane().setLayout(null);

        NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        NameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        NameLabel.setForeground(letters);
        NameLabel.setBounds(162, 11, 544, 73);
        getContentPane().add(NameLabel);
        setSize(860, 250);

    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e1) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error", "Interrumpted exception",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        while (ct == Threadpop) {

            try {
                Thread.sleep(5);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            if (Visible) {

                String name = "";
                int position = ArrayManagment.getValues.SearchArray(ArrayManagment.getValues.ci, LoadUI.CIText);

                if (position != -1) {

                    name = ArrayManagment.getValues.Names.get(position);

                } else {
                    System.out.println("Inexistente");
                }
                NameLabel.setText("¡Bienvenido " + name + "!");

                setVisible(Visible);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } // Visible time of the popup

                Visible = false;
                setVisible(Visible);
                dispose();
            }
        }
    }
}
