package arrow.optics.example

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

import arrow.optics.Optional
import arrow.optics.optics

@optics data class Street(val number: Int, val name: String) { companion object }
@optics data class Address(val city: String, val street: Street) { companion object }
@optics data class Company(val name: String, val address: Address) { companion object }
@optics data class Employee(val name: String, val company: Company?) { companion object }

val original = Employee(
        name = "John Doe",
        company = Company(
                name = "Kategory",
                address = Address(
                        city = "Functional city",
                        street = Street(
                                number = 42,
                                name = "lambda street"
                        )
                )
        )
)

val expectedResult = original.copy(
        company = original.company?.copy(
                address = original.company?.address.copy(
                        street = original.company?.address.street.copy(
                                name = "LAMBDA STREET"
                        )
                )
        )
)

class OptionalSpec : StringSpec({
    "without optics, if I want to change a deeply nested field in an immutable way" {
        val modifiedCopy = original.copy(
                company = original.company?.copy(
                        address = original.company?.address.copy(
                                street = original.company?.address.street.copy(
                                        name = "LAMBDA STREET"
                                )
                        )
                )
        )
        modifiedCopy shouldBe expectedResult
    }

    "optional optics lets us 'modify' deeply nested records in a safe, immutable way, with a fraction of the code." {
        val optional: Optional<Employee, String> = Employee.company.address.street.name
        val modifiedCopy = optional.modify(original, String::toUpperCase)
        modifiedCopy shouldBe expectedResult
    }
})
