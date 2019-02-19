package hu.codecool.Network;

import hu.codecool.Network.Devices.Device;

import java.util.List;

public interface AccessNormals {

    List<Device> collectNormals(int batteryLife);
}
