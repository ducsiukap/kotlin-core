import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DAO {
    private const val url = "jdbc:mysql://localhost:3306/simple_banking_app_db"
    private const val user = "root"
    private const val password = "vduczz#13304"

    init {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
            // load driver
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    fun getConnection(): Connection? {
        val conn =
                try {
                    DriverManager.getConnection(url, user, password)
                } catch (e: SQLException) {
                    e.printStackTrace()
                    null // return
                }
        println(if (conn != null) "Connect to DB successfully!" else "Failed connect to DB!")
        return conn
    }
}
