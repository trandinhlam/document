# BÀI DỊCH PAPER

Nghiên cứu hiệu suất so sánh thuật toán đom đóm lai để phân cụm dữ liệu tự động
 + https://www.semanticscholar.org/paper/A-Comparative-Performance-Study-of-Hybrid-Firefly-Ezugwu-Agbaje/87a471ac21d86339c841c7bc5e1429341ce80d22
___

## ABSTRACT

+ Trong phân tích gom cụm, mục tiêu luôn là mở rộng các phương pháp tốt nhất có thể để tự động xác định số lượng các
  cụm. Tuy nhiên, vì sự thiếu thông tin biết trước, và sự không chắc chắn liên quan đến các đặc điểm của đối tượng dữ
  liệu, rất khó để chọn ra một số lượng các cluster thích hợp, đặc biệt là khi xử lý các đối tượng dữ liệu nhiều chiều,
  đa dạng về kích thước và mật độ.
+ Trong vài thập kỷ trở lại đây, các nhà nghiên cứu khác nhau đã đề xuất và phát triển nhiều phương pháp mô phỏng lấy
  cảm hứng từ tự nhiên để giải quyết bài toán cluster. Nhiều nghiên cứu đã chỉ ra rằng thuật toán đom đóm rất mạnh, hiệu
  qủa và gần với tự nhiên, đã được áp dụng thành công để giải các bài toán khác nhau về tối hưu NP-hard. Tuy nhiên, sự
  đa dạng trong quy trình tìm kiếm được sử dụng trong thuật toán đom đóm có thể dẫn đến các vấn đề về tối ưu, làm chậm
  tốc độ, và tốc độ hội tụ đối với quy mô lớn.
+ Do đó, bài báo này nghiên cứu về việc áp dụng 4 thuật toán đom đóm lai với nhiệm vụ phân nhóm tự động các tập dữ liệu
  quy mô lớn, mật độ dày, không được gán nhãn trước. Ngược lại với hầu hết các kỹ thuật phân tích kinh điển
  heuristic-based về phân nhóm dữ liệu, thuật toán đom đóm lai được đề xuất không yêu cầu bất cứ kiến thức trước nào về
  các đối tượng cả. Thay vào đó, các phương pháp này tự động xác định số lượng cụm tối ưu theo kinh nghiệm và trong quá
  trình thực thi chương trình. Hai nhóm chỉ số hợp lệ phổ biến, là Compach-Separated và Davis-Bouldin, được sử dụng để
  đánh giá tính ưu việt của các thuật toán đom đóm lai đã đề xuất.
+ Xa hơn nữa, 12 tập dữ liệu thực nghiệm tiêu chuẩn từ UCI Machine Learning Repository được sử dụng để đánh giá mức độ
  mạnh mẽ và hiệu quả của các thuật toán so với những thuật toán tối ưu hóa kinh điển, và các kết quả gom nhóm liên quan
  từ tài liệu. Kết quả thử nghiệm cho thấy rằng các phương pháp phân nhóm mới đạt hiệu quả tốt hơn so với các thuật toán
  cũ, dựa trên các chỉ số hợp lệ tiêu chuẩn.

+ Index Terms: Automatic clustering, firefly algorithm, firefly-based hybrid algorithms, clustering validity index.

___

## I. INTRODUCTION

+ Phân cụm dữ liệu là một kỹ thuật phân loại unsupervised quan trọng, liên quan đến tiến trình ghom nhóm dữ liệu mà ở
  đó, các item giống nhau được nhóm vào một cụm dựa vào các thông số tương tự nhau [1]-[4]. Ghom cụm cũng thường được
  dùng cho nhiều ứng dụng hấp dẫn trong thế giới thực, như tiếp thị, sinh học, phân tích hình ảnh, thư viện, bảo hiểm,
  khai thác dữ liệu, y học, phân tích thống kê, nhận diện cộng đồng, và các lĩnh vực khoa học kỹ thuật khác [5]-[7].
+ Mặc dù phân tích ghom cụm đã được sử dụng lần đầu trong 2 lĩnh vực khoa học xã hội, cụ thể là nhân loại học và tâm lý
  học [8], xa hơn nữa, nó cũng được sử dụng cho lý thuyết phân loại đặc điểm trogn tâm lấy nhân cách bởi Cattel vào đầu
  năm 1943 [8],[9].
+ Phương pháp trong ghom cụm dữ liệu đã được mở rộng với sự liên quan đáng kể trong việc áp dụng cho các nghiên cứu mới,
  trong các lĩnh vực như KHDL, Lachine learning. Cần lưu ý rằng việc phân cụm dữ liệu ra thành các nhóm có ý nghĩa là
  một nhiệm vụ quan trọng của cả AI và Data mining.
+ Thông thường, thuật ngữ clustering thường được gán với một phép gán nhãn dữ liệu không giám sát, ở đó kết quả của quá
  trình phân tích này phụ thuộc rất nhiều vào tính ưu việt và hiệu quả của các thuật toán, phương pháp phân nhóm được sử
  dụng.
+ Trong các thập niên trước, nhiều thuật toán heuristic-based đã đưa ra để giải bài toán phân cụm. Mỗi thuật toán được
  thiết kế và cài đặt dựa trên 2 phân lớp chính của phương thức ghom cụm [10]-[11]:
    + hierarchical - phân cụm phân cấp: Các thuật toán này tạo ra một cấu trúc phân cấp dạng cây, đại diện cho một cụm nhóm dính với nhau, 
      của một số điểm dữ liệu. Thuật toán phổ biến nhất trong nhóm này là thuật toán single-link (liên kết đơn) và complete-link (liên hết hoàn toàn) [12]
    + partitioning - phân cụm phân nhóm: ngược lại, các thuật toán này phân phối các điểm dữ liệu vào các cụm không overlap nhau. Nói cách khác, thuật toán phân nhóm 
      tạo ra các phân vùng dữ liệu đơn lẻ thay vì xậy dựng một cấu trúc cây như trên [13].
+ Một trong những thách thức lớn của các thuật toán kể trên là làm sao chọn số lượng cụm thích hợp ở đầu ra cuối cùng. Thuật toán k-means có lẽ là 
phương pháp phổ biến nhất cho vấn đề này. Tuy nhiên, sự thành công của các thuật toán kể trên phụ thuộc nhiều vào việc có thông tin xác định trước
  về các đối tượng dữ liệu và giải pháp yêu cầu ban đầu, trong đó hầu hết các trường hợp có thể dễ dàng làm cho thuật toán mắc xung quanh local optima [8]. Đây là những nhược điểm 
  nghiêm trọng khiến cho các nhà nghiên cứu phải đưa ra các giải pháp hữu hiệu khác để khắc phục, bao gồm việc sử dụng một số cải tiến 
  và các thuật toán thông minh, kết hợp với các thuật toán phức tạp hơn, và các vấn đề phân cụm dữ liệu nhiều chiều.
+ Một vài thuật toán cải tiến được sử dụng để xử lý các vấn đề kể trên là:
    + Genetic algorithm (GA)
    + Differential evolution (DE)
+ Trong khi đó một số kỹ thuật thông minh (swarm intelligence) cũng được áp dụng hiệu quả để giải quyết vấn đề phân cụm[14],[15] như:
    + particle swarm optimization (PSO):
    + ant colony optimization (ACO):
    + firefly algorithm (FA):
    + invasive weed optimization (IWO):
    + artificial bee colony optimization (ABC):
    + teaching learning-based optimization (TLBO): 
+ Ví dụ:
    + Zabihi và Nasiri [16] đề xuất việc sử dụng thuật toán ABC theo history-driven để giải quyết phân cụm dữ liệu, với cơ chế ghi nhớ dựa trên 
    phân vùng không gian nhị phân đã được kết hợp vào thuật toán ABC, để cải thiện hiệu suất phân cụm.
    + Merwe và Engelbrecht đã đề xuất việc sử dụng PSO để giải quyết vấn đề phân cụm [17].
    + Tương tự, Zhao [18] đã làm về việc cải thiện hiệu suất của thuật toán k-mean bằng cách lai nó với PSO để tránh bị ảnh hưởng trực tiếp 
      bởi các trung tâm cụm ban đầu.
    + Liu và công sự [15] phát triển một thuật toán dựa trên GA để tìm ra nhóm có chất lượng tốt cho một cụm không xác định.
    + Nikkam và cộng sự [19] đã đề xuật một thuật toán cải tiến hiệu quả kết hợp ACO và các thuật toán simulated annealing (SA) để giải quyết.  Kết quả mô phỏng của ACO-SA cho thấy thuật toán kết hợp hoạt động hiệu quả hơn SA cơ bản, ACO và k-mean riêng lẻ.
    + Satapathy và Naik [20] đã phát triển một thuật toán TLBO đã được sử dụng để tìm các tâm của một  số lượng cụm do người dùng chỉ định.
+ Các ví dụ liên quan khác:
    + Sahoo và Kumar [21] đề xuất hai chỉnh sửa đối với phương pháp TLBO để nâng cao hiệu suất của nó, trong đó thay vì khởi tạo ngẫu nhiên, một phương pháp được 
      sử dụng để khai tác tâm của các cụm ban đầu.
    + Zhao và Zhou [22] đề xuất một thuật toán fuzzy c-mean dựa trên IWO
    + Liu [23] sử dụng thuật toán IWO đa mục tiêu
    + Wang và cộng sự [24], đề xuất một thuật toán thụ phấn cho hoa  flower pollination algorithm (FPA) với bee pollinators.
    + Agarwal và Mehta [25] đã nghiên cứu ứng dụng nâng cao thuật toán thụ phấn hoa
+ Các ví dụ gần đây:
    + Senthilnath và cộng sự [26] đã tiến hành đánh giá hiệu suất nghiên cứu về việc sử dụng FA tiêu chuẩn. Kết quả được so sánh với PSO, ABA và các thuật toán khác.
    + Hơn nữa, một nghiên cứu tương tự về phân tích hiệu suất của thuật toán đom đóm để phân cụm dữ liệu cũng đã được xem xét trong [27] bởi Banati và Bajaj
    + Trong năm 2012, Abshouri và Bakhtiary [28] đã đề xuất một FA lai mới kết hợp thuật toán FA và K-Harmonic Means
+ Tuy nhiên, hầu hết các thuật toán đề cập ở trên được test và và chứng minh là mang lại các giải pháp chuất lượng vượt trội, yêu cầu các thuật toán 
  phải được cung cấp tri thức cụ thể trước đó về các đặc điểm, đặc trưng của dữ liệu. Chẳng hạn như phải chỉ định trước số cụm và các thuộc tính liên quan của dữ liệu. 
+ Vấn đề là, trong thực tế các bộ dữ liệu, số lượng cụm không được biết trước, đặc biệt đối với các tập quá lớn. Hơn nữa, việc tự động xác định số cụm dữ liệu cần thiết rất khó khăn [15].
+ Do đó, __mục tiêu cụ thể__ của bài báo này là phát triển một phương pháp phân nhóm dựa trên FA được cải tiến, sẽ tự động  cung cấp phân vùng thích hợp 
  mà không cần bất kỳ tri thức biết trước về đặc điểm của dữ liệu. Ngoài ra, nghiên cứu này đề xuất việc triển khai 4 thuật toán FA để giải quyết một loạt các 
  vấn đề trong phân cụm một cách tự động, bao gồm:
  + Tối ưu thuật toán đom đóm lai (FAABC)
  + Firefly algorithm artificial bee colony (FAABC)
  + Firefly algorithm invasive weed optimization (FAIWO)
  + Firefly algorithm teaching-learning-based optimization
    (FATLBO)
+ Để cải tiến FA, một cách thức lựa chọn đột biến được kết hợp vào thuật toán FA chuẩn để duy trì sự cân bằng giữa selection pressure và population diversity. 
+ 2 chỉ số được dùng để phân tích và làm thước đo là:
  + Davies – Bouldin (DB) [35]
  + Compact-Separated (CS) [36]
+ Kết quả thực nghiệm trên bộ dữ liệu thực tế được minh họa, để chứng minh hiệu suất của các thuật toán được đề xuất, so với các phương pháp hiện có.
+ Bố cục của bài báo như sau:
  + Section II: Trình bày chi tiết và toàn diện hơn các thuật toán state-of-the-art. 
  + Section III: Trình bày chi tiết về phương pháp, thiết kế của thuật toán FA đề xuất. Một số khái niệm toán học liên quan đến phân cụm cũng được thảo luận. 
  + Section IV: Mô tả các số liệu thực nghiệm và kết quả so sánh.
  + Section V: Nhận xét, kết luận và các hướng nghiên cứu trong tương lai.

___

## II. RELATED WORK

+ Thuật toán đom đóm (FA), nhờ vào tính mạnh mẽ, hiệu quả, khả năng xử lý vấn đề trong nhiều lĩnh vực khác nhau (bao gồm cả NP-hard), tính linh hoạt 
  và những lợi ích khác, đã được áp dụng vào giải quyết nhiều vấn để khác nhau. Một bài đánh giá toàn diện về FA đã thảo luận về các lĩnh vực 
  đa dạng, mà thuật toán này đã giải quyết được, và ứng dụng rộng rãi trong thế giới thực với kết quả khả quan đã được thực hiện bởi Fister vào năm 2014 [41]
  Trong bài báo, tác giả đã đi xa hơn, để đề xuất các hướng đi trong tương lai cho thuật toán.
+ FA mặc dù đã được nghiên cứu và theo dõi trong nhiều lĩnh vực, tuy nhiên việc triển khai nó và phạm vi phân nhóm tự động vẫn còn rất nông cạn, chưa chuyên sâu.
  Rất ít công trình thực hiện việc áp dụng thuật toán đom đóm trong phân cụm, và thực sự khó nhằn trong việc tìm kiếm các nghiên cứu trước đây nói về ứng dụng của thuật toán này.
+ Một nghiên cứu về hiệu suất của FA được thực hiện bởi Senthilnath [26]. Họ nhận ra các điểm mạnh của FA và đã áp dụng classification error percentage (CEP) để generate ra tâm tốt nhất của các cụm.
  FA chuẩn đã được cài đặt để phân cụm tập trung nhiều hơn vào sự hấp dẫn, quy mô dân số, khoảng cách, và CEP đã được áp dụng để kiểm tra
  phương pháp tạo ra cụm tối ưu. Xa hơn nữa, FA được so sánh với ABC, PSO và 9 phương pháp khác. Kết quả cho thấy sự hiệu quả của FA vượt trội hơn về độ tin cậy, hiệu quả, hiệu suất.
+ Hassanzadeh và Meybodi đã trình bày một phương pháp kết hợp dựa trên FA và k-means để phân cụm dữ liệu [42]. Các mô hình đề xuất được gọi là K-FA đã được thực hiện. FA được dùng để tìm ra tâm cụm do người dùng chỉ định số lượng cụm, sau đó FA được mở rộng 
bằng thuật toán k-mean, để hỗ trợ tinh chỉnh tâm này. 
+ Ngoài ra, global-optima được dùng để cải thiện FA chuẩn. Một thí nghiệm đã chỉ ra rằng K-FA vượt trội hơn 3 thuật toán cluster khác về việc có hiệu quả hơn, giả thiểu khoảng cách trong cụm, cho phép k-mean được khởi tạo thích hợp hơn.
+ Banati và Bajaj đã tiến hành phân tích hiệu suất của FA để phân cụm dữ liệu trong [27]. Phương pháp đề xuất gọi là FClust, dựa trên centroid-based, thông qua hành vi nhấp nháy của đom đóm, vào hàm chính của bài toán phân cụm để được giải pháp tối ưu.
  Hiệu suất của FClust được đánh giá bằng 2 tiêu chí thống kê [43]:
  + trace within criteria (TWR)
  + variance ratio criteria(VRC) [43]
  So sánh kết quả mô phỏng của FClust với PSO, DE cho thấy FClust đạ giá trị tốt nhất về độ lệch chuẩn trong phép đo VRC.
  Hơn nữa, chất lượng của giải pháp FClust cũng được đánh giá bằng cách tiếp cần phân phối (Run lengt distribution - RLD) [44].
  RLD cho thấy rằng FCLust đạ được giá trị tốt nhất và tốc độ hội tụ nhanh hơn.
  
## III. THE FIREFLY ALGORITHM

___

## IV. SIMULATION EXPERIMENTS

___

## V. CONCLUSION
