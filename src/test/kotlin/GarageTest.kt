import ale7canna.garage.*
import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class GarageTest : StringSpec() {
    private val sut = Garage(10, listOf())
    init {
        "Garage should contain the list of the parked cars" {
            val car = Car()
            val garage = sut.park(car)

            garage.isParked(car) shouldBe true
        }

        "Truck can't fit if less than 3 parking space" {
            val garage = EmptyGarage(2)

            garage.canPark(Truck()) shouldBe false
        }

        "Truck can be parked if enough space in the garage" {
            val result = sut.canPark(Truck())

            result shouldBe true
        }

        "Garage can list all the parked cars" {
            val car = Car()
            var garage = sut.park(car)
            garage = garage.park(Truck())

            val result = garage.parkedCars()

            result shouldContain car
        }

        "Garage can list all the parked trucks" {
            val truck = Truck()
            var garage = sut.park(Car())
            garage = garage.park(truck)

            val result = garage.parkedTrucks()

            result shouldContain truck
        }
    }
}