package rikesh.puri.fibonacci;

import java.util.ArrayList;
import java.util.List;

public class FiboDAO {
	
	static List<Integer> fibo = new ArrayList<Integer>();
	
	
	public int getFibo(int index) {
		try {
			return FiboDAO.fibo.get(index);
		} catch (IndexOutOfBoundsException e) {
			return -1;
		}
	}

	public void setFibo(int index, int value) {
		FiboDAO.fibo.add(index, value);
	}

}
