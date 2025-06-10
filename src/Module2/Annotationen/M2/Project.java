package Module2.Annotationen.M2;

@Developer(name = "Richi")
class Project {

    private String projectName;

    Project(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return projectName;
    }
}
