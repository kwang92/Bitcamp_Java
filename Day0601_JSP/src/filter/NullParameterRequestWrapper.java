package filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class NullParameterRequestWrapper extends HttpServletRequestWrapper {
	// 원래 요청이 Map형태로 파라미터를 가지고 있음
	// 파라미터를 달라고 할 때 Map형태로 전해줘야함
	private Map<String, String[]> parameterMap;

	// 기존 요청에 있는 파라미터를 조작해야 하기 때문에 메소드들을 오버라이딩 해줘야한다.
	public NullParameterRequestWrapper(HttpServletRequest request) {
		super(request);
		parameterMap = new HashMap<String, String[]>(request.getParameterMap());	// 기존 request에 있던 parameterMap을 기준으로 만들어야함
		ArrayList a = new ArrayList();
		ArrayList b = new ArrayList(a);
	}



	// 우리가 만든 요청객체가 원래 요청객체가 하는 일을 해야함
	// 파라미터를 조작할거기 때문에 파라미터 관련 메소드를 오버라이딩 해야함.

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

	//////////// 우리가 만들어야하는 기능 메소드 /////////////////////
	public void checkNull(String[] names) {
		// 우리가 지정한 파라미터가 없으면, 파라미터를 추가해준다.
		System.out.println("in");
		for(String pName : names) {
			
			if( !( this.parameterMap.containsKey(pName) ) ) {
				String[] values = new String[] {"없음"};
				System.out.println(pName);
				System.out.println(values);
				this.parameterMap.put(pName, values);
			}
		}
	}
}
