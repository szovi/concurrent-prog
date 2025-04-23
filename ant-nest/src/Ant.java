public class Ant extends NestField implements Runnable {

    private int nutritionLevel;

    public Ant() {
        this.nutritionLevel = 50;
    }

    @Override
    public void run() {


    }

    @Override
    public String toString() {
        return "A";
    }

    public int getNutritionLevel() {
        return nutritionLevel;
    }

    public void setNutritionLevel(int nutritionLevel) {
        this.nutritionLevel = nutritionLevel;
    }

}
