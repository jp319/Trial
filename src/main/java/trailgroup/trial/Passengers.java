package trailgroup.trial;

public class Passengers {
    public int id;
    public int bagId;
    public String imagePath;
    public Passengers (int id, int bagId, String imagePath) {
        this.id = id;
        this.bagId = bagId;
        this.imagePath = imagePath;
    }
    public int getId() {
        return id;
    }
    public int getBagId() {
        return bagId;
    }
    public String getImagePath() {
        return imagePath;
    }
}
