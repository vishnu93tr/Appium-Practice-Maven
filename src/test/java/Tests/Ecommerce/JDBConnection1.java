package Tests.Ecommerce;

import DataBase.JDBConnection;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class JDBConnection1
{
    @Test
    public void JdbcConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        JDBConnection jdbConnection=new JDBConnection();
        jdbConnection.JdbcConnection();
    }
}
