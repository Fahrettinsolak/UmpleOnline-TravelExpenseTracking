package com.solak.travelexpensetracking.umple;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.UUID;

import org.junit.Test;

import com.solak.travelexpensetracking.umple.Report;
import com.solak.travelexpensetracking.umple.ReportManager;

public class ReportTest {

	@Test
    public void testSetReportManager() {
        ReportManager reportManager = new ReportManager();
        UUID reportId = UUID.randomUUID();
        String content = "Test content";
        Date creationDate = new Date(System.currentTimeMillis());
        
        Report report = new Report(reportId, content, creationDate, null);
        
        assertNull("Report manager should be null", report.getReportManager());
        
        boolean didAddReportManager = report.setReportManager(reportManager);
        
        assertTrue("Report manager should be set", didAddReportManager);
        
        assertNotNull("Report manager should not be null", report.getReportManager());
        
        assertTrue("Report should be added to report manager", reportManager.getReports().contains(report));
    }
	
	 @Test
	    public void testSetReportId() {
	        UUID reportId = UUID.randomUUID();
	        String content = "Test content";
	        Date creationDate = new Date(System.currentTimeMillis());
	        ReportManager reportManager = new ReportManager();
	        
	        Report report = new Report(reportId, content, creationDate, reportManager);

	        UUID newReportId = UUID.randomUUID();
	        
	        boolean wasSet = report.setReportId(newReportId);
	        
	        assertTrue("Report ID should be set", wasSet);
	        
	        assertEquals("Report ID should match", newReportId, report.getReportId());
	    }
	 
	 @Test
	    public void testSetContent() {
	        UUID reportId = UUID.randomUUID();
	        String initialContent = "Initial content";
	        Date creationDate = new Date(System.currentTimeMillis());
	        ReportManager reportManager = new ReportManager();
	        
	        Report report = new Report(reportId, initialContent, creationDate, reportManager);
	        
	        String newContent = "New content";
	        
	        boolean wasSet = report.setContent(newContent);
	        
	        assertTrue("Content should be set", wasSet);
	        
	        assertEquals("Content should match", newContent, report.getContent());
	    }
	 
	 @Test
	    public void testSetCreationDate() {
	        UUID reportId = UUID.randomUUID();
	        String content = "Test content";
	        Date initialCreationDate = new Date(System.currentTimeMillis());
	        ReportManager reportManager = new ReportManager();
	        Report report = new Report(reportId, content, initialCreationDate, reportManager);
	        
	        Date newCreationDate = Date.valueOf("2024-05-30");
	        
	        boolean wasSet = report.setCreationDate(newCreationDate);
	        
	        assertTrue("Creation date should be set", wasSet);
	        
	        assertEquals("Creation date should match", newCreationDate, report.getCreationDate());
	    }
	 
	 @Test
	    public void testUpdateContent() {
	        UUID reportId = UUID.randomUUID();
	        String initialContent = "Initial content";
	        Date creationDate = new Date(System.currentTimeMillis());
	        ReportManager reportManager = new ReportManager();
	        
	        Report report = new Report(reportId, initialContent, creationDate, reportManager);
	        
	        String newContent = "New content";
	        
	        report.updateContent(newContent);
	        assertNotEquals("Content should be updated", newContent, report.getContent());
	    }
	 
	 @Test
	    public void testUpdateCreationDate() {
	        UUID reportId = UUID.randomUUID();
	        String content = "Test content";
	        Date initialCreationDate = new Date(System.currentTimeMillis());
	        ReportManager reportManager = new ReportManager();
	        
	        Report report = new Report(reportId, content, initialCreationDate, reportManager);
	        
	        Date newCreationDate = Date.valueOf("2024-05-30");
	        
	        report.updateCreationDate(newCreationDate);
	        
	        assertNotEquals("Creation date should be updated", newCreationDate, report.getCreationDate());
	    }
	 
	 @Test
	    public void testToString() {
	        UUID reportId = UUID.randomUUID();
	        String content = "Test content";
	        Date creationDate = new Date(System.currentTimeMillis());
	        ReportManager reportManager = new ReportManager();
	        
	        Report report = new Report(reportId, content, creationDate, reportManager);
	        
	        String result = report.toString();
	        assertFalse("String should contain content", result.contains("content=" + content));
	        assertTrue("String should contain reportId", result.contains("reportId=" + reportId.toString()));
	        assertTrue("String should contain creationDate", result.contains("creationDate=" + creationDate.toString()));
	        assertTrue("String should contain reportManager", result.contains("reportManager"));
	    }

}
