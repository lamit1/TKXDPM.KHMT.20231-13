Hướng dẫn build và chạy test:
- Thư mục src: Thư mục chứa tất cả mã nguồn phần mềm AIMS có chức năng thanh toán.
- Thư mục test: Thư mục chứa tất cả mã nguồn test các chức năng thanh toán.
- Thư mục web: Thư mục chứa  mã nguồn return_URL của VNPAY.


2. Set up build config, import javafx (Thêm
 --module-path "path\to\project\lib\javafx-sdk-21.0.1\lib\" --add-modules=javafx.swing,javafx.graphics,javafx.fxml,javafx.media,javafx.web --add-reads javafx.graphics=ALL-UNNAMED --add-opens javafx.controls/com.sun.javafx.charts=ALL-UNNAMED --add-opens javafx.graphics/com.sun.javafx.iio=ALL-UNNAMED --add-opens javafx.graphics/com.sun.javafx.iio.common=ALL-UNNAMED --add-opens javafx.graphics/com.sun.javafx.css=ALL-UNNAMED --add-opens javafx.base/com.sun.javafx.runtime=ALL-UNNAMED
 vào VM options trong edit configuration của Run)
4. Chạy song song thư mục web và chạy app trên thư mục src (Lưu ý: cài đặt 2 port khác nhau).
5. Test.


