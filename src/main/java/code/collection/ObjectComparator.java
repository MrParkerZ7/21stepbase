package code.collection;

import java.util.ArrayList;
import java.util.List;

public class ObjectComparator {

    public static void main(String[] args) {
        List<Member> members = new ArrayList<>();
        members.add(new Member(3, "Macro", 345));
        members.add(new Member(1, "Aria", 123));
        members.add(new Member(2, "Bran", 276));
        members.add(new Member(5, "Max", 75));
        members.add(new Member(4, "Saron", 298));

        { // Sort by NO.
            members.sort((Member m1, Member m2) -> {
                return m1.getNo() > m2.getNo() ? 1 : -1;
            });

            for (Member m : members)
                System.out.println(m);
        }

        { // Sort by score.
            members.sort((Member m1, Member m2) -> {
                return m1.getScore() < m2.getScore() ? 1 : -1;
            });

            for (Member m : members)
                System.out.println(m);
        }
    }
}

class Member {
    private int no;
    private String name;
    private int score;

    public Member() {
    }

    public Member(int no, String name, int score) {
        this.no = no;
        this.name = name;
        this.score = score;
    }

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Member{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
