import java.util.HashMap;

//Given an array nums of size n, return the majority element.
//
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always
// exists in the array.
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
        //In this approach, we are adding to the count everytime we see a number that's the same
        //with the number in the candidate, and we subtract the count when we see a different number.
        //We will only be changing the candidate once the count is equal to 0. Through this approach,
        //once we finished traversing the array, the element with the most occurrence (which is the majority element
        // assuming that there always will be one) will remain as candidates value.
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

    //This is another approach utilizing a HashMap. We traverse the nums array and put them in a HashMap.
    public static int majorityElementHashMap(int[] nums)
    {
        int majorityElement = 0;
        HashMap<Integer, Integer>  map = new HashMap<>();
        for(int number : nums)
        {
            //We will use the numbers in the array as key and the value as the number of occurrences in the array.
            // If the map already contains the number, we fetch the current value and add one to it.
            if(map.containsKey(number))
            {
                int currentCount = map.get(number);
                map.put(number, ++currentCount);
            }
            //If the map does not yet contain the number, we put the number and put a value of 1 which means it's the
            //first time we are encountering that number.
            else{
                map.put(number,1);
            }
        }

        //By the end of the iteration, we would already have all the numbers with the number of occurrences in our HashMap.
        //We then loop through our keys, get the value and check if it is greater than nums.length/2 (which is the formula
        //that qualifies a majority element). Since there can't be more than one whose value is greater than nums.length/2,
        //we are able to fetch our majority element.
        for(int key: map.keySet())
        {
            if(map.get(key) > nums.length/2)
                majorityElement = key;
        }
        return majorityElement;
    }
}
