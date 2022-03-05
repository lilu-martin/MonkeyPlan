import java.util.*;

public class Push {
    private String operatorName = "PUSH";
    private String pushFrom;
    private String pushTo;

    public Push(String from, String to){
        this.pushFrom = from;
        this.pushTo = to;
    }

    /*public boolean checkPreconditions(WorldState worldState) {
        if(!worldState.isMonkeyAt(moveFrom)){
            return false;
        }

        if(!worldState.isMonkeyHeight(WorldState.HEIGHT_LOW)){
            return false;
        }

        return true;
    }

    public WorldState applyPostconditions(WorldState worldState) {
        //create and return a new WorldState
        //with the monkey’s updated location
    }*/
}