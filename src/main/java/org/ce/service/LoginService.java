/**
 * 
 */
package org.ce.service;

import java.util.List;

import org.ce.vo.User;

/**
 * @author yang
 *
 */
public interface LoginService {

	/**
	 * 验证用户信息
	 * @param user
	 * @return
	 */
	public boolean validateUser(User user) throws Exception;
	
	/**
	 * 注册用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean register(User user) throws Exception;
	
	/**
	 * 删除用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean deleteUser(User user) throws Exception;
	
	/**
	 * 查询出所有用户
	 * @return
	 * @throws Exception
	 */
	public List<User> queryUsers() throws Exception;
	
	/**
	 * 更新用户
	 * @return
	 * @throws Exception
	 */
	public boolean updateUser(String username,String newPassword) throws Exception;
	
	
}
