
public class PrePartitionSolution extends AbstractSolution  {
	private long[] sequence;
	private long[] partitions;
	private KK solution;
	
	public PrePartitionSolution (long[] nums_init){
		sequence = nums_init;
		
		// make sure there's a solution...
		solution = null;
	}
	
	private KK getNewSequence(){
		//TODO implement transition to A' sequence from partitions and sequence
		return new KK(sequence);
	}
	
	public long getResidue(){
		return solution.getResidue();
	}
	
	public Solution getRandNeigbor(){
		return this;
	}
	
	public Solution randSolution(){
		return this;
	}
	
	
}
