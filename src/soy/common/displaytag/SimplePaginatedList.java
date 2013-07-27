package soy.common.displaytag;

import java.util.List;

import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;

import soy.util.PropsParser;


public class SimplePaginatedList implements PaginatedList {
	private int fullListSize;
	private List list;
	private int objectsPerPage = PropsParser.getPageSize();
	private int pageNumber;
	private int startNumber;
	private String searchId;
	private String sortCriterion;
	private SortOrderEnum sortDirection;
	
	public SimplePaginatedList() {}
	
	public SimplePaginatedList(String page) {
		try {
			Integer integer = Integer.valueOf(page);
			setPageNumber(integer);
		} catch (NumberFormatException e) {
			setPageNumber(1);
		}
	}

	public int getFullListSize() {
		return fullListSize;
	}

	public void setFullListSize(int fullListSize) {
		this.fullListSize = fullListSize;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getObjectsPerPage() {
		return objectsPerPage;
	}

	public void setObjectsPerPage(int objectsPerPage) {
		this.objectsPerPage = objectsPerPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public String getSortCriterion() {
		return sortCriterion;
	}

	public void setSortCriterion(String sortCriterion) {
		this.sortCriterion = sortCriterion;
	}

	public SortOrderEnum getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(SortOrderEnum sortDirection) {
		this.sortDirection = sortDirection;
	}

	public int getStartNumber() {
		return (getPageNumber() - 1) * getObjectsPerPage();
	}

	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}
}
