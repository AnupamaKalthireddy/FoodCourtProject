package foodcourt.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import foodcourt.dto.User;



public class Crud {
	public void createTable()throws Exception   {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodcourt?createDatabaseIfNotExist=true","root","root");
	Statement st=con.createStatement();
	st.execute("create table if not exists user(name varchar(45),gender varchar(45),age int,phno int,email varchar(45),pwd varchar(45),wallet double)");
	st.close();
	con.close();
	
	


}
	

	
public  void saveUser(User u) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodcourt?user=root&password=root");
	PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
	ps.setString(1,u.getName() );
	ps.setString(2,u.getGender());
	ps.setInt(3,u.getAge());
	ps.setLong(4,u.getPhno());
	ps.setString(5,u.getEmail());
	ps.setString(6,u.getPwd());
	ps.setDouble(7, u.getWallet());
	ps.execute();
	ps.close();
	con.close();
	System.out.println("Register Successfull.......");
}
public boolean fetch(User u) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodcourt?user=root&password=root");
		PreparedStatement ps=con.prepareStatement("select * from user where email=? And pwd=?");
		ps.setString(1, u.getEmail());
		ps.setString(2, u.getPwd());
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			if((u.getEmail().equals(rs.getString(5))&(u.getPwd().equals(rs.getString(6))))){
				System.out.println("login succssfull......");
				return true;
			}
		}
		ps.close();
		con.close();
		return false;
	}
public void fetchFood() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodcourt?user=root&password=root");
	PreparedStatement ps=con.prepareStatement("select * from food");
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		System.out.print("slno : "+rs.getInt(1)+"   ");
		System.out.print(" ---item name : "+rs.getString(2)+"       ");
		System.out.print(" ---price : "+rs.getDouble(3)+"   ");
		System.out.print(" ---quantity : "+rs.getInt(4)+"    ");
		System.out.println();
		
	}
	ps.close();
	con.close();
	
}
public double item(int n) throws Exception {
	double price=0;
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodcourt?user=root&password=root");
	PreparedStatement ps=con.prepareStatement("select * from food where slno=?");
	ps.setInt(1, n);
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		System.out.println("slno       --->"+rs.getInt(1));
		System.out.println("item name  --->"+rs.getString(2));
		System.out.println("price      --->"+rs.getDouble(3));
		System.out.println("quantity   --->"+rs.getInt(4));
		System.out.println(".....................................");
		price=rs.getDouble(3);
		
		
	}
	/*System.out.println(price);*/
	ps.close();
	con.close();
	return price;
}
public double userWallet( String email) throws Exception {
	double wallet=0;
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodcourt?user=root&password=root");
	PreparedStatement p=con.prepareStatement("select * from user where email=?");
	p.setString(1, email);
	ResultSet r=p.executeQuery();
	while(r.next()) {
		 wallet=r.getDouble("wallet");
		/*System.out.println(wallet);*/
		
	}
	p.close();
	con.close();
	return wallet;
	
}
public void walletUpdate(double wallet,String email) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodcourt?user=root&password=root");
	PreparedStatement ps=con.prepareStatement("update user set wallet=? where email=?");
	ps.setDouble(1, wallet);
	ps.setString(2, email);
	ps.execute();
}
}

