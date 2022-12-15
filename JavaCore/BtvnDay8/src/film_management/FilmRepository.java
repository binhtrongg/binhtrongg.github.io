package film_management;

public class FilmRepository {
    public static Film[] movies = {
            new Movie(1, "attack on titan", "action", "chonq", "20/12", "180p"),
            new Movie(2, "Transformer", "action", "chonqpink", "22/12", "200p"),
            new Movie(3, "ironman", "action", "pinkchonq", "19/5", "300p"),
    };

    public static Serial[] serials={
            new Serial(4, "co dau 8 tuoi", "anime", "trong", "32/2", 1800, "32p"),
            new Serial(5, "dragonball", "action", "Binhtrong", "23/8", 2382, "15p"),
            new Serial(6, "onePiece", "anime", "emtrong", "12/3", 230, "20p"),
    };
}



