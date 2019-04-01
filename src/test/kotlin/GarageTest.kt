import ale7canna.garage.Garage
import io.kotlintest.specs.StringSpec
import ale7canna.garage.Car
import io.kotlintest.shouldBe

class GarageTest : StringSpec() {
    init {
        "An empty garage can host a car" {
            Garage(1).canPark() shouldBe true
        }

        "Park will fail if garage is full" {
            Garage(0).park(Car()) shouldBe false
        }

        "A full garage can not host car" {
            val car = Car()
            val garage = Garage(1)
            garage.park(car)

            garage.canPark() shouldBe false
        }
    }
}