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

    public static void rotate(int[] nums, int k)
    {
        if(nums.length<=1)
            return;

        int[] tempArray = new int[k];
        int counter = nums.length-1;
        int tempK = k;

        while(tempK != 0)
        {
            tempArray[tempK-1] = nums[counter];
            counter--;
            tempK--;
        }

        for(int counter2 = nums.length - (k+1); counter2>=0; counter2--)
        {
            nums[counter2+k] = nums[counter2];
        }

        for(int counter3 = 0; counter3 < k; counter3++)
        {
            nums[counter3] = tempArray[counter3];
        }
    }
}
