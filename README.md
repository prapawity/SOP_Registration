# SOP_Registration
Project of `Service-oriented Programming`
    ระบบทะเบียน ที่นักศึกษาและอาจารย์ผู้สอนสามารถตรวจสอบและเข้าถึงข้อมูลต่างๆ เช่น ข้อมูลอัตราการเข้าชั้นเรียนของนศ. หรือ ข้อมูลตารางสอน ข้อมูลจำนวนนศ. โดยสามารถนำข้อมูลเหล่านี้มาแสดงผลเป็น chart และ สามารถคาดเดา behaviorได้
<img src="./asset/IMG_0013.PNG">

# Roles
- Administrator (Hongfah)
- Student
- Teacher 

# Server
```
http://35.198.250.42:80
```
# Teacher Service
```
http://35.198.250.42:80/teacher-service
```
## Section Checker (เช็คชื่อ)
```
/sectionCheck/create
/sectionCheck
/sectionCheck/{id}
/sectionCheck/update/{id}
/sectionCheck/delete/{id}
```
## Student  (ดูรายชื่อนักเรียน)
```
/student/view/{id}
/student
```
## Section  (ดู Section)
```
/sections
/section/{id}
```
## Subject  (ดู Subject)
```
/subject
/subject/view/{id}
```

## Score (CRUD คะแนน)
```

```
# Hongfah Service
http://35.198.250.42:80/servicehongfah
```
 Teacher (CRUD)
 POST /subject/create   สร้าง Subject
 GET  /subject          ดู Subject ทั้งหมด
 GET  /subject/{id}     ดู Subject ตาม Id
 POST /subject/update/{id} แก้ไข Subject ตาม Id
 GET  /subject/delete/{id} ลบ Subject ตาม Id
 _________________________________________________
 Student (CRUD)
 POST /teacher/create   สร้าง Subject
 GET  /teacher          ดู Subject ทั้งหมด
 GET  /teacher/{id}     ดู Subject ตาม Id
 POST /teacher/update/{id} แก้ไข Subject ตาม Id
 GET  /teacher/delete/{id} ลบ Subject ตาม Id
 _________________________________________________
 Subject (CRUD)
 POST /student/create   สร้าง Subject
 GET  /student          ดู Subject ทั้งหมด
 GET  /student/{id}     ดู Subject ตาม Id
 POST /student/update/{id} แก้ไข Subject ตาม Id
 GET  /student/delete/{id} ลบ Subject ตาม Id
 __________________________________________________
```
# Tools
<table border="0">
<tr >
    <td colspan="4"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/1280px-Spring_Framework_Logo_2018.svg.png"></td>
    <td colspan="4"><img src="https://hackernoon.com/hn-images/1*_DOHv30w-0eI-Ysz5U47Yg.png"></td>
    <td colspan="4"><img src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-social.png"></td>
</tr>
</table>
