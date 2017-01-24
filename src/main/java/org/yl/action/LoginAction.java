package org.yl.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.yl.cache.CacheProxy;
import org.yl.service.LoginService;
import org.yl.vo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author yang (⊙o⊙)…
 *
 */
@Controller
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private User user;
	
	private Map<String,Object> rootMap =  new HashMap<String,Object>();

	@Qualifier
	private LoginService loginService;

	@Qualifier("dataCache")
	private CacheProxy dataCache ;
	
	public String execute() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String rURL = request.getParameter("rURL");
		rootMap.put("rURL", rURL);
		
		if (user != null && user.getUsername() != null && user.getPassword() != null) {
			if (loginService.validateUser(user)) {
				try{
					dataCache.put("username", user.getUsername(),10);
					System.out.println("缓存为："+dataCache.get("username"));
				}catch(Exception e){
					e.printStackTrace();
				}
				
				rootMap.put("status", "0");
				return Action.NONE;
			}
		}
		rootMap.put("status", "-1");
		return Action.NONE;
	}

	public String register() throws Exception{
		
		if(user!= null&& user.getUsername() != null && user.getPassword() != null){
			if(loginService.register(user)){
				rootMap.put("status", "0");
				return Action.NONE;
			}
		}
		
		rootMap.put("status", "-1");
		return Action.NONE;
	}
	
	public String deleteUser() throws Exception{
		
		if(user!= null || user.getUsername() != null){
			if(loginService.deleteUser(user)){
				rootMap.put("status", "0");
				return Action.NONE;
			}
		}
		rootMap.put("status", "-1");
		return Action.NONE;
	}
	
	public String queryUsers() throws Exception{
		List<User> list = loginService.queryUsers();
		if(list !=null && list.size()>0 ){
			rootMap.put("status", "0");
			rootMap.put("list", list);
			return Action.NONE;
		}
		rootMap.put("status", "-1");
		return Action.NONE;
	}
	
	public String updateUser() throws Exception{
		if(StringUtils.isNotBlank(user.getUsername()) && StringUtils.isNotBlank(user.getPassword())){
			if(loginService.updateUser(user.getUsername(), user.getPassword())){
				rootMap.put("status", "0");
				return Action.NONE;
			}
		}
		
		rootMap.put("status", "-1");
		return Action.NONE;
	}
	
	/**
	 * 
	 * @param loginService
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the rootMap
	 */
	public Map<String, Object> getRootMap() {
		return rootMap;
	}

	/**
	 * @param rootMap the rootMap to set
	 */
	public void setRootMap(Map<String, Object> rootMap) {
		this.rootMap = rootMap;
	}

	/**
	 * @param dataCache the dataCache to set
	 */
	public void setDataCache(CacheProxy dataCache) {
		this.dataCache = dataCache;
	}
	
	

}
