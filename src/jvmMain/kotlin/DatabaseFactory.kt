import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.flywaydb.core.Flyway

object DatabaseFactory {

    //TODO: Make this more globalized (and place into Gradle) over winter break
    private const val dbUrl = "jdbc:postgresql://localhost:5432/fitpick"
    private val dbUser = System.getenv("USERNAME")
    private val dbPassword = System.getenv("PASSWORD")

    fun init() {
        Database.connect(hikari())

        //TODO: Put this in gradle file over winter break
        val flyway = Flyway.configure()
            .dataSource(dbUrl, dbUser, dbPassword)
            .locations("filesystem:db/migrations")
            .baselineOnMigrate(true).load()

        //In the event of catastrophe due to table drops, run clean
        //For presentation purposes, we will wipe the db on application startup
        //Note that this will remove data persistence
        //In other words, the cleaning line must be removed
        // if we are to demonstrate the same state between runs
        flyway.clean()

        flyway.migrate()
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = "org.postgresql.Driver"
        config.jdbcUrl = dbUrl
        config.username = dbUser
        config.password = dbPassword
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        return HikariDataSource(config)
    }

    suspend fun <T> dbQuery(block: () -> T): T =
        withContext(Dispatchers.IO) {
            transaction { block() }
        }
}