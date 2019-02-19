package hu.codecool;

import hu.codecool.Network.Devices.*;
import hu.codecool.Network.Network;

import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Network network = new Network();

        network.addDevice(new Smart(3, ScreenSize.FULLHD));
        network.addDevice(new Smart(6, ScreenSize.UHD));
        network.addDevice(new Smart(4, ScreenSize.HD));
        network.addDevice(new Smart(1, ScreenSize.EDTV));

        network.addDevice(new Normal(5, ScreenSize.HD, 2015));
        network.addDevice(new Normal(15, ScreenSize.UHD, 2019));
        network.addDevice(new Normal(50, ScreenSize.FULLHD, 1910));
        network.addDevice(new Normal(4, ScreenSize.EDTV, 1990));

        network.addDevice(new Connected(6));
        network.addDevice(new Connected(5));
        network.addDevice(new Connected(7));
        network.addDevice(new Connected(8));
        network.addDevice(new Connected(2));

        network.getDevices().forEach(device -> System.out.println(device.calculateRemainingPower()));

        network.getDevices().stream()
                .filter(device -> device instanceof Smart)
                .collect(Collectors.toList())
                .forEach(device -> System.out.println((((Smart) device).getNormals(device.getBatteryLife())).toString()));
    }
}
