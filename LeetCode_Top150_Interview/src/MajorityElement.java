import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int [] nums= {21,8,900,1,1,1,1,1,2,3,4,5,6,7,1,1,1,1};
        System.out.println("Majority Element : " + majorityElement(nums));
    }

    public static int majorityElement(int[] nums)
    {
       int count = 0;
       int candidate = 0;

       for(int num : nums)
       {
           if(count == 0)
           {
               candidate = num;
               count++;
           }
           else if(candidate == num)
           {
               count++;
           }
           else{
               count--;
           }
       }
       return candidate;
    }

//    public static int majorityElement(int[] nums)
//    {
//        int majorityElement = 0;
//        HashMap<Integer, Integer>  map = new HashMap<>();
//        for(int number : nums)
//        {
//            if(map.containsKey(number))
//            {
//                int currentCount = map.get(number);
//                map.put(number, ++currentCount);
//            }
//            else{
//                map.put(number,1);
//            }
//        }
//
//        for(int key: map.keySet())
//        {
//            if(map.get(key) > nums.length/2)
//                majorityElement = key;
//        }
//        return majorityElement;
//    }
}
