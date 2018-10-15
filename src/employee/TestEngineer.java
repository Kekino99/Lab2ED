package employee;
/* * * * * * * *  * * * * * * * * * * * * * * *
 * Hierachy of package employee:
 * Employee --> | Engineer --> TestEngineer
 *              | Admin
 *
 * * * * * * * * * * * * * * * * * * * * * * * */
public class TestEngineer extends Engineer {
    private boolean potatoeFan;

    /** Constructor of the class
     *
     * @param name sets the engineer name
     * @param projectGroupId sets the projectGroupId where belongs the engineer.
     * @param potatoeFan sets the most important information about the engineer.
     */
    public TestEngineer(String name, int projectGroupId, boolean potatoeFan) {
        super(name, projectGroupId);
        this.potatoeFan = potatoeFan;
    }

    /** Getter of potatoeFan
     *
     * @return returns the value of  the most important information about the engineer.
     */
    public boolean isPotatoeFan() {
        return potatoeFan;
    }

}
