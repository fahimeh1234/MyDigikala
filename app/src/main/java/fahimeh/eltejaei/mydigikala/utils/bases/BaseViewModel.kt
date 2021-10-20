package fahimeh.eltejaei.mydigikala.utils.bases

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel :ViewModel(){

    val _isShowLoading = MutableLiveData(true)
    val isShowLoading: MutableLiveData<Boolean>
        get() = _isShowLoading
}