import java.sql.*;

public class DemoJDBC {
        public static void main(String[] args) throws Exception {
                // import package
                // load and register
                // create connection
                // create statement
                // execute statement
                // process the result
                // close
                // exception handling

                // JDBC code goes here...
                // Replace the placeholders with your actual database credentials
                // Class.forName("com.mysql.cj.jdbc.Driver"); // Replace with your JDBC driver
                // class name
                String url = "jdbc:postgresql://localhost:5432/demo";
                String username = "postgres";
                String password = "";
                String query = "SELECT sname FROM students WHERE sid = 1";
                Connection con = DriverManager.getConnection(url, username, password);
                System.out.println("Database connected ....");
                // statement is database query to get some data
                Statement st = con.createStatement();
                // ResultSet is return type of executeQuery
                ResultSet result = st.executeQuery(query);
                // result.next(); will return boolean that we have some data or not after
                // fetching
                result.next();
                // result.next() is very important as it will go to first data/record
                // System.out.println(result.next());
                // getString("sname"); we want data of sname column
                // as we may get multiple colums so name or 1,2,3,4 index need to be specified
                String name = result.getString("sname");
                System.out.println(name);

                // boolean insertedData = st.execute("INSERT into students values (3, 'rina',
                // 80)");
                // System.out.println(insertedData);
                // boolean alterData = st.execute("update students set sname='bina' where
                // sid=2");
                // boolean alterData = st.execute("delete from students where sid=2");

                // PreparedStatements
                int sid = 101;
                String sname = "mira";
                int smarks = 90;
                PreparedStatement ps = con.prepareStatement("insert into students values (?,?,?)");
                ps.setInt(1, sid);
                ps.setString(2, sname);
                ps.setInt(3, smarks);
                ps.execute();

                ResultSet results = st.executeQuery("SELECT * FROM students");
                // we are printing the records until there is next row or put pointer to next
                // row and check if there is next row of data or not
                while (results.next()) {
                        System.out.print(results.getInt(1) + " : ");
                        System.out.print(results.getString(2) + " : ");
                        System.out.print(results.getInt(3));
                        System.out.println();
                }
                // String names = results.getString("sname");
                // System.out.println(names);
                // closing the connection
                con.close();
                System.out.println("connection close..");
        }

}
