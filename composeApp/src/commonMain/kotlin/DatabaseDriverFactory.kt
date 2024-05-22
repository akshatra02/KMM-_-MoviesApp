import app.cash.sqldelight.db.SqlDriver

expect fun databaseDriver() : Driver
interface Driver {
    val driver: SqlDriver
}