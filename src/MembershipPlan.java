public abstract class MembershipPlan implements Billable {
    private String planCode;
    private String clientName;
    private int months;
    private double baseMonthlyFee;
    private boolean autoRenew;

    public MembershipPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.months = months;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
    }

    public String getPlanCode() { return planCode; }
    public String getClientName() { return clientName; }
    public int getMonths() { return months; }
    public double getBaseMonthlyFee() { return baseMonthlyFee; }
    public boolean isAutoRenew() { return autoRenew; }

    public abstract String getPlanType();

    @Override
    public double calculateMonthlyGrossPrice() {
        return calculateMonthlyNetPrice() * 1.23;
    }

    public double calculateTotalNetPrice() {
        return calculateMonthlyNetPrice() * months;
    }

    public final void printSummary() {
        System.out.println("--- Podsumowanie Planu: " + getPlanType() + " ---");
        System.out.println("Kod: " + planCode + ", Klient: " + clientName);
        System.out.println("Miesięczna cena netto: " + calculateMonthlyNetPrice() + " zł");
        System.out.println("Miesięczna cena brutto: " + calculateMonthlyGrossPrice() + " zł");
        System.out.println("Cena całkowita netto (" + months + " mies.): " + calculateTotalNetPrice() + " zł");
    }

    @Override
    public String toString() {
        return "MembershipPlan{" +
                "planCode='" + planCode + '\'' +
                ", clientName='" + clientName + '\'' +
                ", months=" + months +
                ", baseMonthlyFee=" + baseMonthlyFee +
                ", autoRenew=" + autoRenew +
                '}';
    }
}