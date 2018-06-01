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

	@Override				// req, resp, chain : ���� ���Ϳ� ���� ���
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("���Ͱ� �����մϴ�");
		/*
		 * ��û�� �޾Ƽ� ó���� ���� ó���� ��
		 */
		// request��û�� ������ �ִ� �Ķ���� Ȯ�� �� ������ �߰�
		NullParameterRequestWrapper nprw = new NullParameterRequestWrapper((HttpServletRequest)req);
		nprw.checkNull(parameterNames);
		
		
		chain.doFilter(nprw, resp);	// �� ��ü �ȿ����� ������ ó�����ְ� ���� �ܰ�� ��û�� �������ش�.
	}

	@Override	// ���ʷ� ����Ǵ� �޼ҵ�, web.xml���� �����س��� �ʱ� �Ķ���� �̸����� config������ �����´�.
	public void init(FilterConfig config) throws ServletException {
		String names = config.getInitParameter("parameterNames");	// config�� �޾ƿ� name���� getInitParameter �޼ҵ�� �����´�.
		parameterNames = names.split(",");
	}

}
