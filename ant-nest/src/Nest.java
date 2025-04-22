public class Nest {

    private int size;

    private NestField[][] nestFields;


    public Nest() {
        this.size = 30;
        initNest(this.size);
    }

    public Nest(Integer n) {
        if (n == null) {
            this.size = 30;
        }
        initNest(this.size);
    }

    private void initNest(int size) {
        //coz of wall
        this.nestFields = new NestField[size + 2][size + 2];
        for (int i = 0; i < nestFields.length; i++) {
            for (int j = 0; j < nestFields[i].length; j++) {

                if (i == 0 || i == nestFields.length - 1 || j == 0 || j == nestFields[i].length - 1) {
                    nestFields[i][j] = new Wall();
                    continue;
                }

                nestFields[i][j] = new Empty();
            }
        }
    }

    public NestField[][] getNestFields() {
        return nestFields;
    }

    public void setNestFields(NestField[][] nestFields) {
        this.nestFields = nestFields;
    }

    @Override
    public String toString() {
        String display = "";

        return display;
    }
}
