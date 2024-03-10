public class Action {
    String from;
    String to;
    int amount;

    public Action(String from, String to, int amount){
        this.from=from;
        this.to=to;
        this.amount=amount;

    }
    public void printAction(){
        System.out.println("from "+this.from+" to "+this.to+" with with amount "+this.amount);
    }
}
