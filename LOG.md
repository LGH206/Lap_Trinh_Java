#NOTE:
```text
-mọi người note lại toàn bộ ý tưởng, thay đổi, hay ý tưởng vào LOG
-cập nhật đầy đủ ngày/tháng - mọi hành động trên git và Pj, kể cả xóa file, hay code
```

##UPDATE: 8-/6/26 -- GIA HUY
```text
Set up maven Pj -- SQL Server
-- cập nhật folder
├── config 
├── controller 
├── dto 
├── entity 
├── exception 
├── factory 
├── repository 
├── service 
	├── interfaces 
	└── impl 
├── strategy
└── enums

--
```
### Ý tưởng phase 1
```text
-- sử dụng User làm class cha để các đối tượng (amdin/ jocky/...) kế thừa sử dụng

Theo yêu cầu đề tài, Admin có chức năng phân quyền. 
-- phân quyền được hiểu là:
- Gán loại tài khoản cho người dùng
- Quản lý quyền theo role có sẵn

Admin có quyền:
- Gán role
- Thay đổi role
- Khóa tài khoản

Không triển khai:
- Permission
- UserRole
- RolePermission

-- tạo pack enums -- mục đích xây dựng các class status
```
