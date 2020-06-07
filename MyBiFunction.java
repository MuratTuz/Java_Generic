package generics.Aufgabe1;

@FunctionalInterface
public interface MyBiFunction<T, U, R>{
     void apply(T t, U u, R r);
}
