package br.com.exactalabs.bicycleshop.entity;

import java.util.List;

public class Page<T> {
    private Integer pageNumber;
    private Integer totalPages;
    private List<T> results;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNumber=" + pageNumber +
                ", totalPages=" + totalPages +
                ", results=" + results +
                '}';
    }
}
