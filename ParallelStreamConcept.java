import java.util.*;

public class ParallelStreamConcept {
    public static void main(String[] args) {
        int size = 1000;
        List<Integer> nums = new ArrayList<>(size);

        Random ran = new Random();

        for(int i=1; i<size;i++){
            nums.add(ran.nextInt(100));
        }

        long startSt = System.currentTimeMillis();

        int s1 = nums.stream().map(i -> {
            try{
                Thread.sleep(1);
            }catch(Exception e){}
            return i*2;
        }).reduce(0, (c,e) -> c+e);
        
        long endSt = System.currentTimeMillis();

        long timegap1 = endSt - startSt;

        long startPara = System.currentTimeMillis();

        int s2 = nums.parallelStream().map(i -> {
            try{
                Thread.sleep(1);
            }catch(Exception e){}
            return i*2;
        }).mapToInt(i -> i).sum();

        long endPara = System.currentTimeMillis();

        long timegap2 = endPara - startPara;


        System.out.println(s1 + " : Time Taken : " + timegap1);
        System.out.println(s2 + " : Time Taken : " + timegap2);

    }
}
