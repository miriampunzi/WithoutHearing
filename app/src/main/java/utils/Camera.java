package utils;

public class Camera {

    private String name;
    private int idResourceView;

    public Camera(String name, int idResourceView) {
        this.name = name;
        this.idResourceView = idResourceView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdResourceView() {
        return idResourceView;
    }

    public void setIdResourceView(int idResourceView) {
        this.idResourceView = idResourceView;
    }
}
