#Note lại các thuật ngữ xuất hiện trong paper

+ **Clustering:** Một bài toán phân nhóm toàn bộ dữ liệu X 
  thành các nhóm nhỏ dựa trên sự liên quan giữa các dữ liệu trong mỗi nhóm.
  + Ví dụ: phân nhóm khách hàng dựa trên hành vi  mua hàng. Điều này cũng giống như việc ta đưa cho một đứa trẻ rất nhiều mảnh ghép với các hình thù và màu sắc khác nhau, 
  ví dụ tam giác, vuông, tròn với màu xanh và đỏ, sau đó yêu cầu trẻ phân chúng thành từng nhóm. Mặc dù không cho trẻ biết
  mảnh nào tương ứng với hình nào hoặc màu nào, nhiều khả năng chúng vẫn có thể phân loại các mảnh ghép theo màu hoặc hình dạng.

+ **Hierarchical clustering**: 
  
+ **Partitioning clustering**:
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
+ Wilcoxon post-hoc tes

## links
https://en.wikipedia.org/wiki/Firefly_algorithm <br>
https://www.youtube.com/watch?v=QRtt_cJSMNk&ab_channel=Dr.HarishGarg <br>