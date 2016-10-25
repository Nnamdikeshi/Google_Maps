import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Nnamdi on 10/18/2016.
 */
public class GoogleMain {
    public static void main(String[] args) {

        String key = null;
        //read key from file
        try (BufferedReader reader = new BufferedReader(new FileReader("key..txt"))) {
            key = reader.readLine();
            System.out.println(key); //just checking...
        } catch (Exception ioe) {
            System.out.println("No key file found, or could not read key. Please verify key.txt present");
            System.exit(-1); //Quit program - need to fix before continuing.
        }

        GeoApiContext context =  new GeoApiContext().setApiKey(key);

        LatLng mctcLaLng = new LaLng(44.973074, -93.283356);

        ElevationResult[] results = ElevationApi.getByPoints(context, mctcLaLng).await();

        if (results.length >= 1) {
            ElevationResult mctcElevation - results[0];
            System.out.println("The elevation of MCTC above sea level is " + mctcElevation.elevation + " Meters");

            System.out.println(String.format("The elevation of MCTC above sea level is %.2f meters", mctcElevation.elevation));

        }
    }
}
