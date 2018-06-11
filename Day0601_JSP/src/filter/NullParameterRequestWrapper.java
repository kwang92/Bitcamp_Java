package filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class NullParameterRequestWrapper extends HttpServletRequestWrapper {
	// ���� ��û�� Map���·� �Ķ���͸� ������ ����
	// �Ķ���͸� �޶�� �� �� Map���·� ���������
	private Map<String, String[]> parameterMap;

	// ���� ��û�� �ִ� �Ķ���͸� �����ؾ� �ϱ� ������ �޼ҵ���� �������̵� ������Ѵ�.
	public NullParameterRequestWrapper(HttpServletRequest request) {
		super(request);
		parameterMap = new HashMap<String, String[]>(request.getParameterMap());	// ���� request�� �ִ� parameterMap�� �������� ��������
		ArrayList a = new ArrayList();
		ArrayList b = new ArrayList(a);
	}



	// �츮�� ���� ��û��ü�� ���� ��û��ü�� �ϴ� ���� �ؾ���
	// �Ķ���͸� �����Ұű� ������ �Ķ���� ���� �޼ҵ带 �������̵� �ؾ���.

	//////////////// Parameter Method OverRiding /////////////////////

	@Override
	public String getParameter(String name) {
		// TODO Auto-generated method stub
		String[] values = this.getParameterValues(name);
		if(values != null && values.length >0 ) {
			return values[0];
		} 
		return null;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		return this.parameterMap;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		// TODO Auto-generated method stub
		return Collections.enumeration(this.parameterMap.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		// TODO Auto-generated method stub
		return this.parameterMap.get(name);
	}

	//////////////////////////////////////////////////////////////////////////

	//////////// �츮�� �������ϴ� ��� �޼ҵ� /////////////////////
	public void checkNull(String[] names) {
		// �츮�� ������ �Ķ���Ͱ� ������, �Ķ���͸� �߰����ش�.
		System.out.println("in");
		for(String pName : names) {
			
			if( !( this.parameterMap.containsKey(pName) ) ) {
				String[] values = new String[] {"����"};
				System.out.println(pName);
				System.out.println(values);
				this.parameterMap.put(pName, values);
			}
		}
	}
}
