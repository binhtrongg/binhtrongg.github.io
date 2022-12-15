package film_management;

public class Serial extends Film {
    public int espion;
    public String averageTime;
    public Serial() {
    }
    public Serial(int id, String name, String category, String author, String day, int espion, String averageTime) {
        super(id, name, category, author, day);
        this.espion = espion;
        this.averageTime = averageTime;
    }

    public int getEspion() {
        return espion;
    }

    public void setEspion(int espion) {
        this.espion = espion;
    }

    public String getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(String averageTime) {
        this.averageTime = averageTime;
    }

    @Override
    public String toString() {
        return "Serial{" +

                ", id=" + this.id +
                ", name='" + this.name + '\'' +
                ", category='" + this.category + '\'' +
                ", author='" + this.author + '\'' +
                ", day='" + this.day + '\'' +
                "espion=" + espion +
                ", averageTime='" + averageTime + '\''+
                '}';
    }
}
