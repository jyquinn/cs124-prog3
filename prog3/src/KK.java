
public class KK {
	private MaxHeap nums;
	private long residue;
	
	public KK(long[] nums_init){
		nums = new MaxHeap(nums_init);
		residue = calcResidue();
	}
	public KK(MaxHeap nums_heaped){
		nums = nums_heaped;
		residue = calcResidue();
	}
	
	public long getResidue(){
		return residue;
	}
	
	private long calcResidue(){
		while (nums.getSize() > 1){
			nums.insert(Math.abs(nums.extractMax() - nums.extractMax()));
		}
		return nums.extractMax();
	}
}
