package cn.chen.dao;


import cn.chen.domain.User;
import cn.chen.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/*
To manipulate database login----user table

 */
public class UserDao {

    //declare JDBCTemplate object
    private JdbcTemplate tp = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * login method
     * @param loginUser only username and password
     * @return User which contains all information
     */
    public User login(User loginUser)
    {
        try{
            // 1. sql
            String sql = "select * from user where username = ? and password = ?";

            System.out.println(loginUser.getUsername() + loginUser.getPassword());
            //2. call query method in template
            User user = tp.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    loginUser.getUsername(),loginUser.getPassword());

            System.out.println(user);
            return user;
        }
        catch(DataAccessException e)
        {
            e.printStackTrace(); // putting log file in real case
            return null;
        }
    }
}
