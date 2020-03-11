package arrow.optics.example

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class LibraryTest : StringSpec({
    "someLibraryMethod should return 'true'" {
        val classUnderTest = Library()
        classUnderTest.someLibraryMethod() shouldBe ""
    }
})
