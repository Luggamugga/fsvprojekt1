package project01;

import java.util.ArrayList;
import java.util.List;

public class RunLength {
    public static <T> List<Run<T>> encode(List<T> input) {
        // Note: you may assume without checking that input contains no null elements.
        // Java will complain if you try something like this:
        //     if(input.contains(null))
        /*
        input: ABBCAAAACCC
        output: (1,A) (2,B) (1,C) (4,A) (3,C)
         */
        List<Run<T>> result = new ArrayList<>();
        
        // TODO: implement this method
        int counter = 1;
        for(int i = 0;i<input.size();i++){
            if(i == input.size()-1){
                Run<T> Tuple = new Run<T>(counter,input.get(i));
                System.out.println(Tuple);
                result.add(Tuple);
                break;
            }
            if(input.get(i) == input.get(i + 1)){
                counter++;
            } else {
                Run<T> Tuple = new Run<T>(counter,input.get(i));
                System.out.println(Tuple);
                result.add(Tuple);
                counter = 1;
            }
        }
System.out.println(result);
        return result;
    }

    public static <T> List<T> decode(List<Run<T>> runs) {
        List<T> result = new ArrayList<>();

        // TODO: implement this method

        return result;
    }

    public static Integer sum(List<Run<Integer>> runs) {
        // TODO: implement this method (you may peek)

        return 0;
    }
}
