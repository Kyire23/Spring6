import com.oumuanode.spring6.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpringJdbcTest {

    @Test
    public void testJdbcAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "insert into t_user(real_name,age) values(?,?)";
        //ֻҪ��insert delete update ���ǵ��� update ����
        int count = jdbcTemplate.update(sql, "����", 20);
        System.out.println(count);

        //��ѯһ������
        String sql2 = "select id, real_name,age from t_user where id=?";
        User user = jdbcTemplate.queryForObject(sql2, new BeanPropertyRowMapper<>(User.class), 2);
        System.out.println(user);

        //��ѯ���
        String sql3 = " select id, real_name,age form t_user";
        List<User> query = jdbcTemplate.query(sql3, new BeanPropertyRowMapper<>(User.class));
        System.out.println(query);

        //��һ��ֵ
        String sql4 = "select count(1) from t_user";
        Integer total = jdbcTemplate.queryForObject(sql3, int.class);
        System.out.println(total);

        //�������
        //׼������
        Object[] obj1 = {"С��1", 22};
        Object[] obj2 = {"С��2", 25};
        Object[] obj3 = {"С��3", 24};
        Object[] obj4 = {"С��4", 26};
        Object[] obj5 = {"С��5", 28};

        //��ӵ�List����
        List<Object[]> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);
        list.add(obj5);

        //ִ��sql
        int[] count2 = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count2));


        //�ص���������
        String sql5 = "select id, real_name, age from t_user where id = ?";
        jdbcTemplate.execute(sql5, new PreparedStatementCallback<User>() {

            @Override
            public User doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                User user = null;
                ps.setInt(1,2);
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    int id = rs.getInt("id");
                    String realName = rs.getString("real_name");
                    int age = rs.getInt("age");
                    user = new User(id,realName,age);
                }
                return user;
            }
        });
        System.out.println(user);
    }

    @Test
    public void testJdbc() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate);

    }
}
