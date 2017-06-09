package com.macfee.sampletest;

import org.testng.annotations.Test;
import com.macfee.dao.MDMDAO;

/**
*
* @author Balamurugan
*
*/

public class DBEventTableTest 
{
	private static MDMDAO mdmdao;
	
	@Test
	public void test()
	{
		mdmdao.getEventsFromDataBase();
	} 
}
