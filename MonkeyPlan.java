import java.util.*;

public class MonkeyPlan{
    
    private static Scanner sc = new Scanner(System.in);

    public MonkeyPlan(){}

    public void makePlan(){
        WorldState initState = getUserInput();
        System.out.println("Plan:");
        chooseMoves(initState, 6);
    }

    public WorldState getUserInput(){
        String mStart = "", baStart = "", boStart = "";
        while(!mStart.equalsIgnoreCase("A") && !mStart.equalsIgnoreCase("B") && !mStart.equalsIgnoreCase("C")){
            System.out.print("Select which room the monkey starts in:\n[1] Room A\n[2] Room B\n[3] Room C\n==>");
            mStart = sc.nextLine();
        }
        while(!boStart.equalsIgnoreCase("A") && !boStart.equalsIgnoreCase("B") && !boStart.equalsIgnoreCase("C")){
            System.out.print("Select which room the box starts in:\n[1] Room A\n[2] Room B\n[3] Room C\n==>");
            boStart = sc.nextLine();
        }
        while(!baStart.equalsIgnoreCase("A") && !baStart.equalsIgnoreCase("B") && !baStart.equalsIgnoreCase("C")){
            System.out.print("Select which room the bananas starts in:\n[1] Room A\n[2] Room B\n[3] Room C\n==>");
            baStart = sc.nextLine();
        }
        WorldState w = new WorldState(mStart, baStart, boStart, "low", false);
        return w;
    }

    public boolean chooseMoves(WorldState w, int max){
        if(w.hasBananas()){
            return true;
        }
        if(max == 0){
            return false;
        }
        else{
            String[] pls = {"A", "B", "C"};
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 2; j++){
                    Move m = new Move(pls[i], pls[j]);
                    if(m.checkPreconditions(w)){
                        if(chooseMoves(m.applyPostconditions(w), max-1)){
                            System.out.println("Move(" + pls[i] +", " +pls[j]+")");
                            return true;
        
                        }
                    }
                    Push p = new Push(pls[i], pls[j]);
                    if(p.checkPreconditions(w)){
                        if(chooseMoves(p.applyPostconditions(w), max-1)){
                            System.out.println("Push(" + pls[i] +", " +pls[j]+")");
                            return true;
        
                        }
                    }
                }
            }
        }
        ClimbUp cu = new ClimbUp();
        if(cu.checkPreconditions(w)){
            if(chooseMoves(cu.applyPostconditions(w), max-1)){
                System.out.println("ClimbUp()");
                return true;
        
            }
        }
        ClimbDown cd = new ClimbDown();
        if(cd.checkPreconditions(w)){
            if(chooseMoves(cd.applyPostconditions(w), max-1)){
                System.out.println("ClimbDown()");
                return true;
        
            }
        }
        Grab g = new Grab();
        if(g.checkPreconditions(w)){
            if(chooseMoves(g.applyPostconditions(w), max-1)){
                System.out.println("Grab()");
                return true;
        
            }
        }
        return true;
    }
}
