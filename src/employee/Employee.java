package employee;

import org.jetbrains.annotations.NotNull;

/**
/* * * * * * * *  * * * * * * * * * * * * * * *
* Hierachy of package employee:
* Employee --> | Engineer --> TestEngineer
*              | Admin
*
* * * * * * * * * * * * * * * * * * * * * * * */
public class Employee implements Comparable<Employee> {

    private static int numOfEmployees = 0;
    private int id;
    private String name;

    /**Constructor of the class
     *
     * @param name name of the employee
     */
    public Employee(String name) {
        this.id=numOfEmployees;
        numOfEmployees++;
        this.name=name;
    }










    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Employee o) {
        if(o == null) {
            throw new NullPointerException();
        } else {
            return Integer.compare(this.getId(), o.getId());
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals (Object o) {
        if(o instanceof Employee) {
            return this.getId() == ((Employee) o).getId();
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    public String toString() {
        return this.getName() + " with id: " + this.getId();
    }

}
