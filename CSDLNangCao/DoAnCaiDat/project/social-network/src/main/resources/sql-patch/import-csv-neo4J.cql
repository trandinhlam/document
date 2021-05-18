// clear data
MATCH (n)
DETACH DELETE n;
// load users
// "userId";"ten";"ngaySinh";"gioiTinh";"diaChi";"avatar";"ngheNghiep";"ngayThamGia";"timestamp"
LOAD CSV WITH HEADERS FROM "file:///test.csv" AS row
MERGE (u:User {id: row.userId, ten: row.ten, ngaySinh: coalesce(row.ngaySinh, 0), ngayThamGia: coalesce(row.ngayThamGia, 0), diaChi: row.diaChi})

// tinh thanh
MERGE (tt: TinhThanh {ten: row.diaChi})
MERGE (u)-[:CO_DIA_CHI_THUOC]->(tt)

// gioi tinh
MERGE (gt:GioiTinh {ten: row.gioiTinh})
MERGE (u)-[:THUOC_GIOI_TINH]->(gt)

// do tuoi
MERGE (a:DoTuoi {ten:'GenZ'})
MERGE (b:DoTuoi {ten:'9x'})
MERGE (c:DoTuoi {ten:'8x'})


// chạy riêng đoạn này
MATCH (u:User) MATCH (dt:DoTuoi)
WHERE (
    CASE WHEN toInteger(u.ngaySinh) < 641520000 THEN '8x' 
    WHEN toInteger(u.ngaySinh) < 957139200 THEN '9x' 
    ELSE 'GenZ' END) = dt.ten
CREATE (u)-[:THUOC_DO_TUOI]->(dt)