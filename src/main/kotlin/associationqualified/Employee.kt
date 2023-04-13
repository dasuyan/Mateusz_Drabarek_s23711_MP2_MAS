package associationqualified

import java.util.*


data class Employee (
    val name: String,
    val surname: String,
    val specializationsQualified: MutableMap<String, Specialization> = TreeMap<String, Specialization>()
) {
    fun addSpecializationQualified(newSpecialization: Specialization) {
        // Check if we already have the info
        if (!specializationsQualified.containsKey(newSpecialization.name)) {
            specializationsQualified[newSpecialization.name] = newSpecialization

            // Add the reverse connection
            newSpecialization.addEmployee(this)
        }
    }

    @Throws(Exception::class)
    fun findSpecializationQualified(name: String): Specialization? {
        // Check if we have the info
        if (!specializationsQualified.containsKey(name)) {
            throw Exception("Unable to find a specialization with the following ID: $name")
        }
        return specializationsQualified[name]
    }

    override fun toString(): String {
        var info = "Employee: $name\n"

        // Add info about titles of his/her movies
        for (specialization in specializationsQualified) {
            info += "   " + specialization.key + "\n"
        }
        return info
    }
}