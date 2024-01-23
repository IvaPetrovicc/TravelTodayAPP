package ba.sum.fpmoz.traveltoday.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Destination implements Parcelable {

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

    protected Destination(Parcel in) {
        name = in.readString();
        about = in.readString();
        image = in.readString();
    }

    public static final Creator<Destination> CREATOR = new Creator<Destination>() {
        @Override
        public Destination createFromParcel(Parcel in) {
            return new Destination(in);
        }

        @Override
        public Destination[] newArray(int size) {
            return new Destination[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(about);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
