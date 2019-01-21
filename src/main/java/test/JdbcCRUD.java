package test;

import java.sql.*;

/**
 * jdbc的操作实例
 */
public class JdbcCRUD {

    public static void main(String[] args) {

        //insert();
        //update();
        //delete();
        //select();
        preparedStatement();

    }

    /**
     * 测试插入数据
     */
    private static void insert(){

        // 总结一下JDBC的最基本的使用过程
        // 1、加载驱动类：Class.forName()
        // 2、获取数据库连接：DriverManager.getConnection()
        // 3、创建SQL语句执行句柄：Connection.createStatement()
        // 4、执行SQL语句：Statement.executeUpdate()
        // 5、释放数据库连接资源：finally，Connection.close()

        // 定义数据库连接对象
        // 引用JDBC相关的所有接口或者是抽象类的时候，必须是引用java.sql包下的
        // java.sql包下的，才代表了java提供的JDBC接口，只是一套规范
        // 至于具体的实现，则由数据库驱动来提供，切记不要引用诸如com.mysql.jdbc包的类
        Connection conn = null;

        // 定义SQL语句执行句柄：Statement对象
        // Statement对象，其实就是底层会基于Connection数据库连接
        // 可以让我们方便的针对数据库中的表，执行增删改查的SQL语句
        // 比如insert、udpate、delete和select语句
        Statement stmt = null;

        try{
            // 第一步，加载数据库的驱动，我们都是面向java.sql包下的接口在编程，所以
            // 要想让JDBC代码能够真正操作数据库，那么就必须第一步先加载进来你要操作的数据库的驱动类
            // 使用Class.forName()方式来加载数据库的驱动类
            // Class.forName()是Java提供的一种基于反射的方式，直接根据类的全限定名（包+类）
            // 从类所在的磁盘文件（.class文件）中加载类对应的内容，并创建对应的Class对象
            Class.forName("com.mysql.jdbc.Driver");

            // 获取数据库的连接
            // 使用DriverManager.getConnection()方法获取针对数据库的连接
            // 需要给方法传入三个参数，包括url、user、password
            // 其中url就是有特定格式的数据库连接串，包括“主协议:子协议://主机名:端口号//数据库”
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test03","root","root");

            // 基于数据库连接Connection对象，创建SQL语句执行句柄，Statement对象
            // Statement对象，就是用来基于底层的Connection代表的数据库连接
            // 允许我们通过java程序，通过Statement对象，向MySQL数据库发送SQL语句
            // 从而实现通过发送的SQL语句来执行增删改查等逻辑
            stmt = conn.createStatement();

            // 然后就可以基于Statement对象，来执行insert SQL语句了
            // 插入一条数据
            // Statement.executeUpdate()方法，就可以用来执行insert、update、delete语句
            // 返回类型是个int值，也就是SQL语句影响的行数
            String sql = "insert into student_info(id,name,age) values(5,'李四',26)";
            int  rtn = stmt.executeUpdate(sql);
            System.out.println("SQL语句影响了【" + rtn + "】行。");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 最后一定要记得在finally代码块中，尽快在执行完SQL语句之后，就释放数据库连接
            try {
                if(stmt!=null){
                    stmt.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试更新数据
     */
    private static void update(){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test03",
                    "root",
                    "root");
            stmt = conn.createStatement();

            String sql = "update student_info set age=27 where name='李四'";

            int rtn = stmt.executeUpdate(sql);

            System.out.println("SQL语句影响了【" + rtn + "】行。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null) {
                    stmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * 测试删除数据
     */
    private static void delete(){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test03",
                    "root",
                    "root");
            stmt = conn.createStatement();

            String sql = "delete from student_info where name='李四'";

            int rtn = stmt.executeUpdate(sql);

            System.out.println("SQL语句影响了【" + rtn + "】行。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null) {
                    stmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * 测试查询数据
     */
    private static void select(){
        Connection conn = null;
        Statement stmt = null;
        // 对于select查询语句，需要定义ResultSet
        // ResultSet就代表了，你的select语句查询出来的数据
        // 需要通过ResutSet对象，来遍历你查询出来的每一行数据，然后对数据进行保存或者处理
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test03",
                    "root",
                    "root");
            stmt = conn.createStatement();
            String sql = "select * from student_info";

            rs = stmt.executeQuery(sql);
            // 获取到ResultSet以后，就需要对其进行遍历，然后获取查询出来的每一条数据
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                System.out.println("id=" + id + ", name=" + name + ", age=" + age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null) {
                    stmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void preparedStatement(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test03?characterEncoding=utf8",
                    "root",
                    "root");

            // 第一个，SQL语句中，值所在的地方，都用问好代表
            String sql = "insert into student_info(id,name,age) values(?,?,?)";

            pstmt = conn.prepareStatement(sql);

            // 第二个，必须调用PreparedStatement的setX()系列方法，对指定的占位符设置实际的值
            pstmt.setInt(1,5);
            pstmt.setString(2, "李四");
            pstmt.setInt(3, 26);

            // 第三个，执行SQL语句时，直接使用executeUpdate()即可，不用传入任何参数
            int rtn = pstmt.executeUpdate();

            System.out.println("SQL语句影响了【" + rtn + "】行。");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(pstmt != null) {
                    pstmt.close();
                    System.out.println(pstmt + "关闭了");
                }
                if(conn != null) {
                    conn.close();
                    System.out.println(conn + "关闭了");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
