import java.util.*;

public class Task {


    public static List<Integer> withinRange(List<Integer> l, int max, int min) {
        List<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> it = l.iterator();
        while (it.hasNext()) {
            int nombre = it.next();
            if (min <= nombre && nombre < max) {
                result.add(nombre);
            }
        }
        return result;
    }

    public static <E extends Comparable<? super E>> List<E> withinRange(List<E> l, E max, E min) {
        List<E> result = new ArrayList<E>();
        Iterator<E> it = l.iterator();
        while (it.hasNext()) {
            E elem = it.next();
            if (min.compareTo(elem) <= 0 && elem.compareTo(max) < 0) {
                result.add(elem);
            }
        }
        return result;
    }

    public static <E> List<E> withinTange(Comparator<E> comp, List<E> l, E max, E min) {
        /* Hi ha errors */
        List<E> result = new ArrayList<E>();
        Iterator<E> it = l.iterator();
        while (it.hasNext()) {
            E elem = it.next();
            if (comp.compare(min, elem) <= 0 && comp.compare(elem, max) < 0) {
                result.add(elem);
            }
        }
        return result;
    }
}
