import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.StringTemplate.STR;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};

        rotate(nums,3);
        for(int num : nums)
        {
            System.out.print(STR."\{num} ");
        }
    }

    //Solution that got accepted and I'm satisfied with
    public static void rotate(int[] nums, int k)
    {
        if(k % nums.length == 0)
            return;

        //If the length of the array is equal to k, it would just do a 360 rotation and
        //go back to its original order. It is unnecessary to waste time doing this, so we will
        //only start rotating x (the remainder when we divide k to the array length) times.
        k = k % nums.length;

        //If we are given an array with values 1 2 3 4 5 6 7 and k = 3.
        //We have to first reverse 1 2 3 4 because they are the elements that will be pushed to the right since
        //only the last 3 elements will be rotated to the left side. After this line of code below executes,
        //the array will become 4 3 2 1 5 6 7. We are passing the parameters 0 as the posFrom since we will
        //always need to reverse from the leftmost item in the array. We are then passing the nums.length - k - 1
        //as the posTo because if k = 3, meaning, we shouldn't touch the last 3 remaining elements. To achieve
        //this we need the index 7-3-1 (nums.length - k - 1) = 3
        reverse(nums,0, nums.length - k - 1);

        //In the same manner, we also have to reverse those values that will be rotated to the left. In our example,
        //it's going to be the last 3 numbers which are 5 6 7. To get the last 3 numbers, we have to subtract nums.length-k
        //because this will give us 7-3 = 4. 4 is the index we are interested in because the last 3 elements can be found
        //in indeces 4,5, and 6. After this line of code executes, we will now have 4 3 2 1 7 6 5.
        reverse(nums,nums.length-k,nums.length-1);

        //Finally, after those two reverses, we now then reverse the whole array so we'll be passing 0 and the
        // nums.length-1 (since arrays are 0-based). After this line executes, we will then have 5 6 7 1 2 3 4.
        reverse(nums,0,nums.length-1);
    }

    //This is a helper method responsible for the reversing. It accepts the array, the starting position and the
    //ending position in the array that we want to reverse.
    public static void reverse(int[] nums, int posFrom, int posTo)
    {
        //We have this while condition because every after the swap say from index 0 to index 4
        //we need to decrement posTo and increment posFrom to swap the remaining numbers. After this,
        // we are now swapping index 1 to index 3  and then that should be it.
        // In the next iteration the posTo will be 2 and posFrom will be 2. This should signify that there are no
        //more elements to swap
        while(posFrom < posTo)
        {
            int temp = nums[posFrom];
            nums[posFrom] = nums[posTo];
            nums[posTo] = temp;
            posFrom++;
            posTo--;
        }
    }

    //SOLUTION GOT ACCEPTED, BEAT ALMOST 90% OF JAVA USERS IN MEMORY BUT ONLY BEAT 5% OF JAVA USERS IN RUNTIME - I AM NOT SATISFIED >:(
//    public static void rotate(int[] nums,int k)
//    {
//        if(k % nums.length == 0) {
//            return;
//        }
//
//        //If the length of the array is equal to k, it would just do a 360 rotation and
//        //go back to its original order. It is unnecessary to waste time doing this, so we will
//        //only start rotating x (the difference between k and the array length) times.
//        k = k % nums.length;
//
//        IntStream numsToRotateStream = Arrays.stream(nums,nums.length-k,nums.length);
//        IntStream numsToNotRotateStream = Arrays.stream(nums,0,nums.length-k);
//        IntStream concatenatedStream = IntStream.concat(numsToRotateStream,numsToNotRotateStream);
//
//        int[] result = concatenatedStream.toArray();
//        int counter = 0;
//        for(int num : result)
//        {
//            nums[counter] = num;
//            counter++;
//        }
//    }



    //SOLUTION DID NOT GET ACCEPTED
//    public  static void  rotate(int[] nums,int k)
//    {
//
//        int numsArraySize = nums.length;
//        if(k % numsArraySize == 0) {
//            return;
//        }
//
//        //If the length of the array is equal to k, it would just do a 360 rotation and
//        //go back to its original order. It is unnecessary to waste time doing this, so we will
//        //only start rotating x (the difference between k and the array length) times.
//        k = k % numsArraySize;
//
//        int[] tempArray = new int[numsArraySize-k];
//        int counterStart = 0;
//        int counterStartIftempArrayLenghtIsOdd = 1;
//        int counterTransfer = tempArray.length-1;
//        int counterMiddle = k-1;
//        for(int counterEnd = numsArraySize -1; counterStart < numsArraySize; counterEnd--)
//        {
//            if(counterStart<tempArray.length)
//            {
//                if(nums.length %2 != 0)
//                {
//                    tempArray[0] = nums[k];
//                    if(counterMiddle >= 0)
//                        tempArray[counterStartIftempArrayLenghtIsOdd] = nums[counterMiddle];
//                    else {
//                        if(counterStartIftempArrayLenghtIsOdd<tempArray.length)
//                            tempArray[counterStartIftempArrayLenghtIsOdd] = nums[counterStart];
//                    }
//                    counterStartIftempArrayLenghtIsOdd++;
//                }
//                else {
//                    if (counterMiddle >= 0)
//                        tempArray[counterStart] = nums[counterMiddle];
//                    else {
//                        tempArray[counterStart] = nums[counterStart];
//                    }
//                }
//
//                for(int num : tempArray)
//                {
//                    System.out.print(num + " ");
//                }
//                System.out.println();
//                //System.out.print("Temp Array : " + tempArray[counterStart]);
//            }
//
//            if(counterEnd >= numsArraySize-k) {
//                nums[counterMiddle] = nums[counterEnd];
//                //System.out.println("Counter Start " + counterStart);
//                counterMiddle--;
//            }
//            else
//            {
//                nums[counterStart] = tempArray[counterTransfer];
//                //System.out.println("Counter Transfer " + counterStart);
//                counterTransfer--;
//            }
//            counterStart++;
//
//        }
//    }

}
