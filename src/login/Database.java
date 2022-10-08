package login;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    public static ResultSet Us;
    public static ResultSet Ps;
    private static String MAILstring;
    private static String passString;
    public static String CIch;
    private static String NAch;

    public static boolean Read() {

        String udb, pdb, ndb, host, url;
        String mailS = mainWindow.emailField.getText();
        char[] pass = mainWindow.passField.getPassword();
        String password = new String(pass);

        boolean exist = false;

        udb = "medigym";
        pdb = "medigim";
        ndb = "alumnos";
        host = "localhost:3306";
        url = "jdbc:mysql://" + host + "/" + ndb + "?allowPublicKeyRetrieval=true&useSSL=false";

        String PREmail = "SELECT email FROM login WHERE email LIKE '" + mailS + "';";
        String PREpass = "SELECT pass FROM login WHERE email LIKE '" + mailS + "';";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, udb, pdb);
            Statement stmt = con.createStatement();

            ResultSet mailStat = stmt.executeQuery(PREmail);
            while (mailStat.next()) {
                MAILstring = mailStat.getString(1);
            }

            ResultSet passStat = stmt.executeQuery(PREpass);
            while (passStat.next()) {
                passString = passStat.getString(1);
            }

            if (MAILstring.equals(mailS) && passString.equals(password)) {
                exist = true;
            } else {
                exist = false;
            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }
        if (exist) {
            return true;
        } else {
            return false;
        }
    }

    public static void Write() {
        String udb, pdb, ndb, host, url;

        udb = "root";
        pdb = "mateo";
        ndb = "user-pass";
        host = "localhost:3306";
        url = "jdbc:mysql://" + host + "/" + ndb;

        String CHARGEci = "INSERT INTO alumnosgym ('ci', 'na') VALUES '" + CIch + "', '" + NAch;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, udb, pdb);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(CHARGEci);
            System.out.println("Connected");
        }

        catch (Exception e) {
            System.out.println("We can't connect to the database. Try again.");
            System.out.println("Cerrando programa...");
            e.printStackTrace();
        } // Catch
    }
}