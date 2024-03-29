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
        if(nums.length<2)
            return nums.length;

        int k = 0;
        //int atMostTwo = 0;
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
