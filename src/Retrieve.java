import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class Retrieve {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/server";
	   static final String path = "C:\\Users\\Pragati\\workspace\\FirstServlet\\WebContent\\object.js";
	    
	    public static void writeToFile(String object[][]) throws IOException{
	        int i=0;
	        String declaration = "object = new Array(10);\nobjects=[];\nfunction declarations(){\n";
	    	while(object[i][0]!=null){
		        declaration += "object["+i+"]="+object[i][0]+"_creator("+object[i][1]+");\nobject["+i+"].position.set(Math.random()*20-10,Math.random()*20-10,0);\nobjects.push(object["+i+"]);\n";
	        	i++;
	    	}
	    	declaration += "\n}";
	    	System.out.println(declaration);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				    new FileOutputStream("C:\\Users\\Pragati\\workspace\\FirstServlet\\WebContent\\object.js"), "UTF-8"));
				try {
				    out.write(declaration);
				} finally {
				    out.close();
				}
	    	/*BufferedWriter bw = null;
		        FileWriter fw = null;
	
			try {
		            File file = new File(path);
		            // if file doesnt exists, then create it
			    if (!file.exists()) {
		                file.createNewFile();
		            }
			    
		            fw = new FileWriter(file.getAbsoluteFile(), true);
		            bw = new BufferedWriter(fw);
		            bw.write("\n"+declaration);
			}
		        catch (IOException e) {
				e.printStackTrace();
			} 
		        finally {
		            try {
		        	if (bw != null)
		                    bw.close();
		        	if (fw != null)
		                    fw.close();
		            } 
		            catch (IOException ex) {
				ex.printStackTrace();
		            }
			}	*/      

	    }
	    
	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   public void retrieve() throws IOException {
	   Connection conn = null;
	   Statement stmt = null;
	   String re[][]=new String[100][2];
	   System.out.print("Hi");
	   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver").newInstance();;
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      stmt = conn.createStatement();
		      String sql = "SELECT * FROM `bom`";
	    		ResultSet rs = stmt.executeQuery(sql);
	    		int i=0;
	    	  if(rs.next())
	    		{
	    			String first = rs.getString("Object");
	    			re[i][0]= first;
	    			re[i++][1]= rs.getString("Attr-value");
	    		}
	    	      while(rs.next()){
	    	         String first = rs.getString("Object");
	    	         re[i][0]= first;
		    		 re[i++][1]= rs.getString("Attr-value");
	    	      }
	    	      rs.close();
	   }
	   catch(SQLException se){
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
	   
	  writeToFile(re);
}
	   
	   
	   public String objectList() {
		   Connection conn = null;
		   Statement stmt = null;
		   String re="";
		   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver").newInstance();;
			      
			      //STEP 3: Open a connection
			      conn = DriverManager.getConnection(DB_URL, USER, PASS);
			      stmt = conn.createStatement();
			      String sql = "SELECT * FROM `bom`";
		    		ResultSet rs = stmt.executeQuery(sql);
		    		int i=0;
		    		if(rs.next()){
		    	         String first = rs.getString("Object");
		    	         re+= first;
		    	      }
		    	      while(rs.next()){
		    	         String first = rs.getString("Object");
		    	         re+=","+ first;
		    	      }
		    	      rs.close();
		   }
		   catch(SQLException se){
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
	}
	   public String data(String category,String object) {
		   Connection conn = null;
		   Statement stmt = null;
		   String re="";
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver").newInstance();;
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      stmt = conn.createStatement();
		      
		      if(category.equals("")&&object.equals(""))
		      {
		    	  String sql = "SELECT DISTINCT Category FROM `category-object`";
		    		ResultSet rs = stmt.executeQuery(sql);
		    	  if(rs.next())
		    		{
		    			String first = rs.getString("Category");
		    			re+= first;
		    		}
		    	      while(rs.next()){
		    	         String first = rs.getString("Category");
		    	         re+=","+first;
		    	      }
		    	      rs.close();
		      }
		      else if(object.equals(""))
		      {
		    	  String sql = "SELECT Object FROM `category-object`  WHERE Category='"+category+"'";
		  		ResultSet rs = stmt.executeQuery(sql);
		  	  if(rs.next())
		  		{
		  			String first = rs.getString("object");
		  			re+= first;
		  		}
		  	      while(rs.next()){
		  	         String first = rs.getString("object");
		  	         re+=","+first;
		  	      }
		  	      
		  	      rs.close();
		      }
		      else if(category.equals(""))
		      {
		    	  String sql = "SELECT atrr FROM `object-list` WHERE object='" +object+"'";
		    		  		ResultSet rs = stmt.executeQuery(sql);
		    		  	  if(rs.next())
		    		  		{
		    		  			String first = rs.getString("atrr");
		    		  			re+= first;
		    		  		}
		    		  	      while(rs.next()){
		    		  	         String first = rs.getString("atrr");
		    		  	         re+=","+first;
		    		  	      }
		    		  	      
		    		  	      rs.close();
		      }
		      
		      //STEP 5: Extract data from result set
			
			
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
		   return (re);
		}//end data fn
	   
	   public void upload(int id,String object,String val) {
		   Connection conn = null;
		   Statement stmt = null;
		   int rse=0;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver").newInstance();;
		      
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      stmt = conn.createStatement();
		      
		      String v[]=val.split("&");
		      String key="";
		      String vl[];
		 	 vl=v[0].split("=");
		 	 key+=vl[1];
		     for(int i=1;i<v.length;i++)
		     {
		    	 vl=v[i].split("=");
		     	 key+=","+vl[1];
		     }
		     String sql = "INSERT INTO `BOM`( `variable_id`, `Object`, `Attr-value`) VALUES ('"+id+"','"+object+"','"+key+"')";
			 rse = stmt.executeUpdate(sql);
		      //STEP 5: Extract data from result set
		 
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
		}//end data fn
	  
}
