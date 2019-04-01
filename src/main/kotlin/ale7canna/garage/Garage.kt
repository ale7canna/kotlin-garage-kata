package ale7canna.garage

open class Garage(private val parkAvailability: Int, private val parkedCars: List<Car>) {

    fun canPark(): Boolean =
        parkAvailability > 0

    fun park(car: Car): Garage =
        if (!canPark()) FullGarage(parkedCars) else addCar(car)

    private fun addCar(car: Car): Garage =
        Garage(parkAvailability - 1, parkedCars + listOf(car))

    fun isParked(car: Car): Boolean = parkedCars.contains(car)
}

