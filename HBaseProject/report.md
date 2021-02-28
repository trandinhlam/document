###Tài liệu Project HBase nhóm Cao Học K30 - HCMUS
_____________________________
_____________________________
_Yêu cầu 1) Tìm hiểu nội dung, đặc điểm, và các vấn đề liên quan đến loại lưu trữ dữ liệu được chỉ định_
#Chương 1: TỔNG QUAN COLUMN FAMILY
##1.1. Giới thiệu Column Family
###1.1.1. Định nghĩa
Column Family là một loại NoSQL Database...
###1.1.2. Đặc điểm
###1.1.4. Các vấn đề liên quan

##1.2. Các hệ CSDL dựa trên Column Family
+ Big table
+ HBase
+ Cassandra

_____________________________
_____________________________
_Yêu cầu 2) Tìm hiểu về loại sản phẩm NoSQL theo chỉ định_
#Chương 2: APACHE HBASE
##2.1. HBase là gì?
**HBase** là một column-oriented DBMS phát hành lần đầu năm 2008, lưu trữ dữ liệu theo cột thay vì theo hàng như RDBMS. HBase có nguồn gốc từ cơ sở dữ liệu BigTable của Google, chạy trên nền Hadoop Distributed File System (HDFS).
HBase được sử dụng trong các hệ thống Hadoop phát triển bởi Apache. 

####Các đặc trưng của HBase:
+ Là dự án open source có khả năng scale theo chiều ngang (scale out/horizontal scale)
+ Được viết bằng Java
+ Được thiết kế để lưu trữ, xử lý dữ liệu lớn  
+ Xử lý tốt các loại dữ liệu thưa (nhiều giá trị rỗng)

####Một số tính chất của HBase:
+ Distributed: 
+ Flexible Data:
+ Non-Relational:
+ Big data storage: 
+ Scalable: 

####Các loại ứng dụng có thể dùng HBase: 
+ E-Commerce
+ Social network
+ ...

####Các loại ứng dụng không nên dùng HBase:



##2.3. HBase vs RDBMS
Sau đây là bảng so sánh môt số đặc trưng, tính chất cơ bản của HBase và RDBMS

|Feature             | RDBMS            | HBase            |
| ------------------ | -----------------|------------------|
|Data volume         |TB of data        |PB of data
|Primary query language |SQL |Get, Put, Scan shell
|Data object         |Table             |Table       
|Relational          |Yes               |No       
|Join                |Yes               |No       
|Transactions        |Supported         |Not supported
|Indexes             |Primary, secondary, B-Tree,Clustered |Secondary indexes 
|Schema              |Fixed schema      |Schema-less       
|Storage model       |Table spaces       |StoreFiles (HFiles) in HDFS
|Oriented            |Row-oriented      |Column-oriented
|Caching             |Standard data/metadata cache with query cache |In-memory caching
|Architecture        |Monolithic        |Distributed
|Fault tolerant      |Some case         |Highly fault tolerant       |
|Scalability         |Hard              |Highly horizontal scalability       |
|Read/write throughput |~1.000s/second |~1.000.000s/second
|Sharding            |Limited support. Manual server sharding. Table partitioning |Auto-sharding|
|Write performance   |Does not scale well |Scales linearly
|Single point of failure |Yes |No

##2.4. HBase Storage
+ Schema
+ Table
+ Column family & Column Qualifier
+ Region
+ Row-version
+ Block vs Block cache
##2.5. Kiến trúc HBase
![alt text](./photo/hbaseArchitect.png "Kiến trúc HBase")
Kiếm trúc cơ bản của một HBase Cluster bao gồm:
+ Master
+ RegionServers
+ Zookeeper

________
##2.6. Thực hành sử dụng Hbase
_Yêu cầu 3) Tài liệu kỹ thuật về nghiên cứu loại sản phẩm NoSQL qui định: cài đặt, các thao tác trên db: tạo db, thêm, xóa, sửa,... và các thao tác nâng cao
   khác (nếu có)_
###2.6.1. Hướng dẫn cài đặt chi tiết:
+ Hadoop cluster:
  + HDFS
  + Datanode
  + Namenode & secondary Namenode
  + Nodemanager
  + ResourceManager:
    + MapReduce framework
    + Zookeeper
+ HBase cluster:
  + HMaster
  + HRegionServers
  + Zookeeper
###2.6.2. Các thao tác & công cụ cơ bản:
+ HBase shell
+ HBase Java API
+ Bulk Loading Data
_____________________________
_____________________________
#Chương 3: KẾT LUẬN & MỞ RỘNG
###3.2. HBase Ecosystem
###3.3. HBase vs Cassandra
