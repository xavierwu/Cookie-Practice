/**
 * Created on: Jul 15, 2015
 */
package xavierwu.CookiePractice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Remove a cookie
 * 
 * @author Zewei Wu
 */
@SuppressWarnings("serial")
public class CookieDemo02 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()
			+ "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request, response);
	}
}