public class Node {
    int state[];
    Action action;
    Node parent;


    public Node(int state[], Node parent, Action action){
        this.state=state;
        this.parent=parent;
        this.action=action;
    }
    public Node getChildNode(Node parent, Action action){
        return new Node(Problem.TRANSITION_MODEL(parent.state, action), parent, action);
    }
}
