/*******************************************************************************
 * Educational Online Test Delivery System
 * Copyright (c) 2013 American Institutes for Research
 * 
 * Distributed under the AIR Open Source License, Version 1.0
 * See accompanying file AIR-License-1_0.txt or at
 * https://bitbucket.org/sbacoss/eotds/wiki/AIR_Open_Source_License
 ******************************************************************************/
package com.sales.module.domain;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * The response that is returned when using the paged search UI
 * 
 * @param <D>
 */

public class SearchResponse<D> implements Serializable {

    private static final long serialVersionUID = -8479916141589554052L;
    final static String CURRENT_PAGE="currentPage";
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchResponse.class);

    private List<D> searchResults;
    private int currentPage;
    private int returnCount;
    private int pageSize=20;
    private long totalCount;
    private String sortKey;
    private String sortDirection;
    private String nextPageUrl;
    private String prevPageUrl;
    private String searchResource = "/search";
    
    @JsonIgnore
    private Map<String, String[]> originalSearchRequest;


    public SearchResponse() {
        // empty
    }
    @JsonIgnore
    public void build(){
	    this.nextPageUrl = buildNextPageUrl();
	    this.prevPageUrl = buildPrevPageUrl();
    }
    public SearchResponse(final List<D> inSearchResults, final Map<String, String[]> requestMap) {
        this.searchResults = inSearchResults;
        this.returnCount = searchResults.size();
        originalSearchRequest= requestMap;
//        this.sortKey = Joiner.on(", ").skipNulls().join(inOriginalSearchRequest.getSortKeys());
//        this.sortDirection = Joiner.on(", ").skipNulls().join(inOriginalSearchRequest.getSortDirections());
        this.nextPageUrl = buildNextPageUrl();
        this.prevPageUrl = buildPrevPageUrl();

    }

    public List<D> getSearchResults() {
        return searchResults;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getReturnCount() {
        return returnCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public String getSortKey() {
        return sortKey;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public String getPrevPageUrl() {
        return prevPageUrl;
    }

    public long getTotalCount() {
        return totalCount;
    }

    private String buildUrl() {
        StringBuilder sbuilder = new StringBuilder(this.searchResource).append('?');
        for (String key : originalSearchRequest.keySet()) {
        	if(!key.equals(CURRENT_PAGE)){	
	            for (String value : originalSearchRequest.get(key)) {
	                sbuilder.append(key).append('=').append(value).append('&');
	            }
        	}
        }
        sbuilder.append("pageSize").append('=').append(pageSize).append('&');
        // TODO: We could also append the sortKey and sortDir to this if we want.
        return sbuilder.toString();
    }

    private String buildNextPageUrl() {
        return (this.totalCount <= (this.pageSize * (this.currentPage +1))) ? null : buildUrl() + "currentPage=" + (currentPage + 1);
    }

    private String buildPrevPageUrl() {
        return (this.currentPage < 1) ? null : buildUrl() +  "currentPage =" + (currentPage - 1);
    }

	public String getSearchResource() {
		return searchResource;
	}

	public void setSearchResource(String searchResource) {
		this.searchResource = searchResource;
	}

	public void setSearchResults(List<D> searchResults) {
		this.searchResults = searchResults;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setReturnCount(int returnCount) {
		this.returnCount = returnCount;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}

	public void setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
	}

	public void setNextPageUrl(String nextPageUrl) {
		this.nextPageUrl = nextPageUrl;
	}

	public void setPrevPageUrl(String prevPageUrl) {
		this.prevPageUrl = prevPageUrl;
	}

//    @Override
//    public String toString() {
//        String returnString = "SearchResponse: ";
//        try {
//            returnString += new ObjectMapper().writeValueAsString(this);
//        } catch (IOException e) {
//            LOGGER.error("Could not turn this object into JSON", e);
//        }
//        return returnString;
//    }
}
