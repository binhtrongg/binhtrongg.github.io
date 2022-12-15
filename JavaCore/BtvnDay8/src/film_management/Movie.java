package film_management;

public class Movie extends Film {

    public String time;
    public Movie() {
    }
    public Movie(int id, String name, String category, String author, String day, String time) {
        super(id, name, category, author, day);
        this.time = time;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Movie{" +
                ", id=" + this.id +
                ", name='" + this.name + '\'' +
                ", category='" + this.category + '\'' +
                ", author='" + this.author + '\'' +
                ", day='" + this.day + '\'' +
                "time='" + time + '\''+
                '}';
    }
}
