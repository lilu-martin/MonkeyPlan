import java.util.*;

public class ClimbUp {
    private String operatorName = "CLIMBUP";
    private String heightFrom;
    private String heightTo;

    public ClimbUp(String from, String to){
        this.heightFrom = from;
        this.heightTo = to;
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