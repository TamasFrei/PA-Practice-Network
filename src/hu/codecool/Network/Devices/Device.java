package hu.codecool.Network.Devices;

public abstract class Device {

    protected int age;
    protected int batteryLife;

    public Device(int age) {
        this.age = age;
        this.batteryLife = 100;
    }

    public abstract int calculateRemainingPower();

    public int getBatteryLife() {
        return batteryLife;
    }
}
