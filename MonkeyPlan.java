import java.util.*;

/**
 * Used for planning a monkey grabbing a banana from up high
 */
public class MonkeyPlan{
    
    private static Scanner sc = new Scanner(System.in);

    public MonkeyPlan(){
    }
    
    /**
     * Get user input on the initial world state and then make a plan to get
     * the bananas
     */
    public void makePlan(){
        WorldState initState = getUserInput();
        Action[] actions = new AStar(initState).run();
        
        if(actions != null) {
            System.out.println("Plan:");
            for(Action act : actions) {
                System.out.println("\t" + act);
            }
        } else {
            System.out.println("No plan found!");
        }
    }

    public WorldState getUserInput(){
        String mStart = "", baStart = "", boStart = "";
        // Select monkey starting position
        while(mStart.equals("")) {
            System.out.print("Select which room the monkey starts in:\n[1] Room A\n[2] Room B\n[3] Room C\n==>");
            
            String choice = sc.nextLine().toUpperCase();
            switch(choice.charAt(0)) {
                case 'A':
                case '1': 
                    mStart = "A";
                    break;
                case 'B':
                case '2':
                    mStart = "B";
                    break;
                case 'C':
                case '3':
                    mStart = "C";
                    break;
                default:
                    System.out.println("Please enter a valid response");
            }
        }
        // Select box starting position
        while(boStart.equals("")) {
            System.out.print("Select which room the box starts in:\n[1] Room A\n[2] Room B\n[3] Room C\n==>");
            
            String choice = sc.nextLine().toUpperCase();
            switch(choice.charAt(0)) {
                case 'A':
                case '1': 
                    boStart = "A";
                    break;
                case 'B':
                case '2':
                    boStart = "B";
                    break;
                case 'C':
                case '3':
                    boStart = "C";
                    break;
                default:
                    System.out.println("Please enter a valid response");
            }
        }
        // Select banana starting position
        while(baStart.equals("")) {
            System.out.print("Select which room the bananas start in:\n[1] Room A\n[2] Room B\n[3] Room C\n==>");
            
            String choice = sc.nextLine().toUpperCase();
            switch(choice.charAt(0)) {
                case 'A':
                case '1': 
                    baStart = "A";
                    break;
                case 'B':
                case '2':
                    baStart = "B";
                    break;
                case 'C':
                case '3':
                    baStart = "C";
                    break;
                default:
                    System.out.println("Please enter a valid response");
            }
        }
        
        WorldState w = new WorldState(mStart, baStart, boStart, "low", false);
        return w;
    }
}
