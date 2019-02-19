package hu.codecool.Network.Devices;

public abstract class ScreenDevice extends Device {

    protected ScreenSize screenSize;

    public ScreenDevice(int age, ScreenSize screenSize) {
        super(age);
        this.screenSize = screenSize;
    }
}
