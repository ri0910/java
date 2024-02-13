public class BubbleSort {

    private static void sort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j = i; j<arr.length; j++){
                if(arr[j] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
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
