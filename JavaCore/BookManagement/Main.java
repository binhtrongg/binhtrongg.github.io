package BookManagement;

import BookManagement.controller.BookController;

public class Main {
    public static void main(String[] args) {
//
//        controller:Tiếp nhận request từ người dùng
//        model: Chứa các đối tượng
//        service: Chứa business logic của ứng dụng
//        repository:chứa dữ liệu {database}

//        actor-> guwri request(1,2,3)-> gửi tt request->service->repository
        BookController bookController=new BookController();
        bookController.run();
    }
}