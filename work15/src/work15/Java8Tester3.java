package work15;

public class Java8Tester3 {
    public static void main(String args[]) {
        final int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);  // ������Ϊ 3
    }
 
    public interface Converter<T1, T2> {
        void convert(int i);
    }
}