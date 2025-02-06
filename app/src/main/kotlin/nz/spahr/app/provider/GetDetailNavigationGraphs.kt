package nz.spahr.app.provider

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import nz.spahr.feature.navigation.FeatureNavGraph

class GetDetailNavigationGraphs(private val navGraphs: List<FeatureNavGraph>) {
    operator fun invoke(): Flow<List<FeatureNavGraph>> = flow<List<FeatureNavGraph>> {
        emit(navGraphs)
    }

}