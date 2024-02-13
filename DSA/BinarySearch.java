public class BinarySearch {


    private static int search(int[] arr, int n){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == n){
                return mid;
            }
            else if(arr[mid]<n){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 7;
        int result = search(nums, target);
        if(result == -1){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element found at indext : " + result);
        }
    }
}
