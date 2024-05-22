import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.kmm.themoviesapp.AppDatabase
import org.koin.mp.KoinPlatform

class AndroidPlatformSqliteDriver() : Driver {
    override val driver =
        AndroidSqliteDriver(
            AppDatabase.Schema, KoinPlatform.getKoin().get(),
            "movies.db"
        )
}

actual fun databaseDriver(): Driver = AndroidPlatformSqliteDriver()