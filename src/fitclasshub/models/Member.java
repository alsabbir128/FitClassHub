package fitclasshub.models;

public class Member extends Person implements Billable {
    private String membershipType;
    private int months;
    private double monthlyFee;

    public Member(String name, String contact, String membershipType, int months, double monthlyFee) {
        super(name, contact);
        this.membershipType = membershipType;
        this.months = months;
        this.monthlyFee = monthlyFee;
    }

    @Override
    public double calculateMonthlyCost() {
        return months * monthlyFee;
    }

    // Overloading
    public double calculateMonthlyCost(double discountPercent) {
        double total = months * monthlyFee;
        return total - (total * discountPercent / 100);
    }

    @Override
    public String getDetails() {
        return "Member: " + getName() + " | Type: " + membershipType + " | Contact: " + getContact();
    }
}
