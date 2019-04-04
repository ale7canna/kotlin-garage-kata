import ale7canna.garage.Car
import ale7canna.garage.EmptyGarage
import ale7canna.garage.FullGarage
import ale7canna.garage.Garage
import io.kotlintest.matchers.beOfType
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class EmptyGarageTest : StringSpec() {
    private val sut = EmptyGarage(2)

    init {
        "An empty garage can host a car" {
            sut.canPark(Car()) shouldBe true
        }

        "Park succeeds if has enough space" {
            sut.park(Car()) should beOfType<Garage>()
        }
    }
}