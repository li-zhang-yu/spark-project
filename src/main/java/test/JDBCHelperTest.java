package test;

import jdbc.JDBCHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JDBC辅助组件测试类
 */
public class JDBCHelperTest {

    public static void main(String[] args) {
        //获取JDBCHelper的单例
        JDBCHelper jdbcHelper = JDBCHelper.getInstance();

        //测试普通的增删改语句
        //jdbcHelper.executeUpdate("insert into student_info values (?,?,?)",new Object[]{6,"王五",27});

        //测试查询语句
//        final Map<String,Object> testStudentInfo = new HashMap<String, Object>();
//
//        /**
//         * 设计一个内部接口QueryCallback
//         * 那么在执行查询语句的时候，我们就可以封装和指定自己的查询结果的处理逻辑
//         * 封装在一个内部接口的匿名内部类对象中，传入JDBCHelper的方法
//         * 在方法内部，可以回调我们定义的逻辑，处理查询结果
//         * 并将查询结果，放入外部的变量中
//         */
//        jdbcHelper.executeQuery("select * from student_info where id = ?", new Object[]{5}, new JDBCHelper.QueryCallback() {
//            @Override
//            public void process(ResultSet rs) throws Exception {
//                if(rs.next()){
//                    int id = rs.getInt(1);
//                    String name = rs.getString(2);
//                    int age = rs.getInt(3);
//
//                    /**
//                     * 匿名内部类的使用，有一个很重要的知识点
//                     * 如果要访问外部类中的一些成员，比如方法内的局部变量
//                     * 那么，必须将局部变量，声明为final类型，才可以访问
//                     * 否则是访问不了的
//                     */
//                    testStudentInfo.put("id",id);
//                    testStudentInfo.put("name",name);
//                    testStudentInfo.put("age",age);
//                }
//            }
//        });
//
//        System.out.println(testStudentInfo.get("id") + ":" + testStudentInfo.get("name") + ":" + testStudentInfo.get("age"));

        //测试批量执行SQL语句
        String sql = "insert into student_info values(?,?,?)";

        List<Object[]> paramsList = new ArrayList<Object[]>();
        paramsList.add(new Object[]{7, "赵六", 26});
        paramsList.add(new Object[]{8, "王八", 29});
        jdbcHelper.executeBatch(sql, paramsList);
    }

}
