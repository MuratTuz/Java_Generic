package generics.Aufgabe1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ReverseMap<L,R> {
    Map<R,L> leftMap = new HashMap<>();
    Map<L,R> rightMap = new HashMap<>();

    public L getLeft(R right) {
        return leftMap.get(right);
    }

    public R getRight(L left) {
        return rightMap.get(left);
    }

    Collection<L> leftValues(){
        return rightMap.keySet();
    }

    Collection<R> rightValues(){
        return leftMap.keySet();
    }

    void put(L left, R right){
        leftMap.put(right, left);
        rightMap.put(left, right);
    }

    int size(){
        return leftMap.size();
    }

    void clear(){
        leftMap.clear();
        rightMap.clear();
    }
}
