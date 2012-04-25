
public class KK {
	private MaxHeap nums;
	
	public KK(long[] nums_init){
		nums = new MaxHeap(nums_init);
	}
	public KK(MaxHeap nums_heaped){
		nums = nums_heaped;
	}
	
	public long getResidue(){
		while (nums.getSize() > 1){
			nums.insert(Math.abs(nums.extractMax() - nums.extractMax()));
		}
		return nums.extractMax();
	}
}