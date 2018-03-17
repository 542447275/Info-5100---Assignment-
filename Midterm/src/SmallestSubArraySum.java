public class SmallestSubArraySum {
    public static int smallestSubWithSum(int[] arr, int n, int x){
        int curSum = 0, minLen = n + 1;
        int start  = 0, end = 0;

        while(end < n){
            while (curSum <= x && end < n)
                curSum += arr[end++];
            while (curSum > x && start < n){
                if(end - start < minLen)
                    minLen = end - start;
                curSum -= arr[start++];
            }
        }
        return minLen;
    }

    public static void main(String[] args)
    {
        int arr1[] = {1, 4, 45, 6, 10, 19};
        int x = 51;
        int n1 = arr1.length;
        int res1 = smallestSubWithSum(arr1, n1, x);
        System.out.println(res1);

        int arr2[] = {1, 10, 5, 2, 7};
        int n2 = arr2.length;
        x = 9;
        int res2 = smallestSubWithSum(arr2, n2, x);
        System.out.println(res2);

        int arr3[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        int n3 = arr3.length;
        x = 280;
        int res3 = smallestSubWithSum(arr3, n3, x);
        System.out.println(res3);
    }
}
