package generics.Aufgabe1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class Deneme<T>{

    Collection<T> s = new ArrayList<>();
    Function<Collection<String>, Integer> dd = (list) -> list.size();

}