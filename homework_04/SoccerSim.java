public class SoccerSim
{
    public static void main(final String[] array) {
        final Ball[] array2 = new Ball[array.length / 4];
        final double processArgs = processArgs(array, array2);
        final Timer timer = new Timer(0, 0, 0.0, processArgs);

        printReport("INITIAL REPORT at " + timer.toString(), array2);

        while (contactNotPossible(array2) && someBallisBallMoving(array2)) {
            timer.tick();
            for (int i = 0; i < array2.length; ++i) {
                array2[i].move(processArgs);
            }
            printReport("PROGRESS REPORT AT " + timer.toString(), array2);
        }
        if (contactPossible(array2)) {
            System.out.println("CONTACT AT " + contactLocation(array2));
        }
        else {
            System.out.println("NO COLLISION IS POSSIBLE");
        }
    }

    static boolean contactPossible(final Ball[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                final double n = (array[i].getX() - array[j].getX()) * 12.0;
                final double n2 = (array[i].getY() - array[j].getY()) * 12.0;
                if (n * n + n2 * n2 < 79.21000000000001) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean contactNotPossible(final Ball[] array) {
        return !contactPossible(array);
    }

    static String contactLocation(final Ball[] array) {
        String string = "";
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                final double n = (array[i].getX() - array[j].getX()) * 12.0;
                final double n2 = (array[i].getY() - array[j].getY()) * 12.0;
                if (n * n + n2 * n2 < 79.21000000000001) {
                    string = string + "ball " + i + " & " + j + "; ";
                }
            }
        }
        return string;
    }

    static boolean someBallisBallMoving(final Ball[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i].isBallMoving()) {
                return true;
            }
        }
        return false;
    }

    static double processArgs(final String[] array, final Ball[] array2) {
        if (array.length < 4 || array.length % 4 > 1) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < array.length / 4; ++i) {
            try {
                array2[i] = new Ball(Double.parseDouble(array[4 * i]), Double.parseDouble(array[4 * i + 1]), Double.parseDouble(array[4 * i + 2]), Double.parseDouble(array[4 * i + 3]));
            }
            catch (Exception exception1) {
                throw new IllegalArgumentException();
            }
        }
        double double1 = 1.0;
        if (array.length % 4 == 1) {
            try {
                double1 = Double.parseDouble(array[array.length - 1]);
            }
            catch (Exception exception2) {
                throw new IllegalArgumentException();
            }
        }
        if (double1 <= 0.0) {
            throw new IllegalArgumentException();
        }
        return double1;
    }

    static void printReport(final String x, final Ball[] array) {
        System.out.println(x);
        for (int i = 0; i < array.length; ++i) {
            System.out.println(i + ":\t" + array[i].toString());
        }
        System.out.println();
    }
}
