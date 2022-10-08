package General;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class Clock extends javax.swing.JFrame implements Runnable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 
     */
    public static int h, m, s;
    public static boolean verify = true;

    Calendar thours;
    Thread t1;

    public Clock() {
        t1 = new Thread(this);
        t1.start();
    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == t1) {
            getTime();
            LoadUI.forClock.setText(Clock.h + ":" + Clock.m + ":" + Clock.s);
            if (Clock.h >= 19 && Clock.h <= 8 || Clock.h == 0) {
                verify = true;
            } else {
                verify = false;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    public void getTime() {
        Calendar thours = new GregorianCalendar();
        h = thours.get(Calendar.HOUR_OF_DAY);
        m = thours.get(Calendar.MINUTE);
        s = thours.get(Calendar.SECOND);
    }
}