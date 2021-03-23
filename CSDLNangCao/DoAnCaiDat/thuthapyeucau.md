# CSDL NÂNG CAO - ĐỒ ÁN CÀI ĐẶT
![img.png](img.png)
### THÔNG TIN THU THẬP YÊU CẦU VÀ THIẾT KẾ PROPOSAL

___

## Yêu cầu 1: Nghiên cứu, mô tả phạm vi cho các quy trình nghiệp vụ của một HT thực tế

**Kết quả công việc:**

+ Đã chốt tìm hiểu về một **Social Network** để triển khai đồ án

## Trình bày
+ Social network là gì? Lịch sử phát triển
+ Đặc trưng của Social network
+ Các Social network phổ hiến hiện nay

___   

#### Xác định một số nghiệp vụ _CHÍNH_ của hệ thống, chức năng phải đủ lớn và phù hợp để áp dụng CSDL

#####Bước 1:Tìm hiểu và liệt kê một số chức năng chính của vài Social Network lớn trên thị trường:
https://blog.webico.vn/tong-hop-cac-kenh-social-media-lon-nhat-hien-nay/

__Cần giới hạn lại số lượng chức năng:__ tối thiểu 5 chức năng chính trọng yếu
+ Lâm: Facebook
  + Chức năng 1:
  + Chức năng 2:
  + Chức năng 3:
  + Chức năng 4:
  + Chức năng 5:
  + ...
+ Kiệt: Instagram
  + Chức năng 1:
  + Chức năng 2:
  + Chức năng 3:
  + Chức năng 4:
  + Chức năng 5:
  + ...
+ Minh: Twitter
  + Chức năng 1:
  + Chức năng 2:
  + Chức năng 3:
  + Chức năng 4:
  + Chức năng 5:
  + ...
  
___

**Từ danh sách khảo sát trên, nhóm đã chọn ra các chức năng CHÍNH của một hệ thống Social Network cơ bản:**
  + 
 ___

#### Xây dựng bảng mô tả yêu cầu hệ thống

+ Chưa có form mô tả yêu cầu, cần tham khảo các project thật
+ Lần lượt vẽ sơ đồ usecase cho từng chức năng
+ Vẽ mockup cho các flow
+ ...

___
___

## Yêu cầu 2: Phân tích nghiệp vụ hệ thống, xác định loại CSDL phù hợp

___

+ #### Phân tích, thiết kế chức năng đã liệt kê

___

+ #### Lý giải loại CSDL nào áp dụng phù hợp cho từng chức năng, dựa trên đặc thù của chức năng và của loại CSDL

___

+ #### Viết báo cáo

___
___

## Yêu cầu 3: Phân tích - thiết kế loại dữ liệu phù hợp cho các yêu cầu

___

+ #### Thiết kế dữ liệu lưu trữ cho từng chức năng

___

+ #### Với mỗi chức năng cần thiết kế mô hình dữ liệu lưu trữ chi tiết

___

+ #### Viết báo cáo

___
___

## Yêu cầu 4: Cài đặt các tính năng hệ thống

___

#### Khai báo cấu trúc dữ liệu lên các DBMS tương ứng:

    + SQL bắt buộc:
        + Nêu rõ tập lệnh khai báo cấu trúc
        + Tập lệnh thao tác trên dữ liệu cho các nghiệp vụ chức năng
        + Các tập lệnh khác như index, partition,...

    + NoSQL bắt buộc:
        + MongoDB
        + Neo4j
        + Tự chọn thêm để mở rộng (Elastic Search)

#### Thực hiện:

+ Có muốn cài đặt trên một Server Cloud ko? Lâm nghĩ nên xài cloud, dễ setup môi trường
+ Lâm tính xài MySQL
+ Xài MongoDB với Neo4j thì đặc thù là gì ?
    + Neo4j cho query theo relationship rất tốt=> ứng dụng kết nối, mạng xã hội, tương tác,...
    + MongoDB thì chưa rõ

___
___

#### Thiết kế giao diện cho chức năng

+ Tìm Template giao diện ở đâu?
+ Có cần đầu tư phần này?

___

#### Implement hoàn chỉnh

+ Nên đặt mức độ hoàn thành như thế nào? Làm theo chức năng hay theo hệ thống?
+ Microservice hay Monolithic?

___

#### Viết báo cáo

___
___

## Yêu cầu 5 (Nâng cao): Phân tích sử dụng kỹ thuật nâng cao hiệu suất khi khai thác dữ liệu

___

+ #### Phân tích xử lý và hiệu suất xử lý của hệ thống SQL, NoSQL, áp dụng để khai thác dữ liệu hiệu quả
    + Bước này cần chỉ ra và giải thích được vấn đề của hệ thống, từ đó chỉ ra giải pháp phù hợp

___

+ #### Thử nghiệm hiệu suất trên và trình bày kết quả thử nghiệm, có đo đếm rõ ràng
    + Dùng tool gì để benchmark? độ đo như thế nào? có trực quan không?

___

+ #### Viết báo cáo

___
