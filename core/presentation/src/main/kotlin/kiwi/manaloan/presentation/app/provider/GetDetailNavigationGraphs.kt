package kiwi.manaloan.presentation.app.provider

import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kiwi.manaloan.feature.navigation.FeatureNavGraph

class GetDetailNavigationGraphs(private val navGraphs: List<FeatureNavGraph>) {
    operator fun invoke(): Flow<List<FeatureNavGraph>> = flow<List<FeatureNavGraph>> {
        emit(navGraphs)
        awaitCancellation()
    }

}