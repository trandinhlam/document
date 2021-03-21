#CSDL NÂNG CAO - ĐỒ ÁN CÀI ĐẶT
###THÔNG TIN THU THẬP YÊU CẦU VÀ THIẾT KẾ PROPOSAL

___
## Yêu cầu 1: Nghiên cứu và mô tả phạm vi cho các quy trình nghiệp vụ của một hệ thống thông tin thực tế.
 + Chọn, khảo sát một HTTT thực tế để phân tích: Bán hàng, Vé máy bay, vé tàu, báo đài truyên thông,...
 + Thông qua khảo sát, xác định một số nghiệp vụ chính của hệ thống, làm cơ sở cho các tình huống phân tích áp dụng loại CSDL.
Lưu ý chức năng phải đủ lớn và phù hợp để áp dụng (MongoDB, Neo4j,...)
 + Xây dựng bảng mô tả yêu cầu hệ thống: mô tả các nghiệp vụ, chức năng đã xác định

___
## Yêu cầu 2: Phân tích nghiệp vụ hệ thống, xác định loại CSDL phù hợp
 + Phân tích, thiết kế chức năng đã liệt kê
 + Lý giải loại CSDL nào áp dụng phù hợp cho từng chức năng/nhóm chức năng, dựa trên đặc thù của chức năng và đặc thù của loại CSDL
 + Viết báo cáo mô tả nội dung và kết quả phân tích
___
## Yêu cầu 3: Phân tích - thiết kế loại dữ liệu phù hợp cho các yêu cầu
 + Thiết kế dữ liệu lưu trữ cho từng chức năng
 + Với mỗi chức năng cần thiết kế mô hình dữ liệu lưu trữ chi tiết
 + Viết báo cáo trình bày
___
## Yêu cầu 4: Cài đặt các tính năng hệ thống
 + Khai báo cấu trúc dữ liệu lên các DBMS tương ứng:
   + SQL:
     + Nêu rõ tập lệnh khai báo cấu trúc
     + Tập lệnh thao tác trên dữ liệu cho các nghiệp vụ chức năng
     + Các tập lệnh khác như index, partition,...  
   + NoSQL:
     + MongoDB
     + Neo4j
     + Tự chọn thêm để mở rộng
 + Thiết kế giao diện cho chức năng
 + Implement hoàn chỉnh
 + Viết báo cáo
___
## Yêu cầu 5 (Nâng cao): Phân tích sử dụng kỹ thuật nâng cao hiệu suất khi khai thác dữ liệu
 + Phân tích xử lý và hiệu suất xử lý của hệ thống SQL, NoSQL, áp dụng để khai thác dữ liệu hiệu quả
 + Thử nghiệm hiệu suất trên và trình bày kết quả thử nghiệm, có đo đếm rõ ràng
 + Viết báo cáo
