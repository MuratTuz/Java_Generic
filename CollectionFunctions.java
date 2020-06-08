package generics.Aufgabe1;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionFunctions<T, E> {

    public List<T> mergeToList(Collection<T> coll1, Collection<T> coll2){
        List<T> mergedList = new ArrayList<>();
        mergedList.addAll(coll1);
        mergedList.addAll(coll2);

        return mergedList;
    }

    public <T> Set<T> mergeToSet(Collection<T> coll1, Collection<T> coll2){
        Set<T> newSet = new HashSet<>();
        newSet.addAll(coll1);
        newSet.addAll(coll2);

        return newSet;
    }

    MyBiFunction<Collection<Person>, Collection<Person>, Collection<Person>> merge = (x,y,z) -> {
        z.addAll(x); z.addAll(y);
    };

    public <T> void print(Collection<T> printliste){
        printliste.forEach(System.out::println);
    }

    Function<Collection<T>, Integer> dd = (list) -> list.size();

    public Optional<List<Integer>> largest(Collection<Integer> coll, int nbr){
        if((coll.size()<nbr) || (nbr<0)) return Optional.empty();
        return Optional.of(coll.stream().sorted((a,b)->b.compareTo(a)).limit(nbr).collect(Collectors.toList()));
    }

    public Optional<List<Integer>> smallest(Collection<Integer> coll, int nbr){
        if((coll.size()<nbr) || (nbr<0)) return Optional.empty();
        return Optional.of(coll.stream().sorted().limit(nbr).collect(Collectors.toList()));
    }

    <E, C extends Collection<E>> C merge(C coll1, C coll2) throws IllegalAccessException, InstantiationException {
       List<E> newList = new ArrayList<>();
       newList.addAll(coll1); newList.addAll(coll2);


       //   return (C) coll1.getClass().newInstance(); error since coll1 and coll2 are representation classes. not real.
       //return yeni; error the same reason as above

      return (C) newList;
    }

    <C> Collection merge2(Collection<C> coll1, Collection<C> coll2){
        List newList = new ArrayList<>();
        newList.addAll(coll1); newList.addAll(coll2);

        return newList;
    }
}

