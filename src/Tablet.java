import javax.annotation.Resource;
import java.io.Serializable;

public class Tablet extends Computer implements Serializable, Cloneable {
    @Resource
    private OperationSystemNames osName;
    private double displaySize;
    private int batteryCapacity;

    public Tablet(String name, double cpuFrequency, int numberOfCores, double ramCapacity,
                  double romCapacity, OperationSystemNames osName, double displaySize, int batteryCapacity) {
        super(name, cpuFrequency, numberOfCores, ramCapacity, romCapacity);
        this.osName = osName;
        this.displaySize = displaySize;
        this.batteryCapacity = batteryCapacity;
    }
    public OperationSystemNames getOsName() {
        return osName;
    }

    @Tag
    public void setOsName(OperationSystemNames osName) {
        this.osName = osName;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(double displaySize) {
        this.displaySize = displaySize;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Tablet tablet = (Tablet) o;

        if (Double.compare(tablet.displaySize, displaySize) != 0) return false;
        if (batteryCapacity != tablet.batteryCapacity) return false;
        return osName == tablet.osName;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + osName.hashCode();
        temp = Double.doubleToLongBits(displaySize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + batteryCapacity;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " osName=" + osName +
                ", displaySize=" + displaySize +
                ", batteryCapacity=" + batteryCapacity;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
