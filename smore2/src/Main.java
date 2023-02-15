//problem 1

import java.util.ArrayList;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) {
	ArrayList<Pets> pets = new ArrayList<Pets>();
	pets.add(new Pets("Zack", "Oct 10, 2020", "6478895664", "Dog", "Bob"));
	pets.add(new Pets("Zack", "Oct 10, 2020", "6478895664", "Cat", "Bob"));
	pets.add(new Pets("Bill", "Oct 10, 2020", "6478895664", "Cat", "Bob"));

	for(int i = 0; i < pets.size(); i++){
		System.out.println(pets.get(i).getName());
	}
	pets.sort(null);

	System.out.println("  ");
	for(int i = 0; i < pets.size(); i++){
		System.out.println(pets.get(i).getName());
	}

}

}
