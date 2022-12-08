public class Bai1 {
    public static void main(String[] args) {
        inHV(4);
        System.out.println();
        tamGiac(4,5);
    }
    static void inHV(int n){
        int[][] arr=new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }

//    in tam giac
static void tamGiac(int a,int b){
    int[][] arr=new int[a][b];
    for (int i = 0; i < a; i++) {
        for (int j = 0; j <b ; j++) {
            if(i>=j){
                System.out.print("*"+" ");
            }
        }
        System.out.println();
    }
}
}
