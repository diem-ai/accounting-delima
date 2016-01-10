package tests;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import code.DataProcessing;
import code.IDataProcessing;

/**
 * 
 * @author btdiem </br>
 * 
 * Implementing unit test cases for {@link DataProcessing} class </br>
 *
 */

public class JUnitTest_DataProcessing {

	IDataProcessing dataProcessing;
	@Before
	public void setUp() throws Exception {
		dataProcessing = new DataProcessing();
	}

	@After
	public void tearDown() throws Exception {
		dataProcessing = null;
	}
	/**
	 * Validate method {@link IDataProcessing#readFile(String)} </br>
	 * The input is file name but it does not exist </br>
	 * Expect: {@link FileNotFoundException} exception
	 * @throws IOException 
	 */
	@Test (expected = FileNotFoundException.class)
	public void testReadFile1() throws IOException {
		dataProcessing.readFile("notexist");
	}
	/**
	 * Validate method {@link IDataProcessing#readFile(String)} </br>
	 * The input is a text file input.txt </br>
	 * Expect an array with 7 string items </br>
	 * @throws IOException </br>
	 */
	@Test
	public void testReadFile2() throws IOException{
		
		String [] ret = dataProcessing.readFile("resources/input.txt");
		Assert.assertNotNull(ret);
		Assert.assertTrue(ret.length==7);
		Assert.assertEquals(ret[0], "74.06");
		Assert.assertEquals(ret[1], "22.75");
		Assert.assertEquals(ret[2], "59.33");
		Assert.assertEquals(ret[3], "34.22");
		Assert.assertEquals(ret[4], "27.21");
		Assert.assertEquals(ret[5], "17.09");
		Assert.assertEquals(ret[6], "100.99");
		
	}
	
	/**
	 * Validate method {@link IDataProcessing#readFile(String)} </br>
	 * The input is a text file testEmptyInput.txt </br>
	 * Expect that method returns null </br>
	 */
	@Test
	public void testReadFile3() throws IOException{
		
		String [] ret = dataProcessing.readFile("resources/testEmptyInput.txt");
		Assert.assertNull(ret);
	}
	
	/**
	 * Validating method {@link IDataProcessing#convertStringToBigDecimalArray(String[])} </br>
	 * returns null if the input is null value</br>
	 * 
	 */
	@Test
	public void testConvertStringToBigDecimalArray1(){
		
		BigDecimal [] ret = dataProcessing.convertStringToBigDecimalArray(null);
		Assert.assertNull(ret);
	}
	/**
	 * Validating method {@link IDataProcessing#convertStringToBigDecimalArray(String[])} </br>
	 * returns null if the input is an empty array</br>
	*/
	@Test
	public void testConvertStringToBigDecimalArray2(){
		BigDecimal [] ret = dataProcessing.convertStringToBigDecimalArray(new String []{});
		Assert.assertNull(ret);
	}
	/**
	 * Validating method {@link IDataProcessing#convertStringToBigDecimalArray(String[])} </br>
	 * returns a {@link BigDecimal} array if the input is a String array</br>
	*/
	@Test
	public void testConvertStringToBigDecimalArray3(){
		BigDecimal [] ret = dataProcessing.convertStringToBigDecimalArray(
				new String []{"22.75", "59.33", "34.22"});
		Assert.assertNotNull(ret);
		Assert.assertEquals(ret.length, 3);
		Assert.assertEquals(ret[0], new BigDecimal("22.75"));
		Assert.assertEquals(ret[1], new BigDecimal("59.33"));
		Assert.assertEquals(ret[2], new BigDecimal("34.22"));
	}
	/**
	 * Validating method {@link IDataProcessing#toString(BigDecimal[], boolean)} </br>
	 * returns null if the input is null </br>
	*/
	@Test
	public void testToString1() {
		String ret = dataProcessing.toString(null, true);
		Assert.assertNull(ret);
	}
	/**
	 * Validating method {@link IDataProcessing#toString(BigDecimal[], boolean)} </br>
	 * returns null if the input is an empty {@link BigDecimal} array </br>
	*/
	@Test
	public void testToString2(){
		String ret = dataProcessing.toString(new BigDecimal []{}, true);
		Assert.assertNull(ret);
	}
	/**
	 * Validating method {@link IDataProcessing#toString(BigDecimal[], boolean)} </br>
	 * returns a string if the input is a {@link BigDecimal} array and isNewLine option is true</br>
	*/	
	@Test
	public void testToString3(){
		
		BigDecimal [] data = new BigDecimal[] 
				{new BigDecimal("17.09")
				,new BigDecimal("22.75")
				, new BigDecimal("27.21")};
		
		String sb = dataProcessing.toString(data, true);
		Assert.assertEquals(sb, "17.09\r\n22.75\r\n27.21\r\n");
	}
	/**
	 * Validating method {@link IDataProcessing#toString(BigDecimal[], boolean)} </br>
	 * returns a string if the input is a {@link BigDecimal} array and isNewLine option is false</br>
	*/	
	@Test
	public void testToString4(){
		
		BigDecimal [] data = new BigDecimal[] 
				{new BigDecimal("17.09")
				,new BigDecimal("22.75")
				, new BigDecimal("27.21")};
		
		String sb = dataProcessing.toString(data, false);
		Assert.assertEquals(sb, "17.09 22.75 27.21 ");
	}
	
	
	
	
}
