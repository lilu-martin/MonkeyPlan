import java.util.*;

public class Push {
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

        if(!worldState.getRoomMonkeyIn().equalsIgnoreCase(this.pushFrom))

        if(!worldState.isMonkeyHeight("low")){
            return false;
        }

        return true;
    }

    public WorldState applyPostconditions(WorldState worldState) {
        WorldState newWorld = new WorldState(this.pushTo, worldState.getRoomBananasIn(), this.pushTo, "low", false);
        return newWorld;
    }
}