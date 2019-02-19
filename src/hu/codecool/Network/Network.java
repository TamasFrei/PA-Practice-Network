package hu.codecool.Network;

import hu.codecool.Network.Devices.Connected;
import hu.codecool.Network.Devices.Device;
import hu.codecool.Network.Devices.Normal;
import hu.codecool.Network.Devices.Smart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Network implements AccessNormals, AccessConnecteds {

    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device device) {
        if (device instanceof Smart) {
            ((Smart) device).registerAccess(this);
        } else if (device instanceof Connected) {
            ((Connected) device).registerAccess(this);
        }
        devices.add(device);
    }

    public List<Device> getDevices() {
        return devices;
    }

    @Override
    public List<Device> collectNormals(int batteryLife) {
        return devices.stream().filter(device -> device instanceof Normal && device.getBatteryLife()-batteryLife <= 5).collect(Collectors.toList());
    }

    @Override
    public List<Device> collectConnected() {
        return devices.stream().filter(device -> device instanceof Connected).collect(Collectors.toList());
    }


}
