- Các phần mềm cần cài đặt:
    - Java SE Runtime Environment
    - Maven
    - Docker
    - DBeaver(Sử dụng để run script)
- Các cở sở dữ liệu sử dụng:
  - MySQL
  - ElasticSearch
  - Firebase
  - Neo4j
- Chuẩn bị data cho các cơ sở dữ liệu: 
  - Mysql:
    1. Mở terminal và run lệnh start MySQL container:<br>
       **docker run --name=mysql -d -p 3306:3306 -m 1g e- MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=root mysql/mysql-server**
    2. username : root, password: root
    3. Sử dụng app DBeaver create một database với tên là : **social_network** execute file script đính kèm(**mysql/social_network_user.sql và mysql/social_network_banbe.sql**) 
  - ElasticSearch:
    1. Mở terminal và run lệnh để start container ElasticSearch: <br>
       **docker run --name=elasticsearch -d -p 9200:9200 -p 9300:9300 -m 1g  -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.12.1**
    2. Để thực hiện import data cho ES ta sử dụng logstash:
       * Thực hiện chạy lệnh command để start logstash and sync data từ MySQL to ES: </br>
         **docker run --link mysql:mysql --link elasticsearch:elasticsearch -m 1g --rm -it -v {pathFolderDinhKem}/elasticsearch/logstash.yml:/usr/share/logstash/config/logstash.yml -v {pathFolderDinhKem}/elasticsearch/logstash.conf:/usr/share/logstash/config/logstash.conf -v {pathFolderDinhKem}/elasticsearch/mysql-connector-java-8.0.25.jar:/usr/share/logstash/config/mysql-connector-java-8.0.25.jar docker.elastic.co/logstash/logstash:7.12.1**
       * Mở browser access url: **localhost:9200/_cat/indices** để kiểm  tra index tồn tại với tên **user_index**
  - Firebase đang sử dụng: **https://console.firebase.google.com/project/social-network-31b96/firestore/data~2Fpost~2F105** nhưng để có thể access vô được bằng browser cần được cấp permission thông qua email.
      
  - Neo4j:
    1. asdas
    2. asdasd
    
- Cách build và chạy project:
    - Mở terminal folder root của source và thực hiện build bằng lệnh **mvn clean install -SkipTests**
    - Sau  copy file jar trong folder target đặt gần file application.yml(file jar và file application.yml được đặt chung một cấp thư mục).
    - Mở terminal và run lệnh **java -jar {jarFilename}** 
    - Trong file application.yml các thuộc tính config được chú thích trong file.