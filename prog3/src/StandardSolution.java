
public class StandardSolution implements Solution {
	private long[] nums;
	private boolean partitions;
	
	public StandardSolution (long[] nums){
		
	}
	
	public long getResidue(){
		return 1;
	}
	public Solution getRandNeigbor(){
		return this;
	}
	
	public Solution randSolution(){
		return this;
	}
	
	public Solution runRandom(){
		return this;
	}
	
	public Solution runHillClimbing(){
		return this;
	}
	
	public Solution runSimulatedAnnealing(){
		return this;
	}
	
}
