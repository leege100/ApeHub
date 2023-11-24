
import baseDI
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

val homeDI = DI {
    extend(baseDI)
}
