import java.util.Comparator;

/**
 * A comparator to compare two StateNodes
 */
public class SearchComparator implements Comparator<StateNode> {
	public SearchComparator() {
		
	}
	
	@Override
	/**
	 * Compares @param node1 and @param node1 based on which is closer to the goal
	 * @return -1 if @param node1 is close, 1 if @param node1 is closer, 0 otherwise
	 */
	public int compare(StateNode node1, StateNode node2) {
		int diff = (node1.state.distance() + node1.actsFromStart)
			- (node2.state.distance() + node2.actsFromStart);
		return (int) Math.signum(diff);
	}
}
