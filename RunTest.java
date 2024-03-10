public class RunTest {
    public static void printState(int [] state){
        System.out.println(state[0]+" "+state[1]);
    }
    public static void printSolution(Node solution){
        
        while(solution.parent!=null){
            RunTest.printState(solution.state);
            System.out.print("| ");
            solution.action.printAction();
            System.out.println("V");
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
