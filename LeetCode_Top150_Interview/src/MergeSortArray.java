import java.util.Arrays;

//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
//
//
//
//Example 1:
//
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
//        Example 2:
//
//Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
//Explanation: The arrays we are merging are [1] and [].
//The result of the merge is [1].
//Example 3:
//
//Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//Output: [1]
//Explanation: The arrays we are merging are [] and [1].
//The result of the merge is [1].
//Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
public class MergeSortArray {

    public static void main(String... args)
    {
        merge(new int [] {4,5,6,0,0,0}, 3, new int[]{1,2,3}, 3);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //We need to create pointers for both nums1 and nums 2 array. Since arrays are 0-based,
        //we subtract 1 to m (length of nums1) and n (length of nums 2). Since its given that both
        //of our arrays are arranged in ascending order and we want to populate our result array (which is nums1 array)
        //by filling out the largest elements(elements to the rightmost of the array) first, we assign our pointers
        //to the last element and then we will traverse it from right to left.
        int nums1Index = m-1;
        int nums2Index = n-1;

        //We also need a counter that holds the total length of both arrays. We will be needing this
        //counter when we are doing the actual insertion of array elements in their proper order.
        int counter = m + n -1;

        //We want to return early as much as we can. If nums1.length == 0, meaning our nums2 is automatically the
        //result array
        if(nums1.length == 0)
            nums1 = nums2;

        //Notice we did not check if nums1.length > 0. This is because we only need to make sure that
        //our nums 2 contain something before we proceed with our code. because if nums2 is empty, then automatically
        //our result will be nums1 which is as is.
        else if(nums2.length > 0)
        {
            //We set our counter to the last element in the nums1 array because we don't want to create another array
            //to temporarily store our data. Since the last elements of nums1 are all 0s let's utilize it and start inserting
            //elements from there.
            while(counter >= 0)
            {
                //If this condition is true, meaning, we have fully traversed the nums1 array and have successfully
                //inserted them in the resulting array and so all we're gonna do is transfer all the remaining elements in
                // nums2 to fill out the remaining spaces in nums1 (the result array).
                if(nums1Index < 0)
                {
                    nums1[counter] = nums2[nums2Index];
                    nums2Index--;
                }
                //In the same way, if this condition is true, meaning, we have fully traversed the nums2 array
                //and have successfully inserted the nums2 array in the resulting array
                //so all we're gonna do is transfer all the remaining elements in nums1 to fill out
                //the remaining spaces in nums1 (the result array).
                else if(nums2Index < 0)
                {
                    nums1[counter] = nums1[nums1Index];
                    nums1Index--;
                }
                //If the program reaches this else if, meaning there are still items to traverse in both nums1 and nums2.
                //For it to determine which should be inserted first,we will have to compare the values being pointed
                //in our nums1 array and nums2 array. If the nums1 value is bigger than or equal to the nums2 value,
                //the nums1 value should be the one inserted in the resulting array. We then subtract nums1Index to move
                //the pointer 1 step to the left, meaning we have inserted the element from nums1 already. The current nums2 pointer
                //will remain where it is until its value is bigger or equal to the current value being pointed in nums1.
                //When this happens the nums2Index will then be subtracted signaling that we are moving one step to the left
                //in nums2 because we have already inserted the current nums2 element.
                else if(nums1[nums1Index] >= nums2[nums2Index])
                {
                    nums1[counter] = nums1[nums1Index];
                    nums1Index--;
                }
                else
                {
                    nums1[counter] = nums2[nums2Index];
                    nums2Index--;
                }
                //For every iteration of this loop, an item for sure will be inserted in the resulting array so we have
                //to decrement the counter until all the elements are accounted for.
                counter--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}

//FIRST SOLUTION (Additional runtime added in copying)

//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int [] nums1Temporary = new int[m+n];
//        System.arraycopy(nums1, 0, nums1Temporary, 0,m+n);
//
//        int nums1Index = 0;
//        int nums2Index = 0;
//        if(nums1.length == 0)
//            nums1 = nums2;
//        else if(nums2.length > 0)
//        {
//            for(int counter = 0; counter < nums1.length; counter++)
//            {
//                if(nums1Index >= m)
//                {
//                    nums1[counter] = nums2[nums2Index];
//                    nums2Index++;
//                }
//                else if(nums2Index >= n){
//                    nums1[counter] = nums1Temporary[nums1Index];
//                    nums1Index++;
//                }
//                else
//                {
//                    if(nums1Temporary[nums1Index] <= nums2[nums2Index])
//                    {
//                        nums1[counter] = nums1Temporary[nums1Index];
//                        nums1Index++;
//                    }
//                    else
//                    {
//                        nums1[counter] = nums2[nums2Index];
//                        nums2Index++;
//                    }
//                }
//            }
//        }
//        System.out.println(Arrays.toString(nums1));
//    }
