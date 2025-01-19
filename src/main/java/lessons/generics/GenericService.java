package lessons.generics;

public class GenericService<T> {

    public T save( T t ) {
        System.out.println("Saved:  " + t.getClass().getName());
        return t;
    }
}
