/**
 * 
 */
package code;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author btdiem </br>
 * 
 * Find a subset of sorted due payments list. the sum of subset is equal with a given transfer payment </br> 
 * This idea is derived from an article for integer numbers </br>
 * http://codereview.stackexchange.com/questions/36214/find-all-subsets-of-an-int-array-whose-sums-equal-a-given-target </br>
 */
public class FindPayments {

	   boolean found = false;
	   BigDecimal [] foundList = null;

	   /**
	    * Populate posible subsets from an </b>sorted</b> array until the substraction between each item in a subset and the target number is zero </br>
	    * Otherwise, there is no result found </br>
	    * 
	    * @param data an {@link BigDecimal} array </br>
	    * @param fromIndex starting index of data </br>
	    * @param stack an array of subset populated </br>
	    * @param stacklen </br> index of stack
	    * @param target </br> given number compared with sum of subset </br>
	    * 
	    * @return a {@link BigDecimal} array </br>
	    */
	    public BigDecimal [] populateSubset(final BigDecimal[] data, int fromIndex, 
	    									final BigDecimal[] stack, int stacklen,
	    									final BigDecimal target) {
			
	    	if (data == null 
	    		|| fromIndex < 0 
	    		|| fromIndex > data.length 
	    		|| stack == null 
	    		|| stacklen < 0 
	    		|| stacklen > data.length 
	    		|| target == null)
	    		
			return null;
	    	
	    	// exact match of our target. Success!
	    	if (target.compareTo(BigDecimal.ZERO) == 0) {
	    		found = true;
	    		foundList = Arrays.copyOf(stack, stacklen);
			}//if
			
	    	// take advantage of sorted data.
			// we can skip all values that are too large.
			while (!found && fromIndex < data.length && data[fromIndex].compareTo(target) > 1) {
				fromIndex++;
			}//while

			// stop looping when we run out of data, or when we overflow our target.
			while (!found && fromIndex < data.length && data[fromIndex].compareTo(target) <= 0) {
				stack[stacklen] = data[fromIndex];
				populateSubset(data, fromIndex + 1, stack, stacklen + 1, target.subtract(data[fromIndex]));
				fromIndex++;
			}//while
			return foundList;
	    }
}
