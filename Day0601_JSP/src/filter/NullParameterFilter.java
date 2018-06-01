package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class NullParameterFilter implements Filter{
	private String[] parameterNames;
	@Override
	public void destroy() {
		
	}

	@Override				// req, resp, chain : 다음 필터에 대한 기능
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("필터가 동작합니다");
		/*
		 * 요청을 받아서 처리할 일을 처리한 후
		 */
		// request요청이 가지고 있는 파라미터 확인 후 없으면 추가
		NullParameterRequestWrapper nprw = new NullParameterRequestWrapper((HttpServletRequest)req);
		nprw.checkNull(parameterNames);
		
		
		chain.doFilter(nprw, resp);	// 이 객체 안에서의 동작을 처리해주고 다음 단계로 요청을 전달해준다.
	}

	@Override	// 최초로 실행되는 메소드, web.xml에서 지정해놓은 초기 파라미터 이름들을 config변수로 가져온다.
	public void init(FilterConfig config) throws ServletException {
		String names = config.getInitParameter("parameterNames");	// config로 받아온 name들을 getInitParameter 메소드로 가져온다.
		parameterNames = names.split(",");
	}

}
