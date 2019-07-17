# Student_information_management_system

আমি এই প্রজেক্টী মুলত স্প্রিং ফ্রেমওয়ার্ক ব্যাবহার করে ইমপ্লিমেন্ট করেছি। এখানে আমি ডাটাবেজ হিসাবে MYSql ডাটাবেজ ব্যাবহার করেছি। MySQL এর CRUD ফাংশন গুলি ইমপ্লিমেন্ট করেছি। 
spring ফ্রেমওয়ার্কের Dependency injection এই ফিচারটির দিকে বেশি নজর দিয়েছি। সাথে বিভিন্ন অ্যানোটেশন ব্যাবহার করেছি কোড simplicity এর জন্য। 
আমার ডাটাবেজের নামঃ student_information_management_system
টেবিলের নামঃ student_info
ইউজারঃ root
পাসওয়ার্ডঃ 
টেবিল ক্রিয়াশনের কুয়েরিঃ CREATE TABLE student_info (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) NOT NULL,
dept VARCHAR(30) NOT NULL,
email VARCHAR(50) not null,
bloodGroup VARCHAR(50) not null
)
