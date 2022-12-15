package film_management;

public class Film {
    public int id;
    public String name;
    public String category;
    public String author;
    public String day;

    public static void findbyName(String name) {
        int cout = 0;
        for (Film film : FilmRepository.movies) {
            if (film.name.toLowerCase().contains(name.toLowerCase())) {
                System.out.println(film);
                cout++;
            }
        }
        for (Film film : FilmRepository.serials) {
            if (film.name.toLowerCase().contains(name.toLowerCase())) {
                System.out.println(film);
                cout++;
            }
        }
        if (cout == 0) {
            System.out.println("khong co Film nao co ten " + name);
        }
    }
    public Film() {
    }
    public Film(int id, String name, String category, String author, String day) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.author = author;
        this.day = day;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDay() {
        return day;
    }
    public void setDay (String day){
        this.day = day;
    }
    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", day=" + day +
                '}';
    }
}
