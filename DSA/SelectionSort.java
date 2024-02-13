public class SelectionSort {
    private static void sort(int[] arr){
        int minIndex = -1;
        for(int i=0; i<arr.length; i++){
            minIndex = i;
            int temp =0;
            for(int j=i+1; j<arr.length; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex =j;
                }
            }
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }


    public static void main(String[] args) {
        int[] nums = {45,87,2,9,21,49,67};
        for(int num : nums){
            System.out.print(num + ", ");
            
        }
        System.out.println();

        sort(nums);
        for(int num : nums){
            System.out.print(num + ", ");
        }

    }
}
