package nz.spahr.app.provider

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import nz.spahr.app.model.AppStateDataBuilder
import nz.spahr.app.model.AppStateProvider
import nz.spahr.feature.navigation.FeatureNavGraph

class NavigationGraphProvider(private val navGraphs: List<FeatureNavGraph>) : AppStateProvider {
    override val updates: Flow<AppStateDataBuilder.() -> Unit>
        get() = flow<List<FeatureNavGraph>> {
            emit(navGraphs)
        }.map {
            {
                navigationGraphs(it)
            }
        }

}