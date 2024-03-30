//Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
//
//Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
//
//Return k after placing the final result in the first k slots of nums.
//
//Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
//
//Custom Judge:
//
//The judge will test your solution with the following code:
//
//int[] nums = [...]; // Input array
//int[] expectedNums = [...]; // The expected answer with correct length
//
//int k = removeDuplicates(nums); // Calls your implementation
//
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//        assert nums[i] == expectedNums[i];
//        }
//If all assertions pass, then your solution will be accepted.
//
//
//
//        Example 1:
//
//Input: nums = [1,1,1,2,2,3]
//Output: 5, nums = [1,1,2,2,3,_]
//Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).
//Example 2:
//
//Input: nums = [0,0,1,1,1,1,2,3,3]
//Output: 7, nums = [0,0,1,1,2,3,3,_,_]
//Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).

public class RemoveDuplicates2 {
    public static void main(String[] args) {

        int[] nums = {1,1,1,1,2,2,2,2,2,3,3,4,5,6,6,6,7,7};
        System.out.println(removeDuplicates(nums));
        for(int num : nums)
        {
            System.out.print(num + " ");
        }
    }

    public static int removeDuplicates(int[] nums)
    {
        //We want to return early if the array is empty or if it only contains one element.
        if(nums.length<2)
            return nums.length;

//        This k variable is what does the trick. This k variable will only be incremented if in the traversal of the array,
//        we encounter a number that's the same and the lessThanTwo variable is true. However, if we encounter a value
//        the same as the value being pointed to by index k, and the lessThanTwo is false meaning there's already 2 of those
//        values in our result array (the array containing elements from the 0-th element to the k-th element), we continue traversing
//        and we don't increment k. The only time we will increment k again is if we encounter a value that's different
//        from the value being pointed by k currently. And when we do, this means we are encountering this value for the first
//        time so we set the lessthanTwo value to true.
        int k = 0;
        boolean lessThanTwo = true;
        for(int counter = 0; counter<nums.length; counter++)
        {
            if(counter<nums.length-1)
            {
                if(nums[k] == nums[counter+1])
                {
                    if(lessThanTwo) {
                        k++;
                        nums[k] = nums[counter+1];
                        lessThanTwo = false;
                    }
                }
                else {
                    k++;
                    nums[k] = nums[counter+1];
                    lessThanTwo = true;
                }
            }
        }
        return ++k;
    }
}
