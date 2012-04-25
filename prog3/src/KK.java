
public class KK {
	private Heap nums;
	
	public KK(long[] nums_init){
		nums = new Heap(nums_init);
	}
	public KK(Heap sequence){
		nums = sequence;
	}
	
	public long getResidue(){
		while (nums.getSize() > 1){
			nums.insert(Math.abs(nums.extractMax() - nums.extractMax()));
		}
		return nums.extractMax();
	}
}
