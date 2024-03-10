import java.util.ArrayList;



class Problem{
    static public int initialState[]={0,0};
    
    public static ArrayList<Action> ACTIONS(int state[]){
        ArrayList<Action> legalActions=new ArrayList<Action>();
        int amount;
        boolean isLegalAction []={true,true,true,true,true,true};
        //0 action fill 4l cup from water source
        //1 action fill 3l cup fomr water source
        //2 pour water from 4l to 3l
        //3 pour water from 3l to 4l
        //4 emptry 4l cup
        //5 empty 3l cup

        if(state[0]==0){
            isLegalAction[2]=false;
            isLegalAction[4]=false;
        }
        else if(state[0]==4){
            isLegalAction[0]=false;
            isLegalAction[3]=false;
        }
        
        if(state[1]==0){
            isLegalAction[3]=false;
            isLegalAction[5]=false;
        }
        else if(state[1]==3){
            isLegalAction[1]=false;
            isLegalAction[2]=false;
        }

        for(int i=0; i<isLegalAction.length; ++i){
            if(isLegalAction[i]==true){
                switch (i) {
                    case 0:
                    {
                        legalActions.add(new Action("water source", "4l cup", 4-state[0]));
                        break;
                    }
                    case 1:
                    {
                        legalActions.add(new Action("water source", "3l cup", 3-state[1]));
                        break;
                    }
                    case 2:{
                        legalActions.add(new Action("4l cup", "3l cup", Math.min(state[0], 3-state[1])));
                        break;
                    }
                    case 3:{
                        legalActions.add(new Action("3l cup", "4l cup", Math.min(state[1], 4-state[0])));
                        break;
                    }
                    case 4:{
                        legalActions.add(new Action("4l cup", "ground", state[0]));
                        break;
                    }
                    case 5:{
                        legalActions.add(new Action("3l cup", "ground", state[1]));
                        break;
                    }

                }
            }
            else{
                switch (i) {
                    case 0:
                    {
                        System.out.println("from water source to 4l cup");
                        break;
                    }
                    case 1:
                    {
                        System.out.println("from water source to 3l cup");
                        break;
                    }
                    case 2:{
                        System.out.println("from 4l cup to 3l cup");
                        break;
                    }
                    case 3:{
                        System.out.println("from 3l cup to 4l cup");
                        break;
                    }
                    case 4:{
                        System.out.println("from 4l cup to ground");
                        break;
                    }
                    case 5:{
                        System.out.println("from 3l cup to ground");
                        break;
                    }

                }
            }
        }

        return legalActions;
    }
    public static int[] TRANSITION_MODEL(int state[], Action action){
        int newState[]={state[0], state[1]};


        if(action.to!="ground"){
            if(action.to=="4l cup"){
                newState[0]=newState[0]+action.amount;
            }
            else{
                newState[1]=newState[1]+action.amount;
            }
        }
        if(action.from!="water source"){
            if(action.from=="4l cup"){
                newState[0]=newState[0]-action.amount;
            }
            else{
                newState[1]=newState[1]-action.amount;
            }
        }

        return newState;
    }
    public static boolean isGoal(int state[]){
        return (state[0]==2 || state[1]==2);
    }

    public static void main(String[] args) {
        int state[]={4,0};
        ArrayList<Action> legalActions=Problem.ACTIONS(state);
        for(int i=0; i<legalActions.size(); ++i){
            legalActions.get(i).printAction();
            System.out.println("new state:");
            int newState[]=Problem.TRANSITION_MODEL(state, legalActions.get(i));
            System.out.println(newState[0]+"|"+newState[1]);
        }
        
    }
}