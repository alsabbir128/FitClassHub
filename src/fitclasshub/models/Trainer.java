package fitclasshub.models;


public class Trainer extends Person {
    private String specialty;

    public Trainer(String name, String contact, String specialty) {
        super(name, contact);
        this.specialty = specialty;
    }

    @Override
    public String getDetails() {
        return "Trainer: " + getName() + " | Specialty: " + specialty;
    }
}
