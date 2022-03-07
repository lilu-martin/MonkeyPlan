import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class AStar implements Search {
	private PriorityQueue<StateNode> heap;
	
	
	public AStar(WorldState start) {
		Comparator<StateNode> comp = new SearchComparator();
		this.heap = new PriorityQueue<StateNode>(64, comp);
		
		StateNode startNode = new StateNode(null, null, start, 0);
		this.heap.add(startNode);
	}
	
	public Action[] run() {
		// while the heap is non-empty, keep popping and calling expand()
		while(!this.heap.isEmpty()) {
			StateNode node = this.heap.poll();
			
			if(node.state.hasBananas()) {
				// We have the bananas 🎉🎉🎉!!
				return getPath(node);
			}
			
			expand(node);
		}
		return null;
	}
	
	private void expand(StateNode node) {
		// Gets all possible actions from the current state and adds them to
		// the heap
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
		Action[] actionsArray = new Action[actions.size()];
		int i = 0;
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
