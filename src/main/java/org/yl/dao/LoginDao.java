/**
 * 
 */
package org.yl.dao;

import java.util.List;

import org.yl.vo.User;

/**
 * @author yang
 *
 */
public interface LoginDao {

	public User getUserByUsername(String username) throws Exception;

	/**
	 * 插入用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean insertUser(User user) throws Exception;
	
	/**
	 * 删除用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean deleteUser(User user) throws Exception;
	
	/**
	 * 查询所有用户
	 * @return
	 * @throws Exception
	 */
	public List<User> queryUsers() throws Exception;
	
	/**
	 * 更新用户
	 * @param username
	 * @param newPasword
	 * @return
	 * @throws Exception
	 */
	public boolean updateUser(String username,String newPassword) throws Exception;
}
