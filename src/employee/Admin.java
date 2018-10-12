package employee;

public class Admin extends Employee {
    private boolean isDirector;

    public Admin(String name, boolean isDirector) {
        super(name);
        this.isDirector = isDirector;
    }

    public boolean isDirector() {
        return isDirector;
    }
}
