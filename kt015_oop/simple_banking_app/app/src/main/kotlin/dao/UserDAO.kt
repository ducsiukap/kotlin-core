import java.sql.SQLException
import java.sql.Statement

class UserDAO {
    private val conn = DAO.getConnection() ?: throw SQLException("Cannot get database connection")

    fun checkLogin(u: User): Boolean {
        val sql = "SELECT id, name, balance FROM Customer WHERE username=? AND password=?"
        try {
            conn.prepareStatement(sql).use { pstm ->
                pstm.setString(1, u.getUsername())
                pstm.setString(2, u.getPassword())

                pstm.executeQuery().use { result ->
                    return if (result.next()) {
                        u.setID(result.getInt("id"))
                        u.setName(result.getString("name"))
                        u.setBalance(result.getDouble("balance"))
                        true
                    } else {
                        false
                    }
                }
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            return false
        }
    }

    fun addUser(u: User): Boolean {

        val sql = "insert into customer(name, username, password, balance) values (?, ?, ?, ?)"
        return try {
            conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS).use { pstm ->
                pstm.setString(1, u.getName())
                pstm.setString(2, u.getUsername())
                pstm.setString(3, u.getPassword())
                pstm.setDouble(4, u.getBalance())

                pstm.executeUpdate()
                val rs = pstm.generatedKeys
                if (rs.next()) {
                    u.setID(rs.getLong(1).toInt())
                    return true
                } else return true
            }
        } catch (e: SQLException) {
            // do nothing
            e.printStackTrace()
            false
        }
    }
}
