# Java23-WebServices_GritAcademyAPI-Oliver-Schuller
## Endpoints
### Courses
* **`/courses`** - Shows all courses  
* **`/courses/id/{id}`** - Shows information about course with specified id  
* **`/courses/name/{name}`** - Shows information about courses with specified name  
* **`/courses/name-contains/{keyword}`** - Shows all courses whose name contains keyword  
* **`/courses/description-contains/{keyword}`** - Shows all courses whose description contains keyword  

### Students
* **`/students`** - Shows all students  
* **`/students/id/{id}`** - Shows information about student with specified id  
* **`/students/name?fname={fname}&lname={lname}`** - Shows information about student with name, can use both parameters or just one of them  
* **`/students/town/{town}`** - Shows students in town

### Associations
* **`/associations`** - Shows all associations between students and courses

### Create
 * **`/create/course?name={name}&description={description}`** - Create course with specified name and description. Name is required, description is not  
 * **`/create/student?fname={fname}&lname={lname}&town={town}`** - Create student with specified fname, lname and town. Fname and lname is required, town is not
 * **`/associations/create?student_id={student_id}&course_id={course_id}`** - Creates association between student and course. Both parameters are required

 ### Delete
 * **`/delete/course/{id}`** - Delete course with id  
 * **`/delete/student/{id}`** - Delete student with id
 * **`/associations/delete/{associationId}`** - Deletes association with given id
