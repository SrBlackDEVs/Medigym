package General;

import arduino.*;

public class ArdUNO {
	public static boolean connection;
	public static void Ard() throws InterruptedException {
		Ard arduino = new Ard();

		arduino.setPortDescription("COM3");
		arduino.setBaudRate(9600);
		connection = arduino.openConnection();
		if (connection) {
			System.out.println("Succesful");
			arduino.serialWrite("h");
			arduino.closeConnection();
		}

	}
}