import java.util.Comparator;

public class SearchComparator implements Comparator<StateNode> {
	public SearchComparator() {
		
	}
	
	@Override
	public int compare(StateNode node1, StateNode node2) {
		int diff = (node1.state.distance() + node1.actsFromStart)
			- (node2.state.distance() + node2.actsFromStart);
		return (int) Math.signum(diff);
	}
}
