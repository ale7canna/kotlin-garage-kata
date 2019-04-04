import ale7canna.garage.Car
import ale7canna.garage.EmptyGarage
import ale7canna.garage.FullGarage
import ale7canna.garage.Garage
import io.kotlintest.matchers.beOfType
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class GarageTest : StringSpec() {
    private val sut = Garage(3, List())
    init {
        "Garage should contain the list of the parked cars" {
            val car = Car()
            val garage = sut.park(car)

            garage.isParked(car) shouldBe true
        }
    }
}