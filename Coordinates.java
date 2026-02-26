public class Coordinates {
    int longitude;
    int latitude;
    int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }

    // new
    public void updateLongitude(int rest) {
        this.logitude = this.longitude + rest;
    }

    public void updateLatitude(int rest) {
        this.latitude = this.latitude + rest;
    }

    public void updateHeight(int rest) {
        this.height = this.height + rest;
    }
}
