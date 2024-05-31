package com.solak.TravelExpense.main.lib.wrappers;



import java.util.List;
import java.util.UUID;

import com.solak.TravelExpense.umple.Report;
import com.solak.TravelExpense.umple.ReportManager;

import java.sql.Date;

public class ReportManagerWrapper {
    private ReportManager reportManager;

    public ReportManagerWrapper(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    public Report generateReport(String username) {
        return reportManager.generateReport(username);
    }

    public Report viewReport(UUID reportId) {
        return reportManager.viewReport(reportId);
    }

    public void deleteReport(UUID reportId) {
        reportManager.deleteReport(reportId);
    }

    public Report getReport(int index) {
        return reportManager.getReport(index);
    }

    public List<Report> getReports() {
        return reportManager.getReports();
    }

    public int numberOfReports() {
        return reportManager.numberOfReports();
    }

    public boolean hasReports() {
        return reportManager.hasReports();
    }

    public int indexOfReport(Report aReport) {
        return reportManager.indexOfReport(aReport);
    }

    public Report addReport(UUID aReportId, String aContent, Date aCreationDate) {
        return reportManager.addReport(aReportId, aContent, aCreationDate);
    }

    public boolean addReport(Report aReport) {
        return reportManager.addReport(aReport);
    }

    public boolean removeReport(Report aReport) {
        return reportManager.removeReport(aReport);
    }

    public boolean addReportAt(Report aReport, int index) {
        return reportManager.addReportAt(aReport, index);
    }

    public boolean addOrMoveReportAt(Report aReport, int index) {
        return reportManager.addOrMoveReportAt(aReport, index);
    }

    public void delete() {
        reportManager.delete();
    }
}
