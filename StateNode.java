/**
 * Used to build a search tree across the world-state graph
 */
public class StateNode {
	public StateNode prev;
	public Action act;
	public WorldState state;
	public int actsFromStart;
	
	public StateNode(StateNode prev, Action act, WorldState state, int actsFromStart) {
		this.prev = prev;
		this.act = act;
		this.state = state;
		this.actsFromStart = actsFromStart;
	}
}
