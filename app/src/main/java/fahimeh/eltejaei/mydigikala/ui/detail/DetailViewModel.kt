package fahimeh.eltejaei.mydigikala.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fahimeh.eltejaei.mydigikala.network.ApiRepository
import fahimeh.eltejaei.mydigikala.network.dataModel.comment.Data
import fahimeh.eltejaei.mydigikala.network.dataModel.comment.ProductComment
import fahimeh.eltejaei.mydigikala.network.dataModel.comment.ResponseProductComment
import fahimeh.eltejaei.mydigikala.network.dataModel.comment.sendCommentRequest
import fahimeh.eltejaei.mydigikala.network.dataModel.detail.ProductDetail
import fahimeh.eltejaei.mydigikala.network.errorHandling.Resource
import fahimeh.eltejaei.mydigikala.network.errorHandling.Status
import fahimeh.eltejaei.mydigikala.utils.bases.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(private val apiRepository: ApiRepository) :
    BaseViewModel() {


    var productId = ""

    val commentText = MutableLiveData("")

    private val _productDetailResponse = MutableLiveData<Resource<ProductDetail>>()
    val productDetailResponse: LiveData<Resource<ProductDetail>>
        get() = _productDetailResponse

    private val _commentResponse = MutableLiveData<Resource<ResponseProductComment>>()
    val commentResponse: LiveData<Resource<ResponseProductComment>>
        get() = _commentResponse

    private val _sendCommentResponse = MutableLiveData<Resource<ResponseProductComment>>()
    val sendCommentResponse: LiveData<Resource<ResponseProductComment>>
        get() = _sendCommentResponse


    fun getProductDetail(productId: String) {
        viewModelScope.launch {
            _productDetailResponse.value = apiRepository.getProductDetail(productId)
            _isShowLoading.value = false

        }
    }

    fun setCommentSampleData() {
        val commentList = mutableListOf(ProductComment(1,"comment1"),ProductComment(2,"comment2"),ProductComment(3,"comment3"),ProductComment(4,"comment4"),ProductComment(5,"comment5"))
        val data: Data = Data(commentList)
        val productComment = ResponseProductComment(data,"","")
        _commentResponse.value = Resource(Status.SUCCESS,productComment,"",0)
    }

    fun getComments(productId: String) {
        setCommentSampleData()
//        viewModelScope.launch {
//            _commentResponse.value = apiRepository.getProductComments(productId)
//            _isShowLoading.value = false
//        }
    }

    fun sendComment(productId: String,commentDescription:String) {
        viewModelScope.launch {
            _sendCommentResponse.value = apiRepository.sendComment(productId, sendCommentRequest(commentDescription,4,"title"))
            _isShowLoading.value = false
        }
    }
}