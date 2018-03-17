public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || nums == null)
            return;
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }
    private void reverse(int[] nums, int i, int j){
        while (i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        ra.rotate(nums, 2);
        for(int n : nums)
            System.out.print(n + " ");
    }
}
