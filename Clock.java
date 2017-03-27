public class Clock {

    // private instance data;
	private int hours;
	private int minutes;
    private double seconds;
    private double timeslice;
    private double time;


	// got help from t.a. and classmates setting up constructor
	public Clock ( int hours, int minutes, double seconds, double timeslice, double time) {

		if ( hours < 0 | hours > 12 | minutes < 0 | minutes > 59 | seconds < 0 | seconds > 59.9 | timeslice < 0 | timeslice > 1800.0) {
			throw new IllegalArgumentException();

		} else {
			this.hours = hours;
			this.minutes = minutes;
            this.seconds = seconds;
            this.timeslice = timeslice;
            this.time = time;
		}
	}

    //clock running method
    public void tick() {
        this.time = this.time + this.timeslice;
    }

    //return time passed method
    //on the assignment it said to make getHour() but seconds is more practical for accuracy
    public double getSeconds() {
       return this.time;
    }

    public String toString() {
        double hours = this.time / 3600;
        double remainder = this.time % 3600;
        double minutes = remainder / 60;
        double seconds = remainder % 60;

        //The output should consist of just a bunch of lines with one time per line.
        //All times should be expressed using a military-type format
        return (int)hours + ":" + (int)minutes + ":"  + (int)seconds;

    }

}
