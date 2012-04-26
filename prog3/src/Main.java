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
		
		mainScript(nums);
		
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
	
	
	public static void mainScript(long[] nums){
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
			long[] exp = genRandomExperiment(FILE_SIZE);
			//long[] exp = new long[]{5,7,10,8,6};
			
			/*
			long avg = avgArray(exp);
			long var = varArray(exp);
			
			System.out.println("avg:" + avg + " var:" + var);
			*/
			
			//long[] exp = nums;
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
		System.out.println("kk: avg=" + avgArray(kk_res) + " var =" + varArray(kk_res)
				+ "kk-time: avg=" + avgArray(kk_time) + "var=" + varArray(kk_time));
		
		System.out.println("stand_rr: avg=" + avgArray(stand_rr_res) + " var =" + varArray(stand_rr_res)
				+ " stand_rr_res-time: avg=" + avgArray(stand_rr_res) + " var=" + varArray(stand_rr_res));
		
		System.out.println("stand_hc: avg=" + avgArray(stand_hc_res) + " var =" + varArray(stand_hc_res)
				+ " stand_hc_res-time: avg=" + avgArray(stand_hc_res) + " var=" + varArray(stand_hc_res));
		
		System.out.println("stand_sa: avg=" + avgArray(stand_sa_res) + " var =" + varArray(stand_sa_res)
				+ " stand_rr_res-time: avg=" + avgArray(stand_sa_res) + " var=" + varArray(stand_sa_res));
		
		System.out.println("pre_rr: avg=" + avgArray(pre_rr_res) + " var =" + varArray(pre_rr_res)
				+ " pre_rr_res-time: avg=" + avgArray(pre_rr_res) + " var=" + varArray(pre_rr_res));
		
		System.out.println("pre_hc: avg=" + avgArray(pre_hc_res) + " var =" + varArray(pre_hc_res)
				+ " pre_hc_res-time: avg=" + avgArray(pre_hc_res) + " var=" + varArray(pre_hc_res));
		
		System.out.println("pre_sa: avg=" + avgArray(pre_sa_res) + " var =" + varArray(pre_sa_res)
				+ " pre_sa_res-time: avg=" + avgArray(pre_sa_res) + " var=" + varArray(pre_sa_res));
	}
	
	public static long avgArray(long[] nums){
		int i=0;
		long avg = 0;
		for (i=0; i<nums.length; i++){
			avg = (avg) + (nums[i])/nums.length;
		}
		return avg;
	}
	
	public static long varArray(long[] nums){
		int i=0;
		long avg = avgArray(nums);
		long square_avg= 0;
		for (i=0; i<nums.length; i++){
			square_avg = square_avg + (nums[i]*nums[i])/nums.length;
		}
		return square_avg-(avg*avg);
	}
	
	
}
