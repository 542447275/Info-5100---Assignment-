public class SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, hi = nums.length - 1;
        int[] res = new int[2];

        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};

        while (low < hi){
            int mid = low + (hi - low) / 2;
            if(target > nums[mid])
                low = mid + 1;
            else
                hi = mid;
        }
        if(target == nums[low])
            res[0] = low;
        else
            res[0] = - 1;

        hi = nums.length - 1;
        while (low < hi){
            int mid = low + (hi - low) / 2 + 1;
            if(target < nums[mid])
                hi = mid - 1;
            else
                low = mid;
        }
        if(target == nums[hi])
            res[1] = hi;
        else
            res[1] = -1;

        return res;
    }

    public static void main(String[] args){
        SearchforaRange sr = new SearchforaRange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] res = sr.searchRange(nums, 8);
        for(int r : res)
            System.out.print(r + " ");
    }
}