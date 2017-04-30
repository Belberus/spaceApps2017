package spaceapps.domain;


public class Cords {

        private double latitude;
        private double longitude;
        private double intensity;


        public Cords(double latitude, double longitude, double intensity) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.intensity = intensity;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getIntensity() {
        return intensity;
    }

        public void setIntensity(double intensity) {
        this.intensity = intensity;
    }
}
