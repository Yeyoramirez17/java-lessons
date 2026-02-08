package lessons.apistream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ApiStream {

    public static void main(String[] args) {
        List<Employee> employeesTics = new ArrayList<>();
        employeesTics.add(
            new Employee("Jhon Doe", 22, 2500.00, "Web Developer")
        );
        employeesTics.add(
            new Employee("James Gosling", 52, 4500.00, "Software Enginer")
        );
        employeesTics.add(
            new Employee("Taylor Otwell", 42, 3000.00, "Web Developer")
        );
        employeesTics.add(
            new Employee("Miguel Angel Duran", 32, 3000.00, "Scrum Master")
        );
        employeesTics.add(
            new Employee("Sara Nicholl", 22, 3000.00, "Frontend Developer")
        );

        double totalSalaryTics = employeesTics
            .stream()
            .mapToDouble(employee -> employee.getSalary())
            .sum();
        System.out.println("-- Total Salary TIC's: " + totalSalaryTics);

        // List<Employee> employeesWebDeveloper = employeesTics.stream()
        // .filter(employee -> employee.getPosition() == "Web Developer")
        // .collect(Collectors.toList());

        // employeesWebDeveloper.forEach(System.out::println);

        // /** Convertir el Stream a un DoubleStream y aplicar la operción sum() */
        // DoubleStream streamDouble = employeesTics.stream()
        // .filter(employee -> employee.getPosition() == "Web Developer")
        // .mapToDouble(employee -> employee.getSalary());

        // // System.out.println("Summary Statistics: " +
        // streamDouble.summaryStatistics());
        // System.out.println("Sum Salary: " + streamDouble.sum());

        List<Employee> employeesAdministration = new ArrayList<>();
        employeesAdministration.add(
            new Employee("Wild Smith", 45, 4000.00, "General manager")
        );
        employeesAdministration.add(
            new Employee("Elon Musk", 50, 3500.00, "Lawyer")
        );
        employeesAdministration.add(
            new Employee("Andrew Garfield", 35, 3500.00, "Treasurer")
        );
        employeesAdministration.add(
            new Employee("Amanda Hans", 25, 2500.00, "Secretary")
        );

        double totalSalaryAdmin = employeesAdministration
            .stream()
            .mapToDouble(employee -> employee.getSalary())
            .sum();
        System.out.println("-- Total Salary TIC's: " + totalSalaryAdmin);

        var departmentTics = new Department();
        departmentTics.setDepartment("TIC's");
        departmentTics.setEmployees(employeesTics);

        var departmentAdministration = new Department();
        departmentAdministration.setDepartment("Administration");
        departmentAdministration.setEmployees(employeesAdministration);

        List<Department> departments = new ArrayList<>();
        departments.add(departmentTics);
        departments.add(departmentAdministration);

        double totalSalary = departments
            .stream()
            .flatMap(department -> department.getEmployees().stream())
            .mapToDouble(employee -> employee.getSalary())
            .sum();

        System.out.println("-- Total Salary: " + totalSalary);
    }

    public static void introStream() {
        /** Creación de un Stream **/
        // Stream.of( ...values ) - Se crea un Stream a partir de un secuencia de
        // "numeros fijos"
        Stream<Integer> streamOfCreation = Stream.of(1, 2, 3, 4, 5);

        // Stream.of( Integer[] array ) - Se crea un Stream a partir de un "array"
        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 13 };
        Stream<Integer> streamOfCreationArray = Stream.of(numbers);

        // Arrays.stream( Integer[] array ) - La Clase Arrays, nos proporciona el metodo
        // stream, para crea un nuevo "Stream"
        Stream<Integer> stream = Arrays.stream(numbers);

        // List.stream() - Nos permite crear un Stream a partir de una Lista
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Stream<Integer> streamList = list.stream();

        // Stream.generate() or Stream.iterate() - Nos Permite crear un Stream de manera
        // infinita, a menos que especifiquemos el limite
        Stream<Integer> streamGenerate = Stream.generate(() ->
            (new Random()).nextInt(20)
        ).limit(5);
        streamGenerate.forEach(System.out::println);
        Stream<String> streamIterate = Stream.iterate(
            "abc",
            i -> i + "dfgh"
        ).limit(5);
        streamIterate.forEach(System.out::println);

        /**
         * Java Stream Intermediate Operations
         *
         * Las "Terminal operations" retorna un nuevo Stream, lo que permite encadenar
         * metodos
         */
        // Stream filter() - Nos permite filtar un Stream, acepta como parametro un
        // Predicate
        System.out.println("-- Intermediate Operations ");
        System.out.println("Stream.filter(): ");
        Stream<Integer> streamFilter = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 13);
        Stream<Integer> isPar = streamFilter.filter(value -> value % 2 == 0);
        isPar.forEach(System.out::println);

        // Stream.map() - Se utiliza para transformar los elementos de un flujo
        // utilizando una función.
        System.out.println("Stream.map(): ");
        Stream<Integer> streamMap = Stream.of(4, 5, 6, 7, 13);
        Stream<Integer> multiplyTwo = streamMap.map(value -> value * 2);
        multiplyTwo.forEach(System.out::println);

        // Stream.sorted() - Se utiliza para ordenar los elementos de un Stream,
        // acepta una interfaz Comparator, en caso de querer alterar el orden natural
        System.out.println("Stream.sorted(): ");
        Stream<Integer> streamSortedInteger = Stream.of(13, 3, 1, 55, 23, 9);
        streamSortedInteger.sorted().forEach(System.out::println);

        Stream<String> streamSortedString = Stream.of(
            "JavaScript",
            "PHP",
            "Go",
            "Ruby",
            "C#"
        );
        streamSortedString
            .sorted(Comparator.reverseOrder())
            .forEach(System.out::println);

        /**
         * Java Stream - Terminal operations
         *
         * Los "Intermediate Operations" retorna el resultado de cierto tipo de
         * operación realizada a un Stream,
         * NO retorna un Stream, por lo tanto no se pueden encadenar más metodos
         */
        System.out.println("-- Terminal Operation ");
        // Stream.forEach() - Permite iterar sobre un Stream, y realizar operaciones
        // sobre cada elemento del Stream
        System.out.println("Stream.forEach(): ");
        Stream<String> streamForEach = Stream.of(
            "English",
            "Spanish",
            "French",
            "German",
            "Italian"
        );
        streamForEach.forEach(System.out::println);

        // Stream.collect() - Nos permite recibir los elementos de un Stream y
        // almacenarlos en una Coleción (List, Set).
        System.out.println("* Stream.collect(): ");
        Stream<String> streamCollect = Stream.of(
            "English",
            "Spanish",
            "French",
            "German",
            "Italian"
        );
        List<String> listString = streamCollect.collect(Collectors.toList());
        System.out.println("List<String> : " + listString);

        // Stream.match() - Existe diferentes metodos match ( coincidir ) {anyMatch( ),
        // allMatch( ), and noneMatch( )},
        // que devuelve un valor booleano, según muestra especificacion en la interfaz
        // Predicate (predicado).
        String[] arrayString = new String[] {
            "English",
            "Spanish",
            "French",
            "German",
            "Italian",
        };
        Predicate<String> predicate = value -> value.contains("i");
        System.out.println(
            "* Stream { anyMatch(), allMatch(), noneMatch() } :"
        );
        System.out.println(Arrays.stream(arrayString).anyMatch(predicate));
        System.out.println(Arrays.stream(arrayString).allMatch(predicate));
        System.out.println(Arrays.stream(arrayString).noneMatch(predicate));

        // Stream.count() - Se usa para determinar el numero de elementos de un Stream
        System.out.println("* Stream.count() :");
        System.out.println(Arrays.stream(arrayString).count());
        long totalMatched = Arrays.stream(arrayString)
            .filter(value -> value.startsWith("E"))
            .count();
        System.out.println(totalMatched);
    }
}
