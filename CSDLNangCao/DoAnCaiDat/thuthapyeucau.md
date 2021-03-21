# CSDL NÂNG CAO - ĐỒ ÁN CÀI ĐẶT

### THÔNG TIN THU THẬP YÊU CẦU VÀ THIẾT KẾ PROPOSAL

___

## Yêu cầu 1: Nghiên cứu, mô tả phạm vi cho các quy trình nghiệp vụ của một HT thực tế

___

#### Chọn một HT thực tế: Bán hàng, Vé máy bay, vé tàu, báo đài truyền thông, chứng khoán, nhà đất batdongsan.com, giao đồ ăn, map, xe ôm, bán vé rạp phim, web xem phim, web nghe nhạc,...
 + Lâm vote: (chưa biết xài MongoDB)
   + __Social networking__ (good for Neo4j - GraphDB + Redis + HBase(log user action...) + Kafka): chức năng đăng feed, kết bạn, khám phá bạn, tương tác like, comment...
   + __Thương mại điện tử__ (good for MongoDB): web bán hàng online như tiki (dùng SQL ok, NoSQL thì chưa biết)
 + Minh vote:
   + 
 + Kiệt vote:
   + 
___   

#### Xác định một số nghiệp vụ _CHÍNH_ của hệ thống, chức năng phải đủ lớn và phù hợp để áp dụng CSDL
+ Cần giới hạn lại số lượng chức năng:
  + Tối thiểu _x_ chức năng
  + Tối đa _y_ chức năng
 ___

#### Xây dựng bảng mô tả yêu cầu hệ thống

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

___

+ #### Thử nghiệm hiệu suất trên và trình bày kết quả thử nghiệm, có đo đếm rõ ràng

___

+ #### Viết báo cáo

___
