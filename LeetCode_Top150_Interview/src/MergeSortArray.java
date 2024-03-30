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
        int nums1Index = m-1;
        int nums2Index = n-1;
        int counter = m + n -1;
        if(nums1.length == 0)
            nums1 = nums2;
        else if(nums2.length > 0)
        {
            while(counter>=0)
            {
                if(nums1Index<0)
                {
                    nums1[counter] = nums2[nums2Index];
                    nums2Index--;
                }
                else if(nums2Index<0)
                {
                    nums1[counter] = nums1[nums1Index];
                    nums1Index--;
                }
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
