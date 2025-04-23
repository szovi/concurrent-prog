public class Main {
    private static Nest nest;

    public static void main(String[] args) {
        init();
        System.out.println(nest.toString());
    }

    private static void init() {
        nest = new Nest();
    }
}