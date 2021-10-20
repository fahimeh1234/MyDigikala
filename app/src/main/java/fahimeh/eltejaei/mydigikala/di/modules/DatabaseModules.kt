package fahimeh.eltejaei.mydigikala.di.modules

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fahimeh.eltejaei.mydigikala.BuildConfig
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModules {

    @Provides
    @Singleton
    fun provideSharedPref(@ApplicationContext appContext: Context) =
        appContext.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)

}