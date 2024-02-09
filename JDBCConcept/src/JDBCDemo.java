import java.sql.*;

class JDBCDemo{
    public static void main(String[] args) throws Exception {
        /*
        Steps to create JDBC connection
        1. import package
        2. login and register driver
        3. Create connection
        4. Create Statement
        5. Execute Statement
        6. Close connection
         */

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "1998";
        String sql = "select name from student where sid=1";

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection established successfully");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        String name = rs.getString("name");
        System.out.println("The student name is " + name);

//        st.execute("insert into student values (2, 'Aniket', 90)");
//        st.execute("insert into student values (3, 'Kiran', 98)");

        ResultSet rs1 = st.executeQuery("select * from student");
        while(rs1.next()){
            System.out.print(rs1.getInt(1) + "-");
            System.out.print(rs1.getString(2) + "-");
            System.out.print(rs1.getInt(3));
            System.out.println();
        }

        int sid = 101;
        String name1 = "Jasmine";
        int marks = 58;

        String query = "insert into student values(?, ?, ?)";

        PreparedStatement pt = con.prepareStatement(query);
        pt.setInt(1, sid);
        pt.setString(2, name1);
        pt.setInt(3, marks);

        pt.execute();

        con.close();
        System.out.println("Connection closed successfully !");


    }
}
