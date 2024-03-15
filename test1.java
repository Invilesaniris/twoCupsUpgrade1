import java.util.HashMap;
import java.lang.*;
public class test1 {
    

    public static void main(String[] args) {
        HashMap<String, Boolean> a=new HashMap<String, Boolean>();

        // int arr[]={"23",6,1,8};
        // for(int i=0; i<arr.length; ++i){
        //     if(a.get(arr[i])==null){
        //         a.put(arr[i], true);
        //     }
        // }
        // System.out.println();
        // for(int i=0; i<arr.length; ++i){
        //     System.out.println(a.get(arr[i]));
        // }
        int arr[]={1,2};
        String str=String.valueOf(arr[0])+String.valueOf(arr[1]);
        System.out.println(str);

    }
}
