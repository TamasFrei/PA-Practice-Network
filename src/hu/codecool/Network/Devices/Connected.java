package hu.codecool.Network.Devices;

import hu.codecool.Network.AccessConnecteds;

import java.util.Optional;

public class Connected extends Device {

    private Optional<AccessConnecteds> accessToConnectedList = Optional.empty();

    public Connected(int age) {
        super(age);
    }

    public void registerAccess(AccessConnecteds accessConnecteds) {
        this.accessToConnectedList = Optional.of(accessConnecteds);
    }

    @Override
    public int calculateRemainingPower() {
        batteryLife -= 7 * age;
        if (accessToConnectedList.isPresent()) {
            batteryLife -= 20 * (accessToConnectedList.get().collectConnected().size()-1);
        } else {
            System.out.println("There aren't any other devices");
        }
        return batteryLife;
    }

    @Override
    public String toString() {
        return "Connected{" +
                "age=" + age +
                ", batteryLife=" + batteryLife +
                '}';
    }
}
