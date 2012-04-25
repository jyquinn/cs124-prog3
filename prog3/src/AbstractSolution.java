
public abstract class AbstractSolution implements Solution {

	public Solution runRandom(){
		Solution s = this;
		int count = 0;
		while (count < Main.MAX_ITER){
			Solution rand_soln = this.randSolution();
			if (rand_soln.getResidue() < s.getResidue())
				s = rand_soln;
			count++;
		}
		return s;
	}
	public Solution runHillClimbing(){
		Solution s = this;
		int count = 0;
		while(count < Main.MAX_ITER){
			Solution rand_neighbor = s.getRandNeigbor();
			if (rand_neighbor.getResidue() < s.getResidue())
				s = rand_neighbor;
			count++;
		}
		return s;
	}
	public Solution runSimulatedAnnealing(){
		Solution s = this;
		Solution s_store = s;
		int count = 0;
		while (count < Main.MAX_ITER){
			Solution rand_neighbor = s.getRandNeigbor();
			if (rand_neighbor.getResidue() < s.getResidue())
				s = rand_neighbor;
// TODO Probability function
			}
		if (s.getResidue() < s_store.getResidue())
			return s;
		else
			return s_store;
	}
}
