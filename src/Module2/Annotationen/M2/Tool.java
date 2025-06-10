package Module2.Annotationen.M2;

@Developer(name = "lala")
class Tool {

}

class SubTool extends Tool {

    public static void main(String[] args) {
        Class<SubTool> clazz = SubTool.class;
        System.out.println(clazz.isAnnotationPresent(Developer.class));
    }
}
