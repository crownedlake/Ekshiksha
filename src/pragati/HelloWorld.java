package pragati;
import java.sql.*;

public class HelloWorld {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/server";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public static String data() {
   Connection conn = null;
   Statement stmt = null;
   String re="";
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      
      //STEP 3: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
      String sql = "SELECT DISTINCT categories FROM `base_table`";
	ResultSet rs = stmt.executeQuery(sql);
      //STEP 5: Extract data from result set
	
	if(rs.next())
	{
		String first = rs.getString("categories");
		re+= first;
	}
      while(rs.next()){
         String first = rs.getString("categories");
         re+=","+first;
      }
      
      rs.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   return re;
}//end data fn
}//end JDBCExample
