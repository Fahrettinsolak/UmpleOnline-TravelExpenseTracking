package com.solak.TravelExpense.main.lib.models;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.solak.TravelExpense.umple.Report;
import com.solak.TravelExpense.umple.ReportManager;

public class ReportWrapperTest {

    private Report mockReport;
    private ReportWrapper reportWrapper;
    private ReportManager reportManager;
    private UUID reportId;
    private Date creationDate;

    @Before
    public void setUp() {
        reportManager = new ReportManager();
        reportId = UUID.randomUUID();
        creationDate = new Date(System.currentTimeMillis());
        mockReport = new Report(reportId, "Initial Content", creationDate, reportManager);
        reportWrapper = new ReportWrapper(mockReport);
    }

    @Test
    public void testDefaultConstructor() {
        ReportWrapper reportWrapper = new ReportWrapper();
        
        assertNotNull(reportWrapper);
    }

    @Test
    public void testParameterizedConstructor() {
        ReportWrapper reportWrapper = new ReportWrapper(reportId, "New Content", creationDate, reportManager);
        
        assertNotNull(reportWrapper);
        assertEquals(reportId, reportWrapper.getReportId());
        assertEquals("New Content", reportWrapper.getContent());
        assertEquals(creationDate, reportWrapper.getCreationDate());
        assertEquals(reportManager, reportWrapper.getReportManager());
    }

    @Test
    public void testGetReportId() {
        assertEquals(mockReport.getReportId(), reportWrapper.getReportId());
    }

    @Test
    public void testSetReportId() {
        UUID newReportId = UUID.randomUUID();
        reportWrapper.setReportId(newReportId);
        assertEquals(newReportId, reportWrapper.getReportId());
    }

    @Test
    public void testGetContent() {
        assertEquals(mockReport.getContent(), reportWrapper.getContent());
    }

    @Test
    public void testSetContent() {
        String newContent = "Updated Content";
        reportWrapper.setContent(newContent);
        assertEquals(newContent, reportWrapper.getContent());
    }

    @Test
    public void testGetCreationDate() {
        assertEquals(mockReport.getCreationDate(), reportWrapper.getCreationDate());
    }

    @Test
    public void testSetCreationDate() {
        Date newCreationDate = new Date(System.currentTimeMillis() + 86400000); // +1 day
        reportWrapper.setCreationDate(newCreationDate);
        assertEquals(newCreationDate, reportWrapper.getCreationDate());
    }

    @Test
    public void testGetReportManager() {
        assertEquals(reportManager, reportWrapper.getReportManager());
    }

    @Test
    public void testSetReportManager() {
        ReportManager newManager = new ReportManager();
        reportWrapper.setReportManager(newManager);
        assertEquals(newManager, reportWrapper.getReportManager());
    }

    @Test
    public void testUpdateContent() {
        String newContent = "New Content for Update";
        reportWrapper.updateContent(newContent);
        assertEquals(newContent, reportWrapper.getContent());
    }

    @Test
    public void testUpdateCreationDate() {
        Date newCreationDate = new Date(System.currentTimeMillis() + 172800000); // +2 days
        reportWrapper.updateCreationDate(newCreationDate);
        assertEquals(newCreationDate, reportWrapper.getCreationDate());
    }

    @Test
    public void testDelete() {
        reportWrapper.delete();
    }

    @Test
    public void testToString() {
        String expectedString = mockReport.toString();
        assertEquals(expectedString, reportWrapper.toString());
    }
}
