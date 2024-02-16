public class MergeSort {

    private static void merge(int[] arr, int l, int mid, int r){
        int n1 = mid -l + 1;
        int n2 = r - mid;

        int lArray[] = new int[n1];
        int rArray[] = new int[n2];

        for(int x = 0; x < n1; x++){
            lArray[x] = arr[l+x];
        }

        for(int x = 0; x < n2; x++){
            rArray[x] = arr[mid+1+x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while(i < n1 && j < n2){
            if(lArray[i] < rArray[j]){
                arr[k] = lArray[i];
                i++;
            }
            else{
                arr[k] = rArray[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = lArray[i];
            i++;
            k++;
        }

        while(j < n2){
            arr[k] = rArray[j];
            j++;
            k++;
        }

    }


    private static void sort(int[] arr, int l , int r){
        if(l<r){
            int mid = (l+r)/2;
            sort(arr, l, mid);
            sort(arr, mid+1, r);
            merge(arr, l, mid, r);
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
