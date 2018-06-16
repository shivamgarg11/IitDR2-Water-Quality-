package com.shivam.iitdr2water_quality;

public class swimmingpools {

    String Name;
    String address;
    double Ph;
    double Chlorine;
    double phthreshold_max;
    double phthreshold_min;
    double Chlorinethreshold_max;
    double Chlorinethreshold_min;

    public swimmingpools(String name, String address, double ph, double chlorine, double phthreshold_max, double phthreshold_min, double chlorinethreshold_max, double chlorinethreshold_min) {
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

    public double getPh() {
        return Ph;
    }

    public double getChlorine() {
        return Chlorine;
    }

    public double getPhthreshold_max() {
        return phthreshold_max;
    }

    public double getPhthreshold_min() {
        return phthreshold_min;
    }

    public double getChlorinethreshold_max() {
        return Chlorinethreshold_max;
    }

    public double getChlorinethreshold_min() {
        return Chlorinethreshold_min;
    }
}
