package spaceapps.domain;


public class Cords {

    private double latf;
    private double longf;
    private double intensity;
    private double lata;
    private double longa;

    public Cords(double latf, double longf, double intensity, double lata, double longa) {
        this.latf=latf;
        this.longf=longf;
        this.intensity=intensity;
        this.lata=lata;
        this.longa=longa;

        }

    public double getLatf() {
        return latf;
    }

    public void setLatf(double latf) {
        this.latf = latf;
    }

    public double getLongf() {
        return longf;
    }

    public void setLongf(double longf) {
        this.longf = longf;
    }

    public double getIntensity() {
        return intensity;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    public double getLata() {
        return lata;
    }

    public void setLata(double lata) {
        this.lata = lata;
    }

    public double getLonga() {
        return longa;
    }

    public void setLonga(double longa) {
        this.longa = longa;
    }

}
