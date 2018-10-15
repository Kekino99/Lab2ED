package task;

import com.sun.istack.internal.NotNull;

import java.util.*;

public class Task {

    /* * * * Task 1 * * * */

    /**
     *
     * @param l readable list of Integer. Null elements will be ignored, and null lists will cast an
     *          unexpected throw
     * @param max Maximum Integer not included in the range
     * @param min Minimum Integer included in the range
     * @return A list of elements witch min<=number<max
     */
    public static List<Integer> withinRange(@NotNull List<Integer> l, int max, int min) {
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> it = l.iterator();
        while (it.hasNext()) {
            Integer number = it.next();
            if (number != null && min <= number && number < max) {
                result.add(number);
            }
        }
        return result;
    }

    /* * * * Task 2 * * * */
    /**     Generic version of withinRange. Elements must have a super Comparable, or be Comparable themselves
     * @param l readable list of ? witch extends E. Null elements will be ignored, and null lists will cast an
     *          unexpected throw
     * @param max Maximum element not included in the range
     * @param min Minimum element included in the range
     * @return A list of elements witch min<=elem<max
     */
    public static <E extends Comparable<? super E>> List<E> withinRange(@NotNull List<? extends E> l, E max, E min) {
        List<E> result = new ArrayList<>();
        Iterator<? extends E> it = l.iterator();
        while (it.hasNext()) {
            E elem = it.next();
            if (elem!=null && min.compareTo(elem) <= 0 && elem.compareTo(max) < 0) {
                result.add(elem);
            }
        }
        return result;
    }

    /**     Generic version of withinRange.
     * @param comp comparator of the elements. Must be from the elements themselves, or a super class.
     * @param l readable list of ? witch extends E. Null elements will be ignored, and null lists will cast an
     *          unexpected throw
     * @param max Maximum element not included in the range
     * @param min Minimum element included in the range
     * @return A list of elements witch min<=elem<max
     */
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
    /**     Generic version of withinRange. Elements must have a super Comparable, or be Comparable themselves
     * @param src readable list of ? witch extends E. Null elements will be ignored, and null lists will cast an
     *          unexpected throw
     * @param trg list that will be overwritten with elements from src. If trg has more elements than src, those final
     *            elements will be ignored (src ={a, b, c, d} trg={1, 2, 3, 4, 5}, trg'={a, b, c, d, 5} )
     * @param max Maximum element not included in the range
     * @param min Minimum element included in the range
     *
     */
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

    /**     Generic version of withinRange. Elements must have a super Comparable, or be Comparable themselves
     * @param comp comparator of the elements. Must be from the elements themselves, or a super class.
     * @param src readable list of ? witch extends E. Null elements will be ignored, and null lists will cast an
     *          unexpected throw
     * @param trg list that will be overwritten with elements from src. If trg has more elements than src, those final
     *            elements will be ignored (src ={a, b, c, d} trg={1, 2, 3, 4, 5}, trg'={a, b, c, d, 5} )
     * @param max Maximum element not included in the range
     * @param min Minimum element included in the range
     *
     */
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
