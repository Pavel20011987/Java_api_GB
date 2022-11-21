package hw_6;

import java.util.Objects;

public class Laptop {
    private int ram;
    private int storage;
    private String cpuType;
    private String gpuType;
    private String screen;
    private String os;
    private String manufacturer;
    private double price;

    public Laptop(int ram, int storage, String cpuType, String gpuType,
            String screen, String os, String manufacturer, double price) {
        this.ram = ram;
        this.storage = storage;
        this.cpuType = cpuType;
        this.gpuType = gpuType;
        this.screen = screen;
        this.os = os;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public Laptop(String manufacturer, double price) {
        this(2, 256, "Intel Celeron", "Integrated", "TN",
                "Linux", manufacturer, price);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Laptop laptop = (Laptop) o;
        return ram == laptop.ram && storage == laptop.storage && Double.compare(laptop.price, price) == 0
                && Objects.equals(cpuType, laptop.cpuType) && Objects.equals(gpuType, laptop.gpuType)
                && Objects.equals(screen, laptop.screen) && Objects.equals(os, laptop.os)
                && Objects.equals(manufacturer, laptop.manufacturer);
    }

    public int hashCode() {
        return Objects.hash(ram, storage, cpuType, gpuType, screen, os, manufacturer, price);
    }

    public String toString() {
        return "Laptop{" +
                "ram=" + ram +
                ", storage=" + storage +
                ", cpuType='" + cpuType + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", screen='" + screen + '\'' +
                ", os='" + os + '\'' +
                ", maufecturer='" + manufacturer + '\'' +
                ", price=" + price +
                '}';
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getCpuType() {
        return cpuType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getScreen() {
        return screen;
    }

    public String getOs() {
        return os;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void setCpuType(String cpuType) {
        this.cpuType = cpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
