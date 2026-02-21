package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_id_cards")
public class Student_ID_Card {

    @Id
    private int id;

    private int cardNumber;

    @OneToOne(mappedBy = "idCard")
    private Student_class student;

    public Student_ID_Card() {
    }

    public Student_ID_Card(int id, int cardNumber) {
        this.id = id;
        this.cardNumber = cardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Student_class getStudent() {
        return student;
    }

    public void setStudent(Student_class student) {
        this.student = student;
    }
}