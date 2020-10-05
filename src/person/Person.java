package person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Person {

	// Kişi listesinin baseline ını tutmak için.
	ArrayList<String> mainList = new ArrayList<String>();
	// Kişi listesini kıyaslamak için
	ArrayList<String> people = new ArrayList<String>();
	// Bir ad birden fazla geçiyor ise bu listede tutuluyor.
	ArrayList<String> moreThanOne = new ArrayList<String>();
	// Bir adın kaç defa geçtiğini tutmak için Key value değerlerini hashmapte
	// saklıyorum.
	HashMap<String, Integer> personcount = new HashMap<>();
	// sayaç
	int count = 1;

	// Ana fonksiyon
	public void run() {
		// Kulalnıcı adlarını alıyorum
		Scanner scan = new Scanner(System.in);
		System.out.println("Adınız nedir ?");
		for (int i = 0; i < 100; i++) {
			// Kıyaslamak için listeye atıyorum
			people.add(scan.nextLine());
		}
		// Base halini de saklıyorum. Farklı bir işlem olması durumu için.
		mainList = people;
		// Liste içindeki elemanları kendinden sonraki elemanlar ile kıyaslıyorum.
		// Etiketlenmiş elemanlar için kıyaslama yapma ihtiyacı da olmayacaktır.
		for (int i = 0; i < people.size(); i++) {
			for (int j = i + 1; j < people.size(); j++) {
				if (people.get(i).equalsIgnoreCase(people.get(j)) && !people.get(i).equals("checked")) {
					count++;
					// Aynı ismi tekrar kıyaslamamak için etiket koydum.
					people.set(j, "checked");
				}
			}
			// İsim ve kaç tane olduğu bilgisini hashmape atıyorum
			if (!people.get(i).equals("checked")) {
				personcount.put(people.get(i), count);
				if (count > 1) {
					// Birden fazla olanları bir listeye atıyorum.
					moreThanOne.add(people.get(i));
				}
			}
			// bir sonraki isim için sayacı başa alıyorum
			count = 1;
		}
		// Bir isimden kaç defa geçtiğini yazdırıyorum
		for (String i : personcount.keySet()) {
			System.out.println(i + " ismi " + personcount.get(i) + " defa geçiyor ");
		}
		// Birden fazla ismin hangileri olduğunu yazdırıyorum
		System.out.println("1'den fazla olan isimler");
		for (String string : moreThanOne) {
			System.out.println(string);

		}

	}

}