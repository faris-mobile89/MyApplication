package abudhabi.com.myapplication;

/**
 * Created by Faris on 2/28/17.
 */

public class HomeMenuItem {

    private String title;
    private int imageResourceId;

    public HomeMenuItem(String title, int imageResourceId) {
        this.title = title;
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
