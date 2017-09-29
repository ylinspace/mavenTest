/**
 * 
 */
package org.yl.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.yl.dao.mybatis.UserMapper;
import org.yl.vo.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author yang
 *
 */
@Repository("loginDao")
public class LoginDaoImpl  implements LoginDao {

	@Autowired @Qualifier("sqlSession")
	private SqlSession sqlSession;
	
	public User getUserByUsername(String username) throws Exception {
		User user = sqlSession.selectOne("user.selectUserByUsername", username);

		return user;
	}

	/**
	 * @return the sqlSession
	 */
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	/**
	 * @param sqlSession the sqlSession to set
	 */
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public boolean insertUser(User user) throws Exception {
		int ret = sqlSession.insert("user.insertUser", user);
		System.out.println("dao返回结果："+ret);
		if(ret == 1){
			return true;
		}
		return false;
	}

	public boolean deleteUser(User user) throws Exception {
		if(user == null || user.getUsername() == null){
			return false;
		}
		int ret = sqlSession.delete("user.deleteUser", user.getUsername());
		if(ret == 1){
			return true;
		}
		
		return false;
	}

	public List<User> queryUsers() throws Exception {
		int maxSize = 10;
		List<User> list = sqlSession.selectList("user.selectUsers",maxSize);
		if(list != null && list.size()> 0){
			return list;
		}
		
		return null;
	}

	public boolean updateUser(String username, String newPassword) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		map.put("username", username);
		map.put("newPassword", newPassword);
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int ret = userMapper.updateUser(map);
		if(ret == 1){
			return true;
		}
		return false;
	}
	
	
}
