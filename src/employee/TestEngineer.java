package employee;

public class TestEngineer extends Engineer {
    private boolean likesPotetoes;
    public TestEngineer(String name, int projectGroupId, boolean likesPotetoes) {
        super(name, projectGroupId);
        this.likesPotetoes = likesPotetoes;
    }

    public boolean isLikesPotetoes() {
        return likesPotetoes;
    }

}
