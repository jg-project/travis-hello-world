package jgproject.travis.lecture_one.dto;

public final class SquareRootResult {
    private final double x1;
    private final double x2;

    public SquareRootResult(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SquareRootResult that = (SquareRootResult) o;

        if (Double.compare(that.x1, x1) != 0) return false;
        return Double.compare(that.x2, x2) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x1);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(x2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "SquareRootResult{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                '}';
    }
}
