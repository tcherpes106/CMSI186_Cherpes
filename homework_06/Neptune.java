public class Neptune {

	public static final BrobInt LIGHTSPEED     = new BrobInt("299792458");
	public static final BrobInt MAX_SPEED      = new BrobInt("149896528");
	public static final BrobInt EARTH_ESCAPE   = new BrobInt("11186");
	public static final BrobInt NEPTUNE_ESCAPE = new BrobInt("23500");
	public static final BrobInt DISTANCE       = new BrobInt("4400000000000");

	public int     hours    = 0;
	public int     minutes  = 0;
	public int     seconds  = 0;
	public BrobInt distance = BrobInt.ZERO;
	public BrobInt speed    = EARTH_ESCAPE;

	public BrobInt accelVal;
	public BrobInt decelTimeNeptune;
	public BrobInt decelDistNeptune;
	public BrobInt decelTimeEarth;
	public BrobInt decelDistEarth;

	public Neptune (BrobInt accelVal) {

		if (!accelVal.positive) {
			throw new IllegalArgumentException("Acceleration cannot be negative");
		}
		if (accelVal.compareTo(MAX_SPEED) == 1) {
			throw new IllegalAccessError("Acceleration cannot excped maximum speed.");
		}
		this.accelVal   = accelVal;
		this.decelTimeEarth = (MAX_SPEED.subtration(EARTH_ESCAPE)).divide(accelVal);
		this.decelDistEarth = (
			MAX_SPEED.multiply(decelTimeEarth).subtration(
				accelVal.multiply(
					decelTimeEarth.multiply(decelTimeEarth).divideByInt(2)
		)	)	);
		this.decelTimeNeptune = (MAX_SPEED.subtration(NEPTUNE_ESCAPE)).divide(accelVal);
		this.decelDistNeptune = (
			MAX_SPEED.multiply(decelTimeNeptune).subtration(
				accelVal.multiply(
					decelTimeNeptune.multiply(decelTimeNeptune).divideByInt(2)
		)	)	);
	}

	public void tic() {
		seconds++;
		if (seconds >= 60) {seconds -= 60; minutes++;}
		if (minutes >= 60) {minutes -= 60; hours++;}
	}

	public String getTime() {
		String result =
			Integer.toString(hours) + " hours, " +
			Integer.toString(minutes) + " minutes, and " +
			Integer.toString(seconds) + " seconds";
		return result;
	}

	public void speedUp() {
		while (speed.compareTo(MAX_SPEED) == -1) {
			tic();
			speed = speed.addition(accelVal);
			distance = distance.addition(speed);
		}
		speed = MAX_SPEED;
	}

	public void toThreshold(BrobInt threshold) {

		BrobInt distanceRemaining = DISTANCE.subtration(distance).subtration(threshold);
		if (!distanceRemaining.positive) {
			throw new IllegalCallerException("Missed Neptune");
		}
		while (distanceRemaining.positive && !distanceRemaining.equals(BrobInt.ZERO)) {
			tic();
			distance = distance.addition(speed);
			distanceRemaining = distanceRemaining.subtration(speed);
		}
	}


	public void decel (BrobInt threshold) {
		while (speed.compareTo(threshold) == 1) {
			tic();
			speed = speed.subtration(accelVal);
			distance = distance.addition(speed);
		}
		speed = threshold;
	}

	public static void main (String[] args) {
		Neptune ship = null;
		try {
		ship = new Neptune( new BrobInt(args[0]));
		} catch (IllegalArgumentException iae) {
			System.out.println("Accelleration must be a whole positive number.");
			return;
		} catch (IllegalAccessError iae) {
			System.out.println("Please enter an acelleration value smaller than maximum speed.");
			return;
		}

			System.out.println("Take Off Started!");
			System.out.println("Course to Neptune is being calculated, please remain seated!");

		try {
			ship.speedUp();
			System.out.println("__________________________________");
			System.out.println("Speed is increasing. Speed of light will be reached shortly.");
			System.out.println("We have covered a distance of " + ship.distance.toString() + " meters.");
			System.out.println("We have been flying for  " + ship.getTime() + ".");
			ship.toThreshold(ship.decelDistNeptune);
      System.out.println("__________________________________");
			System.out.println("Deceleration begun.");
      System.out.println("We have covered a distance of " + ship.distance.toString() + " meters.");
			System.out.println("We have been flying for  " + ship.getTime() + ".");
			ship.decel(NEPTUNE_ESCAPE);

			System.out.println("__________________________________");
			System.out.println("Neptune has been reached!");
			System.out.println("__________________________________");

			System.out.println("Trip back to Earth started!");
      System.out.println("We have covered a distance of " + ship.distance.toString() + " meters.");
			System.out.println("We have been flying for  " + ship.getTime() + ".");
			ship.distance = BrobInt.ZERO;
			ship.speedUp();
			System.out.println("__________________________________");
			System.out.println("Traveling at speed of light");
      System.out.println("We have covered a distance of " + ship.distance.toString() + " meters.");
			System.out.println("We have been flying for  " + ship.getTime() + ".");
			ship.toThreshold(ship.decelDistEarth);
			System.out.println("__________________________________");
			System.out.println("    We're about to make our dissent back to Earth! What a ride it's been.");
      System.out.println("We have covered a distance of " + ship.distance.toString() + " meters.");
			System.out.println("We have been flying for  " + ship.getTime() + ".");
			ship.decel(NEPTUNE_ESCAPE);
		} catch (IllegalCallerException ice) {
			System.out.println("Trip failed!");
			return;
		}

		System.out.println("__________________________________");
		System.out.println("Landing succesful!");
		System.out.println("__________________________________");
		System.out.println("The total round trip time was " + ship.getTime() + ".);
	}
}
