package employee;
/* * * * * * * *  * * * * * * * * * * * * * * *
 * Hierachy of package employee:
 * Employee --> | Engineer --> TestEngineer
 *              | Admin
 *
 * * * * * * * * * * * * * * * * * * * * * * * */
public class Admin extends Employee {
    private boolean isDirector;

    /** Constructor of the class
     *
     * @param name name of the employee
     * @param isDirector boolean if its director true.
     */
    public Admin(String name, boolean isDirector) {
        super(name);
        this.isDirector = isDirector;
    }

    /** Getter of the variable isDirector.
     *
     * @return current state of isDirector.
     */
    public boolean isDirector() {
        return isDirector;
    }
}
