public class InsertionSort {
    private static void sort(int[] arr){
        int temp =0;
        for(int i=1; i<arr.length; i++){
            temp = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = temp;

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
