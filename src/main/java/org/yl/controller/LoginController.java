package org.yl.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yang on 2017/2/3.
 */
public class LoginController implements Controller{

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.printf("LoginController execute!!!!!");
        return new ModelAndView("/login/welcome.jsp");
    }

}
