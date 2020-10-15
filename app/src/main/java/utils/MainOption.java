package utils;

public class MainOption {

    private String name;
    private int imageIDResource;

    public MainOption(String name, int imageIDResource) {
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
