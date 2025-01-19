package lessons.generics;

public class Main {

    public static void main(String[] args) {
        GenericService<String> genericServiceString  = new GenericService<>();
        genericServiceString.save("Hola");

        GenericService<Integer> genericServiceInteger  = new GenericService<>();
        genericServiceInteger.save(1);
    }
}
