package General;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseExecutor {
    public static String executor(String mysqlStat, ArrayList<String> array) {
    	String resultsql = "";
    	String udb, pdb, ndb, host, url;

        udb = "medigym";
        pdb = "medigim";
        ndb = "alumnos";
        host = "localhost:3306";
        url = "jdbc:mysql://" + host + "/" + ndb + "?allowPublicKeyRetrieval=true&&useSSL=false";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, udb, pdb);
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(mysqlStat);
            
            while(result.next()) {
            	resultsql = result.getString(1);
            	array.add(resultsql);
            }
        }
        catch(Exception e) {
            	e.printStackTrace();
            }
        return resultsql;
    }
}
