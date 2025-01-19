package lessons.functionsinterfaces;

import java.util.function.*;

public class FunctionInterfaceJava {

    public static void main(String[] args) {

        /**
         * Function<T,R> = recibe un argumento lo procesa y retorna otro
         * firma: Function<T,R> donde T es el argumento y R el retorno
         */
        Function<String, Integer> lengthString = ( String word ) -> {
            return word.length();
        };
        System.out.println("Function, lengthString: " + lengthString.apply("Hello Word"));

        /**
         * BiFunction<T,U,R> = recibe (2) dos argumentos lo procesa y retorna otro
         * firma: Function<T,U,R> donde T es el primer argumento, U el segundo y R el retorno
         */
        BiFunction<String,String, Boolean> isEquals = ( String word1, String word2 ) -> {
            return word1.equals(word2);
        };
        System.out.println("BiFunction, isEquals: " + isEquals.apply("Hello Word", "Orange"));

        /**
         * UnaryOperator<T> = Extiende de Function, recibe un unico argumento, se procesa y retorna otro del mismo Tipo
         * firma: UnaryOperator<T> donde T es el unico argumento y retorna uno del mismo tipo
         */
        UnaryOperator<Integer> multiplyNumber = number -> number * number;
        System.out.println("UnaryOperator Functional, multiplyNumber: " + multiplyNumber.apply( 3));

        /**
         * BinaryOperator<T> = Extiende de BiFunction, recibe dos argumentos del mismo tipo, se procesa y retorna otro del mismo Tipo
         * firma: BinaryOperator<T> donde T es el retorno y tiene que ser del mismo tipo que los argumento
         */
        BinaryOperator<String> concatString = ( String word1, String word2 ) -> word1 + " " + word2;
        System.out.println("BinaryOperator Functional, concatString: " + concatString.apply( "Hello", "Orange"));

        /**
         * Consumer<T> Interfaz funcional que acepta un parametro y no retorna nada.
         * firma: Consumer<T> donde T es el parametro de entrada, esta función no retorna ningun valor
         */
        Consumer<String> consumer = name -> System.out.println( "Consumer: Hello " + name );
        consumer.accept( "Jhon Doe");

        BiConsumer<String, Integer> biConsumer = ( name, age ) -> System.out.println( "BiConsumer: Name: " + name + " Age: " + age );
        biConsumer.accept("Jhon Doe", 35);

        /**
         * Supplier<T> Interfaz funcional que no hace ningun valor, pero retorna un valor
         * firma: Supplier<T> donde T es el tipo de retorno, esta función no retorna algún valor
         */
        Supplier<String> supplier = () -> "Hello Suplier";
        System.out.println( supplier.get() );

        /**
         * Predicate<T> Interfaz funcional, Que acepta un valor, pero retorna un valor booleano (true, false)
         * firma: Predicate<T> donde T es el valor que recibe, pero retorna un valor booleano.
         */
        Predicate<Integer> predicate = value -> {
            if (value > 0) return true;

            return false;
        };
        System.out.println("Predicate: Es positivo: " + predicate.test( -1 ));

        /**
         * BiPredicate<T, U> Interfaz funcional, Que extiende de Predicate<T>, pero que acepta dos parametros, igualmente reota un valor booleano
         * firma: BiPredicate<T, U>, donde T y U son los parametros.
         */
        BiPredicate<String, Integer> biPredicate = ( string1, length ) -> {
            if( string1.trim().length() == length ) return true;

            return false;
        };
        System.out.println("BiPredicate: Es verdadero: " + biPredicate.test("Hello  ", 5));

        ToIntBiFunction<String, Integer> toIntBiFunction = ( name, age ) -> {
            int difference = 0;
            difference = name.length() - age;
            return difference;
        };
    }


}
