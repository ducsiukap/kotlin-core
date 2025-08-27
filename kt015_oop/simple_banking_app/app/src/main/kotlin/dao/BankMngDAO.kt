import java.sql.SQLException

class BankMngDAO {
    private val conn = DAO.getConnection() ?: throw SQLException("Cannot get database connection")

    fun getUserBalance(u: User) {
        val sql = "Select balance from Customer where id=?"

        try {

            conn.prepareStatement(sql).use {
                it.setInt(1, u.getID())

                it.executeQuery().use { rs -> if (rs.next()) u.setBalance(rs.getDouble("balance")) }
            }
        } catch (e: SQLException) {
            // Nothing
        }
    }

    fun transfer(from: User, to: User, amount: Double): Boolean {
        try {
            val sql = "Select balance from Customer where id=?"
            conn.prepareStatement(sql).use {
                it.setInt(1, from.getID())
                it.executeQuery().use { rs ->
                    if (rs.next()) {
                        from.setBalance(rs.getDouble("balance"))

                        if (from.getBalance() < amount) return false
                    } else {
                        println("cc")
                        return false
                    }
                }
            }

            conn.prepareStatement(sql).use {
                it.setInt(1, to.getID())
                it.executeQuery().use { rs ->
                    if (rs.next()) to.setBalance(rs.getDouble("balance"))
                    else {

                        println("cc2")
                        return false
                    }
                }
            }

            val transferSql = "Update customer set balance=? where id=?"
            try {
                conn.autoCommit = false

                conn.prepareStatement(transferSql).use {
                    it.setDouble(1, from.getBalance() - amount)
                    it.setInt(2, from.getID())

                    it.executeUpdate()
                }

                conn.prepareStatement(transferSql).use {
                    it.setDouble(1, to.getBalance() + amount)
                    it.setInt(2, to.getID())

                    it.executeUpdate()
                }
                conn.commit()
                from.setBalance(from.getBalance() - amount)
                return true
            } catch (e_: SQLException) {
                conn.rollback()
                e_.printStackTrace()
                return false
            } finally {
                conn.autoCommit = true
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            return false
        }
    }
}
