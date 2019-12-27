package DataBase;

import java.sql.*;

public class JDBConnection
{
    public void JdbcConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException
    {
       Connection con= DriverManager.getConnection(Constants.url,Constants.user_name,Constants.password);
       Statement stmt=con.createStatement();
       ResultSet resultSet=stmt.executeQuery("select * from accountdetails where scenario='zero balance'");
       while(resultSet.next())
       {
           System.out.println(resultSet.getString("username"));
           System.out.println(resultSet.getString("password"));
       }
    }

}
