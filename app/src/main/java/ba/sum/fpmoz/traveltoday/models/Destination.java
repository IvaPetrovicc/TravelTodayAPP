package ba.sum.fpmoz.traveltoday.models;

public class Destination {

    public String name;
    public String about;
    public String image;

    public Destination() {
    }

    public Destination(String name, String about, String image) {
        this.name = name;
        this.about = about;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
