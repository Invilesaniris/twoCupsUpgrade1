import java.util.LinkedList;
import java.util.ArrayList;

public class breadthFirstSearch {
    
    public static boolean isNotInFrontier(Node node, LinkedList<Node> frontier){
        for(int i=0; i<frontier.size(); ++i){
            if(node.state[0]==frontier.get(i).state[0] && node.state[1]==frontier.get(i).state[1])
                return false;
        }
        return true;
    }
    public static boolean isNotInExplored(int state[], ArrayList<int[]> explored){
        for(int i=0; i<explored.size(); ++i){
            if(state[0]==explored.get(i)[0] && state[1]==explored.get(i)[1])
                return false;
        }
        return true;
    }
    public static Node graphBFS(){
        Node intialNode=new Node(Problem.initialState, null, null);
        LinkedList<Node> frontier=new LinkedList<Node>();
        ArrayList<int[]> explored=new ArrayList<int[]>();
        if(Problem.isGoal(intialNode.state)){
            return intialNode;
        }
        frontier.addLast(intialNode);
        Node currentNode=null;
        System.out.println();
       
        while (!frontier.isEmpty()) {
            currentNode=frontier.removeFirst();
            explored.add(currentNode.state);
            System.out.print("Current node: ");
            RunTest.printState(currentNode.state);
            System.out.println("illegal Actions:");
            ArrayList<Action> legalActions=Problem.ACTIONS(currentNode.state);
            Node childNode;
            System.out.println("ajacent states:");
            ArrayList<int[]> adjacentStates=Problem.adjacentStates(currentNode.state);
            for(int i=0; i<adjacentStates.size(); ++i){
                RunTest.printState(adjacentStates.get(i));
            }
            
            System.out.println("legal child state:");
            for(int i=0; i<legalActions.size(); ++i){
                childNode=currentNode.getChildNode(currentNode, legalActions.get(i));
                if(isNotInFrontier(childNode, frontier) && isNotInExplored(childNode.state, explored)){
                    RunTest.printState(childNode.state);
                    if(Problem.isGoal(childNode.state)){
                        return childNode;
                    }
                    frontier.addLast(childNode);
                }
            }
            
            System.out.println("OPEN:");
            for(int i=0; i<frontier.size(); ++i){
                RunTest.printState(frontier.get(i).state);
            }
            System.out.println("CLOSED:");
            for(int i=0; i<explored.size(); ++i){
                RunTest.printState(explored.get(i));
            }
            System.out.println("Legal Actions:");
            for(int i=0; i<legalActions.size(); ++i){
                legalActions.get(i).printAction();
            }
            System.out.println("---------------");
            

        }
        return null;
    }


}
