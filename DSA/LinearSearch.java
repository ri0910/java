public class LinearSearch {

    private static int search(int[] arr, int n){
        for(int i=0; i < arr.length; i++){
            if(arr[i] == n){
                return i;
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
