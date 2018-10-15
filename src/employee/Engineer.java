package employee;
/* * * * * * * *  * * * * * * * * * * * * * * *
 * Hierachy of package employee:
 * Employee --> | Engineer --> TestEngineer
 *              | Admin
 *
 * * * * * * * * * * * * * * * * * * * * * * * */
public class Engineer extends Employee {
    private int projectGroupId;

    /**
     * @param name sets the programmer name
     * @param projectGroupId sets the projectGroupId where belongs the engineer.
     */
    public Engineer(String name, int projectGroupId) {
        super(name);
        this.projectGroupId = projectGroupId;
    }

    /**
     *
     * @return returns the projectGroupId variable
     */
    public int getProjectGroupId() {
        return projectGroupId;
    }

    /** Setter of the variable projectGroupId
     *
     * @param projectGroupId new value of projectGroupId
     */
    public void setProjectGroupId(int projectGroupId) {
        this.projectGroupId = projectGroupId;
    }
}

