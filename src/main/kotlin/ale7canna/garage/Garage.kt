package ale7canna.garage

open class Garage(private val parkAvailability: Int, private val parkedVehicles: List<IVehicle>) {
    fun canPark(vehicle: IVehicle): Boolean =
        vehicle.size <= parkAvailability

    fun park(vehicle: IVehicle): Garage =
        if (!canPark(vehicle)) FullGarage(parkedVehicles) else addCar(vehicle)

    private fun addCar(vehicle: IVehicle): Garage =
        Garage(parkAvailability - vehicle.size, parkedVehicles + listOf(vehicle))

    fun isParked(vehicle: IVehicle): Boolean =
        parkedVehicles.contains(vehicle)

    fun parkedCars(): List<IVehicle> =
        parkedVehicles.filter { it is Car }

    fun parkedTrucks(): List<IVehicle> =
        parkedVehicles.filter { it is Truck }
}