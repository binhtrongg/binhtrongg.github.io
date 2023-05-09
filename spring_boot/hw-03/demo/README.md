# I.SPRING MVC
## 1.Giới thiệu về Spring MVC
### 1.1 Khái Niệm
Spring MVC là một phần trong Spring Framework, là một framework phổ biến trong Java để xây dựng các ứng dụng web.

Spring MVC cung cấp một mô hình phát triển ứng dụng web theo mô hình MVC (Model-View-Controller)
## 2.Mô Hình Hoạt Động Cơ Bản:
![MVC](https://images.viblo.asia/8766ea47-8d20-4045-a616-8e7c101bbb79.png)
* Model:là các file POJO, Service, DAO thực hiện truy cập database, xử lý business
* View: là các file JSP, html…
* Control: là Dispatcher Controller, Handler Mapping, Controller – thực hiện điều hướn các request.
## 3.Các thành phần của Spring MVC
* DispatcherServlet: là một servlet được sử dụng để xử lý các yêu cầu tới ứng dụng Spring. Nó là trung tâm điều khiển của framework và phân phối yêu cầu đến các thành phần khác của framework.
* HandlerMapping: là thành phần xác định controller nào sẽ xử lý yêu cầu được gửi đến từ DispatcherServlet.
* Controller: là thành phần xử lý logic business và trả về model và view cho DispatcherServlet.
* ViewResolver: là thành phần xác định view (thường là các file JSP hoặc HTML) sẽ được sử dụng để hiển thị model dữ liệu được trả về từ Controller.
* ModelAndView: là một đối tượng bao gồm model dữ liệu và tên của view sẽ được sử dụng để hiển thị model đó.
* ModelAttribute: là một annotation được sử dụng để chỉ định một thuộc tính của một controller là một attribute của model và sẽ được trả về cho view.
* RequestMapping: là một annotation được sử dụng để chỉ định URL mà controller có thể xử lý và HTTP method (GET, POST, PUT, DELETE) mà controller hỗ trợ.
* Model: là một đối tượng lưu trữ dữ liệu được sử dụng để chuyển dữ liệu giữa Controller và View.
* View: là một thành phần hiển thị dữ liệu được trả về từ Controller, thông thường là các file JSP hoặc HTML.

## 4.MVC hoạt động thế nào trong Spring
![MVC](https://user-images.githubusercontent.com/29374426/179367062-8b4e0328-d5f8-40ae-9825-e2895c0561b0.png)
* Đầu tiên. sau khi nhận được yêu cầu HTTP, DispatcherServlet liên lạc với HandlerMapping để xác định controller nào sẽ xử lý yêu cầu này.
* DispatcherServlet gửi yêu cầu đến controller sau khi biết được controller nào sẽ xử lý yêu cầu. Controller nhận các yêu cầu và gọi phương thức thích hợp bằng cách sử dụng phương thức GET hoặc POST. Tại đây phương thức thích hợp được gọi sẽ thiết lập model dữ liệu và trả về tên view (đối tượng ModelAndView) cho DispatcherServlet.
* Tiếp theo, DispatcherServlet sẽ nhận được sử trợ giúp từ ViewResolver để xác định view cho các yêu cầu.
* Cuối cùng, quá trình chọn view hoàn thành, DispatcherServlet chuyển model dữ liệu tới view đó và cuối cùng chuyển tới trình duyệt.
## 5.Annotations trong Spring MVC
Annotations trong Spring MVC là các annotation được sử dụng để đánh dấu các phần tử trong ứng dụng web, ví dụ như controller, model, view, request mapping, và nhiều hơn nữa. Sử dụng annotations là một cách tiện lợi để cấu hình và quản lý các thành phần Spring MVC trong ứng dụng web.

Một số annotations quan trọng trong Spring MVC bao gồm:
* @Controller: đánh dấu một class là một Spring MVC controller.
* @RequestMapping: xác định URL mà controller xử lý và phương thức HTTP (GET, POST, PUT, DELETE) mà controller hỗ trợ.
* @Component: Được sử dụng để đánh dấu một lớp là một Spring bean. Lớp được đánh dấu @Component sẽ được quản lý bởi Spring và có thể được tự động liên kết với các bean khác bằng cách sử dụng @Autowired.
* @Service: Được sử dụng để đánh dấu một lớp là một Spring Service. Một Service là một thành phần chứa logic business và thường được sử dụng để xử lý các nghiệp vụ phức tạp.
* @Repository: Được sử dụng để đánh dấu một lớp là một Spring Repository. Một Repository thường được sử dụng để thực hiện các thao tác truy vấn với cơ sở dữ liệu.
* @ModelAttribute: chỉ định một thuộc tính của một controller là một attribute của model và sẽ được trả về cho view.
* @ResponseBody: xác định phương thức sẽ trả về một đối tượng dưới dạng body của HTTP response.
* @ResponseStatus: chỉ định HTTP status code sẽ được sử dụng trong HTTP response trả về từ phương thức controller.
  
Với các annotations này, việc cấu hình và quản lý các thành phần Spring MVC trong ứng dụng web trở nên dễ dàng và hiệu quả hơn.
## 6.Sử dụng Spring MVC
### 6.1 Cách sử dụng :
* Tạo một project Spring MVC: Bạn có thể tạo project Spring MVC bằng cách sử dụng các IDE phổ biến như Eclipse, IntelliJ IDEA, NetBeans hoặc sử dụng Spring Boot để tạo project.
* Thiết lập cấu hình: Bạn cần phải thiết lập các cấu hình cho project Spring MVC như cấu hình cho DispatcherServlet, cấu hình view resolver, cấu hình data source, và các cấu hình khác.
* Tạo các controllers: Bạn cần phải tạo các controllers để xử lý các yêu cầu từ client. Trong Spring MVC, controller có thể được tạo bằng cách sử dụng annotation @Controller.
* Tạo các views: Bạn cần phải tạo các views để hiển thị dữ liệu trả về từ controllers. Trong Spring MVC, các view thường được tạo bằng cách sử dụng các file JSP hoặc Thymeleaf.
* Xử lý các yêu cầu từ client: Sau khi bạn đã tạo các controllers và views, bạn cần phải xử lý các yêu cầu từ client. Trong Spring MVC, các yêu cầu từ client được xử lý bởi DispatcherServlet và được chuyển đến các controllers tương ứng.
* Trả về các views: Sau khi xử lý các yêu cầu từ client, các controllers trả về các model và view tương ứng với dữ liệu được trả về. DispatcherServlet sử dụng view resolver để xác định view tương ứng với các model trả về.
* Hiển thị dữ liệu trả về: Cuối cùng, dữ liệu trả về từ controllers được hiển thị trên các view tương ứng. Các view sẽ sử dụng các model được trả về để hiển thị dữ liệu trên các trình duyệt của client.
### 6.2 Lí do nên sử dụng Spring MVC?
dưới đây là 1 vài lí do nên sử dụng Spring MVC:
* Thiết kế mô hình MVC: Spring MVC thực hiện mô hình MVC (Model-View-Controller), giúp tách biệt logic ứng dụng và giao diện người dùng. Điều này giúp cải thiện khả năng bảo trì, mở rộng và tái sử dụng mã.
* Tích hợp tốt với Spring Framework: Spring MVC được tích hợp chặt chẽ với Spring Framework, cung cấp nhiều tính năng hữu ích như dependency injection, transaction management, security, và nhiều hơn nữa.
* Hỗ trợ nhiều định dạng view: Spring MVC hỗ trợ nhiều định dạng view như JSP, Thymeleaf, FreeMarker, và nhiều hơn nữa. Điều này cho phép lập trình viên lựa chọn định dạng view phù hợp nhất cho ứng dụng của họ.
* Hỗ trợ RESTful web services: Spring MVC cung cấp các tính năng để phát triển RESTful web services, cho phép ứng dụng của bạn giao tiếp với các ứng dụng khác bằng cách sử dụng các giao thức RESTful.
* Cộng đồng lớn: Spring MVC có cộng đồng lớn với nhiều tài liệu, ví dụ, hướng dẫn, các ví dụ và các giải pháp mẫu. Nếu bạn gặp vấn đề, bạn có thể dễ dàng tìm kiếm trên các diễn đàn hoặc stackoverflow.

# II.Thymeleaf
## 1.Thymeleaf là gì ?
Thymeleaf là một thư viện mở,là một Java Template Engine ,dùng để xử lý và tạo ra HTML, XML, JavaScript, CSS, text, Raw ,nó có thể làm việc với cả môi trường web và non-web,mục tiêu chính của Thymeleaf là tạo ra các template đơn giản, dễ bảo trì cho các công việc phát triển giao diện
## 2.Tính Năng
* 1.Cú pháp đơn giản và dễ hiểu: Thymeleaf sử dụng cú pháp XML đơn giản và dễ hiểu, giúp cho việc tạo ra các template dễ dàng hơn so với sử dụng các framework khác.
* 2.Hỗ trợ cho nhiều định dạng template: Thymeleaf có thể sử dụng cho nhiều định dạng template khác nhau như XML, XHTML, HTML5, và các định dạng văn bản khác.
* 3.Tích hợp dữ liệu: Thymeleaf có thể tích hợp dữ liệu từ nhiều nguồn khác nhau, ví dụ như truy vấn cơ sở dữ liệu hoặc dữ liệu được cung cấp bởi các API.
* 4.Định dạng dữ liệu: Thymeleaf có thể định dạng dữ liệu trong các template, ví dụ như định dạng số, ngày tháng, và định dạng chuỗi.
* 5.Tích hợp với các framework khác: Thymeleaf có thể tích hợp với nhiều framework khác trong Java như Spring Framework, để tạo ra các ứng dụng web động.
* 6.Cache thông minh: Thymeleaf cung cấp chức năng cache thông minh, giúp tăng tốc độ xử lý template và giảm thiểu tác động đến tài nguyên hệ thống.
* 7.Tích hợp với tiêu chuẩn web: Thymeleaf được thiết kế để tuân thủ các tiêu chuẩn web và XML, giúp bạn tạo ra các template đầy đủ xác thực nếu cần thiết.
## 3.Ưu,Nhược Điểm
Ưu điểm
* 1.Thymeleaf cho phép tạo các template động trong HTML với các thẻ đơn giản và dễ hiểu, giúp cho việc phát triển ứng dụng web trở nên nhanh chóng và dễ dàng hơn.
* 2.Thymeleaf hỗ trợ tích hợp với Spring Boot, cho phép sử dụng các tính năng của Spring Boot như Dependency Injection, AOP, Security, và nhiều hơn nữa.
* 3.Thymeleaf cung cấp nhiều tính năng tiện ích như thao tác với biến, lặp lại, điều kiện, và các hàm tiện ích, giúp cho việc lập trình template trở nên dễ dàng hơn.
* 4.Thymeleaf hỗ trợ nhiều định dạng template như HTML, XML, XHTML, và được phát triển bởi một cộng đồng lớn và hoạt động tích cực.
Nhược điểm

* 1.Thymeleaf có thể gây hiệu suất chậm hơn so với các công cụ template engine khác do việc phân tích và biên dịch template động trong thời gian chạy.
* 2.Thymeleaf có thể đòi hỏi thêm thời gian để học cú pháp và tính năng tiện ích của nó so với các công cụ template engine khác.
* 3.Thymeleaf có ít tính năng mở rộng và plugin hơn so với các công cụ template engine khác, điều này có thể khiến cho việc mở rộng và tùy chỉnh khó khăn hơn trong một số trường hợp.
* 4.Thymeleaf có thể không được hỗ trợ tốt trên một số trình duyệt cũ hoặc phiên bản thấp hơn, điều này có thể gây ra một số vấn đề về tương thích khi phát triển ứng dụng web.
* 5.Thymeleaf có cú pháp phức tạp hơn so với một số công cụ template engine khác, do đó, có thể đòi hỏi thêm thời gian để làm quen với cú pháp của nó.
* 6.Thymeleaf có một số hạn chế trong việc xử lý các tệp lớn hoặc phức tạp, điều này có thể gây ra vấn đề về hiệu suất và tốc độ xử lý trong một số trường hợp.
## 4.Sử dụng thymeleaf
### 4.1 Cách Sử Dụng
* 1.Thêm Thymeleaf vào dự án. Ta có thể thêm Thymeleaf vào dự án của mình thông qua Maven ,Gradle hoặc cũng có thể tải xuống tệp jar của Thymeleaf từ trang web chính thức của Thymeleaf và thêm nó vào thư mục lib của dự án của mình.
* 2.Cấu hình Thymeleaf. Ta cần cấu hình Thymeleaf trong ứng dụng của mình thông qua file cấu hình Spring hoặc cấu hình Servlet. Ta cần chỉ định các tham số cấu hình như tên thư mục chứa các file template của Thymeleaf, các thuộc tính của template, v.v.
* 3.Tạo các file template Thymeleaf. Ta có thể tạo các file template Thymeleaf bằng cách tạo các file HTML với các đoạn mã Thymeleaf được nhúng trong  HTML. Thymeleaf cung cấp nhiều đoạn mã thymeleaf khác nhau để truy cập các biến, lặp qua danh sách, điều kiện, v.v.
* 4.Sử dụng Thymeleaf trong code Java. Trong code java của mình, ta có thể sử dụng Thymeleaf để tạo các đối tượng template, truyền các đối tượng model vào các template và hiển thị các template trả về cho người dùng.
### 4.2 Tại Sao Sử Dụng ThymeLeaf?
* 1.Tích hợp tốt với Spring Framework: Thymeleaf là một trong những template engine được tối ưu để tích hợp với Spring Framework. Nó cung cấp các tính năng mạnh mẽ như tích hợp dữ liệu, quản lý phiên, bảo mật và nhiều tính năng khác.
* 2.Cú pháp đơn giản: Thymeleaf sử dụng cú pháp đơn giản, giúp người lập trình dễ dàng tạo các file template và hiểu rõ hơn cách hiển thị dữ liệu trên trang web.
* 3.Có thể tích hợp với các loại file khác: Thymeleaf có thể xử lý các file XML, XHTML, HTML5 và các định dạng file khác.
* 4.Hiển thị dữ liệu động: Thymeleaf cho phép hiển thị dữ liệu động, giúp bạn tạo ra các trang web phản hồi nhanh và tương tác tốt với người dùng.
* 5.Tính linh hoạt: Thymeleaf cho phép bạn sử dụng các biểu thức Java để thực hiện các tính toán, truy vấn cơ sở dữ liệu và thực hiện các hành động khác trên dữ liệu.
* 6.Hỗ trợ đa ngôn ngữ: Thymeleaf cho phép bạn tạo các file template đa ngôn ngữ, giúp ứng dụng của bạn dễ dàng hơn để phân phối trên nhiều quốc gia.

=>Như vậy , Thymeleaf là một thư viện template engine mạnh mẽ, tương thích tốt với Spring Framework, cú pháp đơn giản, tính linh hoạt và hỗ trợ đa ngôn ngữ, giúp dễ dàng hiển thị dữ liệu trên trang web và tạo ra các ứng dụng web Java chất lượng cao.
### 4.3 Khi nào sử dụng thymeleaf?
* 1.Phát triển ứng dụng web: Thymeleaf là một công cụ mạnh mẽ để phát triển ứng dụng web, đặc biệt là khi kết hợp với các framework như Spring.
* 2.Sử dụng mẫu: Thymeleaf là một công cụ mạnh mẽ để tạo mẫu, vì nó cho phép các nhà phát triển tạo các mẫu dễ đọc và hiểu, có thể sử dụng cho nhiều mục đích khác nhau.
* 3.Tích hợp dữ liệu: Thymeleaf cho phép tích hợp dữ liệu từ các nguồn khác nhau như cơ sở dữ liệu, tệp tin hoặc các dịch vụ web khác.
* 4.Hiển thị dữ liệu động: Thymeleaf cho phép hiển thị dữ liệu động từ các nguồn khác nhau mà không cần tải lại trang web.
* 5.Đa ngôn ngữ: Thymeleaf có thể được sử dụng để tạo các ứng dụng đa ngôn ngữ, cho phép hiển thị nội dung ứng dụng trong nhiều ngôn ngữ khác nhau.
* 6.Kiểm tra lỗi: Thymeleaf giúp kiểm tra lỗi trong quá trình phát triển, đảm bảo rằng ứng dụng của bạn hoạt động tốt và không gây ra lỗi.

Vì vậy, Thymeleaf là một công cụ rất hữu ích cho các nhà phát triển web khi cần tạo ra các ứng dụng động và đa ngôn ngữ, với tính linh hoạt và khả năng tích hợp dữ liệu tốt.