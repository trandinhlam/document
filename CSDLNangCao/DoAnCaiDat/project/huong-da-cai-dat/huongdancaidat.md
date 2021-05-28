- C�c ph?n m?m c?n c�i ??t:
    - Java SE Runtime Environment
    - Docker
    - DBeaver(s? d?ng ?? run + connect c�c h? c? s? d? li?u)
- C�c database s? d?ng:
  - MySQL
  - ElasticSearch
  - Firebase
  - Neo4j
- Chu?n b? data cho c�c c? s? d? li?u:
  - Mysql:
    1. M? terminal v� run l?nh ?? start MySQL container:<br>
       **docker run --name=mysql -d -p 3306:3306 -m 1g e- MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=root mysql/mysql-server**
    2. username : root, password: root
    3. S? d?ng app DBeaver create m?t database v?i t�n l� : **social_network** execute file script ?�nh k�m(**mysql/social_network_user.sql v� mysql/social_media_banbe.sql**) 
  - ElasticSearch:
    1. M? terminal v� run l?nh ?? start container ElasticSearch: <br>
       **docker run --name=elasticsearch -d -p 9200:9200 -p 9300:9300 -m 1g  -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.12.1**
    2. ?? th?c hi?n import data cho ES ta s? d?ng logstash ?? l�m vi?c ?�:
       * Th?c hi?n ch?y l?nh command ?? start logstash and sync data t? MySQL to ES: </br>
         **docker run --link mysql:mysql --link elasticsearch:elasticsearch -m 1g --rm -it -v {pathFolderDinhKem}/elasticsearch/logstash.yml:/usr/share/logstash/config/logstash.yml -v {pathFolderDinhKem}/elasticsearch/logstash.conf:/usr/share/logstash/config/logstash.conf -v {pathFolderDinhKem}/elasticsearch/mysql-connector-java-8.0.25.jar:/usr/share/logstash/config/mysql-connector-java-8.0.25.jar docker.elastic.co/logstash/logstash:7.12.1**
       * M? browser v� access url: **localhost:9200/_cat/indices** ?? ki?m tra index ?� ???c t?o v?i t�n l� **user_index**
  - Firebase ?ang s? d?ng: **https://console.firebase.google.com/project/social-network-31b96/firestore/data~2Fpost~2F105** nh?ng ?? c� th? access v� ???c b?ng browser c?n ???c c?p permission th�ng qua email.
      
  - Neo4j:
    1. asdas
    2. asdasd
    
- C�ch build v� ch?y project:
    - M? terminal ? folder root c?a source v� ti?n h�nh build b?ng l?nh **mvn clean install -sts**
    - Sau  copy file jar trong folder target ??t g?n file application.yml
    - M? terminal v� run l?nh **java -jar {jarFilename}** 
    - Trong file application.yml c�c thu?c t�nh config ???c ch� th�ch trong file