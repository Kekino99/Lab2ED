package employee;

public class Engineer extends Employee {
    private int projectGroupId;

    public Engineer(String name, int projectGroupId) {
        super(name);
        this.projectGroupId = projectGroupId;
    }

    public int getProjectGroupId() {
        return projectGroupId;
    }

    public void setProjectGroupId(int projectGroupId) {
        this.projectGroupId = projectGroupId;
    }
}

