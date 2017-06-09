package com.mcafee.framework;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

/**
*
* @author Balamurugan
*
*/

public class DataProviderClass 
{
	@DataProvider(name="impersonation")
	public static Object[][] getUserLoginData() throws InvalidFormatException, IOException
	{
		return getDataProviderData("./resources/TestData.xlsx", "Login");
	}
	
	@DataProvider(name="contactCreatorByEndCustomer")
	public static Object[][] getEndCustomerContactTestData() throws InvalidFormatException, IOException
	{
		return getDataProviderData("./resources/TestData.xlsx", "ContactsCreationByEndCustomer");
	}
	
	@DataProvider(name="contactCreatorByPartnerCreator")
	public static Object[][] getPartnerContactTestData() throws InvalidFormatException, IOException
	{
		return getDataProviderData("./resources/TestData.xlsx", "ContactsCreationByPartner");
	}
	
	@DataProvider(name="OpportunityCreatorByStandard")
	public static Object[][] getOpportunityData() throws InvalidFormatException, IOException
	{
		return getDataProviderData("./resources/TestData.xlsx", "OpportunityCreationByStandard");
	}
	
	@DataProvider(name="OpportunityCreatorAddPartner")
	public static Object[][] getOptyCreateAddPartner() throws InvalidFormatException, IOException
	{
		return getDataProviderData("./resources/TestData.xlsx","OptyCreationAddPartner");
	} 
	
	@DataProvider(name="LeadCreatorUsingRecordTypeOCC")
	public static Object[][] getOCCLeadData() throws InvalidFormatException, IOException
	{
		return getDataProviderData("./resources/TestData.xlsx", "LeadCreationByOCC");
	}
	
	@DataProvider(name="LeadCreatorUsingRecordTypeSalesLead")
	public static Object[][] getSalesLeadData() throws InvalidFormatException, IOException
	{
		return getDataProviderData("./resources/TestData.xlsx", "LeadCreationBySalesLead");
	}
	
	@DataProvider(name="AccountCreatorUsingByDraftEndCustomer")
	public static Object[][] getgetDraftEndCustomerAccountsDataAccountsData() throws InvalidFormatException, IOException
	{
		return getDataProviderData("./resources/TestData.xlsx", "AccountsCreationsByDraftEndCus");
	}
	
	@DataProvider(name="AccountCreatorUsingByEndCustomer")
	public static Object[][] getEndCustomerAccountsData() throws InvalidFormatException, IOException
	{
		return getDataProviderData("./resources/TestData.xlsx", "AccountsCreationsByEndCustomer");
	}
	
	@DataProvider(name="AccountCreatorUsingByCountry")
	public static Object[][] getAccountsCountryData() throws InvalidFormatException, IOException
	{
		return getDataProviderData("./resources/TestData.xlsx", "AccountsCreationsByCountry");
	}
	
	@DataProvider(name="AccountCreatorUsingByNonCountry")
	public static Object[][] getAccountsNonCountryData() throws InvalidFormatException, IOException
	{
		return getDataProviderData("./resources/TestData.xlsx", "AccountsCreationsByNonCountry");
	}
	
	private static String[][] getDataProviderData(String excelFile, String sheetName) throws InvalidFormatException, IOException 
	{
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(excelFile));
		XSSFWorkbook wb = new XSSFWorkbook(OPCPackage.open(input));
		XSSFSheet sheet=wb.getSheet(sheetName);
		Iterator<Row> rows = sheet.rowIterator();
		XSSFRow hedderRow = (XSSFRow) rows.next();
		int totalRows=sheet.getPhysicalNumberOfRows()-1;
		int totalColumns=hedderRow.getPhysicalNumberOfCells();
		String[][] dataObject=new String[totalRows][totalColumns];
		int i=0,j=0;
		while (rows.hasNext()) 
		{
			XSSFRow row = (XSSFRow) rows.next();
			Iterator<Cell> dataCells = row.cellIterator();
			{
				while (dataCells.hasNext()) 
				{
					XSSFCell header = (XSSFCell) dataCells.next();
					header.setCellType(CellType.STRING);
					try
					{
						dataObject[i][j]=header.toString().trim();
					}
					catch(Exception ex){}
					j++;
				}
			}
			i++;
			j=0;
		}
		wb.close();
		return dataObject;
	}
	
	public static void writeDataToExcel(String excelFile, String sheetName, String data, int rowNo, int colNo) throws InvalidFormatException, IOException 
	{
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(excelFile));
        XSSFWorkbook wb = new XSSFWorkbook(OPCPackage.open(input));
        XSSFSheet sheet=wb.getSheet(sheetName);
        XSSFRow row = sheet.getRow(rowNo);
        XSSFCell actualResultCell = row.createCell(colNo);
        actualResultCell.setCellValue(data);
        FileOutputStream fileOut = new FileOutputStream(excelFile);
        wb.write(fileOut);
        fileOut.close();
        wb.close();
	}
}
