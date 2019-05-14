package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://stackify.com/streams-guide-java-8/
 */

public class Streams {

    public static void main(String[] args) {

        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0, Gender.MALE),
                new Employee(2, "Bill Gates", 200000.0, Gender.MALE),
                new Employee(3, "GIllian Tans", 200000.0, Gender.FEMALE),
                new Employee(4, "Mark Zuckerberg", 300000.0, Gender.MALE)
        };

        Stream.of(arrayOfEmps);

        // obtain a stream from an existing list:
        List<Employee> empList = Arrays.asList(arrayOfEmps);
        empList.stream();


        // create a stream from individual objects using Stream.of()
        Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2], new Employee(4, "Ian Brown", 400000.0, Gender.MALE));

        // ... Or using Stream.builder():

        Stream.Builder<Employee> empStreamBuilder = Stream.builder();
        empStreamBuilder.accept(arrayOfEmps[0]);
        empStreamBuilder.accept(arrayOfEmps[1]);
        empStreamBuilder.accept(arrayOfEmps[2]);
        Stream<Employee> empStream = empStreamBuilder.build();


        empList.stream().forEach(e -> e.salaryIncrement(10.0));
        System.out.println(empList);

        empList.stream().forEach(e -> {
            if (e.getGender() == Gender.MALE) {
                e.setName("Mr " + e.getName());
            } else {
                e.setName("Ms " + e.getName());
            }
        });
        System.out.println(empList);

        empList.stream().forEach(e -> e.setName(e.getName().toUpperCase()));
        System.out.println(empList);

        List<String> alpha = Arrays.asList("a", "b", "c", "d");
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);

        empList.stream()
                .peek(e -> e.subtractTax(0.20))
                .peek(System.out::println)
                .collect(Collectors.toList());

        List<Employee> collect2 = empList.stream()
                .filter(e -> e.getSalary() > 100000)
                .filter(e -> e.getSalary() < 200000)
                .collect(Collectors.toList());
        System.out.println(collect2);

        collect2 = empList.stream()
                .filter(e -> e.getSalary() > 100000)
                .filter(e -> e.getSalary() < 200000)
                .filter(e -> e.getGender() == Gender.FEMALE)
                .collect(Collectors.toList());
        System.out.println(collect2);

        collect2 = Stream.of(arrayOfEmps)
                .filter(e -> e.getGender() == Gender.MALE)
                .collect(Collectors.toList());
        System.out.println(collect2);

        collect2 = Arrays.stream(arrayOfEmps)
                .filter(e -> e.getGender() == Gender.MALE)
                .collect(Collectors.toList());
        System.out.println(collect2);

        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect3 = infiniteStream
                .skip(0)
                .limit(12)
                .collect(Collectors.toList());
        System.out.println(collect3);

        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(20)
                .map(n -> n[0])
                .forEach(x -> System.out.print(x + " "));
        System.out.println();

        Stream.iterate(1, n -> n < 20 , n -> n * 2)
                .forEach(x -> System.out.print(x + " "));
        System.out.println();

        System.out.println(empList.stream()
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .collect(Collectors.toList()));

        System.out.println(empList.stream()
                .filter(e -> e.getGender() == Gender.MALE)
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList()));

        Employee maxSalEmp = empList.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        System.out.println(maxSalEmp);

        List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
        System.out.println(intList.stream().distinct().collect(Collectors.toList()));

        intList = Arrays.asList(2, 4, 5, 6, 8);
        System.out.println(intList.stream().allMatch(i -> i % 2 == 0));
        System.out.println(intList.stream().anyMatch(i -> i % 2 == 0));
        System.out.println(intList.stream().noneMatch(i -> i % 3 == 0));

    }
}
