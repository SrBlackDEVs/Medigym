package General;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChargeUI {
	public static JFrame window = new JFrame();
	public static JTextField searchBar;

	/**
	 * @throws InterruptedException 
	 * @wbp.parser.entryPoint
	 */
	public static void Window() throws InterruptedException {
		// Color text = new Color(31, 35, 41);

		window.setSize(1366, 768);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);

		
		JLabel image = new JLabel();
		image.setIcon(new ImageIcon(ChargeUI.class.getResource("/General/recurs/Image.png")));
		image.setBounds(window.getBounds());

		searchBar = new JTextField();
		searchBar.setForeground(Color.BLACK);
		searchBar.setBounds(393, 82, 344, 38);
		searchBar.setColumns(1);

		window.getContentPane().add(searchBar);
		window.getContentPane().add(image);

		window.setVisible(true);
		
		

	}
}