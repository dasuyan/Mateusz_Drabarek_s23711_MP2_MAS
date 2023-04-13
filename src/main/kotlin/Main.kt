import associationattribute.Animal
import associationattribute.Care
import associationattribute.Caretaker
import associationqualified.Employee
import associationqualified.Specialization
import associationregular.Cat
import associationregular.Customer
import compositioninner.Qualification
import java.time.LocalDate

fun main() {
    /*
    * Uncomment any test, to see the functionality in action
    * */
    //testRegularAssociations()
    //testAttributeAssociations()
    //testQualifiedAssociations()
    //testCompositionInnerClass()
}
fun testRegularAssociations() {
    // Create new business objects (without connections)
    val cat1 = Cat("Pruti", "Hunter", LocalDate.of(2020, 3, 10), "Female", "Tricolore", mutableListOf("passport", "book of health", "vaccination certificate"))
    val cat2 = Cat("Leoś", null, LocalDate.of(2021, 10, 28), "Male", "Orange Tabby", mutableListOf("list of allergies", "book of health", "vaccination certificate"))

    val customer1 = Customer("Mateusz", "Drabarek", "male", mutableListOf("Słoneczna 42, Kotuń", "123456789", "m.d@gmail.com"))
    val customer2 = Customer("Artur", "Konopka", "male", mutableListOf("Malinowa 42, Łosice", "987654321", "a.k@gmail.com"))
    val customer3 = Customer("Julia", "Drabarek", "female", mutableListOf("Słoneczna 42, Kotuń", "010101010", "j.d@gmail.com"))

    // Add info about connections
    cat1.addCustomer(customer2)
    cat2.addCustomer(customer1)
    cat2.addCustomer(customer3)

    // Show info about cats
    println(cat1)
    println(cat2)

    // Show info about customers
    println(customer1)
    println(customer2)
    println(customer3)
}
fun testAttributeAssociations() {
    val animal1 = Animal("Fofik", "dog", 19)
    val animal2 = Animal("Calypso", "gecko", 3)
    val animal3 = Animal("Bonbon", "hamster", 1)

    val caretaker1 = Caretaker("Edyta", "edyta@gmail.com", LocalDate.of(2001, 2, 1))
    val caretaker2 = Caretaker("Sylwester", "sylwester@gmail.com", LocalDate.of(2004, 5, 21))

    val care1 = Care(12, animal3, caretaker1)
    val care2 = Care(7, animal2, caretaker2)
    val care3 = Care(2, animal1, caretaker1)
    val care4 = Care(4, animal3, caretaker1)

    println(caretaker1.getAnimals())
    care1.removeCare()
    println(caretaker1.getAnimals())

    println(animal3.getCaretakers())
    animal3.removeCare(care4)
    println(animal3.getCaretakers())
    println(caretaker1.getAnimals())
}

@Throws(Exception::class)
fun testQualifiedAssociations() {
    // Create new business objects (without connections)
    val employee1 = Employee("Jan", "Kowalski")
    val employee2 = Employee("Bożena", "Adamska")

    val specialization1 = Specialization("Super Pro at grooming cats", "Difficult to get", "Tech")
    val specialization2 = Specialization("Being nice", "Took 10 years to obtain", "Charisma")

    // Add info about connections
    employee1.addSpecializationQualified(specialization1)
    employee2.addSpecializationQualified(specialization2)
    employee1.addSpecializationQualified(specialization2)

    // Show info about employee's specializations
    println(employee1)

    // Get the info about the "Being nice" specialization for the employee1
    val retrievedSpecialization1: Specialization? = employee1.findSpecializationQualified("Being nice")
    println(retrievedSpecialization1)
    val retrievedSpecialization2: Specialization? = employee2.findSpecializationQualified("Super Pro at grooming cats")
    println(retrievedSpecialization2)
}

@Throws(java.lang.Exception::class)
fun testCompositionInnerClass() {
    // Create a new whole
    val qualification = Qualification("Neurologist")
    qualification.createTreatment("Spinal cord acupuncture")
    qualification.createTreatment("Brain massage")

    // A wrong result: creating a new part inside the already existing whole, but without a connection between the whole and the part
    val treatment: Qualification.Treatment = qualification.Treatment("THIS SHOULDN'T EXIST")

    println(qualification)
    println(treatment)
    println(treatment.qualification)
}