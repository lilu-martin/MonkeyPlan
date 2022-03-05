import java.util.*;

public class ClimbDown {
    private String operatorName = "CLIMBDOWN";

    public ClimbDown(){
    }

    
    public String getOpName(){
        return operatorName;
    }

    public boolean checkPreconditions(WorldState worldState) {
        if(!worldState.getRoomMonkeyIn().equalsIgnoreCase(worldState.getRoomBoxIn())){
            return false;
        }

        if(!worldState.isMonkeyHeight("high")){
            return false;
        }

        return true;
    }

    public WorldState applyPostconditions(WorldState worldState) {
        WorldState newWorld = new WorldState(worldState.getRoomMonkeyIn(), worldState.getRoomBananasIn(), worldState.getRoomBoxIn(), "low", false);
        return newWorld;
    }
}