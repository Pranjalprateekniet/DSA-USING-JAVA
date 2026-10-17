import java.util.*;
public class vms {
    static Scanner sc = new Scanner(System.in);
    static HashSet<Integer> voterIds = new HashSet<>();
    static ArrayList<String> voterList = new ArrayList<>();
    static int nextId=0;
    private static void addVoter() {
        System.out.println("Enter your voter id / if does not exist press -1");
        int id = sc.nextInt();
        if (!voterIds.contains(id) && id != -1) {
            System.out.println("Voter id does not exist. Enter the name of the voter");
            String name = sc.next();
            voterList.add(name);
            nextId++;
            voterIds.add(nextId);
            System.out.println("Voter is added with id " + nextId);
        } else if (id == -1) {
            System.out.println("You are not registered.Please register yourself.");
            String name = sc.nextLine();
            voterList.add(name);
            nextId++;
            voterIds.add(nextId);
            System.out.println("You have been registered with id "+nextId);
        } else {
            System.out.println("Voter id already exists");
        }
    }
    static int can1Votes=0;
    static int can2Votes=0;
    static int can3Votes=0;
    static int can4Votes=0;
    static String candidates[] = {"pranjal","prateek","shruti","pratham"};
    private static Map<Integer, String> votes = new HashMap<>();
    private static void castVote() {
        System.out.println("Enter your voter id");
        int id = sc.nextInt();
        if (voterIds.contains(id)) {
            System.out.println("Press 1 for pranjal");
            System.out.println("Press 2 for prateek");
            System.out.println("Press 3 for shruti");
            System.out.println("Press 4 for pratham");
            int choice=sc.nextInt();
            if (choice>=1 && choice<= 4) {
                String candidate=candidates[choice-1];
                if(!votes.containsKey(id)) {
                    votes.put(id, candidate);
                    System.out.println("You have voted for "+candidate);
                    if (choice==1) {
                        can1Votes++;
                    } else if (choice==2) {
                        can2Votes++;
                    } else if (choice==3) {
                        can3Votes++;
                    } else if (choice==4) {
                        can4Votes++;
                    }
                } else {
                    System.out.println("You have already voted");
                }
            } else {
                System.out.println("Invalid choice");
            }
        } else {
            System.out.println("Voter id does not exist");
        }
    }
    private static void showResults() {
        System.out.println("The results for the elections are as follows");
        System.out.println("Votes received by pranjal are"+can1Votes);
        System.out.println("Votes received by prateek are "+can2Votes);
        System.out.println("Votes received by shruti are "+can3Votes);
        System.out.println("Votes received by pratham are "+can4Votes);
    }
    public static void main(String[] args) {
        System.out.println("Enter your choice: ");
        System.out.println("press 1 for adding voter");
        System.out.println("press 2 for casting vote");
        System.out.println("press 3 to show results");
        System.out.println("press 4 for exit");
        int choice = sc.nextInt();
        boolean flag = true;
        while (flag) {
            if (choice==1) {
                addVoter();
            } else if (choice==2) {
                castVote();
            } else if (choice==3) {
                showResults();
            } else if (choice==4) {
                flag = false;
                System.out.println("Program ended");
                return;
            } else {
                System.out.println("Invalid input");
            }
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            System.out.println("press 1 for adding voter");
            System.out.println("press 2 for casting vote");
            System.out.println("press 3 to show results");
            System.out.println("press 4 for exit");
        }
    }
}
/*
 */