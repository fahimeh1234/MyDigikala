package fahimeh.eltejaei.mydigikala.network

import fahimeh.eltejaei.mydigikala.network.dataModel.comment.ResponseProductComment
import fahimeh.eltejaei.mydigikala.network.dataModel.comment.sendCommentRequest
import fahimeh.eltejaei.mydigikala.network.dataModel.detail.ProductDetail
import fahimeh.eltejaei.mydigikala.network.dataModel.login.LoginRequest
import fahimeh.eltejaei.mydigikala.network.dataModel.login.LoginResponse
import fahimeh.eltejaei.mydigikala.network.dataModel.product.ResponseProduct
import fahimeh.eltejaei.mydigikala.network.errorHandling.Resource
import retrofit2.http.Body
import retrofit2.http.Path

interface ApiRepository {

    suspend fun  loginUser(request:LoginRequest): Resource<LoginResponse>

    suspend fun  signUpUser(request:LoginRequest): Resource<LoginResponse>

    suspend fun getProduct(): Resource<ResponseProduct>

    suspend fun getProductDetail(id: String): Resource<ProductDetail>

    suspend fun getProductComments(id: String): Resource<ResponseProductComment>

    suspend fun sendComment(id: String,body: sendCommentRequest): Resource<ResponseProductComment>
}