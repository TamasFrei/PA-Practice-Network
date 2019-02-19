package hu.codecool.Network.Devices;

import hu.codecool.Network.AccessNormals;

import java.util.List;
import java.util.Optional;

public class Smart extends ScreenDevice{

    private static int id = 1;
    private int name;
    private Optional<AccessNormals> accessToNormals = Optional.empty();

    public Smart(int age, ScreenSize screenSize) {
        super(age, screenSize);
        this.name = id;
        id++;
    }


    public void registerAccess(AccessNormals accessNormals) {
        this.accessToNormals = Optional.of(accessNormals);
    }

    @Override
    public int calculateRemainingPower() {
        batteryLife -= 15 * age + screenSize.getBatteryAgeReduction();
        return batteryLife;
    }

    public List<Device> getNormals(int number) {
        return accessToNormals.map(accessNormals -> accessNormals.collectNormals(number)).orElse(null);
    }

    @Override
    public String toString() {
        return "Smart{" +
                "name=" + name +
                ", screenSize=" + screenSize +
                ", age=" + age +
                ", batteryLife=" + batteryLife +
                '}';
    }
}
