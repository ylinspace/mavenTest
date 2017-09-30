package org.cute.dubbo;

/**
 * Created by yang on 2017/2/25.
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello"+name;
    }

    @Override
    public User findUserById(long id) {
        User user = new User();
        user.setId(100L);
        user.setAge(23);
        user.setName("张三");
        return user;
    }
}
