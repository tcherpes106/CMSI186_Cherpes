public class Timer
{
    private double timeSlice;
    private int hours;
    private int minutes;
    private double seconds;

    public Timer() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0.0;
        this.timeSlice = 1.0;
    }

    public String toString() {
        return this.hours + ":" + this.minutes + ":" + this.seconds;
    }

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public double getSeconds() {
        return this.seconds;
    }

    public Timer(final int hours, final int minutes, final double seconds, final double timeSlice) {
        if (hours < 0 | minutes < 0 | minutes >= 60 | seconds < 0.0 | seconds >= 60.0 | timeSlice <= 0.0 | timeSlice > 1800.0) {
            throw new IllegalArgumentException();
        }
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.timeSlice = timeSlice;
    }

    public void tick() {
        this.seconds += this.timeSlice;
        while (this.seconds >= 60.0) {
            ++this.minutes;
            this.seconds -= 60.0;
        }
        while (this.minutes >= 60.0) {
            ++this.hours;
            this.minutes -= 60;
        }
    }


}
