
public class PrePartitionSolution extends AbstractSolution  {
	private long[] sequence;
	private long[] partitions;
	private KK solution;
	
	public PrePartitionSolution (long[] nums_init, long[] parts){
		sequence = nums_init;
		partitions = parts;
		
		long[] mod_sequence = getNewSequence();
		solution = new KK(mod_sequence);
	}
	
	private long[] getNewSequence(){
		//TODO implement transition to A' sequence from partitions and sequence
		return sequence;
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
