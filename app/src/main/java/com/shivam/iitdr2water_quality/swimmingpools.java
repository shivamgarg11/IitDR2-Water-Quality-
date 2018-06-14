package com.shivam.iitdr2water_quality;

public class swimmingpools {

    String Name;
    String address;
    int Ph;
    int Chlorine;
    int phthreshold_max;
    int phthreshold_min;
    int Chlorinethreshold_max;
    int Chlorinethreshold_min;

    public swimmingpools(String name, String address, int ph, int chlorine, int phthreshold_max, int phthreshold_min, int chlorinethreshold_max, int chlorinethreshold_min) {
        Name = name;
        this.address = address;
        Ph = ph;
        Chlorine = chlorine;
        this.phthreshold_max = phthreshold_max;
        this.phthreshold_min = phthreshold_min;
        Chlorinethreshold_max = chlorinethreshold_max;
        Chlorinethreshold_min = chlorinethreshold_min;
    }


    public String getName() {
        return Name;
    }

    public String getAddress() {
        return address;
    }

    public int getPh() {
        return Ph;
    }

    public int getChlorine() {
        return Chlorine;
    }

    public int getPhthreshold_max() {
        return phthreshold_max;
    }

    public int getPhthreshold_min() {
        return phthreshold_min;
    }

    public int getChlorinethreshold_max() {
        return Chlorinethreshold_max;
    }

    public int getChlorinethreshold_min() {
        return Chlorinethreshold_min;
    }
}
