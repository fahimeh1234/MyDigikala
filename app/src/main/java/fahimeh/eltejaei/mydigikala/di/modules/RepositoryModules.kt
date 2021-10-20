package fahimeh.eltejaei.mydigikala.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fahimeh.eltejaei.mydigikala.db.SharedPrefRepository
import fahimeh.eltejaei.mydigikala.db.SharedPrefRepositoryImp
import fahimeh.eltejaei.mydigikala.network.ApiRepository
import fahimeh.eltejaei.mydigikala.network.ApiRepositoryImp

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModules {

    @Binds
    abstract fun provideApiRepository(apiRepositoryImp: ApiRepositoryImp):ApiRepository

    @Binds
    abstract fun provideSharedPrefRepository(sharedPref: SharedPrefRepositoryImp): SharedPrefRepository
}