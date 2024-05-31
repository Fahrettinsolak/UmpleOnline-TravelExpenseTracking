package com.solak.TravelExpense.umple;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.UUID;

import org.junit.Test;

public class ReportManagerTest {

	@Test
    public void testConstructor() {
        ReportManager reportManager = new ReportManager();
        assertNotNull(reportManager); 

        assertTrue(reportManager.getReports().isEmpty());
    }
	
	@Test
    public void testGetReport() {
        ReportManager reportManager = new ReportManager();
        
        UUID reportId1 = UUID.randomUUID();
        UUID reportId2 = UUID.randomUUID();
        UUID reportId3 = UUID.randomUUID();
        
        String content1 = "Content 1";
        String content2 = "Content 2";
        String content3 = "Content 3";
        
        Date creationDate1 = new Date(System.currentTimeMillis());
        Date creationDate2 = new Date(System.currentTimeMillis());
        Date creationDate3 = new Date(System.currentTimeMillis());
        
        reportManager.addReport(reportId1, content1, creationDate1);
        reportManager.addReport(reportId2, content2, creationDate2);
        reportManager.addReport(reportId3, content3, creationDate3);

        assertEquals(reportId1, reportManager.getReport(0).getReportId());
        assertEquals(reportId2, reportManager.getReport(1).getReportId());
        assertEquals(reportId3, reportManager.getReport(2).getReportId());
    }
	
	 @Test
	    public void testNumberOfReports() {
	        ReportManager reportManager = new ReportManager();
	        
	        assertEquals(0, reportManager.numberOfReports());

	        UUID reportId1 = UUID.randomUUID();
	        UUID reportId2 = UUID.randomUUID();
	        UUID reportId3 = UUID.randomUUID();
	        
	        String content1 = "Content 1";
	        String content2 = "Content 2";
	        String content3 = "Content 3";
	        
	        Date creationDate1 = new Date(System.currentTimeMillis());
	        Date creationDate2 = new Date(System.currentTimeMillis());
	        Date creationDate3 = new Date(System.currentTimeMillis());
	        
	        reportManager.addReport(reportId1, content1, creationDate1);
	        reportManager.addReport(reportId2, content2, creationDate2);
	        reportManager.addReport(reportId3, content3, creationDate3);

	        assertEquals(3, reportManager.numberOfReports());
	    }
	 
	 @Test
	    public void testHasReports() {
	        ReportManager reportManager = new ReportManager();
	        
	        assertFalse(reportManager.hasReports());
	        
	        UUID reportId = UUID.randomUUID();
	        String content = "Sample Content";
	        Date creationDate = new Date(System.currentTimeMillis());
	        
	        reportManager.addReport(reportId, content, creationDate);

	        assertTrue(reportManager.hasReports());
	    }
	 
	 @Test
	    public void testIndexOfReport() {
	        ReportManager reportManager = new ReportManager();
	        
	        assertEquals(-1, reportManager.indexOfReport(null));
	        
	        UUID reportId = UUID.randomUUID();
	        String content = "Sample Content";
	        Date creationDate = new Date(System.currentTimeMillis());
	        
	        Report sampleReport = reportManager.addReport(reportId, content, creationDate);

	        assertEquals(0, reportManager.indexOfReport(sampleReport));
	    }
	 
	 @Test
	    public void testMinimumNumberOfReports() {
	        assertEquals(0, ReportManager.minimumNumberOfReports());
	    }
	 
	 @Test
	    public void testAddReport() {
	        ReportManager reportManager = new ReportManager();

	        UUID reportId = UUID.randomUUID();
	        String content = "Sample Content";
	        Date creationDate = new Date(System.currentTimeMillis());
	        Report report = new Report(reportId, content, creationDate, reportManager);

	        assertFalse(reportManager.addReport(report));
	        assertEquals(1, reportManager.numberOfReports());
	        assertEquals(report, reportManager.getReport(0));

	        assertFalse(reportManager.addReport(report));
	        assertEquals(1, reportManager.numberOfReports());

	        ReportManager anotherReportManager = new ReportManager();

	        assertTrue(anotherReportManager.addReport(report));
	        assertEquals(1, anotherReportManager.numberOfReports());
	        assertEquals(report, anotherReportManager.getReport(0));

	        assertEquals(0, reportManager.numberOfReports());
	    }
	 
	 @Test
	    public void testAddReportAtMaintainsOrder() {
	        // Yeni bir ReportManager oluştur
	        ReportManager reportManager = new ReportManager();

	        // Yeni raporlar oluştur
	        Report report1 = createReport("Content 1");
	        Report report2 = createReport("Content 2");
	        Report report3 = createReport("Content 3");

	        // Raporları sırayla ekleyin ve doğru sırayı koruduğunu doğrulayın
	        assertTrue(reportManager.addReportAt(report1, 0));
	        assertTrue(reportManager.addReportAt(report2, 1));
	        assertTrue(reportManager.addReportAt(report3, 2));
	        
	        assertEquals(report1, reportManager.getReport(0));
	        assertEquals(report2, reportManager.getReport(1));
	        assertEquals(report3, reportManager.getReport(2));
	    }

	    // Yardımcı metot: Yeni bir rapor oluşturur
	    private Report createReport(String content) {
	        UUID reportId = UUID.randomUUID();
	        Date creationDate = new Date(System.currentTimeMillis());
	        return new Report(reportId, content, creationDate, new ReportManager());
	    }
	    
	    @Test
	    public void testAddOrMoveReportAt() {
	        // Yeni bir ReportManager oluştur
	        ReportManager reportManager = new ReportManager();

	        // Yeni raporlar oluştur
	        Report report1 = createReport("Content 1");
	        Report report2 = createReport("Content 2");
	        Report report3 = createReport("Content 3");

	        // Raporları sırayla ekleyin
	        reportManager.addReport(report1);
	        reportManager.addReport(report2);
	        reportManager.addReport(report3);

	        // Raporları taşıyın ve doğrulayın
	        assertTrue(reportManager.addOrMoveReportAt(report1, 2));
	        assertEquals(report2, reportManager.getReport(0));
	        assertEquals(report3, reportManager.getReport(1));
	        assertEquals(report1, reportManager.getReport(2));

	        // Mevcut olmayan bir raporu ekleyin ve doğrulayın
	        Report report4 = createReport("Content 4");
	        assertTrue(reportManager.addOrMoveReportAt(report4, 1));
	        assertEquals(report2, reportManager.getReport(0));
	        assertEquals(report4, reportManager.getReport(1));
	        assertEquals(report3, reportManager.getReport(2));
	        assertEquals(report1, reportManager.getReport(3));
	    }
	    
	    @Test
	    public void testDelete() {
	        ReportManager reportManager = new ReportManager();

	        Report report1 = createReport("Content 1");
	        Report report2 = createReport("Content 2");
	        Report report3 = createReport("Content 3");

	        reportManager.addReport(report1);
	        reportManager.addReport(report2);
	        reportManager.addReport(report3);

	        reportManager.delete();
	        assertEquals(0, reportManager.numberOfReports());
	    }
	    
	    @Test
	    public void testGenerateReport() {
	        ReportManager reportManager = new ReportManager();

	        Report generatedReport = reportManager.generateReport("username");
	        assertNull(generatedReport);
	    }
	    
	    @Test
	    public void testViewReport() {
	        ReportManager reportManager = new ReportManager();

	        UUID reportId = UUID.randomUUID();

	        Report viewedReport = reportManager.viewReport(reportId);
	        assertNull(viewedReport);
	    }
	    
	    @Test
	    public void testDeleteReport() {
	        ReportManager reportManager = new ReportManager();

	        UUID reportId = UUID.randomUUID();

	        reportManager.deleteReport(reportId);
	    }

}
