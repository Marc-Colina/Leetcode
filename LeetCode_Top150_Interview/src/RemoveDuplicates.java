//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
//
//Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
//
//Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
//Return k.
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
//Input: nums = [1,1,2]
//Output: 2, nums = [1,2,_]
//Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).
//Example 2:
//
//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).
public class RemoveDuplicates {
    public static void main(String[] args) {
        int [] nums = {0,1,1,1,2,2,3,3,3,4,5,5,5,6,6,7};
        System.out.println(removeDuplicates(nums));
        for(int num : nums)
        {
            System.out.print(num + " ");
        }
    }

    public static int removeDuplicates(int[] nums)
    {
        //k in this program will determine how many unique elements are present in our array.
        int k =0;

        //We want to return early so if the array is either empty or only has one element, we just return the length
        //right away.
        if(nums.length<2)
            return nums.length;

        for(int counter=0; counter<nums.length; counter++)
        {
            //Since our array is sorted in ascending order, we can go ahead and do a side by side comparison per element
            //and we are sure that once we move k to the right, we will not encounter any other element that is smaller
            //than the value at index k.
            //The trick here is the value of k. On the first iteration, k will be 0 so it will compare the first element
            //to the other elements. As it traverses the array, everytime the counter index has a value that's the same as the
            //value of the k index, the k index will not be incremented. While continuing the traversal, when the counter index now has
            // an element different from the element at index k, we then increment k and put the element in the counter index to
            //the now incremented index k. At the end of the iteration,all the unique elements have been added to the beginning of
            //the array thanks to the k variable that kept track of it. The remaining elements to the right of the k index,
            //are not significant and these are elements that are expected to be duplicates of the unique elements from the 0-th
            //to the k-th index.
            if(nums[k] != nums[counter])
            {
                k++;
                nums[k] = nums[counter];
            }
        }
        return ++k;
    }
}
