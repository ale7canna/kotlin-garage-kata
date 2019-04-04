import ale7canna.garage.*
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class GarageTest : StringSpec() {
    private val sut = Garage(3, listOf())
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
    }
}