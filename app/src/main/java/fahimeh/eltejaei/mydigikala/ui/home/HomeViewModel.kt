package fahimeh.eltejaei.mydigikala.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fahimeh.eltejaei.mydigikala.network.ApiRepository
import fahimeh.eltejaei.mydigikala.network.dataModel.product.ResponseProduct
import fahimeh.eltejaei.mydigikala.network.errorHandling.Resource
import fahimeh.eltejaei.mydigikala.utils.bases.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val apiRepository: ApiRepository) : BaseViewModel(){



    private val _productResponse = MutableLiveData<Resource<ResponseProduct>>()
    val productResponse: LiveData<Resource<ResponseProduct>>
        get() = _productResponse

    init {
        getProduct()
    }

    fun getProduct(){
        viewModelScope.launch {
            _productResponse.value = apiRepository.getProduct()
            _isShowLoading.value = false

        }

    }
}