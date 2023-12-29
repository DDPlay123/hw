package mai.project.myapplication

data class Contact(
    val name: String,
    val email: String,
    val phone: String? = null,
) {
    override fun toString(): String {
        // 顯示 Contact 的資訊
        val phoneStr = if (phone != null) "\nPhone: $phone" else ""
        return "Name: $name\nEmail: $email$phoneStr"
    }
}
