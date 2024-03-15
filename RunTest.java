public class RunTest {
    public static void printState(int [] state){
        System.out.println(state[0]+" "+state[1]);
    }
    public static void printSolution(Node solution){
        System.out.println("The solution path:");
        while(solution.parent!=null){
            RunTest.printState(solution.state);
            System.out.println("/\\");
            System.out.print("| ");
            solution.action.printAction();
            
            solution=solution.parent;
        }
        RunTest.printState(solution.state);
    }


    public static void main(String[] args) {
        Node solution=breadthFirstSearch.graphBFS();
        if(solution==null){
            System.out.println("no solution");
        }
        else{
            RunTest.printSolution(solution);
        }
    }
}
