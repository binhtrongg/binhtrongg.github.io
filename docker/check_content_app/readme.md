# Phân biệt CMD và ENTRYPOINT trong Docker

Trong Docker, `CMD` và `ENTRYPOINT` là hai instruction quan trọng để xác định lệnh mặc định cho việc chạy container từ image.
## CMD

- `CMD` xác định lệnh mặc định sẽ được thực thi khi container được khởi chạy.
- Nếu không cung cấp lệnh khi chạy container, lệnh trong `CMD` sẽ được thực hiện.
- Nếu cung cấp lệnh khi chạy container, nó sẽ ghi đè lên lệnh trong `CMD`.
- Chỉ có một `CMD` có thể tồn tại trong Dockerfile.
- `CMD` thường được viết dưới dạng mảng JSON, ví dụ: `CMD ["echo", "Hello from CMD"]`.

## ENTRYPOINT

- `ENTRYPOINT` xác định lệnh thực sự (executable) sẽ được chạy khi container bắt đầu.
- Khi không cung cấp lệnh khi chạy container, lệnh trong `ENTRYPOINT` sẽ được thực hiện.
- Nếu cung cấp lệnh khi chạy container, lệnh đó sẽ được thêm vào sau `ENTRYPOINT`.
- `ENTRYPOINT` không dễ bị ghi đè bởi tham số lệnh khi chạy container.
- có thể sử dụng nhiều `ENTRYPOINT` để tạo một hệ thống từ nhiều lệnh khác nhau.
- `ENTRYPOINT` thường được viết dưới dạng mảng JSON, ví dụ: `ENTRYPOINT ["echo", "Hello from ENTRYPOINT"]`.
