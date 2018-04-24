package studentManagement;

import java.io.Serializable;

public class MyList<E> implements Serializable{	// 임의의 데이터타입을 넣을 수 있도록 작성 ( 제네릭 )

	private static final long serialVersionUID = 1L;


	// add(E), remove(index), get(index), size(), set(int, E)
	private E[] array;
	public MyList() {
		array = (E[])new Object[0];
	}
	
	public void add(int index, E data) {
		// index 위치에 data 삽입
		E[] tmp = (E[])new Object[array.length+1];
		int pos = 0;
		
		for(int i = 0; i < size(); i++) {
			if(index == i) {
				pos++;
			}
			tmp[i+pos] = this.array[i];
		}
		tmp[index] = data;
		array = tmp;
	}
	public void add(E data) {
		E[] tmp = (E[])new Object[array.length+1];
		
		for(int i = 0; i < size(); i++) {
			tmp[i] = this.array[i];
		}
		tmp[array.length] = data;
		array = (E[])new Object[array.length+1];
		array = tmp;
	}
	public void remove(int index) {
		// index 삭제하고 뒤 배열 내용 앞으로 한칸씩
		if(index < 0 || index > array.length) {
			System.out.println("해당 데이터가 없습니다.");
			return;
		}
		E[] tmp = (E[])new Object[array.length-1];
		int pos = 0;
		
		for(int i = 0; i < array.length-1; i++) {
			if(i == index)
				pos++;
			tmp[i] = array[i + pos];
		}
		array = tmp;
	}
	public E get(int index) {
		return this.array[index];
	}
	public int size() {
		return array.length;
	}
}