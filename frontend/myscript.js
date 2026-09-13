function showCourses(){
    fetch("http://localhost:8081/courses") //API End point
    .then((response) => response.json())
    .then((courses) => {
        const dataTable = document.getElementById("coursetable")

        courses.forEach(course => {
            var row = `<tr>
            <td>${course.CourseId}</td>
            <td>${course.CourseName}</td>
            <td>${course.Trainer}</td>
            <td>${course.DurationinWeeks}</td>
            </tr>`

            dataTable.innerHTML+=row;
        });
    });
}

function showEnrolledStudents(){
    fetch("http://localhost:8081/courses/enrolled") //API End point
    .then((response) => response.json()) //Http response into json object
    .then((students) => {
        const dataTable = document.getElementById("enrolledtable")

        students.forEach(student => {
            var row = `<tr>
            <td>${student.name}</td>
            <td>${student.emailid}</td>
            <td>${student.coursename}</td>
            </tr>`

            dataTable.innerHTML+=row;
        });
    });
}