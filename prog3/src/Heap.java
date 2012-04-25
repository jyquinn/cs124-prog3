
public class Heap {

//	private DistIndex[] heap;
	private long[] heap;
	private int last_elt;
	private int[] indices;
	
	public Heap(long[] elts){
//		heap = new DistIndex[elts.length*(elts.length-1)/2];
		heap = new long[elts.length];
		last_elt = 0;
		for (int i = 0; i < elts.length; i++){
			insert(elts[i]);
		}
	}
//	public Heap(int size){
//		heap = new DistIndex[size];
//		last_elt = 0;
//		indices = new int[size]; Arrays.fill(indices, -1);
//
//	}
	
	public void maxHeapify (int n) {
		int ind_l = n*2+1;
		int ind_r = n*2+2;
		int smallest;
		
		if (ind_l < last_elt && heap[ind_l] < heap[n])
			smallest = ind_l;
		else
			smallest = n;
		
		if (ind_r < last_elt && heap[ind_r] < heap[smallest])
			smallest = ind_r;
			
		if (smallest != n){
			long temp = heap[n];
			heap[n] = heap[smallest];
			heap[smallest] = temp;
			
//			indices[heap[n].getIndex()] = n;
//			indices[heap[smallest].getIndex()] = smallest;
			maxHeapify(smallest);
		}
			
				
	}
	
	public int getSize() {
		return last_elt+1;
	}


	public long extractMax() {
		long max = heap[0];
		heap[0] = heap[last_elt-1]; 
		indices[heap[0].getIndex()] = 0;

		last_elt--;
		minHeapify(0);
		
		return min;
	}
	
	public void insert(long elt){
		int heap_index = indices[elt.getIndex()];
		int i;
		
		if (heap_index < 0 || heap_index > last_elt-1){	
			// elt has not yet been added to the heap
			heap[last_elt] = elt;
			indices[elt.getIndex()] = last_elt;
			i = last_elt;
			last_elt++;		
		} else{
			// elt already in heap
			heap[heap_index] = elt;
			i = heap_index;
			minHeapify(i);
		}
			
		int parent = (i-1)/2;
			
		while (i > 0 && heap[parent].getDist() > heap[i].getDist()){
			// switch nodes
			DistIndex temp = heap[parent];
			heap[parent] = heap[i];
			heap[i] = temp;

			// update index array
			indices[heap[parent].getIndex()] = parent;
			indices[heap[i].getIndex()] = i;
			
			i = parent;		
			parent = (i-1)/2;

		}
		
	}
	
	public boolean isEmpty(){
		return (last_elt < 1);
	}
	
	public void printHeap(){
		System.out.printf("Frontier index: %d\n", last_elt);
		System.out.println("Heap: ");
		for (int i = 0; i < last_elt; i++)
			System.out.printf("heap index: %d, node index: %d, d:%f\n",i,heap[i].getIndex(),heap[i].getDist());
		System.out.println("Indices: ");
		for (int i = 0; i < indices.length; i++)
			System.out.printf("node index: %d, heap index: %d\n",i,indices[i]);
		System.out.println();
		
	}
	public long[] getHeap() {
		return heap;
	}
	
	public int[] getIndices() {
		return indices;
	}
}


