import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 * Implements the A* algorithm for forward-chaining planning
 */
public class AStar implements Search {
	private PriorityQueue<StateNode> heap;
	private Set<String> visitedStates;
	
	/**
	 * @param start Start state of the world
	 */
	public AStar(WorldState start) {
		Comparator<StateNode> comp = new SearchComparator();
		this.heap = new PriorityQueue<StateNode>(64, comp);
		this.visitedStates = new HashSet<String>();
		
		StateNode startNode = new StateNode(null, null, start, 0);
		this.heap.add(startNode);
	}
	
	public Action[] run() {
		return run(false);
	}
	
	public Action[] run(boolean debug) {
		// while the heap is non-empty, keep popping and calling expand()
		while(!this.heap.isEmpty()) {
			StateNode node = this.heap.poll();
			if(this.visitedStates.contains(node.state.toString())) {
				continue;
			} else {
				this.visitedStates.add(node.state.toString());
			}
			
			if(debug) {
				System.out.println("heap: " + this.heap.size() + " visited: " + this.visitedStates.size());
			}
			
			if(node.state.hasBananas()) {
				// We have the bananas 🎉🎉🎉!!
				return getPath(node);
			}
			
			expand(node);
		}
		return null;
	}
	
	/**
	 * Gets all possible actions from the current state and adds them to
	 * the heap
	 * @param node
	 */
	private void expand(StateNode node) {
		for(Action action : node.state.getActions()) {
			WorldState newState = action.applyPostConditions(node.state);
			StateNode newNode = new StateNode(node, action, newState, node.actsFromStart+1);
			this.heap.add(newNode);
		}
	}
	
	private Action[] getPath(StateNode goalNode) {
		// Create a linked list and call backTrack
		Stack<Action> actions = new Stack<Action>();
		backTrack(goalNode, actions);
		
		// Then, add everything from the list into an array in reverse, then
		// return the array
		Action[] actionsArray = new Action[actions.size()-1];
		int i = 0;
		actions.pop();
		while(!actions.isEmpty()) {
			actionsArray[i] = actions.pop();
			i++;
		}
		
		return actionsArray;
	}
	
	private void backTrack(StateNode node, Stack<Action> actions) {
		// Backtrack from node to the start and add them to actions
		if(node != null) {
			actions.add(node.act);
			backTrack(node.prev, actions);
		}
	}
}
