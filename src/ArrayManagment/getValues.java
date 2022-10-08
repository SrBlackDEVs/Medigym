package ArrayManagment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

// Charge values to the RAM

public class getValues implements Runnable {
	
    public static ArrayList<String> Names = new ArrayList<String>();
    public static ArrayList<String> ci = new ArrayList<String>();
    private static int i = 1;
    
    Thread arrayT;

    public getValues() {
        arrayT = new Thread(this);
        arrayT.start();
    }
    @Override
    public void run() {

        String udb, pdb, ndb, host, url;

        udb = "medigym";
        pdb = "medigim";
        ndb = "alumnos";
        host = "localhost:3306";
        url = "jdbc:mysql://" + host + "/" + ndb + "?allowPublicKeyRetrieval=true&&useSSL=false";

        String PREstat = "SELECT na FROM alumnosgym";
        String PREstat2 = "SELECT ci FROM alumnosgym";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, udb, pdb);
            Statement stmt = con.createStatement();
            ResultSet namesState = stmt.executeQuery(PREstat);
            while (namesState.next()) {
                i = i++;
                String AllNames = namesState.getString(i);
                Names.add(AllNames);
            }
            ResultSet ciState = stmt.executeQuery(PREstat2);
            while (ciState.next()) {
                i = i++;
                String Allna = ciState.getString(i);
                ci.add(Allna);
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int SearchArray(ArrayList<String> array, String toSearch) {
        int position = array.indexOf(toSearch);
        if (position != 0) {
            return position;
        } else {
            return -1;
        }
    }
}
