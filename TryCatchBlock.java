public class TryCatchBlock {
    public static void main(String[] args) {
        int i = 20;
        int j = 0;
        String str = null;
        int arr[] = new int[5];

        try{
            j = 18/i;
            if(j == 0){
                throw new ArithmeticException("The answer is zero.");
            }
            // System.out.println(str.length());
            // System.out.println(arr[5]);
        }
        catch(ArithmeticException e){
            j = 18/1;
            System.out.println("Can not devided by zero." + e);
        }
        // catch(ArrayIndexOutOfBoundsException e){
        //     System.out.println("Out of bound error");
        // }
        catch(Exception e){
            System.out.println("Something went wrong...." + e);
        }

        System.out.println(j);
        System.out.println("Bye");
    }
}
