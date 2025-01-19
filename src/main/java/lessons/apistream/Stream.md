# API STREAM
Stream. un stream es una secuencia de objectos que soporta varios metodos, y que se usa para procesar colecciones de objetos.

- Los Stream **NO** son una estructura de datos.
- Los Stream **NO** cambian la estructura de datos original, solo proporciona el resultado de los metodos canalizados.
- No soporta tipos primitivos: `int`, `long`, `double` etc.

## Java Stream Intermediate and Terminal Operations
- Las operaciones que devuelven un nuevo Stream se llaman "*intermediate operations*".
- Las operaciones que producen un resultado o producen un efecto secundario, son llamadas "*Terminal Operations*".

### Creación de un Stream
Mediante el método `Stream.of(...values)`
```java
Stream<Integer> streamOfCreation = Stream.of(1, 2, 3, 4, 5);
```
El metodo `Stream.of(...values)` Puede aceptar un array
```java
Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 13 };
Stream<Integer> stream = Stream.of( numbers );
```
La clase `Arrays` del paquete `java.utils`, nos proporciona el metodo `Arrays.stream([]int array)`.
```java
Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 13 };
Stream<Integer> stream = Arrays.stream(numbers);
```
Tambien podemos transformar una lista en un Stream.
```java
List<Integer> list = new ArrayList<Integer>();
list.add( 1 );
list.add( 2 );
list.add( 3 );
list.add( 4 );
     
Stream<Integer> streamList = list.stream();
```
### Interfaces de Stream
Existen 4 interfaces con la cual podemos trabajar.
- `Stream` con la cual podemos trabajar con cualquier tipo de dato.
Y existen otras que se especializan en valores de tipo numericos.
- `IntStream`.
- `LongStream`.
- `DoubleStream`.

Estas son similares a `Stream`, aparte agrega metodos con los cuales podemos trabajar, con numeros como son: `sum`, `min`, `max`, `average`

Podemos convertir un `Stream` generico en uno mas especifico como `DoubleStream`.
```java
Stream<String> stream = Stream.of("PHP", "Java", "JavaScript", "Ruby", "Cobol");
IntStream intStream = stream.mapToInt( language -> language.length() );
int total = intStream.sum(); // total = 26
```
### Intermediate Operations
Operaciones que transforman un `Stream` en otro. Estas incluyen.
1. `filter`: filtra elemento basado en una condición especifica. Acepta un función `Predicate`, es decir devuelve un valor boleano.
    ```java
    Stream<Integer> numbers = Stream.of(2, 4, 5, 8, 15, 20);
    List<Integer> result = numbers.filter(number -> number > 5).collect(Collectors.toList());

    result.forEach(System.out::print); // 8, 15, 20
    ```

2. `map` transforma los elementos de un Stream en otro valor.
2. `flatMap`.
3. `sorted` ordena los elementos de un Stream.