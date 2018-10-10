import org.junit.Before;

import java.util.*;

import static org.junit.Assert.*;

public class TaskTest {
    private List<Long> list1;

    @Before
    public void init () {
        list1 = Arrays.asList(1L, 2L, 3L, 4L, 5L);
    }

    @org.junit.Test
    public void testWithinRange() {
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i<10; i++) {
            list2.add(i);
        }
        assertEquals(Arrays.asList( 1, 2, 3, 4), Task.withinRange(list2, 5, 1));
        assertEquals(Collections.emptyList(), Task.withinRange(list2, 1, 2));
        assertEquals(Arrays.asList(3, 4, 5, 6), Task.withinRange(list2, 7, 3));
    }

    @org.junit.Test
    public void testWithinRange1() {
        assertEquals(Arrays.asList(3L, 4L, 5L), Task.withinRange(list1, 6L, 3L));
        assertEquals(Collections.emptyList(), Task.withinRange(list1, 1L, 2L));

    }

    @org.junit.Test
    public void testWithinTange() {
        assertEquals(Arrays.asList(3L, 4L, 5L), Task.withinTange(Comparator.naturalOrder(),
                list1, 6L, 3L));
        assertEquals(Collections.emptyList(), Task.withinTange(Comparator.naturalOrder(),
                list1, 1L, 2L));
    }

    @org.junit.Test
    public void testCopyWithRange() {
        List<Long> list3 = new ArrayList<>();
        Task.copyWithRange(list1, list3, 1L, 2L);
        assertEquals(Collections.emptyList(), list3);
        Task.copyWithRange(list1, list3, 5L, 2L);
        assertEquals(Arrays.asList(2L, 3L, 4L), list3);
        list3 = Arrays.asList(10L, 11L, 12L, 13L, 14L);
        Task.copyWithRange(list1, list3, 5L, 2L);
        assertEquals(Arrays.asList(2L, 3L, 4L, 13L, 14L), list3);
    }

    @org.junit.Test
    public void testCopyWithTange() {
        List<Long> list3 = new ArrayList<>();
        Task.copyWithTange(Comparator.naturalOrder(), list1, list3, 1L, 2L);
        assertEquals(Collections.emptyList(), list3);
        Task.copyWithTange(Comparator.naturalOrder(), list1, list3, 5L, 2L);
        assertEquals(Arrays.asList(2L, 3L, 4L), list3);
        list3 = Arrays.asList(10L, 11L, 12L, 13L, 14L);
        Task.copyWithTange(Comparator.naturalOrder(), list1, list3, 5L, 2L);
        assertEquals(Arrays.asList(2L, 3L, 4L, 13L, 14L), list3);

    }


}