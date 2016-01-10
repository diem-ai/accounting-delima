/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.FindPayments;

/**
 * @author btdiem
 * Implementing unit test cases for {@link FindPayments} class </br> 
 *
 */
public class JUnitTest_FindPayments {

	FindPayments findPayment;
	BigDecimal [] data = new BigDecimal[] 
			{new BigDecimal("17.09")
			,new BigDecimal("22.75")
			, new BigDecimal("27.21")
			, new BigDecimal("34.22")
			, new BigDecimal("59.33")
			, new BigDecimal("100.99")
			};
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		findPayment = new FindPayments();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		findPayment = null;
	}

	/**
	 * Validate method {@link FindPayments#populateSubset(BigDecimal[], int, BigDecimal[], int, BigDecimal)} </br>
	 * with target parameter is 74.06 </br>
	 * expect result: 17.09, 22.75 and 34.22
	 */
	@Test
	public void testpopulateSubset1() {
		
		BigDecimal target = new BigDecimal("74.06");
		int fromIndex = 0;
		BigDecimal [] stack = new BigDecimal[data.length];
		int stacklen = 0;
		
		BigDecimal [] ret = findPayment.populateSubset(data, fromIndex, stack, stacklen, target);
		assertNotNull(ret);
		assertTrue(ret.length==3);
		assertTrue(ret[0].compareTo(new BigDecimal("17.09"))==0);
		assertTrue(ret[1].compareTo(new BigDecimal("22.75"))==0);
		assertTrue(ret[2].compareTo(new BigDecimal("34.22"))==0);
		
	}
	
	/**
	 * Validate method {@link FindPayments#populateSubset(BigDecimal[], int, BigDecimal[], int, BigDecimal)} </br>
	 * with target parameter is 100.00 </br>
	 * expect result: null </br>
	 */
	@Test
	public void testpopulateSubset2() {
		
		BigDecimal target = new BigDecimal("100.00");
		int fromIndex = 0;
		BigDecimal [] stack = new BigDecimal[data.length];
		int stacklen = 0;

		BigDecimal [] ret = findPayment.populateSubset(data, fromIndex, stack, stacklen, target);
		assertNull(ret);
	}
	
	/**
	 * Validating method {@link FindPayments#populateSubset(BigDecimal[], int, BigDecimal[], int, BigDecimal)} </br>
	 * return null if one of input value is invalid </br>
	 * 
	 */
	@Test
	public void testpopulateSubset3() {
		
		BigDecimal target = new BigDecimal("74.06");
		int fromIndex = 0;
		BigDecimal [] stack = new BigDecimal[data.length];
		int stacklen = 0;

		BigDecimal [] ret = findPayment.populateSubset(null, fromIndex, stack, stacklen, target);
		assertNull(ret);
	}
	
	/**
	 * Validating method {@link FindPayments#populateSubset(BigDecimal[], int, BigDecimal[], int, BigDecimal)} </br>
	 * return null if one of input value is invalid </br>
	 * 
	 */
	@Test
	public void testpopulateSubset4() {
		
		BigDecimal target = new BigDecimal("74.06");
		BigDecimal [] stack = new BigDecimal[data.length];
		int stacklen = 0;

		BigDecimal [] ret = findPayment.populateSubset(data, -1, stack, stacklen, target);
		assertNull(ret);
	}

	/**
	 * Validating method {@link FindPayments#populateSubset(BigDecimal[], int, BigDecimal[], int, BigDecimal)} </br>
	 * return null if one of input value is invalid </br>
	 * 
	 */
	@Test
	public void testpopulateSubset5() {
		
		BigDecimal target = new BigDecimal("74.06");
		BigDecimal [] stack = new BigDecimal[data.length];
		int stacklen = 0;
		
		BigDecimal [] ret = findPayment.populateSubset(data, data.length +1, stack, stacklen, target);
		assertNull(ret);
	}	
	/**
	 * Validating method {@link FindPayments#populateSubset(BigDecimal[], int, BigDecimal[], int, BigDecimal)} </br>
	 * return null if one of input value is invalid </br>
	 * 
	 */
	@Test
	public void testpopulateSubset6() {
		
		BigDecimal target = new BigDecimal("74.06");
		//BigDecimal [] stack = new BigDecimal[data.length];
		int stacklen = 0;
		
		BigDecimal [] ret = findPayment.populateSubset(data, 0 , null, stacklen, target);
		assertNull(ret);
	}	
	
	/**
	 * Validating method {@link FindPayments#populateSubset(BigDecimal[], int, BigDecimal[], int, BigDecimal)} </br>
	 * return null if one of input value is invalid </br>
	 * 
	 */
	@Test
	public void testpopulateSubset7() {
		
		BigDecimal target = new BigDecimal("74.06");
		BigDecimal [] stack = new BigDecimal[data.length];
		//int stacklen = 0;
		
		BigDecimal [] ret = findPayment.populateSubset(data, 0 , stack, -1, target);
		assertNull(ret);
	}	
	/**
	 * Validating method {@link FindPayments#populateSubset(BigDecimal[], int, BigDecimal[], int, BigDecimal)} </br>
	 * return null if one of input value is invalid </br>
	 * 
	 */
	@Test
	public void testpopulateSubset8() {
		
		BigDecimal target = new BigDecimal("74.06");
		BigDecimal [] stack = new BigDecimal[data.length];
		//int stacklen = 0;
		
		BigDecimal [] ret = findPayment.populateSubset(data, 0 , stack, data.length + 1, target);
		assertNull(ret);
	}	
	/**
	 * Validating method {@link FindPayments#populateSubset(BigDecimal[], int, BigDecimal[], int, BigDecimal)} </br>
	 * return null if one of input value is invalid </br>
	 * 
	 */
	@Test
	public void testpopulateSubset9() {
		
		//BigDecimal target = new BigDecimal("74.06");
		BigDecimal [] stack = new BigDecimal[data.length];
		int stacklen = 0;
		int fromIndex = 0;
		
		BigDecimal [] ret = findPayment.populateSubset(data, fromIndex , stack, stacklen, null);
		assertNull(ret);
	}	
	
}
