package searcher;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

public class Engine implements Runnable {
	public static ArrayList<String> valuesEngine = new ArrayList<String>();

	public static boolean active = false;
	Thread searchT;
	private JTextField field;
	private String finalString = "";

	public Engine(JTextField field) {
		searchT = new Thread(this);
		searchT.start();
		this.field = field;
	}

	@Override
	public void run() {
		while(true) {
			if(field.isFocusOwner()) {
				active = true;
				break;
			} else {
				active = false;
			}
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (active) {
			field.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char key = e.getKeyChar();

					String charString = String.valueOf(key);
					finalString = finalString.concat(charString);

					General.DatabaseExecutor.executor("SELECT na FROM alumnosgym WHERE na LIKE '" + finalString + "%';", valuesEngine);
					
					for(int i = 0; i < valuesEngine.size(); i++) {
						String values = valuesEngine.get(i);
						System.out.println(values);
					}
					valuesEngine.clear();
				}
			});
		}
	}
}