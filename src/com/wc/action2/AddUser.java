package com.wc.action2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.bean.WcFile;
import com.wc.bean.WcUser;
import com.wc.dao.OfUserDAO;
import com.wc.dao.WcUserDAO;

@WebServlet(name = "AdminServlet", urlPatterns=("/addUser.do"))
public class AddUser extends HttpServlet {

	private WcUserDAO uDao = new WcUserDAO();
	private OfUserDAO ofDAO=new OfUserDAO();
	/**
	 * Constructor of the object.
	 */
	public AddUser() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the POST method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
		String moible = request.getParameter("mobile");
		String password = request.getParameter("password");
		String nickName = request.getParameter("nickname");
		if (uDao.findByUserName(mobile).size() != 0) {
			// 注册失败，用户名已存在
			
		}
		
//		if (uDao.findByUserName(nickName).size() != 0) {
//			// 注册失败，用户名已存在
//			res.add("status", -3);
//			res.add("msg", "注册失败，该昵称已注册");
//			return res.toString();
//		}
		
		
		WcFile file=fileDao.findById(userHead);
		
		WcUser user = new WcUser();
		user.setUserName(mobile);
		user.setUserPassword(uPass);
		user.setUserDescription(description);
		user.setUserNickname(nickName);
		if(file!=null)
		user.setUserHead(file);
		user.setApiKey(_blow.encryptString(mobile + uPass
				+ System.currentTimeMillis()));
		uDao.save(user);
				
		registerOpenFireUser(user);
		
		response.sendRedirect("listUser.jsp");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
