package fahimeh.eltejaei.mydigikala.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ErrorInterceptor  @Inject constructor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var builder = chain.request().newBuilder()

        var response = chain.proceed(builder.build())

        if (response.code == 401) {
            GlobalNavigator.logout()
        }
        return response
    }
}