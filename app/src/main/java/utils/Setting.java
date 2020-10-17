package utils;

public class Setting {

    private String name;
    private int imageIDResource;

    public Setting(String name, int imageIDResource) {
        this.name = name;
        this.imageIDResource = imageIDResource;
    }

    public String getName() {
        return name;
    }

    public int getImageIDResource() {
        return imageIDResource;
    }
}
