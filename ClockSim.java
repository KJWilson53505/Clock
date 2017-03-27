public class ClockSim {
    //NOTES FROM CLASS
    //Initialize system variables
        /*Initial Report*/
    //Loop while simulation not finished
        /*Advance system clock +1 time slice*/
        /*Update system varialbe accordingly*/
        /*( optional) Generate progress report*/
    //Generate final report

    public static double toAngle( double time ) {

        int hours = ( int ) time / 3600;
        double remainder = time % 3600;
        double minutes = remainder / 60;
        double seconds = remainder % 60;

        //.5 degrees per second for hourHand
        //6 degrees per second for minuteHand
        double hourHand = 0.5 * ( (double) hours * 60 + minutes);
        double minuteHand = 6 * minutes;

        //gives angle of two hands by subtracting the angle of the hands
        return Math.abs( hourHand - minuteHand );
    }


    //recieved help in making this checking method
    public static Boolean checkPossible( double angleToCheck, double check, double inputAngle ) {

        if ( angleToCheck > inputAngle && inputAngle > angleToCheck - check ) {

            return true;

        } else if ( angleToCheck < inputAngle && inputAngle < angleToCheck + check ) {

            return true;

        } else {

            return false;

        }
    }

	public static void main ( String[] args ) {

    /*Your program must validate the argument( s) and throw an IllegalArgumentException if invalid or inappropriately missing.*/
        //this is make sure only non-negative values are being input
        //Andrew advised to do this before initializing variables

        /*if ( args[0].contains( "-" ) || args[1].contains( "-" ) ) {
                 throw new IllegalArgumentException();
        } else {
               //lines 11-17 were given after asking for help from my classmates
               try {
                    Double.parseDouble( args[0] );
                    Double.parseDouble( args[1] );
                } catch ( NumberFormatException ex ) {
                    throw new IllegalArgumentException();
                }
        }*/

            double inputAngle;
            double timeslice;

            if ( args.length <= 0 || args.length > 2 ) {

                throw new IllegalArgumentException();

            } else {

                if ( args.length == 1 ) {
                    //lines 74-84 were given after asking for help from my classmates
                    if ( args[0].contains( "-" ) ) {
                             throw new IllegalArgumentException();
                    } else {
                           try {
                                Double.parseDouble( args[0] );
                            } catch ( NumberFormatException ex ) {
                                throw new IllegalArgumentException();
                            }
                            //input
                            inputAngle = Double.parseDouble( args[0] );
                            timeslice = 60;
                        }

                } else {

                    if ( args[0].contains( "-" ) || args[1].contains( "-" ) ) {
                             throw new IllegalArgumentException();
                    } else {
                           try {
                                Double.parseDouble( args[0] );
                                Double.parseDouble( args[1] );
                            } catch ( NumberFormatException ex ) {
                                throw new IllegalArgumentException();
                            }

                            inputAngle = Double.parseDouble( args[0] );
                            timeslice = Double.parseDouble( args[1] );

                    }
                }

            }


            //keeps track of time
            double time = 0.0;

            //starting angles
            double angle = 0.0;
            double secondAngle = 360.0;

            //answer variable
            String match = "";

            //public constructor in clock.java help from t.a.
            Clock watch = new Clock( 0 ,0 ,0.0 ,timeslice, time );



            //Initialize system variables
            time = watch.getSeconds();
            toAngle( time );
            //initializes variable for timeslice
            /*Advance system clock +1 time slice*/
            double check = ( toAngle( timeslice ) / 2 );



            //Loop while simulation not finished
            //43200 is not magic number it is 60sec*60min*12hours
            while ( time < 43200 ) {

                watch.tick();
                time = watch.getSeconds();
                angle = toAngle( time );
                secondAngle = ( 360 - angle );

                //MAJOR FLAW ALERT IM NOT GOING TO CHANGE THIS BUT I DID NOT CATCH THAT THESE TWO BELONG IN THE SAME IF STATEMENT
                if ( angle == inputAngle || secondAngle == inputAngle ) {

                    match = match + ( watch.toString() ) + "\n";

                } else if ( checkPossible( angle, check, inputAngle) || checkPossible( secondAngle, check, inputAngle) ) {

                    match = match + ( watch.toString() ) + "\n";

                } else {
                    //keep loop running until goes through all 12 hours
             }
         }

         //Generate final report
        System.out.println( match );
    }

}
