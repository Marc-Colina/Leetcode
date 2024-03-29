public class RemoveElement {
    public static void main(String[] args) {

        int[] nums = {2,2,2,2,2,1,1,1,4,5,6,4,6,8,7,23,56,12,2,2,4,5,6};
        System.out.println("K IS  " + removeElement(nums,2));
        for(int num:nums)
        {
            System.out.print(num + " ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for(int counter = 0; counter < nums.length; counter++)
        {
            if(counter == 0 && nums[counter] != val) {
                k++;
                continue;
            }

            if(nums[counter] != val)
            {
                if(k != counter) {
                    nums[k] = nums[counter];
                    nums[counter] = val;
                }
                k++;
            }
        }
        return k;
    }
}
