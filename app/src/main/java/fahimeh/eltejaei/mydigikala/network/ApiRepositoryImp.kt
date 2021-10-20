package fahimeh.eltejaei.mydigikala.network

import fahimeh.eltejaei.mydigikala.network.dataModel.comment.ResponseProductComment
import fahimeh.eltejaei.mydigikala.network.dataModel.comment.sendCommentRequest
import fahimeh.eltejaei.mydigikala.network.dataModel.detail.ProductDetail
import fahimeh.eltejaei.mydigikala.network.dataModel.login.LoginRequest
import fahimeh.eltejaei.mydigikala.network.dataModel.login.LoginResponse
import fahimeh.eltejaei.mydigikala.network.dataModel.product.ResponseProduct
import fahimeh.eltejaei.mydigikala.network.errorHandling.Resource
import fahimeh.eltejaei.mydigikala.network.errorHandling.ResponseHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class ApiRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val responseHandler: ResponseHandler
) : ApiRepository {
    override suspend fun loginUser(request: LoginRequest): Resource<LoginResponse> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val result = apiService.loginUser(request)
                responseHandler.handleSuccess(result)
            } catch (e: Exception) {
                responseHandler.handleException(e)
            }
        }

    override suspend fun signUpUser(request: LoginRequest): Resource<LoginResponse> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val result = apiService.signUpUser(request)
                responseHandler.handleSuccess(result)
            } catch (e: Exception) {
                responseHandler.handleException(e)
            }
        }

    override suspend fun getProduct(): Resource<ResponseProduct> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val result = apiService.getProduct()
                responseHandler.handleSuccess(result)
            } catch (e: Exception) {
                responseHandler.handleException(e)
            }
        }

    override suspend fun getProductDetail(id: String): Resource<ProductDetail> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val result = apiService.getProductDetail(id)
                responseHandler.handleSuccess(result)
            } catch (e: Exception) {
                responseHandler.handleException(e)
            }
        }

    override suspend fun getProductComments(id: String): Resource<ResponseProductComment> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val result = apiService.getProductComments(id)
                responseHandler.handleSuccess(result)
            } catch (e: Exception) {
                responseHandler.handleException(e)
            }
        }

    override suspend fun sendComment(id: String,body: sendCommentRequest): Resource<ResponseProductComment>  =
        withContext(Dispatchers.IO) {
            return@withContext try {
                val result = apiService.sendComment(id,body)
                responseHandler.handleSuccess(result)
            } catch (e: Exception) {
                responseHandler.handleException(e)
            }
        }

}




