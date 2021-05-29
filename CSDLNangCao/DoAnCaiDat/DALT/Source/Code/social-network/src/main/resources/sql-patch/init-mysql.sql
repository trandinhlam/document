SET SQL_SAFE_UPDATES = 0;
update user 
set diaChi = (case 
		when userId % 10 = 0 then 'Ha Noi' 
        when userId % 10 = 1 then 'Da Nang'
        when userId % 10 = 2 then 'Tay Ninh'
        when userId % 10 = 3 then 'Quang Nam'
        when userId % 10 = 4 then 'Khanh Hoa'
        when userId % 10 = 5 then 'Binh Duong'
        when userId % 10 = 6 then 'Binh Thuan'
        when userId % 10 = 7 then 'Ca Mau'
        when userId % 10 = 8 then 'Tien Giang'
        else 'Ho Chi Minh' 
    end)
;

insert into banbe (userYC, userNhan, ngayKetBan, trangThai, timestamp) values (105, 106, STR_TO_DATE('2021-05-01 16:20:00','%Y-%m-%d %H:%i:%s'), 1, CURTIME());
insert into banbe (userYC, userNhan, ngayKetBan, trangThai, timestamp) values (107, 108, STR_TO_DATE('2021-05-02 16:20:00','%Y-%m-%d %H:%i:%s'), 1, CURTIME());
insert into banbe (userYC, userNhan, ngayKetBan, trangThai, timestamp) values (109, 110, STR_TO_DATE('2021-05-03 16:20:00','%Y-%m-%d %H:%i:%s'), 1, CURTIME());
insert into banbe (userYC, userNhan, ngayKetBan, trangThai, timestamp) values (111, 112, STR_TO_DATE('2021-05-04 16:20:00','%Y-%m-%d %H:%i:%s'), 1, CURTIME());
insert into banbe (userYC, userNhan, ngayKetBan, trangThai, timestamp) values (113, 114, STR_TO_DATE('2021-05-05 16:20:00','%Y-%m-%d %H:%i:%s'), 1, CURTIME());
insert into banbe (userYC, userNhan, ngayKetBan, trangThai, timestamp) values (115, 116, STR_TO_DATE('2021-05-06 16:20:00','%Y-%m-%d %H:%i:%s'), 1, CURTIME());
insert into banbe (userYC, userNhan, ngayKetBan, trangThai, timestamp) values (117, 118, STR_TO_DATE('2021-05-07 16:20:00','%Y-%m-%d %H:%i:%s'), 1, CURTIME());
insert into banbe (userYC, userNhan, ngayKetBan, trangThai, timestamp) values (119, 120, STR_TO_DATE('2021-05-08 16:20:00','%Y-%m-%d %H:%i:%s'), 1, CURTIME());
insert into banbe (userYC, userNhan, ngayKetBan, trangThai, timestamp) values (121, 122, STR_TO_DATE('2021-05-09 16:20:00','%Y-%m-%d %H:%i:%s'), 1, CURTIME());


