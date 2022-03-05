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

}
