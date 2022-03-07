import java.util.*;

public class Grab extends Action {
    private String operatorName = "Grab";

    public Grab(){
    }

    public String getOpName(){
        return operatorName;
    }

    public boolean checkPreconditions(WorldState worldState) {
        if(!worldState.getRoomMonkeyIn().equalsIgnoreCase(worldState.getRoomBananasIn())){
            return false;
        }

        if(!worldState.isMonkeyHeight("high")){
            return false;
        }

        return true;
    }
    
    public WorldState applyPostConditions(WorldState worldState) {
        WorldState newWorld = new WorldState(worldState.getRoomMonkeyIn(), worldState.getRoomBananasIn(), worldState.getRoomBoxIn(), "high", true);
        return newWorld;
    }
    
}