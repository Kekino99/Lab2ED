package employee;
/* * * * * * * *  * * * * * * * * * * * * * * *
 * Hierachy of package employee:
 * Employee --> | Engineer --> TestEngineer
 *              | Admin
 *
 * * * * * * * * * * * * * * * * * * * * * * * */
public class TestEngineer extends Engineer {
    private boolean likesPotetoes;

    //Constructor
    public TestEngineer(String name, int projectGroupId, boolean likesPotetoes) {
        super(name, projectGroupId);
        this.likesPotetoes = likesPotetoes;
    }

    public boolean isLikesPotetoes() {
        return likesPotetoes;
    }

}
