
public interface Solution {
	
	public long getResidue();
	public Solution getRandNeigbor();
	public Solution randSolution();
	
	public Solution runRandom();
	public Solution runHillClimbing();
	public Solution runSimulatedAnnealing();
	
}
