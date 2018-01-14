package productions.darthplagueis.testingsqlite.model;

/**
 * Created by oleg on 1/14/18.
 */

public class LaptopSighting {

    private String name;
    private String timeStamp;
    private String laptopType;
    private int isOpen;
    private int isUsing;
    private String location;
    private int isFellow;
    private int totalLaptops;

    public LaptopSighting(String name, String laptopType, int isOpen, int isUsing, String location, int isFellow, int totalLaptops) {
        this.name = name;
        this.laptopType = laptopType;
        this.isOpen = isOpen;
        this.isUsing = isUsing;
        this.location = location;
        this.isFellow = isFellow;
        this.totalLaptops = totalLaptops;
    }

    public LaptopSighting(String name, String timeStamp, String laptopType, int isOpen, int isUsing, String location, int isFellow, int totalLaptops) {
        this.name = name;
        this.timeStamp = timeStamp;
        this.laptopType = laptopType;
        this.isOpen = isOpen;
        this.isUsing = isUsing;
        this.location = location;
        this.isFellow = isFellow;
        this.totalLaptops = totalLaptops;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getLaptopType() {
        return laptopType;
    }

    public void setLaptopType(String laptopType) {
        this.laptopType = laptopType;
    }

    public int isOpen() {
        return isOpen;
    }

    public void setOpen(int open) {
        isOpen = open;
    }

    public int isUsing() {
        return isUsing;
    }

    public void setUsing(int using) {
        isUsing = using;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int isFellow() {
        return isFellow;
    }

    public void setFellow(int fellow) {
        isFellow = fellow;
    }

    public int getTotalLaptops() {
        return totalLaptops;
    }

    public void setTotalLaptops(int totalLaptops) {
        this.totalLaptops = totalLaptops;
    }
}
