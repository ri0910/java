public class QuickSort {

    private static int partition(int[] arr, int low, int high){
        int pivot = high;
        int i = low -1;
        for(int j = low; j<high; j++){
            if(arr[j]<arr[pivot]){
                i ++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[pivot];
        arr[pivot] = temp;
        return pivot;
    }


    private static void sort(int[] arr, int low, int high){
        if(low <= high){
            int pi = partition(arr, low, high);
            sort(arr, pi+1 ,high);
            sort(arr, low, pi-1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {45,87,2,9,21,49,67};
        for(int num : nums){
            System.out.print(num + ", ");
            
        }
        System.out.println();

        sort(nums, 0, nums.length-1);
        for(int num : nums){
            System.out.print(num + ", ");
        }

    }
}
