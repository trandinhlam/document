# FILE TỔNG HỢP CÁC NỘI DUNG SERMINAR CỦA NHÓM

## Mục tiêu cuối cùng của bài Serminar:

## **LÀM THẾ NÀO ĐỂ LỚP HIỂU TARGET <br> CỦA LĨNH VỰC OBJECT DETECTION**

Link bài dịch: https://docs.google.com/document/d/1x7gl_FlZ10jm8LBw55JzHnBl5I0pCHu6En4ttOaJvRw/edit

Tổng hợp task: https://trello.com/c/ZY6oKScO/10-ti%E1%BA%BFn-h%C3%A0nh-%C4%91%E1%BB%93-%C3%A1n-serminar

_______________________________________

### 1. Overview
_______________________________________
+ ### Bài báo đến từ đâu? Ra mắt năm nào?
  Bài báo đến từ đội ngũ Nhóm nghiên cứu của Phòng Nghiên cứu Khoa Học Máy Tính và Công Nghệ, Đại học Thanh Hoa Bắc Kinh (Tsinghua University)<br>
  Được công bố ở hội nghị CVPR năm 2016 <br>
  Số lượng Citation: <br>
  Các tác giả bao gồm: Zhe Zhu, Dun Liang, Song-Hai Zhang, Xiaolei Huang, Baoli Li and Shi-Min Hu<br>
  Link bài báo: https://cg.cs.tsinghua.edu.cn/traffic-sign/
  
_______________________________________   

+ ###Mục tiêu cốt lõi của nhóm tác giả là gì?
  Trong phần introduction, tác giả giới thiệu 2 mục tiêu và kết quả cốt lõi chính của bài báo:
    + Xây dựng một tập data Tsinghua-Tencent 100K thực tế hơn các tập data về Traffic-Sign trước đó.
    + Xây dựng được mạng CNN cải tiến để vừa xác định biển báo, vừa phân loại biển báo luôn.

_(Ý này có nghĩa là các mạng CNN trước đó thường thực hiện xác định biển báo trước, sau đó tuần tự mới phân loại biển báo
sau)_
_______________________________________
+ ### Tác giả cung cấp những gì? Tài liệu phụ lục kèm theo?
+ https://cg.cs.tsinghua.edu.cn/traffic-sign/
+ Tác giả cung cấp bộ data set 100K tấm ảnh góc rộng từ Tencent Street View<br>
+ Hướng dẫn chạy model của họ  với TT100K dataset
+ Có Phụ lục kèm theo bao gồm kết quả detect một số case, và kết quả classification một số case
+ Có cung cấp 1 file caffemodel và 3 file .prototxt để train và test cho mô hình Fast-RNN
_______________________________________
+ ### Tác giả không cung cấp những gì? 
_(thuật toán có chi tiết? cách cài đặt có rõ ràng ko?...)_

_______________________________________

### 2. Lookback - Đặt vấn đề

+ Các bài báo tiền nhiệm là bài báo nào?
+ Bối cảnh và bài toán nào đã được các bài trước đó giải quyết?
+ Vấn đề phát sinh từ các bài báo này?
    + Các bộ dữ liệu kinh điển bị nhược điểm gì mà tác giả lại chê?
    + Các giải pháp cũ có ứng dụng thực tiễn được không?

_______________________________________

### 3. Cách họ xây dựng data như thế nào? ( Nhóm thực hành)

+ Các bộ dataset của các paper trước đó là gì ? (PASCAL VOC)
+ Data lấy từ đâu?
+ Có lấy data từ các bài báo trước đó không?
+ Tính chất của data có gì khác biệt so với bộ data của các bài báo trước?
+ Họ chuẩn hóa data như thế nào? Dùng tay để lọc hay dùng máy?
+ Data có nhiễu nhiều hay không? Được chụp/quay bằng gì?
+ Họ có trích xuất Feature ra trước khi đưa vào mạng không? Có gán nhãn trước cho biển báo giao thông?
+ Tác giả có chú trọng rất nhiều, có đặt trọng tâm bài báo vào bộ data này không? Vì sao?

_______________________________________

### 4. Mô hình Mạng CNN có gì đặc biệt?

#### Mô hình cũ trước đó

+ Nêu ra các mô hình cũ trước đó? Ít nhất 2 mô hình
+ Đưa ra hình ảnh mô hình?
+ Bạn có thể giái thích cơ bản mô tả mô hình cũ này không?

#### Mô hình mới

+ Mô hình mạng mới của bài này có gì khác biệt? đặc biệt hơn cái cũ chỗ nào?
+ Cơ sở lý thuyết cụ thể là gì ?
+ Công thức họ đưa ra là công thức gì?
+ Những kỹ thuật và phương pháp nào đã được tác giả sử dụng?
+ Làm sao để giải thích rõ ràng mô hình mạng này cho mọi người hiểu?

_______________________________________

### 5. Kết quả và đối sánh hiệu quả ra sao?

+ Thời gian thực thi như thế nào? Chạy trên device gì? Card gì, chạy trong bao lâu thì ra kết quả? Model hội tụ được kết
  quả sau bao nhiều lần lặp?
+ Mỗi biểu đồ trong bài báo thể hiện điều gì? Thông số nào là quan trọng?
+ Kết quả cho thấy tốt hơn như thế nào? Nhanh hơn hay chính xác hơn? Nhanh hơn bao nhiêu? Chính xác hơn bao nhiêu?
+ Những đóng góp mới của nhóm tác giả có giá trị như thế nào? Tạo tiền đề gì cho hậu thế? Cụ thể thì sẽ được mở rộng
  trong khía cạnh nào của lĩnh vực nhận diện biển báo giao thông?
+ Có điểm nào trong phần này bạn thấy chưa thỏa đáng hay không?

_______________________________________

### 6. Demo như thế nào? (Nhóm thực hành)

+ Quay video demo lại __cách sử dụng model__ đã được train. Cần check lại có model sẵn chưa?
+ Có option chạy CPU không ? Nếu chạy trên GPU thì chạy cloud được ko? GoogleColab?
+ Có chạy được với dataset ít hơn ko? 14GB?

+ Nhận xét chủ quan của nhóm mình?
  (bước tiến có lớn hay ko hay chỉ chém gió? so với cái cũ thì có vượt trội?)
