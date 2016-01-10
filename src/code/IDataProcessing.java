package code;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * 
 */

/**
 * @author btdiem
 *
 */
public interface IDataProcessing {
	/**
	 * Read a text file and return String array </br>
	 * @param fileName name of input file </br>
	 */
	public String [] readFile (String fileName) throws IOException ;
	/**
	 * Convert String array to {@link BigDecimal} array </br>
	 * to support for accurate numberic computation </br>
	 * @param lines an array of string </br>
	 * @return {@link BigDecimal} array </br>
	 */
	public BigDecimal [] convertStringToBigDecimalArray(String [] lines);
	/**
	 * Convert {@link BigDecimal} array to string object </br>
	 * 
	 * @param array a list of {@link BigDecimal} numbers </br>
	 * @param isNewLine if it is true, adding new line letter
	 *  to string when processing new item in the array </br>
	 * @return String value
	 */
	public String toString(BigDecimal [] array, boolean isNewLine);
	/**
	 * Write a string object to text file </br>
	 * @param str String object </br>
	 * @param fileName name of output file </br>
	 * @throws IOException
	 */
	public void writeFile(String str, String fileName) throws  IOException;
	
}
