import java.util.Random;

public class Nest {

    private int size;
    private Random random;

    private static final int DEFAULT_SIZE = 30;
    private static final int DEFAULT_ANTS = 10;
    private static final int DEFAULT_NUTRITION = 10;
    private static final int DEFAULT_PHEROMONE = 10;

    private NestField[][] nestFields;

    public Nest() {
        this.size = 30;
        this.random = new Random();
        initNest(this.size);
        placeInitialElements();
    }

    public Nest(Integer n) {
        if (n == null) {
            this.size = 30;
        }
        this.random = new Random();
        initNest(this.size);
        placeInitialElements();
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

    private void placeInitialElements() {
        // Place initial ants
        for (int i = 0; i < DEFAULT_ANTS; i++) {
            placeRandomElement(new Ant());
        }

        // Place initial nutrition
        for (int i = 0; i < DEFAULT_NUTRITION; i++) {
            placeRandomElement(new Nutrition());
        }

        // Place initial pheromones
        for (int i = 0; i < DEFAULT_PHEROMONE; i++) {
            placeRandomElement(new Pheromone());
        }
    }

    private void placeRandomElement(NestField element) {
        int row, col;
        do {
            // +1 because of walls, -2 to avoid walls
            row = 1 + random.nextInt(nestFields.length - 2);
            col = 1 + random.nextInt(nestFields.length - 2);
        } while (!(nestFields[row][col] instanceof Empty));

        nestFields[row][col] = element;
    }

    public NestField[][] getNestFields() {
        return nestFields;
    }

    public void setNestFields(NestField[][] nestFields) {
        this.nestFields = nestFields;
    }

    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        for (NestField[] row : nestFields) {
            for (NestField field : row) {
                display.append(field.toString());
            }
            display.append("\n");
        }
        return display.toString();
    }
}