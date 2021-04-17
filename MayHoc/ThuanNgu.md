#Note lại các thuật ngữ xuất hiện trong paper

+ **Clustering:** Một bài toán phân nhóm toàn bộ dữ liệu X 
  thành các nhóm nhỏ dựa trên sự liên quan giữa các dữ liệu trong mỗi nhóm.
  + Ví dụ: phân nhóm khách hàng dựa trên hành vi  mua hàng. Điều này cũng giống như việc ta đưa cho một đứa trẻ rất nhiều mảnh ghép với các hình thù và màu sắc khác nhau, 
  ví dụ tam giác, vuông, tròn với màu xanh và đỏ, sau đó yêu cầu trẻ phân chúng thành từng nhóm. Mặc dù không cho trẻ biết
  mảnh nào tương ứng với hình nào hoặc màu nào, nhiều khả năng chúng vẫn có thể phân loại các mảnh ghép theo màu hoặc hình dạng.

  + Đặc điểm:
    + Số cụm dữ liệu không được biết trước
    + Có nhiều các tiếp cận, mối cách lại có vài kỹ thuật
    + Các kỹ thuật khác nhau thường mang lại kết quả khác nhau.
  + Tính chất của độ đo khoảng cách:
    + Tính không âm (non-negative): d(x,y) >=0 và d(x, y) = 0 khai và chỉ khi x trùng y.
    + Tính đối xứng (symmetic): d(x, y) = d(y, x)
    + Tính tam giác (traingle inequality): d(x, y) + d(y, z) >= d(x, z)
  + Các độ đo khoảng cách
    + Độ đo Euclid r1
    + Độ đo Euclid chuẩn (r = 2)
    + Độ đo Manhattan
    + Độ đo Cosine
    + Độ đo Hamming
    + Độ đo Jaccard
    + Độ đo Kullback-Leibler (KL)
___
+ **Hierarchical clustering**: Phân cụm phân cấp 
  + Agglomerative: "đi từ dưới lên": Ban đầu chọn K là một số lớn gần bằng số điểm dữ liệu. Sau khi thực hiện phân cụm K-meas
  lần đầu, các cụm gần nhau được ghép lại thành một cụm. Lúc này khoảng cách giữa các cụm có thể được xác định bằng khoảng cách
  giữa các tâm cụm. Tiếp tục K-means ở các bước tiếp theo để giảm dần số lượng cụm.
    ![img_1.png](img_1.png)
    + Các tiêu chí chọn hai cụm để sát nhập:
      + _Centroid-linkage_: Sát nhập hai cụm có khoảng cách giữa hai tâm của hai cụm này là nhỏ nhất.
      + _Single-linkage_: khoảng cách giữa hai điểm gần nhau nhất thuộc hai cụm. Sát nhập hai cụm có khoảng cách này nhỏ nhất.
      + _Average-linkage_: trung bình các khoảng cách giữa hai cặp điểm bất kì thuộc hai cụm. Sát nhập hai cụm có khoảng cách này nhỏ nhất.
      + _Complete-linkage_: khoảng cách giữa hai điểm xa nhau nhất của hai cụm, sát nhập hai cụm có khoảng cách này là nhỏ nhất.
      + _Radius:_ bán kính của một cụm là khoảng cách từ tâm tới điểm xa nhất của cụm, sát nhập hai cụm nếu hai cụm tạo ra một cụm có bán kính nhỏ nhất.
      + _Diameter:_ đường kính của một cụm là khoảng cách của hai điểm xa nhau nhất trong cụm, sát nhập hai cụm nếu chúng tạo nên một cụm có đường kính nhỏ nhất.
      

  + Divisive: "đi từ trên xuống": Ban đầu k-means với K nhỏ để thu được các cụm lớn. Sau đó tiếp tục K-means trên mỗi cụm đến khi 
  kết quả chấp nhận được.
  + Ưu điểm của phân cụm phân lớp là không phải xác định trước số lượng cụm điều này khá vượt trội so với K-Means. Tuy nhiên, nó không hoạt động tốt với lượng dữ liệu khổng lồ.
  + Thuật toán phân cụm phân lớp có thể được sử dụng để xác định, dự đoán số cụm trước khi thực hiện thuật toán K-Means.
___
+ **Partitioning clustering**: là phương pháp non-hierarchical clustering phổ biến nhất, là phương pháp phân cụm one-level, 
  các cluster không thể hiện dưới dạng cấp bậc. Hướng tiếp cận cơ bản nhất trong Partition clustering là tách cụm độc quyền,
  giống như Hard-clustering, mỗi object chỉ thuộc một cluster duy nhất. 
___
+ **NP:** In computational complexity theory, NP (nondeterministic polynomial time) is a complexity class used to classify 
  decision problems. NP is the set of decision problems for which the problem instances, where the answer is "yes", have 
  proofs verifiable in polynomial time by a deterministic Turing machine.
https://stackoverflow.com/questions/1857244/what-are-the-differences-between-np-np-complete-and-np-hard
  + 
+ **NP-Hard:** at least as hard as the hardest problems in NP
___
+ **fitness function:** hàm cần tối ưu hóa trong bài toán
___
+ **evolution algorithm:** 
  + Một giải thuật tiến hóa (evolutionary algorithm - EA) là một thuật toán tối ưu hóa heuristic sử dụng các kỹ thuật bắt 
    nguồn từ các cơ chế tiến hóa hữu cơ (organic evolution) chẳng hạn như biến dị, tái tổ hợp và chọn lọc tự nhiên để tìm 
    một cấu hình tối ưu cho một hệ thống với các ràng buộc cụ thể.
___
+ **Firefly Algorithm:** Trong tối ưu hóa, thuật toán đom đóm là một metaheuristic do Xin-She Yang đề xuất năm 2007 và lấy cảm hứng từ hành vi 
  nhấp nháy của đom đóm. Thuật toán bầy đom đóm là một công cụ hiệu quả cho tối ưu hóa toàn cục
  ![img.png](img.png)
  Có 3 rule dùng để xây dựng thuật toán:
  + 1. Tất cả đom đóm có thể **bị thu hút** bởi các đom đóm khác **sáng hơn**.
  + 2. **Độ sáng** của mỗi con được xác định bằng một hàm **objective function**
  + 3. **Độ thu hút** tỉ lệ thuận trực tiếp đến độ sáng, và khoảng cách giữa 2 đom đóm càng xa thì độ thu hút và độ sáng đều giảm.
     + Có nghĩa là 1 con đom đóm sẽ di chuyển đến gần con khác sáng hơn
     + Khi không có con nào sáng hơn, nó di chuyển ngẫu nhiên
   
    
___
+ **Hybrid Firefly Algorithm:** 
___
+ Particle Swarm Optimization (PSO):
+ Compach-Separated và Davis-Bouldin: 
+ Automatic clustering:
+ Firefly-based hybrid algorithms
+ Clustering validity
+ Local optima
+ Swarm intelligence
+ selection pressure and population diversity
+ classification error percentage (CEP)
+ fuzzy c-means
+ cluster validity index (CVI)
+ Davies – Bouldin (DB)
+ Compact-Separated (CS)
+ Variance reduction exponent
+ inertia weight damping
+ Friedman rank-sum test
+ Wilcoxon post-hoc test

## links
https://en.wikipedia.org/wiki/Firefly_algorithm <br>
https://www.youtube.com/watch?v=QRtt_cJSMNk&ab_channel=Dr.HarishGarg <br>
https://viblo.asia/p/hierarchical-clustering-phan-cum-du-lieu-maGK7q2elj2 <br>
https://bigdatauni.com/tin-tuc/phuong-phap-clustering.html