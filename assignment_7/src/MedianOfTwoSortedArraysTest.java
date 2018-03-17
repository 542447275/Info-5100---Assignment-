import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfTwoSortedArraysTest {
    @Test
    void findMedianSortedArrays() {
        MedianOfTwoSortedArrays mt = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double res = mt.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.5, res);
    }

}