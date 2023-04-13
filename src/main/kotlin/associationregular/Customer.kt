package associationregular

data class Customer(
    val name: String, // public for simplicity
    val surname: String,
    val sex: String,
    val contactData: MutableList<String>,
    val cats: MutableList<Cat> = mutableListOf(), // implementation of an association, cardinality "*"
) {
    fun addCat(newCat: Cat) {
        // Check if we already have the info
        if (!cats.contains(newCat)) {
            cats.add(newCat)
            // Add the reverse connection
            newCat.addCustomer(this)
        }
    }

    fun removeCat(catToRemove: Cat) {
        if (cats.contains(catToRemove)) {
            cats.remove(catToRemove)
            // Remove the reverse link
            catToRemove.removeCustomer(this)
        }
    }

    override fun toString(): String {
        var info = "Customer: $name\n"

        // Add info about his/her cats
        for (cat in cats) {
            info += "   " + cat.name + "\n"
        }
        return info
    }
}
