import java.io.Serializable;

public class Computer implements Serializable {
    private String name;
    private double cpuFrequency;
    private int numberOfCores;
    private double ramCapacity;
    private double romCapacity;

    public Computer(String name, double cpuFrequency, int numberOfCores, double ramCapacity, double romCapacity) {
        this.name = name;
        this.cpuFrequency = cpuFrequency;
        this.numberOfCores = numberOfCores;
        this.ramCapacity = ramCapacity;
        this.romCapacity = romCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCpuFrequency() {
        return cpuFrequency;
    }

    public void setCpuFrequency(double cpuFrequency) {
        this.cpuFrequency = cpuFrequency;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public double getRamCapacity() {
        return ramCapacity;
    }

    public void setRamCapacity(double ramCapacity) {
        this.ramCapacity = ramCapacity;
    }

    public double getRomCapacity() {
        return romCapacity;
    }

    public void setRomCapacity(double romCapacity) {
        this.romCapacity = romCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Computer computer = (Computer) o;

        if (Double.compare(computer.cpuFrequency, cpuFrequency) != 0) return false;
        if (numberOfCores != computer.numberOfCores) return false;
        if (Double.compare(computer.ramCapacity, ramCapacity) != 0) return false;
        if (Double.compare(computer.romCapacity, romCapacity) != 0) return false;
        return name.equals(computer.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(cpuFrequency);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + numberOfCores;
        temp = Double.doubleToLongBits(ramCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(romCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", cpuFrequency=" + cpuFrequency +
                ", numberOfCores=" + numberOfCores +
                ", ramCapacity=" + ramCapacity +
                ", romCapacity=" + romCapacity;
    }

}
