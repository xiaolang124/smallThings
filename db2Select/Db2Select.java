package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Db2Select {

	private static Connection con=null;
	private static PreparedStatement sql=null;
	private static ResultSet rs=null;
	
	public static void main(String[] args) throws SQLException, UnsupportedEncodingException, FileNotFoundException {
		
		FileInputStream test=new FileInputStream("D:/test/qr_to_orderId.txt");
		
		InputStreamReader is=new InputStreamReader(test,"UTF-8");
		BufferedReader br=new BufferedReader(is);
		String str_sql=null;
		String str=null;
		String[] str_condi=new String[2];
		
		try{
			con=dbConn("qr_datad","qr_datad");
			
			System.out.println("----------begin----------");
			
			if(con==null){
				System.out.println("error");
			}
			
			while((str=br.readLine())!=null){
				
				str_condi=str.split("\t");
				
				
				
				str_sql="select mchnt_order_id  as id from QRDATDB.TBL_QRONL_TRANS_FLOW0601_0607 where qr_no = \'"+str_condi[1]+"\' and sys_tra_no = \'"+str_condi[0]+"\'";
				sql=con.prepareStatement(str_sql);
				rs=sql.executeQuery();
				
				while(rs.next()){
					System.out.println(rs.getString("id"));
				}
			}
			
			System.out.println("----------end----------");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		
	}

	
	public static Connection dbConn(String name, String pass) {

	      Connection c = null;

	      try {
	        Class.forName("com.ibm.db2.jcc.DB2Driver");
	      } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	      }

	      try {
	        c = DriverManager.getConnection("jdbc:db2://172.18.43.135:60001/QRDATDB",
	              name, pass);
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	      return c;
	   }
}
