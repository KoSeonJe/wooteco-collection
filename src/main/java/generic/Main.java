package generic;

public class Main {

    public static void main(String[] args) {
        // 미션 1
        SimpleList<Integer> values = new SimpleArrayList<>();
        values.add(1);
        values.add(2);

        Integer first = values.get(0);
        Integer second = values.get(1);
        System.out.println(first + " " + second);

        // 미션 2
        final String[] arrays = {"first", "second"};
        final SimpleList<String> values2 = SimpleList.<String>fromArrayToArrayList(arrays);
        System.out.println(values2.get(0) + " " + values2.get(1));

        // 미션 3
        final SimpleList<Double> doubleValues = new SimpleArrayList<>(0.5, 0.7);
        final SimpleList<Integer> intValues = new SimpleArrayList<>(1, 2);

        final double doubleTotal = SimpleList.sum(doubleValues); // 1.2
        final double intTotal = SimpleList.sum(intValues);  // 3
        System.out.println(doubleTotal + " " + intTotal);

        // 미션 4
        final SimpleList<Double> doubleValues2 = new SimpleArrayList<Double>(-0.1, 0.5, 0.7);
        final SimpleList<Integer> intValues2 = new SimpleArrayList<Integer>(-10, 1, 2);

        final SimpleList<Double> filteredDoubleValues = SimpleList.filterNegative(doubleValues2);
        final SimpleList<Integer> filteredIntValues = SimpleList.filterNegative(intValues2);
        for (int i = 0; i < filteredDoubleValues.size(); i++) {
            System.out.println(filteredDoubleValues.get(i) + " " + filteredIntValues.get(i));
        }

        // 미션 5
        class Printer { }
        class LaserPrinter extends Printer { }
        //
        //---
        //
        final LaserPrinter laserPrinter = new LaserPrinter();
        //
        final SimpleList<Printer> printers = new SimpleArrayList<Printer>();
        final SimpleList<LaserPrinter> laserPrinters = new SimpleArrayList<LaserPrinter>(laserPrinter);
        //
        SimpleList.copy(laserPrinters, printers);
        //
        System.out.println(printers.get(0) == laserPrinter); // true
    }
}
