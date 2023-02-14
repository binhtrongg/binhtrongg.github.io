public class LC2418 {
    //    cho 2 mảng tên và chiều cao có độ dài bằng nhau,với tên[i] và chiều cao[i] là các giá trị tương ứng
//    sắp xếp tên theo chiều cao giảm dần
//    í tưởng:for trâu để so sánh chiều cao của các phần tử trong mảng.
    public String[] sortPeople(String[] names, int[] heights) {
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (heights[j] > heights[i]) {// nếu chiều cao [j]>[i]->hoán đổi vị trí
//                    swap chiều cao
                    int temp = heights[i];
                    heights[i] = heights[j];
                    heights[j] = temp;
//                    swap tên
                    String tempp = names[i];
                    names[i] = names[j];
                    names[j] = tempp;
                }
            }
        }
        return names;
    }
}
