import java.io.*;
import java.util.Random;


public class Main {

	public static int MAX_ITER = 25000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
