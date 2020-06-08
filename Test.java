package generics.Aufgabe1;

import java.time.LocalDate;
import java.util.*;

import static java.util.Optional.*;

public class Test<T> {
	private static final List<Integer> INTEGER_LIST = Arrays.asList(1, -3, 22, 7, 43, 212, -87, 12, 6, 99, -65, 2162, 0, -1, -3, 7, 12);
	private static final int MEDIAN_INTEGER = 7;
	private static final List<Integer> LARGEST_3_INTEGERS = Arrays.asList(2162, 212, 99);
	private static final List<Integer> SMALLEST_3_INTEGERS = Arrays.asList(-87, -65, -3);

	private static final List<Person> PEOPLE_LIST = Arrays.asList(
			new Person("Klaus", "Adam", createDate(1978, 4, 13),
					"Oberseestrasse 14", 8640, "Rapperswil", "Student", "male"),
			new Person("Clara", "M?ller", createDate(1978, 4, 13),
					"Oberseestrasse 14", 8640, "Rapperswil", "Student", "female"),
			new Person("Hans", "Meier", createDate(1980, 1, 2),
					"Waldweg 2", 8640, "Rapperswil", "Student", "male"),
			new Person("Petra", "Schneider", createDate(1970, 8, 8),
					"Bahnhofstrasse 1", 8001, "Z?rich", "Manager", "female"),
			new Person("Klaus", "Schnell", createDate(1982, 12, 10),
					"R?tistrasse", 8630, "R?ti", "Engineer", "male"),
			new Person("Peter", "Winter", createDate(1965, 3, 3),
					"Hinterweg 12", 5000, "Aarau", "Carpenter", "male"),
			new Person("Sandra", "Vogt", createDate(1972, 11, 30),
					"Altstadtweg 8", 8001, "Z?rich", "Banker", "female"),
			new Person("Markus", "Marxer", createDate(1976, 2, 5),
					"Hauptstrasse 7", 6002, "Luzern", "Baker", "male"),
			new Person("Anna", "Widmer", createDate(1980, 7, 7),
					"Albisstrasse", 8004, "Z?rich", "Teacher", "female"),
			new Person("Hans", "Steiner", createDate(1976, 10, 10),
					"Seeufer 232", 8640, "Rapperswil", "Student", "male"),
			new Person("Vreni", "Affolter", createDate(1981, 4, 30),
					"Altstadtweg 17", 4000, "Basel", "Student", "female"),
			new Person("Karl", "Widmer", createDate(1977, 7, 31),
					"Zentralstrasse 87", 8640, "Rapperswil", "Engineer", "male"),
			new Person("Franz", "Eberhard", createDate(1978, 1, 1),
					"Hauptstrasse 10", 8640, "Rapperswil", "Student", "male"),
			new Person("Hedi", "Z?rcher", createDate(1950, 3, 22),
					"Bergstrasse 98", 8001, "Z?rich", "Retired", "female"),
			new Person("Monika", "Wehrli", createDate(1967, 9, 17),
					"Stadtweg 1", 5000, "Aarau", "Entrepreneur", "female"),
			new Person("Hans", "Beeler", createDate(1982, 6, 11),
					"Hauptstrasse 121", 8630, "R?ti", "Student", "male"));
	
	private static final Person MEDIAN_PERSON = PEOPLE_LIST.get(4);
	private static final Collection<Person> LARGEST_2_PEOPLE = Arrays.asList(PEOPLE_LIST.get(13), PEOPLE_LIST.get(5));
	private static final Collection<Person> SMALLEST_2_PEOPLE = Arrays.asList(PEOPLE_LIST.get(0), PEOPLE_LIST.get(10)); 
	
	private static LocalDate createDate(int year, int month, int dayOfMonth) {
		return LocalDate.of(year, month, dayOfMonth);
	}
	
	public static void main(String[] args) {
		// TODO: Test your generic collection methods using the test data above

		CollectionFunctions collectionFunctions = new CollectionFunctions();
		collectionFunctions.print(
				collectionFunctions.mergeToList(LARGEST_2_PEOPLE, SMALLEST_2_PEOPLE));

		System.out.println("*****************");
		collectionFunctions.print(
				collectionFunctions.mergeToSet(LARGEST_2_PEOPLE, LARGEST_2_PEOPLE));

		System.out.println("*****************");
		Collection<Person> newColl = new ArrayList<>();
		collectionFunctions.merge.apply(SMALLEST_2_PEOPLE, PEOPLE_LIST, newColl);
		collectionFunctions.print(newColl);

		System.out.println("*****************");
		collectionFunctions.print(
				Collections.singletonList(ofNullable(collectionFunctions.largest(INTEGER_LIST, 3))
						.get().orElse(Collections.singletonList("Invalid Process"))));

		System.out.println("*****************");
		collectionFunctions.print(
				Collections.singletonList(ofNullable(collectionFunctions.smallest(INTEGER_LIST, 5))
						.get().orElse(Collections.singletonList("Invalid Process"))));

		System.out.println("#####################");
		try {
			collectionFunctions.print(
					collectionFunctions.merge(LARGEST_2_PEOPLE,LARGEST_2_PEOPLE));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}

		System.out.println("----------------------");
		collectionFunctions.print(
				collectionFunctions.merge2(LARGEST_2_PEOPLE,LARGEST_2_PEOPLE));

		System.out.println("*****************");
		ReverseMap<Integer,String> reverseMap = new ReverseMap<>();
		reverseMap.put(123, "Murat");
		reverseMap.put(234, "Cemil");
		reverseMap.put(345, "Mehmet");
		reverseMap.put(456, "Ferdi");


		System.out.println(reverseMap.getLeft("Cemil"));
		System.out.println(reverseMap.getRight(456));
		collectionFunctions.print(reverseMap.leftValues());
		collectionFunctions.print(reverseMap.rightValues());
		System.out.println("Size : "+reverseMap.size());
		reverseMap.clear();
		collectionFunctions.print(reverseMap.leftValues());
		collectionFunctions.print(reverseMap.rightValues());

	}
}
