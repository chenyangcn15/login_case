package cn.chen.test;

import cn.chen.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {

    @Test
    public void test()
    {
        User user = new User();

        try {
//            BeanUtils.setProperty(user, "username", "zhao");
            BeanUtils.setProperty(user, "haha", "male");
//            BeanUtils.setProperty(user, "gender", "male");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}
