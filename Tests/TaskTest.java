import employee.Admin;
import employee.Employee;
import employee.Engineer;
import employee.TestEngineer;
import org.junit.Before;
import org.junit.BeforeClass;
import task.Task;

import java.util.*;

import static org.junit.Assert.*;

public class TaskTest {
    private List<Long> list1;
    private List<Employee> employees;
    private List<Admin> admins;
    private List<Engineer> engineers;
    private List<TestEngineer> testEngineers;
    private List<Employee> all;
    private static Employee[] employee = new Employee[3];
    private static Admin[] admin = new Admin[3];
    private static Engineer[] engineer = new Engineer[3];
    private static TestEngineer[] testEngineer = new TestEngineer[2];

    @Before
    public void init () {
        list1 = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        initEmployeesLists();

    }

    @BeforeClass
    public static void initEmployees () {
        employee[0] = new Employee("Ian");
        employee[1] = new Employee("Tere");
        employee[2] = new Employee("Pau");
        admin[0] = new Admin("Quim", true);
        admin[1] = new Admin("Carmen", false);
        admin[2] = new Admin("Aiax", false);
        engineer[0] = new Engineer("Sergi", 0);
        engineer[1] = new Engineer("Jaume", 0);
        engineer[2] = new Engineer("Alba", 1);
        testEngineer[0] = new TestEngineer("Aran", 1, true);
        testEngineer[1] = new TestEngineer("Laura", 0, true);
    }

    private void initEmployeesLists(){
        employees = Arrays.asList(employee);
        admins = Arrays.asList(admin);
        engineers = Arrays.asList(engineer);
        testEngineers = Arrays.asList(testEngineer);
        all = new ArrayList<>();
        all.addAll(employees);
        all.addAll(admins);
        all.addAll(engineers);
        all.addAll(testEngineers);
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