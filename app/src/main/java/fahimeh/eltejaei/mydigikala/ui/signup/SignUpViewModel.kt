package fahimeh.eltejaei.mydigikala.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fahimeh.eltejaei.mydigikala.db.SharedPrefRepository
import fahimeh.eltejaei.mydigikala.network.ApiRepository
import fahimeh.eltejaei.mydigikala.network.dataModel.login.LoginRequest
import fahimeh.eltejaei.mydigikala.network.dataModel.login.LoginResponse
import fahimeh.eltejaei.mydigikala.network.errorHandling.Resource
import fahimeh.eltejaei.mydigikala.utils.bases.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
    private val sharedPrefRepository: SharedPrefRepository
) : BaseViewModel() {
    val username = MutableLiveData("")
    val password = MutableLiveData("")

    private val _signUpUserResponse = MutableLiveData<Resource<LoginResponse>>()
    val signUpUserResponse: LiveData<Resource<LoginResponse>>
        get() = _signUpUserResponse

    init {
        _isShowLoading.value = false
    }

    fun signUpUser() {
        _isShowLoading.value = true
        viewModelScope.launch {
            _signUpUserResponse.value = apiRepository.signUpUser(
                LoginRequest(
                    password = password.value,
                    username = username.value
                )
            )
            _isShowLoading.value = false
        }
    }

    fun saveToken(token: String) {
        sharedPrefRepository.saveToken(token)
    }
}