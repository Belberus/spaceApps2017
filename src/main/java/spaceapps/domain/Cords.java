package spaceapps.domain;


public class Cords {

        private double latitude;
        private double longitude;
        private double dis;
        private double bri;

        public Cords(double latitude, double longitude, double dis, double bri) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.bri = bri;
            this.dis = dis;
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
}
