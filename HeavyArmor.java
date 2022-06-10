public class HeavyArmor extends Armor {

    public HeavyArmor(String name, String type, double weight, double value) {
        super(name, type, weight, value);
    }

    @Override
    public void itemInfo() {
        print.printCyan("\nName: " +getName());
        print.printCyan("Weight: " + getWeight());
        print.printCyan("Value: " + getValue());
        print.printCyan("Resistance: " + getResistance());
    }
}