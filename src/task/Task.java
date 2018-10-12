package task;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Task {

//Comentari per provar el Git. Funciona.
    public static List<Integer> withinRange(List<Integer> l, int max, int min) {
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
