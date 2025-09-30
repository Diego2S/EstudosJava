import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main{

    public static void main(String[] args){

        List <Integer> list = Arrays.asList(3,4,5,10,7);

        System.out.println(list);
        
        Stream<Integer> st1 = list.stream().map(n -> n * 2);

        System.out.println(Arrays.toString(st1.toArray()));


        int sum = list.stream().reduce(0, (a,b) -> a + b);
        System.out.println("Sum: " + sum);

        List<Integer> newList = list.stream()
        .filter(x -> x % 2 == 0)
        .map(x -> x * 10)
        .collect(Collectors.toList());

        System.out.println(Arrays.toString(newList.toArray()));
    }

}