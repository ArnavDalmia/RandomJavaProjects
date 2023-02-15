import java.util.ArrayList;
public class Pets implements Comparable<Pets> {
    
private String name;
private String birth;
private String ownerName;
private String number;
private String species;
private ArrayList<String> possileSpecies = new ArrayList<String>();

public void speciesFill(){
    possileSpecies.add("Dog");
    possileSpecies.add("Cat");
    possileSpecies.add("Cow");
    possileSpecies.add("Bird");
    possileSpecies.add("Dog");
}

public int compareTo(Pets other) {
    // Convert to lowercase for comparison as Zbc will come before abc if we don't!
    if(this.getName().toLowerCase().equals(other.getName().toLowerCase())) {
        if (this.getSpecies().toLowerCase().equals(other.getSpecies().toLowerCase()))
            return 0; 
        else if (this.getSpecies().toLowerCase().compareTo(other.getSpecies().toLowerCase()) > 0)
            return 1; 
        else
            return -1; 
    }
    else if (this.getName().toLowerCase().compareTo(other.getName().toLowerCase()) > 0){ 
            return 1;
    }  
    
    else{
        return -1; 
    }
}
public void setName(String name){
    this.name = name;
}
public void setBirth(String birth){
    this.birth = birth;
}

public void setOwnerName(String ownerName){
    this.ownerName = ownerName;
}

public void setNumber(String number){
    this.number = number;
}

public void setSpecies(String species){
    this.species = species;
}

public Pets(){
    setName("");
    setBirth("");
    setNumber("");
    setSpecies("");
    setOwnerName("");
}
public Pets(String name, String birth, String number,  String species, String ownerName){
    setName(name);
    setBirth(birth);
    setNumber(number);
    setSpecies(species);
    setOwnerName(ownerName);
}

public String getName(){
    return name;
}
public String getSpecies(){
    return species;
}

}
