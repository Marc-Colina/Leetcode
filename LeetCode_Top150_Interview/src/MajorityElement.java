import java.util.HashMap;

//Given an array nums of size n, return the majority element.
//
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
//
//
//
//Example 1:
//
//Input: nums = [3,2,3]
//Output: 3
//Example 2:
//
//Input: nums = [2,2,1,1,1,2,2]
//Output: 2

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
