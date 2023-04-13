package associationqualified

data class Specialization (
    val name: String,
    val description: String,
    val category: String,
    val employees: MutableList<Employee> = mutableListOf()
) {
    fun addEmployee(newEmployee: Employee) {
        // Check if we have the information already
        if (!employees.contains(newEmployee)) {
            employees.add(newEmployee)

            // Add the reverse connection
            newEmployee.addSpecializationQualified(this)
        }
    }
    override fun toString(): String {
        var info = "Specialization: $name\n"

        // Add info about titles of his/her movies
        for (employee in employees) {
            info += "   " + employee.name + "\n"
        }
        return info
    }
}