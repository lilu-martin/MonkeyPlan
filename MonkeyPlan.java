import java.util.*;

public class MonkeyPlan{
    
    private static Scanner sc = new Scanner(System.in);

    public MonkeyPlan(){}

    public void makePlan(){
        WorldState initState = getUserInput();
        System.out.println(initState.getRoomMonkeyIn() + " " + initState.getRoomBananasIn()  + " " + initState.getRoomBoxIn());
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
        WorldState w = new WorldState(mStart, baStart, boStart);
        return w;
    }
}