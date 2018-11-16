package esd.scos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LoginValidator extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		JSONArray jsonarray =new JSONArray();
		JSONObject jsonObject = new JSONObject();
		String loginOrRegister;
		String username;
		String mypassword;
		String sPass= " ";
		int isRegister = 0;
		Cookie[] cookies = req.getCookies();	
		try {
			username = req.getParameter("username");
			mypassword = req.getParameter("mypassword");
			loginOrRegister = req.getParameter("loginOrRegister");
			if(cookies==null) {
				System.out.println("null");
			}
			if(cookies!=null) {
				for(Cookie c:cookies) {
					if(c.getName().equals(username)) {
						isRegister=1;
						//se.setAttribute("isRegister", isRegister);
						sPass = URLDecoder.decode(c.getValue(), "utf-8");
						System.out.println(c.getName()+","+URLDecoder.decode(c.getValue(), "utf-8"));
					}
					System.out.println(c.getName()+","+URLDecoder.decode(c.getValue(), "utf-8"));
				}
			}
			System.out.println(isRegister);
			switch(loginOrRegister) {
			case "login":
				jsonarray = new JSONArray();
				jsonObject = new JSONObject();
				if(isRegister==0) {
					jsonObject.put("RESULTCODE", 0);
					jsonObject.put("MESSAGE", "用户名无效！");
				}else if(sPass.equals(mypassword)) {
					jsonObject.put("RESULTCODE", 1);
					jsonObject.put("MESSAGE", "登录成功！");
				}else {
					jsonObject.put("RESULTCODE", 0);
					jsonObject.put("MESSAGE", "登录失败！");
				}
				break;
			case "register":
				jsonarray = new JSONArray();
				jsonObject = new JSONObject();
				if(isRegister!=1) {
					jsonObject.put("RESULTCODE", 1);
					jsonObject.put("MESSAGE", "注册成功！");
					Cookie cookie = new Cookie(username, URLEncoder.encode(mypassword,"utf-8"));
					resp.addCookie(cookie);
				}else {
					jsonObject.put("RESULTCODE", 0);
					jsonObject.put("MESSAGE", "账户已注册！");
				}
				break;
			}
			out = resp.getWriter();
			out.println(jsonObject);	
		}catch(Exception e) {
			out.println("get data error");
			e.printStackTrace();
		}
	}

	

}
