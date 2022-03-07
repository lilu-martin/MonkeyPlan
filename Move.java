public class Move extends Action {
    private String operatorName = "Move";
    private String moveFrom;
    private String moveTo;

    public Move(String from, String to){
        this.moveFrom = from;
        this.moveTo = to;
    }

    
    public String getOpName(){
        return operatorName + "(" + this.moveFrom + ", " + this.moveTo + ")";
    }

    public boolean checkPreconditions(WorldState worldState) {
        if(!worldState.getRoomMonkeyIn().equalsIgnoreCase(this.moveFrom)){
            return false;
        }

        if(worldState.getRoomMonkeyIn().equalsIgnoreCase(this.moveTo)){
            return false;
        }

        if(!worldState.isMonkeyHeight("low")){
            return false;
        }

        return true;
    }

    public WorldState applyPostConditions(WorldState worldState) {
        WorldState newWorld = new WorldState(this.moveTo, worldState.getRoomBananasIn(), worldState.getRoomBoxIn(), "low", worldState.hasBananas());
        return newWorld;
    }
}