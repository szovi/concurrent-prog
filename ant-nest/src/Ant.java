public class Ant implements NestField, Runnable {

    private int nutritionLevel;

    public Ant() {
        this.nutritionLevel = 50;
    }

    @Override
    public void run() {
        //ant logic
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
