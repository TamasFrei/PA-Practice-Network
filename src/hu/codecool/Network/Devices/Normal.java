package hu.codecool.Network.Devices;

public class Normal extends ScreenDevice {

    private int manufacturingYear;

    public Normal(int age, ScreenSize screenSize, int manufacturingYear) {
        super(age, screenSize);
        this.manufacturingYear = manufacturingYear;
        if (manufacturingYear >= 2000) {
            batteryLife *= 2;
        } else {
            batteryLife *= 0.5;
        }
    }

    @Override
    public int calculateRemainingPower() {
        batteryLife -= 3 * age;
        return batteryLife;
    }

    @Override
    public String toString() {
        return "Normal{" +
                "manufacturingYear=" + manufacturingYear +
                ", screenSize=" + screenSize +
                ", age=" + age +
                ", batteryLife=" + batteryLife +
                '}';
    }
}
