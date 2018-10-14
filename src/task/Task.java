package task;

import com.sun.istack.internal.NotNull;

import java.util.*;

public class Task {

    /* * * * Task 1 * * * */
    //Returns a list of integers between the Max and Min.
    public static List<Integer> withinRange(@NotNull List<Integer> l, int max, int min) {
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> it = l.iterator();
        while (it.hasNext()) {
            int nombre = it.next();
            if (min <= nombre && nombre < max) {
                result.add(nombre);
            }
        }
        return result;
    }

    /* * * * Task 2 * * * */
    //Generic version of withinRange. version 1
    public static <E extends Comparable<? super E>> List<E> withinRange(@NotNull List<? extends E> l, E max, E min) {
        List<E> result = new ArrayList<>();
        Iterator<? extends E> it = l.iterator();
        while (it.hasNext()) {
            E elem = it.next();
            if (min.compareTo(elem) <= 0 && elem.compareTo(max) < 0) {
                result.add(elem);
            }
        }
        return result;
    }

    //Generic version of withinRange. version 2
    public static <E> List<E> withinTange(Comparator<? super E> comp, @NotNull List<? extends E> l, E max, E min) {
        List<E> result = new ArrayList<>();
        Iterator<? extends E> it = l.iterator();
        while (it.hasNext()) {
            E elem = it.next();
            if (comp.compare(min, elem) <= 0 && comp.compare(elem, max) < 0) {
                result.add(elem);
            }
        }
        return result;
    }

    /* * * * Task 3 * * * */
    //Copies the elements within max and min from one list to another. Comparable Version
    public static <E extends Comparable<? super E>> void copyWithRange(@NotNull List<? extends E> src, @NotNull List<? super E> trg,
                                                                       E max, E min) {
        Iterator<? extends E> srcit = src.iterator();
        ListIterator<? super E> trgit = trg.listIterator();
        while(srcit.hasNext()) {
            E elem = srcit.next();
            if (min.compareTo(elem) <= 0 && elem.compareTo(max) < 0) {
                if (trgit.hasNext()) {
                    trgit.next();
                    trgit.set(elem);
                } else {
                    trgit.add(elem);
                }
            }
        }
    }

    //Copies the elements within max and min from one list to another. Comparator Version
    public static <E> void copyWithTange(Comparator<? super E> comp, @NotNull List<? extends E> src, @NotNull List<? super E> trg, E max, E min) {
        Iterator<? extends E> srcit = src.iterator();
        ListIterator<? super E> trgit = trg.listIterator();
        while(srcit.hasNext()) {
            E elem = srcit.next();
            if (comp.compare(min, elem) <= 0 && comp.compare(elem, max) < 0) {
                if (trgit.hasNext()) {
                    trgit.next();
                    trgit.set(elem);
                } else {
                    trgit.add(elem);
                }
            }
        }
    }
}
