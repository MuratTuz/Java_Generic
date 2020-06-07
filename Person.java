package generics.Aufgabe1;

import java.time.LocalDate;
import java.time.Period;

public class Person implements Comparable<Person> {
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String address;
	private int zipCode;
	private String city;
	private String profession;
	private String gender;

	public Person(String firstName, String lastName, LocalDate birthDate,
			String address, int zipCode, String city, String profession,
			String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.profession = profession;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getAddress() {
		return address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getProfession() {
		return profession;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		LocalDate today = LocalDate.now();
		Period difference = birthDate.until(today);
		return difference.getYears();
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " " + 
				birthDate + " " + address + " " + 
				zipCode + " " +  city + " " + gender;
	}

	@Override
	public int compareTo(Person other) {
		return lastName.compareTo(other.lastName);
	}
}
