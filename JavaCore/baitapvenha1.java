public class baitapvenha1 {
   public static void main(String[] agrs){
       xinChao();
       xinChaoX("Bình Trọng");
       xinChaoX2("'Bình Trọng'");

       int tong=sum(20,30);
       System.out.println("tong" +" "+ tong);

       int binhPhuong=binhphuong(9);
       System.out.println("binh phuong cua 9 là" +" "+binhPhuong);

       double chisobmi=bmi(1.58,60);
       System.out.println("chỉ số BMI là"+ " " +chisobmi );

       int theki= (int) Math.ceil(gettheki(1));
       System.out.println("thế kỉ thứ "+theki );
   }
//   bài 1
   public static void xinChao(){
       System.out.println("xin chào các bạn");
   }
//   bài 2
   public static void xinChaoX(String name){
       System.out.println("xin chào " + name);
   }
//   bài 3
   public static void xinChaoX2(String name1){
       System.out.println("xin chào " + name1);
   }
//   bài 4
   public static int sum(int a,int b){
       return a+b;
   }
//   bài 5
   public static int binhphuong(int x){
       return x*x;
   }
//   bài 6
   public static double gettheki(double b){
       return b/100;
   }
//   bài 7
   public static double bmi(double h ,double w){
       return w/(h*h);
   }
}
