import java.util.*;

public class Push extends Action {
    private String operatorName = "PUSH";
    private String pushFrom;
    private String pushTo;

    public Push(String from, String to){
        this.pushFrom = from;
        this.pushTo = to;
    }

   
    public String getOpName(){
        return operatorName;
    }

    public boolean checkPreconditions(WorldState worldState) {
        if(!worldState.getRoomMonkeyIn().equalsIgnoreCase(worldState.getRoomBoxIn())){
            return false;
        }

        if(!worldState.getRoomMonkeyIn().equalsIgnoreCase(this.pushFrom)){
            return false;
        }

        if(worldState.getRoomMonkeyIn().equalsIgnoreCase(this.pushTo)){
            return false;
        }

        if(!worldState.isMonkeyHeight("low")){
            return false;
        }

        return true;
    }

    public WorldState applyPostConditions(WorldState worldState) {
        WorldState newWorld = new WorldState(this.pushTo, worldState.getRoomBananasIn(), this.pushTo, "low", false);
        return newWorld;
    }
}