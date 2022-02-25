package br.com.crud.connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
   private static final String USERNAME = "root";
   private static final String PASSWORD = "";
   private static final String DATABASE_URL ="jdbc:mysql://localhost:3306/arquivo";
   
   public static Connection createConnectiontoMySQL() throws Exception {
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
	   
	   return connection;
   } 
   public static void main(String[] args) throws Exception {
	   Connection con = createConnectiontoMySQL();
	   if(con!=null) {
		   System.out.println("Conectado com sucesso");
		   con.close();
	   }
   }
}
