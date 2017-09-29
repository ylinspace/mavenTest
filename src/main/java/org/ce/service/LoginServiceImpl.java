/**
 * 
 */
package org.ce.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ce.dao.LoginDao;
import org.ce.vo.User;

/**
 * @author yang
 *
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	public boolean validateUser(User user) throws Exception {
		if(user == null || user.getUsername() == null){
			return false;
		}
		String username = user.getUsername().trim();
		String password = user.getPassword().trim();
		
		User userTemp = loginDao.getUserByUsername(username);
		if(userTemp == null){
			return false;
		}
		
		String usernameTemp = userTemp.getUsername().trim();
		String passwordTemp = userTemp.getPassword().trim();
		
		if(username.equals(usernameTemp) && password.equals(passwordTemp)){
			return true;
		}
		
		return false;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public boolean register(User user) throws Exception {
		
		if(user==null || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())){
			return false;
		}
		
		return this.loginDao.insertUser(user);
		
	}

	@Transactional(rollbackFor=Exception.class)
	public boolean deleteUser(User user) throws Exception {
		if(user == null || user.getUsername() == null){
			return false;
		}
		
		return this.loginDao.deleteUser(user);
	}

	public List<User> queryUsers() throws Exception {
		return this.loginDao.queryUsers();
	}

	public boolean updateUser(String username,String newPassword) throws Exception {
		if(StringUtils.isBlank(username) || StringUtils.isBlank(newPassword)){
			return false;
		}
		
		return this.loginDao.updateUser(username, newPassword);
	}
}
