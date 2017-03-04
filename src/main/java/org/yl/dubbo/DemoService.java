package org.yl.dubbo;

/**
 * Created by yang on 2017/2/25.
 */
public interface DemoService {

    /**
     * sayHello方法
     * @param name
     * @return
     */
    public String sayHello(String name);

    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    public User findUserById(long id);

}
