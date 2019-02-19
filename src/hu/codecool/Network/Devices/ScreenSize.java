package hu.codecool.Network.Devices;

public enum ScreenSize {

    EDTV(5),
    HD(10),
    FULLHD(15),
    UHD(20);

    private int batteryAgeReduction;

    ScreenSize(int batteryAgeReduction) {
        this.batteryAgeReduction = batteryAgeReduction;
    }

    public int getBatteryAgeReduction() {
        return batteryAgeReduction;
    }
}
