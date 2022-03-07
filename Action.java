/**
 * Abstract class to represent actions
 */
public abstract class Action {
	public abstract WorldState applyPostConditions(WorldState worldState);
	public abstract String getOpName();
	public String toString() {
		return getOpName();
	}
}