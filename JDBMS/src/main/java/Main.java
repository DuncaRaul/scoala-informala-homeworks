import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try{
        try{
            Class.forName("org.postgresql.Driver").newInstance();
        }catch (InstantiationException|IllegalAccessException|ClassNotFoundException e){
            System.err.println("Can't load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        }

        Main m = new Main();
        Connection connection = getConnection("postgresql","localhost","5432","grp8","postgres","traian981994");
        ResultSet rs = null;
        Statement st = null;

        if (connection == null) return;
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM employee");

            if (rs.next()){
                do{
                    System.out.println("Employee Name " + rs.getString("first_name") +" " + rs.getString("last_name"));
                }while(rs.next());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch(){e.printStackTrace();};


    public static Connection getConnection(String type, String host, String port, String dbName, String user, String pw) {

        java.sql.Connection conn = null;
        DriverManager.setLoginTimeout(60); // wait 1 min; optional: DB may be busy, good to set a higher timeout
        try {
            String url = new StringBuilder()
                    .append("jdbc:")
                    .append(type) // “mysql” / “db2” / “mssql” / “oracle” / ...
                    .append("://")
                    .append(host)
                    .append(":")
                    .append(port)
                    .append("/")
                    .append(dbName)
                    .append("?user=")
                    .append(user)
                    .append("&password=")
                    .append(pw).toString();
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }
        return conn;
    }
}
