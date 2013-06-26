package org.bofa.service;

import javax.servlet.http.HttpServletRequest;

import org.bofa.model.UrlSearchResult;

public class SearchService {
	

public UrlSearchResult getSearchResults(HttpServletRequest request) {
		
		UrlSearchResult result = null;
	
		String pacexecutable = request.getParameter("pacexecutable");
		String pacfile = request.getParameter("pacfile");
		String pacurl = request.getParameter("pacurl");
		
		System.out.println(pacexecutable + " " +pacfile+ " " +pacurl);
		return result;
		
	}
	
}
