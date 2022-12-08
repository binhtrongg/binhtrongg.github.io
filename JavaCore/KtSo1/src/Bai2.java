public class Bai2 {
    public static void main(String[] args) {
        demTU("binh trong");
        demKiTu("binh trong");

    }

    static String demTU(String str) {
        String[] word = str.split(" ");
        System.out.println(word.length);
        return str;
    }

    static void demKiTu(String str) {
        int dem = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)== 'o') {
                dem++;
            }
        }
        System.out.println("ki tu o xuat hien "+dem+" lan");
        System.out.println("index cua ki tu o "+str.indexOf('o'));
    }
}
