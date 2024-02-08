public class StringBufferDemo {
    public static void main(String[] args){
        StringBuffer buffer = new StringBuffer("Riya");
        System.out.println(buffer);
        System.out.println(buffer.capacity());
        System.out.println(buffer.length());
        buffer.append(" Karmakar");
        System.out.println(buffer);
        buffer.deleteCharAt(2);
        System.out.println(buffer);
        String sb = buffer.toString();
        System.out.println(sb);
    }
}
