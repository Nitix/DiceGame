package Controller;

/**
 * Created by Asus on 08/01/2017.
 */
public class Randomizer {
    private static Randomizer instance;
    private static boolean created = false;
    private static int value;
    private static int maxValue = 12;

    public static Randomizer getInstance(){
        if(!created){
            instance = new Randomizer();
            created = true;
        }
        return instance;
    }

    private Randomizer(){
        this.value = (int) (Math.random()*maxValue);
    }

    private static int reload(){
        getInstance().value = (int) (Math.random()*maxValue);
        return  getInstance().getValue();
    }

    public static int getValue() {
        return value;
    }

    public static int getMaxValue() {
        return maxValue;
    }

    public static void setMaxValue(int maxValue) {
        Randomizer.maxValue = maxValue;
    }
}
