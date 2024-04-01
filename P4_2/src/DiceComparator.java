import java.util.Comparator;

class DiceComparator implements Comparator<Dice> {
    @Override
    public int compare(Dice d1, Dice d2) {
        return Integer.compare(d1.getValue(), d2.getValue());
    }
}
