package EQMobileWorkSample
import java.io.File
import java.time.LocalTime
import java.time.format.DateTimeFormatter



public data class LocationEvent(val lat: Float, val lon: Float, val time: Long, val ext: String)


public class Library {
    fun setup(): Boolean {
        return true
    }



    fun log(event: LocationEvent) {


        val locationEventInstance = LocationEvent()


        // WORST CASE SCENARIO

        if (locationEventInstance.lat == null) || (locationEventInstance.lon == null)){
            locationEventInstance.lat = 0
            locationEventInstance.lon = 0
        }


        //  PROVIDING CURRENT TIME IF NO EXPLICIT TIMESTAMP

        if(locationEventInstance.time == null) {
            val currentTime = LocalTime.now()
            locationEventInstance.time = currentTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM))

        }


        // POST to API Server

        print("Latitude :${locationEventInstance.lat} Longtitude : ${locationEventInstance.lon} Time : ${locationEventInstance.time} ")

        //PACKANGING IT FOR IMPORT USE

        val fileName = "geoData.txt"
        var fileObject = File(fileName)
        try {

            fileObject.writeText("Latitude :${locationEventInstance.lat} Longtitude : ${locationEventInstance.lon}  Time : ${locationEventInstance.time} ")

             } catch (e: Exception) {
            e.printStackTrace()
             }






        }

    }
}

