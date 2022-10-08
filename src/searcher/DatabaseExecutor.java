package searcher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseExecutor {
	
    private static String udb = "";
    private static String pdb = "";
    private static String ndb = "";
    private static String host = "";
    private static String url = "";
    
    public static ArrayList<String> executor(String mysqlStat, ArrayList<String> array) {
    	if(udb == null || pdb == null || ndb == null) {
    		System.out.println("Please use first setDatabase to define the database to use.");
    	} else {
    	
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url, udb, pdb);
	            Statement stmt = con.createStatement();
	            ResultSet result = stmt.executeQuery(mysqlStat);
	            
	            int cont = 1;
	            while(result.next()) {
	            	array.add(result.getString(cont));
	            	cont = cont++;
	            }
	        }
	        catch(Exception e) {
	            	e.printStackTrace();
	            }
	        return array;
    	}
    	return null;
    }
    public static void setDatabase(String UserDB, String PassDB, String NameDB, String ipOrLocalHost, String Parameters) {
    	udb = UserDB;
    	pdb = PassDB;
    	ndb = NameDB;
    	
    	if(host != null) {
    		host = ipOrLocalHost;
    	} else {
    		host = "localhost:3306";
    	}
    	
    	if(Parameters != null) {
    		url = "jdbc:mysql://" + host + "/" + ndb + Parameters;
    	} else {
    		url = "jdbc:mysql://" + host + "/" + ndb + "?allowPublicKeyRetrieval=true&&useSSL=false";
    	}
    }
}
