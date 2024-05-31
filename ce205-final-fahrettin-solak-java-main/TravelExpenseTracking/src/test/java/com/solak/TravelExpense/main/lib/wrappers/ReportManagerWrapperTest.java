package com.solak.TravelExpense.main.lib.wrappers;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.UUID;

import org.junit.Test;

import com.solak.TravelExpense.umple.Report;
import com.solak.TravelExpense.umple.ReportManager;

public class ReportManagerWrapperTest {

	@Test
    public void testConstructor() {
        ReportManager reportManager = new ReportManager();
        ReportManagerWrapper reportManagerWrapper = new ReportManagerWrapper(reportManager);
        assertNotNull(reportManagerWrapper);
        assertNotEquals(reportManager, reportManagerWrapper.getReports());
    }
	
	@Test
    public void testGenerateReport() {
        ReportManager reportManager = new ReportManager();
        ReportManagerWrapper reportManagerWrapper = new ReportManagerWrapper(reportManager);
        String username = "testUser";
        Report report = reportManagerWrapper.generateReport(username);
        assertNull(report);

    }
	
	@Test
    public void testViewReport() {
        ReportManager reportManager = new ReportManager();
        ReportManagerWrapper reportManagerWrapper = new ReportManagerWrapper(reportManager);
        UUID reportId = UUID.randomUUID();
        Report report = reportManagerWrapper.viewReport(reportId);
        assertNull(report); 
    }

    @Test
    public void testDeleteReport() {
        ReportManager reportManager = new ReportManager();
        ReportManagerWrapper reportManagerWrapper = new ReportManagerWrapper(reportManager);
        UUID reportId = UUID.randomUUID();
        reportManagerWrapper.deleteReport(reportId);
    }
    
    @Test
    public void testNumberOfReports() {
        ReportManager reportManager = new ReportManager();
        ReportManagerWrapper reportManagerWrapper = new ReportManagerWrapper(reportManager);
        int numberOfReports = reportManagerWrapper.numberOfReports();
        assertEquals(0, numberOfReports); 
    }

    @Test
    public void testHasReports() {
        ReportManager reportManager = new ReportManager();
        ReportManagerWrapper reportManagerWrapper = new ReportManagerWrapper(reportManager);
        boolean hasReports = reportManagerWrapper.hasReports();
        assertFalse(hasReports); 
    }
    
    @Test
    public void testIndexOfReport() {
        ReportManager reportManager = new ReportManager();
        ReportManagerWrapper reportManagerWrapper = new ReportManagerWrapper(reportManager);
        Report report = new Report(UUID.randomUUID(), "Test Content", new Date(System.currentTimeMillis()), reportManager);
        
        int indexOfReport = reportManagerWrapper.indexOfReport(report);
        assertNotEquals(-1, indexOfReport); 
    }

    @Test
    public void testAddReportWithParameters() {
        ReportManager reportManager = new ReportManager();
        ReportManagerWrapper reportManagerWrapper = new ReportManagerWrapper(reportManager);
        UUID reportId = UUID.randomUUID();
        String content = "Test Content";
        Date creationDate = new Date(System.currentTimeMillis());
        Report addedReport = reportManagerWrapper.addReport(reportId, content, creationDate);
        assertNotNull(addedReport);
    }

    @Test
    public void testAddReportWithObject() {
        ReportManager reportManager = new ReportManager();
        ReportManagerWrapper reportManagerWrapper = new ReportManagerWrapper(reportManager);
        
        Report report = new Report(UUID.randomUUID(), "Test Content", new Date(System.currentTimeMillis()), reportManager);
        boolean added = reportManagerWrapper.addReport(report);
        assertFalse(added); 
    }
    
    @Test
    public void testRemoveReport() {
        ReportManager reportManager = new ReportManager();
        ReportManagerWrapper reportManagerWrapper = new ReportManagerWrapper(reportManager);
        Report report = new Report(UUID.randomUUID(), "Test Content", new Date(System.currentTimeMillis()), reportManager);
        boolean removed = reportManagerWrapper.removeReport(report);
        assertFalse(removed); 
    }

    @Test
    public void testAddReportAt() {
        ReportManager reportManager = new ReportManager();
        ReportManagerWrapper reportManagerWrapper = new ReportManagerWrapper(reportManager);
        Report report = new Report(UUID.randomUUID(), "Test Content", new Date(System.currentTimeMillis()), reportManager);
        int index = 0;
        boolean added = reportManagerWrapper.addReportAt(report, index);
        assertFalse(added); 
    }

    @Test
    public void testAddOrMoveReportAt() {
        ReportManager reportManager = new ReportManager();
        ReportManagerWrapper reportManagerWrapper = new ReportManagerWrapper(reportManager);
        
        Report report = new Report(UUID.randomUUID(), "Test Content", new Date(System.currentTimeMillis()), reportManager);
        int index = 0;
        boolean addedOrMoved = reportManagerWrapper.addOrMoveReportAt(report, index);
        assertTrue(addedOrMoved); 
    }

    @Test
    public void testDelete() {
        ReportManager reportManager = new ReportManager();
        ReportManagerWrapper reportManagerWrapper = new ReportManagerWrapper(reportManager);
        reportManagerWrapper.delete();
    }
    
    @Test
    public void testGetReport() {
        ReportManager reportManager = new ReportManager();
        ReportManagerWrapper reportManagerWrapper = new ReportManagerWrapper(reportManager);
        
        Report report = new Report(UUID.randomUUID(), "Test Content", new Date(System.currentTimeMillis()), reportManager);
        reportManager.addReport(report);
        int index = 0;
        Report retrievedReport = reportManagerWrapper.getReport(index);
        assertNotNull(retrievedReport); 
    }

}
