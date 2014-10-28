package org.lalosuarez.app;
import java.util.ArrayList;
import java.util.List;

import org.lalosuarez.util.paginator.Paginator;


public class PaginatorApp {

	public static void main(String[] args) {
		Paginator paginator = new Paginator();
		paginator.setNumberOfElementsToShow(6);
		
		List<Object> results = new ArrayList<Object>();
		
		for (int i = 1; i <= 10; i++) {
			results.add("Element" + i);
		}
		
		List<Object> items = paginator.paginate(results, 2);
		
		for (Object item : items) {
			System.out.println(item);
		}
	}

}
