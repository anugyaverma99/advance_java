package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "passport_table")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passport_seq_gen")
    @SequenceGenerator(
            name = "passport_seq_gen",
            sequenceName = "passport_sequence",
            allocationSize = 1,
            initialValue = 100
    )
    private int passportId;

    private String passportNumber;

    private String country;
    @OneToOne(mappedBy="passport")
    private Person person;

   
    public Passport() {
    }

 
    public Passport(String passportNumber, String country) {
        this.passportNumber = passportNumber;
        this.country = country;
    }



    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}
    
}
