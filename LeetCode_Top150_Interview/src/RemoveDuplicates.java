public class RemoveDuplicates {
    public static void main(String[] args) {
        int [] nums = {0,1,1,2,2,3,3,3,4,5,5,5,6,6,7};
        System.out.println(removeDuplicates(nums));
        for(int num : nums)
        {
            System.out.print(num + " ");
        }
    }

    public static int removeDuplicates(int[] nums)
    {
        int k =0;
        if(nums.length<2)
            return nums.length;

        for(int counter=0; counter<nums.length;counter++)
        {
            if(counter<nums.length-1 && nums[k] != nums[counter+1])
            {
                k++;
                nums[k] = nums[counter+1];
            }
        }
        return ++k;
    }
}
