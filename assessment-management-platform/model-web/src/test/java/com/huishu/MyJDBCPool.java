package com.huishu;

public class MyJDBCPool {
	/* public static Connection getConnection() throws ClassNotFoundException, SQLException{
	        String driver = "org.apache.hive.jdbc.HiveDriver";
	        String url = "jdbc:hive2://node23:21050/;auth=noSasl";
	        String username = "";
	        String password = "";
	        Connection conn = null;
	        Class.forName(driver);
	        conn = (Connection) DriverManager.getConnection(url,username,password);
	        return conn;
	    }
	    public void select() throws ClassNotFoundException, SQLException{
	        Connection conn = getConnection();
	        String sql = "select * from t_stu;";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("=====================================");
	        while (rs.next()){
	            for(int i=1;i<=col;i++){
	                System.out.print(rs.getString(i)+"\t");
	            }
	            System.out.print("\n");
	        }
	        System.out.println("=====================================");
	    }*/
}
