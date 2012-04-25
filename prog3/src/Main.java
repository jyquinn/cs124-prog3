import java.io.*;
import java.util.Random;
import org.apache.commons.io.FileUtils;


public class Main {

	public static int MAX_ITER = 25000;
	public static int FILE_SIZE = 100;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File text_file = new File(args[0]);
		String text = "";
		try {
			text = FileUtils.readFileToString(text_file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] numStrings = text.split("\\n");
		long[] nums = new long[FILE_SIZE]; 
		
		int i=0;
		for(i=0; i<nums.length; i++){
			nums[i] = Integer.parseInt(numStrings[i]);		
		}
		
	}
	
	public long[] genRandomExperiment(int n, int max_int){
		Random rand = new Random();
		long[] sequence = new long[n];
		for (int i = 0; i < n; i++)
			sequence[i] = rand.nextInt(max_int);
		return sequence;
	}
	
	public long[] readExperiment(String file){
		long[] sequence = new long[100];
		File f = new File(file);
		//TODO finish
		return sequence;
	}
	

}
