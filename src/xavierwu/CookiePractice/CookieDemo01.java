/**
 * Created on: Jul 15, 2015
 */
package xavierwu.CookiePractice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A Cookie-demo£ºget the last time user logged in
 * 
 * @author Zewei Wu
 */
@SuppressWarnings("serial")
public class CookieDemo01 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();

		// get cookies
		Cookie[] cookies = request.getCookies();
		if (cookies == null)
			printWriter.write("It's your first time to this website!\n");
		else {
			printWriter.write("Last time you visit: ");
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals("lastAccessTime")) {
					Long lastAccessTime = Long.parseLong(cookie.getValue());
					Date date = new Date(lastAccessTime);
					printWriter.write(date.toString() + "\n");
				}
			}
		}

		// send cookies
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()
			+ "");
		//// For Chinese: 
		// Cookie cookie = new Cookie("userName", URLEncoder.encode("¹Â°Á²ÔÀÇ", "UTF-8"));
		// URLDecoder.decode(cookies[i].getValue(), "UTF-8")
		cookie.setMaxAge(24 * 60 * 60);// one day
		response.addCookie(cookie);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request, response);
	}
}
