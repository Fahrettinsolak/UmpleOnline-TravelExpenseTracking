package com.solak.TravelExpense.main.lib.models;


import java.sql.Date;
import java.util.UUID;

import com.solak.TravelExpense.umple.Report;
import com.solak.TravelExpense.umple.ReportManager;

public class ReportWrapper {
    
    private Report report;
    
	public ReportWrapper() {
	}

    public ReportWrapper(Report report) {
        this.report = report;
    }

    // Constructor to create a ReportWrapper with new Report instance
    public ReportWrapper(UUID reportId, String content, Date creationDate, ReportManager reportManager) {
        this.report = new Report(reportId, content, creationDate, reportManager);
    }

    // Getters and Setters for the wrapped Report
    public UUID getReportId() {
        return report.getReportId();
    }

    public void setReportId(UUID reportId) {
        report.setReportId(reportId);
    }

    public String getContent() {
        return report.getContent();
    }

    public void setContent(String content) {
        report.setContent(content);
    }

    public Date getCreationDate() {
        return report.getCreationDate();
    }

    public void setCreationDate(Date creationDate) {
        report.setCreationDate(creationDate);
    }

    public ReportManager getReportManager() {
        return report.getReportManager();
    }

    public void setReportManager(ReportManager reportManager) {
        report.setReportManager(reportManager);
    }

    // Method to update content with additional logic if necessary
    public void updateContent(String content) {
        // Add any additional logic or validation here
        report.setContent(content);
    }

    // Method to update creation date with additional logic if necessary
    public void updateCreationDate(Date creationDate) {
        // Add any additional logic or validation here
        report.setCreationDate(creationDate);
    }

    // Method to delete the report
    public void delete() {
        report.delete();
    }

    @Override
    public String toString() {
        return report.toString();
    }
}
