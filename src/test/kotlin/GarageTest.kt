import io.kotlintest.specs.StringSpec
import ale7canna.garage.Car
import ale7canna.garage.EmptyGarage
import ale7canna.garage.FullGarage
import ale7canna.garage.Garage
import io.kotlintest.matchers.beOfType
import io.kotlintest.matchers.types.shouldBeSameInstanceAs
import io.kotlintest.matchers.types.shouldNotBeSameInstanceAs
import io.kotlintest.should
import io.kotlintest.shouldBe

class GarageTest : StringSpec() {
    init {
        "An empty garage can host a car" {
            EmptyGarage(1).canPark() shouldBe true
        }

        "Park succeeds if has enough space" {
            EmptyGarage(1).park(Car()) should beOfType<Garage>()
        }

        "Parking will fail if garage is full" {
            FullGarage(listOf(Car())).park(Car()) should beOfType<FullGarage>()
        }

        "A full garage can not host car" {
            FullGarage(listOf(Car())).canPark() shouldBe false
        }

        "Garage should contain the list of the parked cars" {
            val emptyGarage = EmptyGarage(2)
            val car = Car()
            val garage = emptyGarage.park(car)

            garage.isParked(car) shouldBe true
        }
    }
}