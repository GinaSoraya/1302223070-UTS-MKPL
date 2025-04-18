package lib;

public class Child {
    private String childNames;
    private String childIdNumber;

    public Child(String childNames, String childIdNumber) {
        this.childNames = childNames;
        this.childIdNumber = childIdNumber;
    }

    public String getChildNames() {
        return childNames;
    }

    public void setChildNames(String childNames) {
        this.childNames = childNames;
    }

    public String getChildIdNumber() {
        return childIdNumber;
    }

    public void setChildIdNumber(String childIdNumber) {
        this.childIdNumber = childIdNumber;
    }
}