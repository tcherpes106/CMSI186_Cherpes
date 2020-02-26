public class Ball
{
    public static final double BALL_RADIUS = 4.45;
    public static final double BALL_WEIGHT = 1.0;
    private double x;
    private double y;
    private double dXdt;
    private double dYdt;
    private boolean ballAtRest;

    public Ball(final double x, final double y, final double dXdt, final double dYdt) {
        this.x = x;
        this.y = y;
        this.dXdt = dXdt;
        this.dYdt = dYdt;
        this.ballAtRest = (Math.sqrt(this.dXdt * this.dXdt + this.dYdt * this.dYdt) < 0.08333333333333333);
    }

    public boolean ballAtRest() {
        return this.ballAtRest;
    }

    public boolean isBallMoving() {
        return !this.ballAtRest;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getXSpeed() {
        return this.dXdt;
    }

    public double getYSpeed() {
        return this.dYdt;
    }


    public void move(double n) {
        if (!this.ballAtRest) {
            while (n >= 1.0) {
                this.x += this.dXdt;
                this.y += this.dYdt;
                this.dXdt -= 0.01 * this.dXdt;
                this.dYdt -= 0.01 * this.dYdt;
                --n;
            }
            if (n > 0.0) {
                this.x += this.dXdt * n;
                this.y += this.dYdt * n;
                this.dXdt -= 0.01 * this.dXdt * n;
                this.dYdt -= 0.01 * this.dYdt * n;
            }
            this.ballAtRest = (Math.sqrt(this.dXdt * this.dXdt + this.dYdt * this.dYdt) < 0.08333333333333333);
        }
    }

    public String toString() {
        if (this.ballAtRest) {
            return "Position is <<<" + report(this.x) + "," + report(this.y) + ">>>\t at rest";
        }
        return "Position is <<<" + report(this.x) + "," + report(this.y) + ">>>\t Velocity is <<<" + report(this.dXdt) + "," + report(this.dYdt) + ">>>";
    }

    static String report(final double d) {
        final String value = String.valueOf(d);
        final int index = value.indexOf(46);
        if (index < value.length() - 4) {
            return value.substring(0, index + 5);
        }
        return value;
    }
}
