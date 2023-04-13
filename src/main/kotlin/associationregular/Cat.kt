package associationregular

import java.time.LocalDate

data class Cat(
    val name: String,
    val surname: String?,
    val dateOfBirth: LocalDate,
    val sex: String,
    val breed: String,
    val documents: MutableList<String>,
    val customers: MutableList<Customer> = mutableListOf(), // implementation of an association, cardinality "*"
) {
    fun addCustomer(newCustomer: Customer) {
        // Check if we already have the info
        if (!customers.contains(newCustomer)) {
            customers.add(newCustomer)
            // Add the reverse connection
            newCustomer.addCat(this)
        }
    }

    fun removeCustomer(customerToRemove: Customer) {
        if (customers.contains(customerToRemove)) {
            customers.remove(customerToRemove)
            // Remove the reverse link
            customerToRemove.removeCat(this)
        }
    }

    override fun toString(): String {
        var info = "Cat: $name\n"

        // Add info about his/her owners
        for (customer in customers) {
            info += "   " + customer.name + "\n"
        }
        return info
    }
}
