/**
 * 
 */
package tests;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

import code.DataProcessing;
import code.FindPayments;
import code.IDataProcessing;

/**
 * @author btdiem </br>
 * This file is a simulation for the solution </br>
 * The argument parameter is a text file name </br>
 * The system will read string data in the file </br>
 * , parse the data to {@link BigDecimal} format </br>
 * and sort this array </br>
 * The returned value of {@link FindPayments#populateSubset(BigDecimal[], int, BigDecimal[], int, BigDecimal)} method
 * might be a {@link BigDecimal} array or null </br>
 * 
 * if the method returns null, output.txt file will show NO SOLUTION </br>
 * Otherwise, it will display a list of double number each line </br>
 * 
 *
 */
public class ValidationTest {

	public static void main (String[] args) throws IOException{

		if (args == null) return;
		if (args.length == 0) return;
		
		String fileName = args[0];
		IDataProcessing dataProcessing = new DataProcessing();
		FindPayments findPayments = new FindPayments();
		
		String [] strData = dataProcessing.readFile(fileName);
		BigDecimal [] decData = dataProcessing.convertStringToBigDecimalArray(strData);
		BigDecimal target = decData[0];
		BigDecimal[] duePayments = Arrays.copyOfRange(decData, 1, decData.length);
		BigDecimal [] stack = new BigDecimal[duePayments.length];
		Arrays.sort(duePayments);
		
		BigDecimal [] ret = findPayments.populateSubset(duePayments, 0, stack , 0, target);
		String rets = "NO SOLUTION";
		if (ret != null && ret.length > 0){
			rets = dataProcessing.toString(ret, true);
		}
		dataProcessing.writeFile(rets, "output.txt");
		
		
	}
}
