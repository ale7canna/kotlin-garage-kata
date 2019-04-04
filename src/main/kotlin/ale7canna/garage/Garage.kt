package ale7canna.garage

open class Garage(private val parkAvailability: Int, private val parkedCars: List<ITransportation>) {
    fun canPark(transportation: ITransportation): Boolean =
        transportation.size <= parkAvailability

    fun park(transportation: ITransportation): Garage =
        if (!canPark(transportation)) FullGarage(parkedCars) else addCar(transportation)

    private fun addCar(transportation: ITransportation): Garage =
        Garage(parkAvailability - transportation.size, parkedCars + listOf(transportation))

    fun isParked(transportation: ITransportation): Boolean =
        parkedCars.contains(transportation)
}