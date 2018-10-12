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
    private List<Engineer> engineers;
    private List<Employee> all;
    private static Employee[] employee = new Employee[3];
    private static Admin[] admin = new Admin[3];
    private static Engineer[] engineer = new Engineer[3];
    private static TestEngineer[] testEngineer = new TestEngineer[2];
    private static List<Engineer> testList = new ArrayList<>();


    @Before
    public void init() {
        list1 = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        initEmployeesLists();

    }

    @BeforeClass
    public static void initEmployees() {
        employee[0] = new Employee("Ian"); //0
        employee[1] = new Employee("Tere"); //1
        employee[2] = new Employee("Pau"); //2
        admin[0] = new Admin("Quim", true); //3
        admin[1] = new Admin("Carmen", false); //4
        admin[2] = new Admin("Aiax", false); //5
        engineer[0] = new Engineer("Sergi", 0); //6
        engineer[1] = new Engineer("Jaume", 0); //7
        engineer[2] = new Engineer("Alba", 1); //8
        testEngineer[0] = new TestEngineer("Aran", 1, true); //9
        testEngineer[1] = new TestEngineer("Laura", 0, true); //10

    }

    private void initEmployeesLists() {
        List<Employee> employees = Arrays.asList(employee);
        List<Admin> admins = Arrays.asList(admin);
        engineers = Arrays.asList(engineer);
        List<TestEngineer> testEngineers = Arrays.asList(testEngineer);
        all = new ArrayList<>();
        all.addAll(employees);
        all.addAll(admins);
        all.addAll(engineers);
        all.addAll(testEngineers);
        testList.addAll(engineers);
        testList.addAll(testEngineers);
    }

    @org.junit.Test
    public void testWithinRange() {
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list2.add(i);
        }
        assertEquals(Arrays.asList(1, 2, 3, 4), Task.withinRange(list2, 5, 1));
        assertEquals(Collections.emptyList(), Task.withinRange(list2, 1, 2));
        assertEquals(Arrays.asList(3, 4, 5, 6), Task.withinRange(list2, 7, 3));
    }

    @org.junit.Test
    public void testWithinRange1() {
        assertEquals(Arrays.asList(3L, 4L, 5L), Task.withinRange(list1, 6L, 3L));
        assertEquals(Collections.emptyList(), Task.withinRange(list1, 1L, 2L));

        /* * * * Testos de jerarquia * * * */
        assertEquals(engineers, Task.withinRange(engineers, testEngineer[0], engineer[0])); //test comparable super
        assertNotEquals(all.subList(6, 9), Task.withinRange(testList, testEngineer[1], engineer[0]));
            //testeja List<? extends E>
        assertEquals(all.subList(0, 6), Task.withinRange(all, engineer[0], employee[0]));

    }

    @org.junit.Test
    public void testWithinTange() {
        assertEquals(Arrays.asList(3L, 4L, 5L), Task.withinTange(Comparator.naturalOrder(),
                list1, 6L, 3L));
        assertEquals(Collections.emptyList(), Task.withinTange(Comparator.naturalOrder(),
                list1, 1L, 2L));

        /* * * * Testos de jerarquia * * * */
        assertEquals(engineers, Task.withinTange(Comparator.naturalOrder(), engineers, testEngineer[0], engineer[0]));
        //Per la naturalesa de .naturalOrder ja testeja el super de Comparator
        assertNotEquals(all.subList(6, 9), Task.withinTange(Comparator.naturalOrder(),
                                                            testList, testEngineer[1], engineer[0]));
        assertEquals(all.subList(0, 6), Task.withinTange(Comparator.naturalOrder(), all, engineer[0], employee[0]));
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

        /* * * * Testos de jerarquia * * * */
        List<Employee> testList1 = new ArrayList<>(all.subList(3, 7));
        Task.copyWithRange(all, testList1, testEngineer[1], employee[0]);
        assertEquals(all.subList(0, 10), testList1);
        testList1 = new ArrayList<>();
        Task.copyWithRange(engineers, testList1, testEngineer[0], engineer[0]);
            //Testeja super de testList1 i comparable ja que E -> Engineer
        assertEquals(engineers, testList1);
        Task.copyWithRange(engineers, testList1, admin[2], testEngineer[0]);//Testeja extends de engineers (E->Employee)
        assertEquals(all.subList(6, 9), testList1);
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

        /* * * * Testos de jerarquia * * * */
        List<Employee> testList1 = new ArrayList<>(all.subList(3, 7));
        Task.copyWithTange(Comparator.naturalOrder() ,all, testList1, testEngineer[1], employee[0]);
        assertEquals(all.subList(0, 10), testList1);
        testList1 = new ArrayList<>();
        Task.copyWithTange(Comparator.naturalOrder(),engineers, testList1, testEngineer[0], engineer[0]);
        //Testeja super de testList1 i comparable ja que E -> Engineer
        assertEquals(engineers, testList1);
        Task.copyWithTange(Comparator.naturalOrder(), engineers, testList1, admin[2], testEngineer[0]);
            //Testeja extends de engineers (E->Employee)
        assertEquals(all.subList(6, 9), testList1);
    }


}