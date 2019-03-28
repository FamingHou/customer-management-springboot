package com.example.customermanagement.service;

public class SortCriteria {

    private String sortColumn;
    private String sortDirection; // asc, desc
    
    public SortCriteria(String sortColumn, String sortDirection) {
        super();
        this.sortColumn = sortColumn;
        this.sortDirection = sortDirection;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

}
