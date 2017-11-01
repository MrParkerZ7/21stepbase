package code.stream.object_stream.SerializableObjectStreamXml;

import java.util.List;

public class CollectionStudent {
    private List<Student> students;

    public CollectionStudent() {
    }

    public CollectionStudent(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "CollectionStudent{" +
                "students=" + students +
                '}';
    }
}
