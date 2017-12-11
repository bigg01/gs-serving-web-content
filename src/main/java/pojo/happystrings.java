package pojo;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class happystrings {


    public static void main(String[] args){
        System.out.println("hello moto");

        String counters =
                IntStream.rangeClosed(1,10)
                .mapToObj(i -> 1 + "miu")
                        .collect(Collectors.joining("\n"));

        System.out.println(counters);
    }
}
