import java.util.Objects;

public class App {
    /*
        Przygotuj strukturę danych, która przechowuje współrzędne punktu
        w układzie współrzędnych. Aplikacja umożliwia porównywanie obiektów
        tej struktury danych. Kryterium porównywania jest odległość punktu
        od początku układu współrzędnych.
    */

    record Point(double x, double  y) {
        public double getZeroDistance() {
            return Math.sqrt(x * x + y * y);
        }

        public boolean lt(Point p) {
            return getZeroDistance() < p.getZeroDistance();
        }

        public boolean le(Point p) {
            return getZeroDistance() <= p.getZeroDistance();
        }

        public boolean gt(Point p) {
            return getZeroDistance() > p.getZeroDistance();
        }

        public boolean ge(Point p) {
            return getZeroDistance() >= p.getZeroDistance();
        }

        public int compare(Point p) {
            return Double.compare(getZeroDistance(), p.getZeroDistance());
        }

        public static int compare(Point p1, Point p2) {
            return Double.compare(p1.getZeroDistance(), p2.getZeroDistance());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.getZeroDistance(), getZeroDistance()) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getZeroDistance());
        }
    }

    public static void main(String[] args) {
        var p1 = new Point(1, 1);
        var p2 = new Point(1, 1);
        var p3 = new Point(2, 2);

        System.out.println(p1.equals(p2));
        System.out.println(!p1.equals(p3));
        System.out.println(p1.lt(p3));
        System.out.println(p1.le(p2));
        System.out.println(p3.gt(p1));
        System.out.println(p2.ge(p1));

        System.out.println(p1.compare(p2));
        System.out.println(p1.compare(p3));
        System.out.println(p3.compare(p1));

        System.out.println(Point.compare(p1, p2));
        System.out.println(Point.compare(p1, p3));
        System.out.println(Point.compare(p3, p1));

    }
}
