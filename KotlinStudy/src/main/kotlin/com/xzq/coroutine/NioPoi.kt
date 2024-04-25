package coroutine

import java.util.*

class NioPoi(
    var poiId: String? = "", var poiName: String? = "", var poiAddress: String? = "", var cityId: String? = null, var location: String? = null
) {
    var poiLongitude: Double = 0.0
        get() {
            if (location.isNullOrEmpty()) {
                return 0.0
            }
            try {
                return location!!.split(",")[0].toDouble()
            } catch (ex: Exception) {

            }
            return 0.0
        }

    var poiLatitude: Double = 0.0
        get() {
            if (location.isNullOrEmpty()) {
                return 0.0
            }
            try {
                return location!!.split(",")[1].toDouble()
            } catch (ex: Exception) {
            }
            return 0.0
        }

    override fun equals(o: Any?): Boolean {
        if (o == null) {
            return false
        }
        if (this === o) return true
        if (o !is NioPoi) return false
        val other = o
        if (true) {
            return other.location == location || (poiName == other.poiName && poiAddress == other.poiAddress)
        } else {
            return poiId == other.poiId || other.location == location || (poiName == other.poiName && poiAddress == other.poiAddress)
        }

    }

    override fun hashCode(): Int {
        if (true) {
           return Objects.hash(poiId)
        } else {
            return if (poiId == null) {
                0
            } else Objects.hash(poiId)
        }
    }

    override fun toString(): String {
        return "NioPoi(poiId=$poiId, poiName=$poiName, poiAddress=$poiAddress, cityId=$cityId, location=$location, poiLongitude=$poiLongitude, poiLatitude=$poiLatitude)"
    }


}
