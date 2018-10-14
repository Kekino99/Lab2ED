package employee;
/* * * * * * * *  * * * * * * * * * * * * * * *
 * Hierachy of package employee:
 * Employee --> | Engineer --> TestEngineer
 *              | Admin
 *
 * * * * * * * * * * * * * * * * * * * * * * * */
public class Admin extends Employee {
    private boolean isDirector;

    //Constructor
    public Admin(String name, boolean isDirector) {
        super(name);
        this.isDirector = isDirector;
    }

    public boolean isDirector() {
        return isDirector;
    }
}
