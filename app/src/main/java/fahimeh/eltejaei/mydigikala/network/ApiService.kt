package fahimeh.eltejaei.mydigikala.network

import fahimeh.eltejaei.mydigikala.network.dataModel.comment.ResponseProductComment
import fahimeh.eltejaei.mydigikala.network.dataModel.comment.sendCommentRequest
import fahimeh.eltejaei.mydigikala.network.dataModel.detail.ProductDetail
import fahimeh.eltejaei.mydigikala.network.dataModel.login.LoginRequest
import fahimeh.eltejaei.mydigikala.network.dataModel.login.LoginResponse
import fahimeh.eltejaei.mydigikala.network.dataModel.product.ResponseProduct
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("signup/")
    suspend fun signUpUser(@Body body:LoginRequest): LoginResponse

    @POST("login/")
    suspend fun loginUser(@Body body:LoginRequest): LoginResponse

    @GET("products/")
    suspend fun getProduct():ResponseProduct

    @GET("product/{id}")
    suspend fun getProductDetail(@Path("id") id: String): ProductDetail

    @GET("product/{id}/comments/")
    suspend fun getProductComments(@Path("id") id: String): ResponseProductComment

    @POST("product/{id}/comment/")
    suspend fun sendComment(@Path("id") id: String,@Body body: sendCommentRequest): ResponseProductComment
}