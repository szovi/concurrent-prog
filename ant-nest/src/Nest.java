import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Nest {

    private int size;
    private ThreadLocalRandom random;


    private ScheduledExecutorService scheduler;
    private static final int DEFAULT_DELAY = 200;

    private static final int DEFAULT_ANTS = 10;
    private static final int DEFAULT_NUTRITION = 10;
    private static final int DEFAULT_PHEROMONE = 10;
    private AtomicInteger nutritionCount = new AtomicInteger(0);
    private AtomicInteger pheromoneCount = new AtomicInteger(0);


    private NestField[][] nestFields;

    public Nest() {
        this.size = 30;
        this.random = ThreadLocalRandom.current();
        initNest(this.size);
        placeAnts();
    }

    public Nest(Integer n) {
        if (n == null) {
            this.size = 30;
        }
        this.random = ThreadLocalRandom.current();
        initNest(this.size);
        placeAnts();
    }

    private void initNest(int size) {
        //coz of wall
        this.nestFields = new NestField[size + 2][size + 2];
        for (int i = 0; i < nestFields.length; i++) {
            for (int j = 0; j < nestFields[i].length; j++) {
                if (i == 0 || i == nestFields.length - 1 || j == 0 || j == nestFields[i].length - 1) {
                    nestFields[i][j] = (new Wall()).setPosition(new Position(i, j));
                    continue;
                }
                nestFields[i][j] = (new Empty()).setPosition(new Position(i, j));
            }
        }
    }

    private void placeAnts() {
        for (int i = 0; i < DEFAULT_ANTS; i++) {
            placeRandomNestFieldItem(new Ant());
        }
    }

    public void placeNutritionAndPheromone() {
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            if (nutritionCount.get() < DEFAULT_NUTRITION && pheromoneCount.get() < DEFAULT_PHEROMONE) {
                placeRandomNestFieldItem(new Nutrition());
                placeRandomNestFieldItem(new Pheromone());
                nutritionCount.incrementAndGet();
                pheromoneCount.incrementAndGet();

                System.out.println(this);
            } else {
                scheduler.shutdown(); // Leállítjuk a scheduler-t ha elértük a limitet
            }
        }, 0, DEFAULT_DELAY, TimeUnit.MILLISECONDS);
    }

    private void placeRandomNestFieldItem(NestField element) {
        int row, col;
        do {
            // +1 because of walls, -2 to avoid walls
            row = 1 + random.nextInt(nestFields.length - 2);
            col = 1 + random.nextInt(nestFields.length - 2);
        } while (!(nestFields[row][col] instanceof Empty));

        nestFields[row][col] = element;
        element.setPosition(new Position(row, col));
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