import java.util.Arrays;

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
