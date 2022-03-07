import java.util.*;

public class ClimbUp extends Action {
    private String operatorName = "CLIMBUP";

    public ClimbUp(){
    }

   
    public String getOpName(){
        return operatorName;
    }

    public boolean checkPreconditions(WorldState worldState) {
        if(!worldState.getRoomMonkeyIn().equalsIgnoreCase(worldState.getRoomBoxIn())){
            return false;
        }

        if(!worldState.isMonkeyHeight("low")){
            return false;
        }

        return true;
    }

    public WorldState applyPostConditions(WorldState worldState) {
        WorldState newWorld = new WorldState(worldState.getRoomMonkeyIn(), worldState.getRoomBananasIn(), worldState.getRoomBoxIn(), "high", false);
        return newWorld;
    }
}