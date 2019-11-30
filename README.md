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
http://35.198.250.42:80/teacher-service
```
 SectionCheck (CRUD)
 POST /sectionCheck/create   
 GET  /sectionCheck
 GET  /sectionCheck/{id}
 POST /sectionCheck/update/{id}
 GET  /sectionCheck/delete/{id}
 _________________________________________________
 Score (CRUD)
 POST /scores/create
 GET  /scores
 GET  /scores/{id}
 POST /scores/update/{id}
 GET  /scores/delete/{id}
 _________________________________________________
 Subject
 GET  /subject/view/{id}
 GET  /subject
 __________________________________________________
 Section
 GET /sections
 GET /section/{id}
 __________________________________________________
 Student
 GET /student/view/{id}
 GET /student
 __________________________________________________
```



# Student Service
```
http://35.198.250.42:80/servicestudent
```
## Student  (ดู Student)
```
/student/view/{id}
```
## SectionCheck Status (ดูสถานะการเข้าเรียน)
```
/sectioncheck/{id}
```
## Subject  (ดู Subject&section)
```
/subject/view
```
## Score (ดู Student's score)
```
/score/view/{id}
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

# Members : Group 7
|  |ชื่อ|นามสกุล|GitHub Username|รหัสนักศึกษา|
|:-:|--|------|---------------|---------|
|![]()|กวีพล|ขุนศรี|[@Suerpmalonz](https://github.com/Supermalonz)|60070003|
|![]()|ฐิติพัฒน์|อริยรัตนา|[@prapawity](https://github.com/thitipat021)|60070021|
|![]()|นิติพล|สิริวัฒนวโรดม|[@wewarwo](https://github.com/wewarwo)|60070042|
|![]()|ปภาวิทย์|พัทธสิริวิโชติ|[@prapawity](https://github.com/prapawity)|60070045|