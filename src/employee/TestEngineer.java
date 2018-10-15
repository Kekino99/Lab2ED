package employee;
/* * * * * * * *  * * * * * * * * * * * * * * *
 * Hierachy of package employee:
 * Employee --> | Engineer --> TestEngineer
 *              | Admin
 *
 * * * * * * * * * * * * * * * * * * * * * * * */
public class TestEngineer extends Engineer {
    private boolean potatoeFan;

    //Constructor
    public TestEngineer(String name, int projectGroupId, boolean potatoeFan) {
        super(name, projectGroupId);
        this.potatoeFan = potatoeFan;
    }

    public boolean isPotatoeFan() {
        return potatoeFan;
    }

}
