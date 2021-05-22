Tìm danh sách đã kết bạn tới userId:
select f from Friend f where (f.inviter=:userId and f.trangthai=:trangthai) or (f.receiver=:userId and f.trangthai=:trangthai);

Tìm danh sách đã gửi lời kết bạn tới receiver:
select f from Friend f where (f.receiver=:receiver and f.trangthai=:trangthai)

Tìm danh sách mình đã gửi lời mời nhưng chưa phản hồi
select f from Friend f where (f.inviter=:inviter and f.trangthai=:trangthai)

Xác định trạng thái bạn bè giữa 2 người
select f from Friend f where (f.inviter=:user1 and f.receiver=:user2) or (f.inviter=:user2 and f.receiver=:user1)