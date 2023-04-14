function Student(student_name,student_grade,student_sex){
    this.name=student_name
    this.grade=student_grade
    this.sex=student_sex
   }
   let student1=new Student("John",8,"M")
   let student2=new Student("Sarah",12,"F")
   let student3=new Student("Bob",19,"M")
   let student4=new Student("Johnny",2,"M")
   let student5=new Student("Ethan",4,"M")
   let student6=new Student("Paula",18,"F")
   let student7=new Student("Donald",5,"M")
   let student8=new Student("Jennifer",13,"F")
   let student9=new Student("Courtny",15,"F")
   let student10=new Student("Jane",9,"F")
   let grades=[student1,student2,student3,student4,student5,student6,student7,student8,student9,student10]
   function print_list_std(grade_list){
     for (std of grade_list)
       console.log(`     ${std.name} - ${std.grade} - ${std.sex}`)
   }
   function print_std(std){
    console.log(`     ${std.name} - ${std.grade} - ${std.sex}`)
   }
//    1
   function get_grade_average(grade_list){
    return grade_list.reduce((sum,std) => sum+std.grade,0)/grade_list.length
   }
//    2,3
   function get_grade_average_by_sex(grade_list,sex){
    let grade_by_sex= grade_list.filter(std =>std.sex.toLowerCase()===sex.toLowerCase())
    return get_grade_average(grade_by_sex)
   }

//    4,5
// function get_best_grade_by_sex(grade_list,sex){
//     let grade_by_sex = grade_list
//     .filter(student => student.sex.toLowerCase() === sex.toLowerCase())
//     .map(student => student.grade)
//     return grade_by_sex.find(std=>std.grade=Math.max(...grade_by_sex))
// }
function get_best_grade_by_sex(grade_list, sex) {
    let grade_by_sex = grade_list
    .filter(student => student.sex.toLowerCase() === sex.toLowerCase())
    .map(student => student.grade);
    return grade_list.find(student => student.grade === Math.max(...grade_by_sex));
  }
//    6,7
function get_worst_grade_by_sex(grade_list,sex){
    let grade_by_sex = grade_list
    .filter(student => student.sex.toLowerCase() === sex.toLowerCase())
    .map(student => student.grade);
    return grade_list.find(student => student.grade === Math.min(...grade_by_sex));
}
// 8
function get_best_grade(grade_list){
    return grade_list.find(student => student.grade === Math.max(...grade_list.map(std=>std.grade)))
}
// 9
function get_worst_grade(grade_list){
    return grade_list.find(student => student.grade === Math.min(...grade_list.map(std=>std.grade)))
}
// 10
function get_female_student(grade_list){
    return grade_list.filter(std=>std.sex==="F")
}
// 11
function sort_by_alphabet(grade_list){
    return grade_list.sort((a, b) => a.name.toLowerCase() > b.name.toLowerCase() ? 1 : -1);
}
// 12
function sort_by_grade_DESC(grade_list){
    return grade_list.sort((a,b)=>b.grade-a.grade)
}
// 13
function get_female_name_by_first_char(grade_list){
    return grade_list.filter(std=>std.sex.toUpperCase()==="F").filter(std=>std.name.charAt(0)==="J")
}
// 14
function get_top_5(grade_list){
    return sort_by_grade_DESC(grade_list).splice(0,5)
}
console.log("1-Điểm trung bình của cả lớp")
console.log(get_grade_average(grades))
console.log("2-Điểm trung bình của nam trong lớp")
console.log(get_grade_average_by_sex(grades,"m"))
console.log("3-Điểm trung bình của nữ trong lớp")
console.log(get_grade_average_by_sex(grades,"f"))
console.log("4-Học viên nam có điểm cao nhất")
print_std(get_best_grade_by_sex(grades,"m"))
console.log("5-Học viên nữ có điểm cao nhất")
print_std(get_best_grade_by_sex(grades,"f"))
console.log("6-Học viên nam có điểm thấp nhất")
print_std(get_worst_grade_by_sex(grades,"m"))
console.log("7.Học viên nữ có điểm thấp nhất")
print_std(get_worst_grade_by_sex(grades,"f"))
console.log("8-Học viên có điểm cao nhất lớp")
print_std(get_best_grade(grades))
console.log("9-Học viên có điểm thấp nhất lớp")
print_std(get_worst_grade(grades))
console.log("10-Danh sách học viên nữ trong lớp")
print_list_std(get_female_student(grades))
console.log("11-Sắp xếp học viên theo bảng chữ cái")
print_list_std(sort_by_alphabet(grades))
console.log("12-Danh sách học viên sắp xếp theo điểm giảm dần")
print_list_std(sort_by_grade_DESC(grades))
console.log("13-Danh sách học viên nữ có tên bắt đầu bằng chữ J")
print_list_std(get_female_name_by_first_char(grades))
console.log("14-Top 5 học sinh có điểm cao nhất lớp")
print_list_std(get_top_5(grades))