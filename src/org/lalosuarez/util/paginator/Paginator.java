package org.lalosuarez.util.paginator;

import java.util.ArrayList;
import java.util.List;


public class Paginator {

	private int numberOfElementsToShow = 5;
	
	public int getPaginationItems(int resultSize) {
		double items = (double)resultSize/(double)numberOfElementsToShow;
		items = Math.ceil(items);
		return (int) items;
	}
	
	public List<Integer> createPaginationItems(int resultSize) {
		int numberOfItems = getPaginationItems(resultSize);
		
		List<Integer> items = new ArrayList<Integer>(numberOfItems);
		
		for (int i = 1; i <= numberOfItems; i++) {
			items.add(i);
		}
		
		return items;
	}

	public int calculateStartValue(int page) {
		int value = 0;
		
		if (page > 1) {
			value = (page * numberOfElementsToShow) - numberOfElementsToShow;
		}
		
		return value;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List paginate(List results, int page) {
		
		List itemsPaginated = new ArrayList<Object>();
		
		int index = calculateStartValue(page);
		int resultsSize = results.size();
		int paginationItems = getPaginationItems(resultsSize);
		
		if (page <= paginationItems) {

			for (int i = 0; i < numberOfElementsToShow; i++) {
				itemsPaginated.add(results.get(index));
				i = index >= (resultsSize-1) ? 100 : i;
				index++;
			}		
		}

		return itemsPaginated;
	}
	
	public int getNumberOfElementsToShow() {
		return numberOfElementsToShow;
	}

	public void setNumberOfElementsToShow(int numberOfElementsToShow) {
		this.numberOfElementsToShow = numberOfElementsToShow;
	}
	
}
