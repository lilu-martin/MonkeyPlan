import java.util.*;

public class WorldState {
    private String roomMonkeyIn;
    private String roomBoxIn;
    private String roomBananasIn;
    private String monkeyHeight;
    private boolean hasBanana;

    public static final String ROOM_A = "A";
    public static final String ROOM_B = "B";
    public static final String ROOM_C = "C";

    public WorldState(String roomM, String roomBa, String roomBo, String heightM, boolean hasB){
        this.roomMonkeyIn = roomM;
        this.roomBananasIn = roomBa;
        this.roomBoxIn = roomBo;
        this.monkeyHeight = heightM;
        this.hasBanana = hasB;
    }
    
    public Action[] getActions() {
        List<Action> actions = new ArrayList<Action>();
        
        String[] pls = {"A", "B", "C"};
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                Move m = new Move(pls[i], pls[j]);
                if(m.checkPreconditions(this)){
                    actions.add(m);
                }
                Push p = new Push(pls[i], pls[j]);
                if(p.checkPreconditions(this)){
                    actions.add(p);
                }
            }
        }
        // Add in the climbs
        if(this.roomBoxIn.equals(this.roomMonkeyIn)) {
            actions.add("low".equals(this.monkeyHeight) ? new ClimbUp() : new ClimbDown());
        }
        // Add in the grab
        if(this.roomBananasIn.equals(this.roomMonkeyIn) && "high".equals(this.monkeyHeight)) {
            System.out.println("Able to grab 🎉🎉🎉🎉🎉!");
            actions.add(new Grab());
        }
        
        // Convert the linked list into an array
        Action[] actionsArray = new Action[actions.size()];
        int i = 0;
        for(Action act : actions) {
            actionsArray[i] = act;
            i++;
        }
        return actionsArray;
    }
    
    public int distance() {
        if(this.hasBanana) {
            return 0;
        }
        
        int dist = 1;
        
        if(this.roomMonkeyIn != this.roomBoxIn) {
            dist += 1;
        }
        if(this.roomMonkeyIn != this.roomBananasIn) {
            dist += 1;
        }
        if(this.roomBoxIn != this.roomBananasIn) {
            dist += 10;
        }
        if(this.monkeyHeight != "high") {
            dist += 1;
        }
            
        return dist;
    }

    public String getRoomMonkeyIn(){
        return this.roomMonkeyIn;
    }

    public String getRoomBananasIn(){
        return this.roomBananasIn;
    }

    public String getRoomBoxIn(){
        return this.roomBoxIn;
    }

    public String getMonkeyHeight(){
        return this.monkeyHeight;
    }

    public boolean hasBananas(){
        return this.hasBanana;
    }

    public boolean isMonkeyAt(String room) {
        return this.roomMonkeyIn.equalsIgnoreCase(room);
    }

    public boolean isBananaAt(String room) {
        return this.roomBananasIn.equalsIgnoreCase(room);
    }

    public boolean isBoxAt(String room) {
        return this.roomBoxIn.equalsIgnoreCase(room);
    }
    public boolean isMonkeyHeight(String h){
        return this.monkeyHeight.equalsIgnoreCase(h);
    }

    public WorldState clone() {
        return new WorldState(
            this.roomMonkeyIn,
            this.roomBananasIn,
            this.roomBoxIn,
            this.monkeyHeight,
            this.hasBanana
        );
    }
    
    public String toString() {
        return "WorldState(" 
            + this.roomMonkeyIn + "," 
            + this.roomBananasIn + "," 
            + this.roomBoxIn + "," 
            + this.monkeyHeight + "," 
            + this.hasBanana + ")";
    }
}