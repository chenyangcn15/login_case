package cn.chen.test;

import cn.chen.dao.UserDao;
import cn.chen.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin()
    {
        User user = new User();
        user.setUsername("chen");
        user.setPassword("1125");

        UserDao dao = new UserDao();
        User ur = dao.login(user);

        System.out.println(ur);
    }
}
