package code;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is an implementation of {@link IDataProcessing} </br>
 * @author btdiem </br>
 *
 */
public class DataProcessing implements IDataProcessing{
	
	/*
	 * (non-Javadoc)
	 * @see code.IDataProcessing#readFile(java.lang.String)
	 */
	@Override
	public String [] readFile(String fileName) throws IOException {
		
		File file = new File(fileName);
		if (!file.exists()) throw new FileNotFoundException(fileName + " does not exist");
		
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = null;
		List<String> lines = new ArrayList<String>();
		
		try{
			
			while ((line = br.readLine()) != null && line.length() > 0){
				lines.add(line);
			} ;
			
		}finally{
			br.close();
			fis.close();
		}

		if (!lines.isEmpty()) return lines.toArray(new String [] {});
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see code.IDataProcessing#convertStringToBigDecimalArray(java.lang.String[])
	 */
	@Override
	public BigDecimal[] convertStringToBigDecimalArray(String[] lines) {
		if (lines == null) return null;
		if (lines.length == 0) return null;
		int len = lines.length;
		
		BigDecimal [] numbers = new BigDecimal[len]; 
		for (int i=0; i<len; i++) {
			numbers[i] = new BigDecimal(lines[i]);
		}
		return numbers;
	}

	/* (non-Javadoc)
	 * @see code.IFileProcessing#toStringBigDecimalArray(java.math.BigDecimal[])
	 */
	@Override
	public String toString(BigDecimal[] array, boolean isNewLine) {
		
		//String eol = System.getProperty("line.separator");
		if(array == null) return null;
		if (array.length == 0) return null;
		StringBuffer sb = new StringBuffer();
		for (BigDecimal item : array) {
			if (item != null){
				sb.append(item).append(isNewLine ? "\r\n" : " ");
			}
		}
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see code.IFileProcessing#writeFile(java.lang.String, java.lang.String)
	 */
	@Override
	public void writeFile(String str, String fileName) throws IOException {
		
		FileOutputStream fos = new FileOutputStream(fileName);
		DataOutputStream dos = new DataOutputStream(fos);
		try{
			dos.writeBytes(str);
			
		}finally{
			dos.close();
			fos.close();
		}
	}
	
	
	
}
