import ale7canna.garage.Car
import ale7canna.garage.FullGarage
import io.kotlintest.matchers.beOfType
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class FullGarageTest : StringSpec() {
    private val sut = FullGarage(listOf(Car(), Car()))

    init {
        "Parking will fail if garage is full" {
            sut.park(Car()) should beOfType<FullGarage>()
        }

        "A full garage can not host car" {
            sut.canPark() shouldBe false
        }
    }
}