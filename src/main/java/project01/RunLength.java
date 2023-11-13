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

        return result;
    }

    public static <T> List<T> decode(List<Run<T>> runs) {
        List<T> result = new ArrayList<>();

        // TODO: implement this method
        if (runs.equals(null)) {
            return result;
        }
        else {
            for (Run<T> element : runs) {
                int c = element.count;
                for (int i = 0; i<element.count; i++) {
                    result.add(element.elem);
                }
            }
            return result;
        }
    }

    public static Integer sum(List<Run<Integer>> runs) {
        // TODO: implement this method (you may peek)
        Integer sum;
        sum = 0;

        for (Run<Integer> element : runs) {
            for (int i = 0; i < element.count; i++) {
                sum += element.elem;
            }
        }


        return sum;
    }
}
