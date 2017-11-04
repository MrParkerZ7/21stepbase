package code.connection.hibernate.h_00_basic;

import javax.persistence.*;

@Entity
@Table(name = "Student_Detail") // Using for define different name on database.
public class Student {

    @Id
    private int no;

    @Column(name = "nick_name") // Using for define name column in database.
    private String name;

    @Column(name = "skin_heart")
    private String color;

    @Transient // Using for deprecate column.
    private int age;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}
