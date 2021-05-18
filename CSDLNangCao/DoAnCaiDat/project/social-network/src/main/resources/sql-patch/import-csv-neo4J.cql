// clear data
MATCH (n)
DETACH DELETE n;
// load users
// "userId";"ten";"ngaySinh";"gioiTinh";"diaChi";"avatar";"ngheNghiep";"ngayThamGia";"timestamp"
LOAD CSV WITH HEADERS FROM "file:///test.csv" AS row
MERGE (u:User {id: row.userId, ten: row.ten, ngaySinh: coalesce(row.ngaySinh, 0), ngayThamGia: coalesce(row.ngayThamGia, 0), diaChi: row.diaChi})
MERGE (gt:GioiTinh {ten: row.gioiTinh})
MERGE (tt: TinhThanh {ten: row.diaChi})

WITH u, gt
MERGE (u)-[:THUOC_GIOI_TINH]->(gt)

WITH u, tt
MERGE (u)-[:CO_DIA_CHI_THUOC]->(tt)

CREATE (a:DoTuoi {ten:'GenZ'})
CREATE (b:DoTuoi {ten:'9x'})
CREATE (c:DoTuoi {ten:'8x'})

MATCH (u:User) MATCH (dt:DoTuoi)
WHERE (CASE WHEN u.ngaySinh < 641520000 THEN '8x' WHEN u.ngaySinh < 957139200 THEN '9x' ELSE 'GenZ' END) = dt.ten
CREATE (u)-[:THUOC_DO_TUOI]->(dt)