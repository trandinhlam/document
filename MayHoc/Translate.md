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

+ Phân cụm dữ liệu là một kỹ thuật phân loại unsupervised quan trọng, liên quan đến tiến trình gom nhóm dữ liệu mà ở đó,
  các item giống nhau được nhóm vào một cụm dựa vào các thông số tương tự nhau [1]-[4]. gom cụm cũng thường được dùng
  cho nhiều ứng dụng hấp dẫn trong thế giới thực, như tiếp thị, sinh học, phân tích hình ảnh, thư viện, bảo hiểm, khai
  thác dữ liệu, y học, phân tích thống kê, nhận diện cộng đồng, và các lĩnh vực khoa học kỹ thuật khác [5]-[7].
+ Mặc dù phân tích gom cụm đã được sử dụng lần đầu trong 2 lĩnh vực khoa học xã hội, cụ thể là nhân loại học và tâm lý
  học [8], xa hơn nữa, nó cũng được sử dụng cho lý thuyết phân loại đặc điểm trong tâm lý nhân cách bởi Cattel vào đầu
  năm 1943 [8],[9].
+ Phương pháp trong gom cụm dữ liệu đã được mở rộng với sự liên quan đáng kể trong việc áp dụng cho các nghiên cứu mới,
  trong các lĩnh vực như KHDL, Machine learning. Cần lưu ý rằng việc phân cụm dữ liệu ra thành các nhóm có ý nghĩa là
  một nhiệm vụ quan trọng của cả AI và Data mining.
+ Thông thường, thuật ngữ clustering thường được gán với một phép gán nhãn dữ liệu không giám sát, ở đó kết quả của quá
  trình phân tích này phụ thuộc rất nhiều vào tính ưu việt và hiệu quả của các thuật toán, phương pháp phân nhóm được sử
  dụng.
+ Trong các thập niên trước, nhiều thuật toán heuristic-based đã đưa ra để giải bài toán phân cụm. Mỗi thuật toán được
  thiết kế và cài đặt dựa trên 2 phân lớp chính của phương thức gom cụm [10]-[11]:
    + hierarchical - phân cụm phân cấp: Các thuật toán này tạo ra một cấu trúc phân cấp dạng cây, đại diện cho một cụm
      nhóm dính với nhau, của một số điểm dữ liệu. Thuật toán phổ biến nhất trong nhóm này là thuật toán single-link (
      liên kết đơn) và complete-link (liên hết hoàn toàn) [12]
    + partitioning - phân cụm phân nhóm: ngược lại, các thuật toán này phân phối các điểm dữ liệu vào các cụm không
      overlap nhau. Nói cách khác, thuật toán phân nhóm tạo ra các phân vùng dữ liệu đơn lẻ thay vì xậy dựng một cấu
      trúc cây như trên [13].
+ Một trong những thách thức lớn của các thuật toán kể trên là làm sao chọn số lượng cụm thích hợp ở đầu ra cuối cùng.
  Thuật toán k-means có lẽ là phương pháp phổ biến nhất cho vấn đề này. Tuy nhiên, sự thành công của các thuật toán kể
  trên phụ thuộc nhiều vào việc có thông tin xác định trước về các đối tượng dữ liệu và giải pháp yêu cầu ban đầu, trong
  đó hầu hết các trường hợp có thể dễ dàng làm cho thuật toán mắc kẹt xung quanh local optima [8]. Đây là những nhược
  điểm nghiêm trọng khiến cho các nhà nghiên cứu phải đưa ra các giải pháp hữu hiệu khác để khắc phục, bao gồm việc sử
  dụng một số cải tiến và các thuật toán thông minh, kết hợp với các thuật toán phức tạp hơn, và các vấn đề phân cụm dữ
  liệu nhiều chiều.
+ Một vài thuật toán cải tiến được sử dụng để xử lý các vấn đề kể trên là:
    + Genetic algorithm (GA)
    + Differential evolution (DE)
+ Trong khi đó một số kỹ thuật thông minh (swarm intelligence) cũng được áp dụng hiệu quả để giải quyết vấn đề phân
  cụm[14],[15] như:
    + particle swarm optimization (PSO):
    + ant colony optimization (ACO):
    + firefly algorithm (FA):
    + invasive weed optimization (IWO):
    + artificial bee colony optimization (ABC):
    + teaching learning-based optimization (TLBO):
+ Ví dụ:
    + Zabihi và Nasiri [16] đề xuất việc sử dụng thuật toán ABC theo history-driven để giải quyết phân cụm dữ liệu, với
      cơ chế ghi nhớ dựa trên phân vùng không gian nhị phân đã được kết hợp vào thuật toán ABC, để cải thiện hiệu suất
      phân cụm.
    + Merwe và Engelbrecht đã đề xuất việc sử dụng PSO để giải quyết vấn đề phân cụm [17].
    + Tương tự, Zhao [18] đã làm về việc cải thiện hiệu suất của thuật toán k-mean bằng cách lai nó với PSO để tránh bị
      ảnh hưởng trực tiếp bởi các trung tâm cụm ban đầu.
    + Liu và công sự [15] phát triển một thuật toán dựa trên GA để tìm ra nhóm có chất lượng tốt cho một cụm không xác
      định.
    + Nikkam và cộng sự [19] đã đề xuật một thuật toán cải tiến hiệu quả kết hợp ACO và các thuật toán simulated
      annealing (SA) để giải quyết. Kết quả mô phỏng của ACO-SA cho thấy thuật toán kết hợp hoạt động hiệu quả hơn SA cơ
      bản, ACO và k-mean riêng lẻ.
    + Satapathy và Naik [20] đã phát triển một thuật toán TLBO đã được sử dụng để tìm các tâm của một số lượng cụm do
      người dùng chỉ định.
+ Các ví dụ liên quan khác:
    + Sahoo và Kumar [21] đề xuất hai chỉnh sửa đối với phương pháp TLBO để nâng cao hiệu suất của nó, trong đó thay vì
      khởi tạo ngẫu nhiên, một phương pháp được sử dụng để khai tác tâm của các cụm ban đầu.
    + Zhao và Zhou [22] đề xuất một thuật toán fuzzy c-mean dựa trên IWO
    + Liu [23] sử dụng thuật toán IWO đa mục tiêu
    + Wang và cộng sự [24], đề xuất một thuật toán thụ phấn cho hoa flower pollination algorithm (FPA) với bee
      pollinators.
    + Agarwal và Mehta [25] đã nghiên cứu ứng dụng nâng cao thuật toán thụ phấn hoa
+ Các ví dụ gần đây:
    + Senthilnath và cộng sự [26] đã tiến hành đánh giá hiệu suất nghiên cứu về việc sử dụng FA tiêu chuẩn. Kết quả được
      so sánh với PSO, ABA và các thuật toán khác.
    + Hơn nữa, một nghiên cứu tương tự về phân tích hiệu suất của thuật toán đom đóm để phân cụm dữ liệu cũng đã được
      xem xét trong [27] bởi Banati và Bajaj
    + Trong năm 2012, Abshouri và Bakhtiary [28] đã đề xuất một FA lai mới kết hợp thuật toán FA và K-Harmonic Means
+ Tuy nhiên, hầu hết các thuật toán đề cập ở trên được test và và chứng minh là mang lại các giải pháp chuất lượng vượt
  trội, yêu cầu các thuật toán phải được cung cấp tri thức cụ thể trước đó về các đặc điểm, đặc trưng của dữ liệu. Chẳng
  hạn như phải chỉ định trước số cụm và các thuộc tính liên quan của dữ liệu.
+ Vấn đề là, trong thực tế các bộ dữ liệu, số lượng cụm không được biết trước, đặc biệt đối với các tập quá lớn. Hơn
  nữa, việc tự động xác định số cụm dữ liệu cần thiết rất khó khăn [15].
+ Do đó, __mục tiêu cụ thể__ của bài báo này là phát triển một phương pháp phân nhóm dựa trên FA được cải tiến, sẽ tự
  động cung cấp phân vùng thích hợp mà không cần bất kỳ tri thức biết trước về đặc điểm của dữ liệu. Ngoài ra, nghiên
  cứu này đề xuất việc triển khai 4 thuật toán FA để giải quyết một loạt các vấn đề trong phân cụm một cách tự động, bao
  gồm:
    + Tối ưu thuật toán đom đóm lai (FAABC)
    + Firefly algorithm artificial bee colony (FAABC)
    + Firefly algorithm invasive weed optimization (FAIWO)
    + Firefly algorithm teaching-learning-based optimization
      (FATLBO)
+ Để cải tiến FA, một cách thức lựa chọn đột biến được kết hợp vào thuật toán FA chuẩn để duy trì sự cân bằng giữa
  selection pressure và population diversity.
+ 2 chỉ số được dùng để phân tích và làm thước đo là:
    + Davies – Bouldin (DB) [35]
    + Compact-Separated (CS) [36]
+ Kết quả thực nghiệm trên bộ dữ liệu thực tế được minh họa, để chứng minh hiệu suất của các thuật toán được đề xuất, so
  với các phương pháp hiện có.
+ Bố cục của bài báo như sau:
    + Section II: Trình bày chi tiết và toàn diện hơn các thuật toán state-of-the-art.
    + Section III: Trình bày chi tiết về phương pháp, thiết kế của thuật toán FA đề xuất. Một số khái niệm toán học liên
      quan đến phân cụm cũng được thảo luận.
    + Section IV: Mô tả các số liệu thực nghiệm và kết quả so sánh.
    + Section V: Nhận xét, kết luận và các hướng nghiên cứu trong tương lai.

___

## II. RELATED WORK

+ Thuật toán đom đóm (FA), nhờ vào tính mạnh mẽ, hiệu quả, khả năng xử lý vấn đề trong nhiều lĩnh vực khác nhau (bao gồm
  cả NP-hard), tính linh hoạt và những lợi ích khác, đã được áp dụng vào giải quyết nhiều vấn để khác nhau. Một bài đánh
  giá toàn diện về FA đã thảo luận về các lĩnh vực đa dạng, mà thuật toán này đã giải quyết được, và ứng dụng rộng rãi
  trong thế giới thực với kết quả khả quan đã được thực hiện bởi Fister vào năm 2014 [41]
  Trong bài báo, tác giả đã đi xa hơn, để đề xuất các hướng đi trong tương lai cho thuật toán.
+ FA mặc dù đã được nghiên cứu và theo dõi trong nhiều lĩnh vực, tuy nhiên việc triển khai nó và phạm vi phân nhóm tự
  động vẫn còn rất nông cạn, chưa chuyên sâu. Rất ít công trình thực hiện việc áp dụng thuật toán đom đóm trong phân
  cụm, và thực sự khó nhằn trong việc tìm kiếm các nghiên cứu trước đây nói về ứng dụng của thuật toán này.
+ Một nghiên cứu về hiệu suất của FA được thực hiện bởi Senthilnath [26]. Họ nhận ra các điểm mạnh của FA và đã áp dụng
  classification error percentage (CEP) để generate ra tâm tốt nhất của các cụm. FA chuẩn đã được cài đặt để phân cụm
  tập trung nhiều hơn vào sự hấp dẫn, quy mô dân số, khoảng cách, và CEP đã được áp dụng để kiểm tra phương pháp tạo ra
  cụm tối ưu. Xa hơn nữa, FA được so sánh với ABC, PSO và 9 phương pháp khác. Kết quả cho thấy sự hiệu quả của FA vượt
  trội hơn về độ tin cậy, hiệu quả, hiệu suất.
+ Hassanzadeh và Meybodi đã trình bày một phương pháp kết hợp dựa trên FA và k-means để phân cụm dữ liệu [42]. Các mô
  hình đề xuất được gọi là K-FA đã được thực hiện. FA được dùng để tìm ra tâm cụm do người dùng chỉ định số lượng cụm,
  sau đó FA được mở rộng bằng thuật toán k-mean, để hỗ trợ tinh chỉnh tâm này.
+ Ngoài ra, global-optima được dùng để cải thiện FA chuẩn. Một thí nghiệm đã chỉ ra rằng K-FA vượt trội hơn 3 thuật toán
  cluster khác về việc có hiệu quả hơn, giảm thiểu khoảng cách trong cụm, cho phép k-mean được khởi tạo thích hợp hơn.
+ Banati và Bajaj đã tiến hành phân tích hiệu suất của FA để phân cụm dữ liệu trong [27]. Phương pháp đề xuất gọi là
  FClust, dựa trên centroid-based, thông qua hành vi nhấp nháy của đom đóm, vào hàm chính của bài toán phân cụm để được
  giải pháp tối ưu. Hiệu suất của FClust được đánh giá bằng 2 tiêu chí thống kê [43]:
    + trace within criteria (TWR)
    + variance ratio criteria(VRC) [43]
      So sánh kết quả mô phỏng của FClust với PSO, DE cho thấy FClust đạ giá trị tốt nhất về độ lệch chuẩn trong phép đo
      VRC. Hơn nữa, chất lượng của giải pháp FClust cũng được đánh giá bằng cách tiếp cần phân phối (Run lengt
      distribution - RLD) [44]. RLD cho thấy rằng FCLust đạ được giá trị tốt nhất và tốc độ hội tụ nhanh hơn.

[comment]: <> (  ![]&#40;./photos/hinh1.png&#41;<br>)

[comment]: <> (  FIGURE 1. A compartmentalized flowchart of the hybrid firefly algorithms.)


[comment]: <> (  ![]&#40;./photos/6-Figure2-1.png&#41;<br>)

[comment]: <> (  FIGURE 2. Flowchart of the hybrid firefly algorithms.)

[comment]: <> (  ![]&#40;./photos/7-Figure4-1.png&#41;<br>)

[comment]: <> (  FIGURE 4. Average computational time consumed by the four hybrid firefly algorithms on DB measure for all the datasets)

[comment]: <> (  for 40 replications.)

+ Năm 2015, Kaushik và Arora đã tích hợp FA với một thuật toán di truyền cải tiến [45], được gọi là FGA. Mô hình được đề
  xuất chọn dân số ban đầu của nó từ một nhóm dân số dựa trên thuật toán đom đóm, tức là dân số ban đầu được tạo ra từ
  các giải pháp toàn cục tốt nhất. FAG hoạt động theo 2 cách:
    + 1, FA cổ điển được áp dụng cho các tập dân số được khởi tạo ngẫu nhiên, tạo ra nhiễm sắc thể chromosomes của một
      bộ
    + 2, các nhiễm sắc thể sau đó được định vị trong vùng giao nhau, chúng tham gia vào các hoạt động đột biến và trao
      đổi chéo của thuật toán di truyền GA.
+ Ngoài ra, ở giai đoạn khởi tạo FGA, nó dẫn đến tối ưu toàn cục, điều này ngăn quá trình mắc kẹt trong local optima.
  Kết quả kiểm tra, khi so sánh với GA cơ bản và thuật toán đom đóm, cho thấy FGA có inter-cluter tốt hơn, và khoảng
  cách intra-cluster tốt hơn, dẫn đến kết quả tốt hơn.

+ Nayak [47] cài đặt một FA cải tiến hơn với thuật toán fuzzy c-means gọi là FAFCM và FAFCM cải tiến cho các tập dữ liệu
  thế giới thực. FA cải tiến đã giải quyết những thiếu sót của phương pháp fuzzy c-means, của entrapment local optima,
  và độ nhạy cao khi khởi tạo. FAFCM bao gồm 2 giai đoạn:
    + 1, một FA chuẩn với phân cụm fuzzy c-means. pha này xử lý các hạn chế của thuật toán fuzzy c-means bằng cách tối
      thiểu objective function.
    + 2, một FA cải tiến với phân cụm fuzzy c-means. Pha này tinh chỉnh các tâm cụm đã được xác định ở phase 1, và cũng
      hỗ trợ tiếp tục tối thiểu hóa hàm mục tiêu.
+ FAFCM được so sánh với 3 thuật toán phân cụm khác, kết quả cho thấy FAFCM có kết quả thống nhất với tập test, và tốc
  độ hội tụ nhanh hơn. Tuy nhiên, số lượng cụm đã được các định trước khi FAFCM gán vào.

[comment]: <> (  ![]&#40;./photos/9-Figure6-1.png&#41;)

[comment]: <> (  FIGURE 6. Clustering results of hybrid FAABC of some datasets on DB-index.)

+ Một phương pháp lai hiệu quả dựa trên FA và thuật toán dynamic k-means được phát triển bởi Sundararajan and
  Karthikeyan[48]. Thuật toán này gọi là hybrid modified firefly and dynamic k-means. Thuật toán dynamic k-means được
  kết hợp để có thể tìm ra số cụm tối ưu trong thời gian thực thi, cũng như để cải tiến chất lượng phân cụm và tính tối
  ưu. Mô hình hoạt động theo cách đó, nó xác định các tâm cụm mới bằng cách thêm một tâm mới vào bộ đếm counter ở mỗi
  vòng lặp, cho đến khi chất lượng cụm yêu cầu đạt được, và mô hình hoạt động đủ tốt. Kết quả thực nghiệm cho thấy chất
  lượng cụm tốt hơn trong thời gian ngắn hơn với tối ưu tốt hơn, so với các thuật toán khác.

+ Ezugwu [40] đã trình bày một nghiên cứu khảo sát sâu rộng về Các thuật toán metaheuristic lấy cảm hứng từ thiên nhiên,
  được áp dụng để giải quyết các vấn đề về phân cụm tự động. Hơn nữa, tác giả đã thực hiện một so sánh một số thuật toán
  nổi tiếng về global metaheuristic để giải quyết phân cụm tự động, trong đó 3 thuật toán hybrid swarm intelligence and
  evolutionary algorithms:
    + article swarm differential evolution algorithm
    + firefly differential evolution algorithm
    + invasive weed optimization differential evolution algorithm
      <br>
      Kết quả thử nghiệm cho thấy thuật toán FA phù hợp hơn để phân nhóm trong cả trường hợp đối tượng đa chiều so với
      các state-of-the-art.

+ Tất cả các tài liệu và phân tích so sánh khác nhau đều chỉ ra rằng FA là một thuật toán metaheuristic rất hiệu quả và
  mạnh mẽ để giải quyết vấn đề này trong thế giới thực. Hơn nữa, những phát hiện từ Ezugwu [40] và Agbaje et al. [49] về
  hiệu suất đầy hứa hẹn của FA trong phân nhóm tự động đã dẫn dắt chúng tôi đi vào nghiên cứu này, để làm rõ hơn về sự
  vượt trội của cả thuật toán FA và các biến thể, cải tiến của nó trong phân nhóm tự động.
+ Sau khi các phân tích sâu rộng được thực hiện, chúng tôi đã tổng hợp các phương pháp phân cụm khả thi sau đây, với các
  thông số chỉ mục kèm theo được xác định, được trình bày trong bảng 1:

![](./photos/4-Table1-1.png)<br>
TABLE 1. A summary of metaheuristic algorithms that have been applied to automatic clustering problems.

![](./photos/5-Table2-1.png)<br>
TABLE 1. (Continued.) A summary of metaheuristic algorithms that have been applied to automatic clustering problems.

___

## III. THE FIREFLY ALGORITHM

___

## IV. SIMULATION EXPERIMENTS

+ Thí nghiệm được thực hiện trên máy cấu hình:
    + CPU 3.60 GHz Intel(R) Core(TM) i7-7700
    + RAM 16GB
    + Windows 10
+ Toàn bộ thuật toán được lập trình trên MATLAB R2018b và các phân tích thống kê được thực hiện trên IBM SPSS Version 25

### A. PARAMETER SETTING

Trong phần này, chúng tôi sẽ trình bày các cài đặt cụ thể các tham số cho 4 thuận toán đã đề xuất. Các cài đặt thông số
được mô tả trong bảng 2(a)
![](photos/14-Table2-1.png)<br>
_TABLE 2. (a) Parameter configurations of ABC, IWO, PSO, and TLBO algorithms. (b) Characteristics of the twelve
benchmark datasets._

+ Đối với mỗi thuật toán được đề xuất, chúng tôi khởi tạo một tập số lượng population bằng nhau ở mỗi lần lặp, trong
  trường hợp này là 40 lần chạy cho tất cả các thử nghiệm. Các cài đặt tham số cho FA được mô tả như sau:
    + size của population là 25, số lượng tối đa MaxIt là 200
    + Hệ số light absorption γ=1 (hệ số hấp thụ ánh sáng)
    + hệ số attraction coefficient β=2 (hệ số hấp dẫn)
    + hệ số mutation m=2
    + tỉ lệ mutation damping α=1.
+ Các cấu hình tham số của ABC, IWO, PSO, TLBO được trình bày chi tiết hơn trong bảng 2a.

+ Các thuật ngữ chính trong tham số:
    + tham số _a_ là giới hạn trên của hệ số gia tốc acceleraton coefficient.
    + _Smin_ và _Smax_ là số seed tối thiểu/tối đa
    + _E_ là variance reduction exponent
    + _sigma_initial_ và _sigma_final_ là giá trị độ lệch chuẩn lúc đầu và lúc cuối
    + _c1_ và _c2_ là hệ số học personal và global
    + _wdamp_ tỉ số inertia weight damping
    + _w_ là inertia weight được tính theo công thức ![img.png](img.png), với _t_
      là số lần lặp. Lưu ý rằng giá trị của w được điều chỉnh liên quan đến lần lặp t để tránh hybrid FAPSO khỏi lao vào
      sự hội tụ quá sớm.

### B. DATASETS DESCRIPTION

12 tập data được sử dụng là các tập data phổ biến, dễ sử dụng từ UCI Machine Learning Repository. Mô tả ngắn gọn về một
vài dataset:

+ Breast Cancer Wisconsin (Original) dataset: Tập dữ liệu này được thu thập từ chuẩn đoán ung thư vú từ bệnh viện Đại
  học Wiscosin. Nó chưa hai class khối u (2 lành tính và 4 ác tính), 699 điểm dữ liệu với 10 thuộc tính.
+ Glass dataset: tập dữ liệu này được lấy từ Dịch vụ Khoa học Pháp y Hoa Kỳ, được xác định theo hàm lượng oxide của
  chúng. Việc phân loại tập data này tạo tiền đề cho các cuộc điều tra tội phạm từ các hiện trường vụ án, nơi các tấm
  kính để lại có thể được sử dụng làm nguồn bằng chứng nếu được xác định chính xác. 9 nhân tố hóa học khác nhau (chỉ số
  khúc xạ RI, Natri Na, Nhôm Al, Silicon Si, Kali K, Canxi Ca, Bari Ba, Sắt Fe, Magie Mg) được sử dụng như một tiêu
  chuẩn để xác định một loại glass trong 6 loại glass. Tập này bao gồm 214 điểm dữ liệu với 10 thuộc tính.
+ Iris dataset: Tập data bao gồm 3 biến thể khác nhau của hoa iris
    + Iris Setosa
    + Iris Versicolor
    + Iris Virginica <br>
      3 loại này bao gồm 150 cá thể với 4 thuộc tính
+ Statlog (Heart) dataset: Bộ này dựa trên việc chuẩn đoán bệnh tim từ 4 CSDL khác nhau, được tạo ra dựa trên 13 thuộc
  tính khác nhau. Bao gồm 250 case và 13 thuộc tính
+ Wine dataset: Tập dữ liệu về rượu được thu thập bằng cách sử dụng phân tích hóa học để xác định nguồn gốc của rượu
  được trồng ở cùng 1 vùng miền, nhưng từ 3 người trồng khác nhau ở Ý. Phân tích này có thể xác định số lượng cấu thành
  trong 13 thành phần được tìm thấy trong mỗi loại của 3 loại rượu. Bộ này chứa 178 mẫu với 13 thuộc tính.
+ Yeast dataset: Bộ dữ liệu nấm men được dùng để dự đoán các vị trí các vị trí localization của protein trong các tế
  bào. Bộ này gồm 1484 mẫu và 8 thuộc tính.
+ Chi tiết về các tập data còn lại, cụ thể là, Jain dataset, Pathbased dataset, Spiral dataset, and Thyroid được đề cập
  trong [38][39][40]. 12 bộ dữ liệu được tóm tắt trong bảng 2b ở trên.

### C. RESULTS AND DISCUSSION

Trong phần này, chúng tôi trình bày và thảo luận về các kết quả trung bình thu được bởi standard FA và 4 thuật toán FA
đã đề xuất. Các thuật toán được so sánh dựa trên các giá trị trung bình của chỉ số CS và DB. Trong bảng 3, các giá trị
được in đậm chỉ rằng thuật toán thu được giải pháp tốt nhất so với các thuật toán khác. Tất cả các kết quả được trình
bày trong nghiên cứu này được mô tả ở 4 chữ số thập phân và chúng tôi chủ yêu tập trung vào chất lượng của giải pháp
được tạo ra bởi mỗi thuật toán, cũng như thời gian thực hiện ở mỗi thuật toán để tìm kiếm các giải pháp gần tối ưu nhất.
![](./photos/15-Table3-1.png)<br>
_TABLE 3. Numerical results comparison of average solutions obtained by muted FA and the four hybrid algorithms based on
the CS and DB indices over 40 replications._ <br>
![](./photos/16-Table4-1.png)<br>
![](./photos/17-Table4-1.png)<br>
_TABLE 4. Numerical results for the four hybrid firefly algorithms based on the CS and DB indices on over 40
replications._<br>

+ Đối với phép đo CS, chỉ ra rằng FA hoạt động tốt trên tập Breast dataset và Flame dataset. Tương tự, FAABC work tốt
  trên tập Flame. Hơn nữa, FAPSO đã đạt được hiệu suất tốt nhất 9/12 bộ data, cụ thể là Compound, Iris, Jain, Pathbased,
  Spiral, Statlog, Thyroid, Wine and, Yeast datasets.
+ Bên phía DB index, hiệu suất tốt nhất là của FATLBO, trong 5 dataset Flame, Iris, Pathbased, Spiral and, Yeast. Theo
  sau là FAPSO với 4 bộ dữ liệu Glass, Jain, Thyroid, and Wine datasets. Mặc dù vậy, FA tiêu chuẩn đã làm khá tốt trên 3
  tập Breast, Compound, and Statlog. Cả FAABC và FAIWO đều không vượt trội trong chỉ số DB. Điều này chứng minh rằng FA
  hoạt động tốt hơn các thuật toán khác trên bộ dữ liệu Breast dataset trên cả 2 phép đo. Ngược lại FAIWO không tỏ ra
  vượt trội hơn ai ở cả 2 phép đo CS và DB.

+ Nhìn chung, sự so sánh giữa FA chuẩn và các biến thể lai của nó, cho thấy răng các giải pháp optimal fitness đạt được
  bởi FAPSO trên chỉ số CS có giá trị thấp hơn, nghĩa là hiệu suất tốt hơn. Hơn thế nữa, hiệu suất của thuật toán FAPSO
  có thể đạt xuất sắc trên nhiều bộ dataset hơn bất kỳ thuật toán nào khác. Tuy nhiên, đối với chỉ số DB, FATLBO nổi lên
  là thuật toán hoạt động tốt nhất, sau đó là FAPSO, rồi đến FA chuẩn. Kết luận, chúng ta có thể suy ra FAPSO là một
  thuật toán phân nhóm tự động rất hiệu quả.

___

+ Tiếp theo, chúng tôi trình bày và thảo luận về kết quả của 4 thuật toán bằng cách sử dụng thống kê để tìm ra giải pháp
  tốt nhất, kém nhất, trung bình và độ lệch chuẩn. Các giá trị được đánh dấu in đậm cho biết thuật toán work tốt nhất.
    + Như đã thấy ở CS index:
        + FAABC, FAIWO và FATLBO đã đạt được kết quả tương tự trên tập Breast
        + cũng như FAABC and FATLBO trên Compound dataset.
        + Tương tự là FAPSO trên Flame, Iris, Jain, Thyroid, Wine and Yeast datasets.
        + FAPSO và FATLBO đạt tốt nhất trên Pathbased
        + FAABC thì trên Spiral. Mức độ nhất quán và ổn định được thể hiện trong kết quả thu được trong bộ dữ liệu Glass
          và Statlog, trên tất cả bốn phương pháp kết hợp. Do đó, FAPSO thể hiện sự vượt trội so với các thuật toán khác
          trên CS index.
    + Ở DB index:
        + FAABC, FAIWO và FATLBO đã thu được kết quả tốt nhất nhưng giống hệt nhau đối với tập Breast. Kết quả này tương
          tự như kết quả của chỉ số CS, tức là hiệu suất của 3 thằng này là giống nhau ở cả 2 phép đo.
        + FAPSO đạt tốt nhấ trên Compound, Glass, Statlog and Thyroid.
        + FAABC, FAIWO and FATLBO giống nhau ở tập Breast, Flame và Yeast.
        + FAABC and FATLBO giống nhau ở Iris and Wine.
        + FAABC tốt nhất ở Spiral
        + FATLBO trên Jain and Pathbased
+ Mặc dù một số trường hợp bằng nhau giữa 2 hay nhiều thuật toán, không thể phủ nhật FAPSO hoạt động tốt hơn các thuật
  toán khác trên 4 tập Compound, Glass, Statlog and Thyroid. FAPSO cũng thu được kết quả tốt trên tổng thể. Dựa trên
  những đánh giá này, ta có thể nói rằng chỉ số CS đánh giá hợp lý hơn DB cho cả 4 thuật toán và trên 12 tập dữ liệu.
+ Hình 3 và 4 cho thây thời gian tính toán trung bình của mỗi thuật toán qua 2 chỉ số trên.
  ![](./photos/7-Figure4-1.png)
  <br>
    + Trong 2 biểu đồ trên, FAACB biểu thị bằng màu vàng, FAIWO màu tím, FAPSO màu đỏ, FATLBO màu xanh lam. Thời gian
      thực thi trung bình được lập tương ứng với bộ dữ liệu
        + Đối với CS index trong hình 3, FAPSO có thời gian kém nhất trên 12 tập.
        + Tiếp theo là FAIWO, FATLBO.
        + FAABC chạy tốt nhất.
    + Như đã đề cập, mặc dù FAPSO là giải pháp tốt nhất trong CS index, nó lại tiêu tốn thời gian đáng kể nhất.
    + Tương tự đối với DB index, thứ tự tốt nhất là FAABC, FATLBO, FAPSO, FAIWO.

___

### D. STATISTICAL ANALYSIS TEST

+ Để so sánh thêm, chúng tôi đã thực hiện kiểm tra thống kê phi tham số Friedman rank-sum test, dùng để xác định các sự
  khác biệt đáng kể giữa nhiều thuật toán, Như trình bày trong bảng 5, cho thấy rằng đối với CS index, FAPSO có rank tốt
  nhất trên 7/12 bộ dữ liệu, gồm Iris, Jain, Pathbased, Spiral Thyroid, Wine and Yeast. tương tự Glass and Statlog cho
  thấy sữ tương đồng giữa 4 thuật toán, như trong bảng 4 đã trình bày.
  ![](./photos/17-Table5-1.png)
  _TABLE 5. Mean ranks achieved by the Friedman test for the four proposed hybrid firefly algorithms._<br>

+ FATLBO xếp cùng FAPSO trong 3 bộ Breast Compound and Flame.
+ Tuy nhiên, thực tế củng cố FAPSO là thuật toán hiệu quả.
+ Ở DB index, FAPSO and FATLBO bằng nhau (Compound, Jain, Statlog, Thyroid, and Yeast cho FAPSO) và (reast, Flame, Iris,
  Pathbased and Spiral datasets for the FATLBO)
+ Cuối cùng, FAABC, FAIWO and FATLBO bằng nhau trong Glass.


+ Để so sánh thêm và củng cố cho phép đo Friedman, Chúng tôi thực hiện thêm Wilcoxon pos-hoc test để xác định các khác
  biệt giữa các thuật toán.
  ![](./photos/18-Table6-1.png)<br>
  _TABLE 6. p-values produced by the Wilcoxon rank-sum test for equal medians on CS index._<br>
  ![](./photos/18-Table7-1.png)<br>
  _TABLE 7. p-values produced by the Wilcoxon rank-sum test for equal medians on DB index._<br>

+ Table 6 và Table 7 báo cáo các p-value được tạo ra bởi phân tích này để so sánh các cặp thuật toán với nhau, trên cả
  CS và DB. Hầu hết các giá trị là dưới p-values chúng tôi đã điều chỉnh là (p ≤ 0.0083).
+ Chúng tôi đã thu được một số lượng lớn các giá trị có ý nghĩa thống kê trên FAPSO theo cặp với các thuật toán khác
  trong cả CS và DB. Điều này càng chứng tỏ tính ưu việt của FAPSO.

___

### E. CLUSTERING PROCESS

___

### F. ALGORITHM CONVERGENCE CURVES

___

### G. HIGH-DIMENSIONAL DATASET AND PARAMETER FINE-TUNING

___

### H. ALGORITHM COMPLEXITY

___

## V. CONCLUSION

+ Trong nghiên cứu này, 4 thuật toán lai dựa trên FA đã được triển khai thành công để giải các bài tóan phân cụm dữ liệu
  tự động.
+ Theo đó, một nghiên cứu hiệu suất của các thuật toán này đã được thực hiện. Các kết quả mô phỏng thí nghiệm thu được
  cho thấy FAPSO hoạt động tốt hơn so với các loại khác (FAABC, FAIWO, FATLBO) về chất lượng và tốc độ hội tụ.
+ Mặt khác, FATLBO hoạt động tương đối tốt và gần được như FAPSO, vì chất lượng gần bằng và tốc độ tốt hơn.
+ Tuy nhiên, FAIWO tỏ ra kém hiệu quả về chất lượng và tốc độ thực thi.
+ Trong tương lai, chúng tôi dự định áp dụng các thuật toán kết hợp dựa trên FA cải tiến tương tự bài báo này.
+ Tương tự, sẽ rất thú vị khi thấy một số phần mở rộng high-level của các thuật toán phân cụm tự động đã đề xuất, có thể
  xác định được tập cấu hình tham số tối ưu nhất cho từng quá trình riêng lẻ.
+ Cuối cùng, khả năng kết hợp các thuật toán FA với một số phương pháp Deep Learning clustering như Deep embedding
  clustering [83], deep clustering network [84], pairwise constraints clustering [85], deep embedding network [86],
  joint unsupervised learning of deep representation for images [84], deep learning with non-parametric clustering [87],
  convolutional neural network clustering [88] and deep clustering with convolutional autoencoder embedding [90]... với
  kích thước dữ liệu lớn và các đặc trưng phức tạp hơn.