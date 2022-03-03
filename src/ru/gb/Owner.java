package ru.gb;

public class Owner {
    private String name;
    private String address;

    public Owner(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getOwnerName() {
        return name;
    }

    public String getOwnerAddress() {
        return address;
    }
}
