package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(  ((HttpServletRequest)req).getSession().getAttribute("id") != null) {
			chain.doFilter(req, resp);
		}else {
			((HttpServletResponse)resp).sendRedirect("loginForm");
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}
