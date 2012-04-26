import java.io.*;
import java.util.Random;
import org.apache.commons.io.FileUtils;


public class Main {
	
	public static long MAX_SIZE = (long)Math.pow(10, 12);
	public static int MAX_ITER = 25000;
	public static int FILE_SIZE = 100;
	public static int NUM_TESTS = 50;

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
		
		mainScript();
		
	}
	
	public static long[] genRandomExperiment(int n){
		Random rand = new Random();
		long[] sequence = new long[n];
		long s = 0;
		int i = 0;
		for (i = 0; i < n; i++) {
			s = rand.nextLong()%MAX_SIZE;
			if (s<0){ s=s*-1; }
			sequence[i] = s;
		}
		return sequence;
	}
	
	public long[] readExperiment(String file){
		long[] sequence = new long[100];
//		File f = new File(file);
//		//TODO finish
		return sequence;
	}
	
	public static void testHeap(){
		int n = 11;
		MaxHeap h = new MaxHeap(n);
		Random rand = new Random();
		for (int i = 0; i < 10; i++){
			h.insert(rand.nextInt(10));
		}
		h.printHeap();
		
		
		System.out.print("pulling in order\n");
		for (int i = 0; i<10; i++){
			System.out.print(h.extractMax());
			System.out.println();
		}
	}
	

	public static void testKK(){
		long[] nums = new long[]{5,7,10,8,6};
		KK kk = new KK(nums);
		System.out.println(kk.getResidue());
	} 
	
	
	public static void mainScript(){
		int i;
		
		long[] kk_res        = new long[NUM_TESTS];
		long[] stand_rr_res  = new long[NUM_TESTS];
		long[] stand_hc_res  = new long[NUM_TESTS];
		long[] stand_sa_res  = new long[NUM_TESTS];
		long[] pre_rr_res    = new long[NUM_TESTS];
		long[] pre_hc_res    = new long[NUM_TESTS];
		long[] pre_sa_res    = new long[NUM_TESTS];
		
		long[] kk_time       = new long[NUM_TESTS];
		long[] stand_rr_time = new long[NUM_TESTS];
		long[] stand_hc_time = new long[NUM_TESTS];
		long[] stand_sa_time = new long[NUM_TESTS];
		long[] pre_rr_time   = new long[NUM_TESTS];
		long[] pre_hc_time   = new long[NUM_TESTS];
		long[] pre_sa_time   = new long[NUM_TESTS];
		
		long time_start = 0;
		long time_finish = 0;
		
		for (i=0; i< NUM_TESTS; i++){
			//long[] exp = genRandomExperiment(FILE_SIZE);
			long[] exp = new long[]{5,7,10,8,6};
			KK kk_exp = new KK(exp);
			StandardSolution stand_exp = new StandardSolution(exp);
			PrePartitionSolution pre_exp = new PrePartitionSolution(exp);
			
			time_start       = System.currentTimeMillis();
			kk_res[i]        = kk_exp.getResidue();	
			time_finish      = System.currentTimeMillis();
			kk_time [i]      = time_finish-time_start;
			
			time_start       = System.currentTimeMillis();
			stand_rr_res[i]  = stand_exp.runRandom().getResidue();
			time_finish      = System.currentTimeMillis();
			stand_rr_time[i] = time_finish-time_start;
			
			time_start       = System.currentTimeMillis();
			stand_hc_res[i]  = stand_exp.runHillClimbing().getResidue();
			time_finish      = System.currentTimeMillis();
			stand_hc_time[i] = time_finish-time_start;			
			
			time_start       = System.currentTimeMillis();
			stand_sa_res[i]  = stand_exp.runSimulatedAnnealing().getResidue();	
			time_finish      = System.currentTimeMillis();
			stand_sa_time[i] = time_finish-time_start;				
			
			time_start       = System.currentTimeMillis();			
			pre_rr_res[i]    = pre_exp.runRandom().getResidue();
			time_finish      = System.currentTimeMillis();
			pre_rr_time[i]   = time_finish-time_start;				
			
			time_start       = System.currentTimeMillis();			
			pre_hc_res[i]    = pre_exp.runHillClimbing().getResidue();
			time_finish      = System.currentTimeMillis();
			pre_hc_time[i]   = time_finish-time_start;				
			
			time_start       = System.currentTimeMillis();			
			pre_sa_res[i]    = pre_exp.runSimulatedAnnealing().getResidue();
			time_finish      = System.currentTimeMillis();
			pre_sa_time[i]   = time_finish-time_start;		
			
			System.out.println(kk_res[i] + " " + kk_time[i] + "   " 
					+ stand_rr_res[i] + " " + stand_rr_time[i] + "    " 
					+ stand_hc_res[i] + " " + stand_hc_time[i] + "    " 
					+ stand_sa_res[i] + " " + stand_sa_time[i] + "    " 	
					+ pre_rr_res[i] + " " + pre_rr_time[i] + "    " 
					+ pre_hc_res[i] + " " + pre_hc_time[i] + "    "
					+ pre_sa_res[i] + " " + pre_sa_time[i] + "    " 
					);
		}
	}
}
