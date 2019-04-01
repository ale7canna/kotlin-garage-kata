package ale7canna.garage

class Garage(private var parkAvailability: Int) {
    private val parkedCars: MutableList<Car> = mutableListOf()

    fun canPark(): Boolean {
        return parkAvailability > 0
    }

    fun park(car: Car): Boolean{
        if (parkAvailability <= 0)
            return false
        parkedCars.add(car)
        parkAvailability -= 1
        return true
    }

}
