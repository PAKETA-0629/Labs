class Human {
    name;
    age;
    sex;
    constructor(name, age, sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    sleep() {
        console.log("zzzz");
    }

    describe() {
        console.log(this.name + " " + this.age + " " + this.sex);
    }
}

class Student extends Human {
    course;
    groupName;

    constructor(name, age, sex, course, groupName) {
        super(name, age, sex);
        this.course = course;
        this.groupName = groupName;
    }

    goToUniversity() {
        console.log("Йду в палітєх");
    }
}

class Teacher extends Human {

    degree;
    experience;
    subjectName;
    constructor(name, age, sex, degree, experience, subjectName) {
        super(name, age, sex);
        this.degree = degree;
        this.experience = experience;
        this.subjectName = subjectName;
    }
    describe() {
        console.log(this.name + " " + this.age + " " + this.sex + " " + this.degree + " " + this.experience + " " + this.subjectName)
    }
}

let human = new Human("Kyrylo", 19, "Male");
human.describe();
human.sleep();

let student = new Student("Kyrylo", 19, "Male", 3, "Computer Science");
student.describe();
student.sleep();
student.goToUniversity();

let teacher = new Teacher("Petro", 30, "Male", "Master", 5, "Java");
teacher.describe();
teacher.sleep();