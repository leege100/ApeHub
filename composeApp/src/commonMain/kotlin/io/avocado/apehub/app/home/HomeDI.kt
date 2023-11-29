
import io.avocado.apehub.app.home.trending.developers.TrendingDevelopersViewModel
import io.avocado.apehub.app.home.trending.repositories.TrendingRepositoriesViewModel
import org.kodein.di.DI
import org.kodein.di.bindProvider

val homeDI = DI {
    extend(baseDI)
    bindProvider { TrendingDevelopersViewModel() }
    bindProvider { TrendingRepositoriesViewModel() }
}
