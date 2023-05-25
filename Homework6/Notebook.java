package Homework6;

public class Notebook {
    private String cpu;
    private Integer ram;
    private Integer hdd;
    private String os;
    private String color;

    public Notebook(String cpu, Integer ram, Integer hdd, String os, String color) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        return "CPU: " + cpu + ", RAM: " + ram + ", HDD: " + hdd + ", OS: " + os + ", Color: " + color;
    }

    public String getCpu() {
        return cpu;
    }

    public Integer getRam() {
        return ram;
    }

    public Integer getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

}
