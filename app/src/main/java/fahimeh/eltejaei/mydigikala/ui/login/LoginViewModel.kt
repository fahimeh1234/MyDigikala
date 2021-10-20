package fahimeh.eltejaei.mydigikala.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fahimeh.eltejaei.mydigikala.db.SharedPrefRepository
import fahimeh.eltejaei.mydigikala.network.ApiRepository
import fahimeh.eltejaei.mydigikala.network.dataModel.login.LoginRequest
import fahimeh.eltejaei.mydigikala.network.dataModel.login.LoginResponse
import fahimeh.eltejaei.mydigikala.network.errorHandling.Resource
import fahimeh.eltejaei.mydigikala.utils.bases.BaseViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import timber.log.Timber.e
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val apiRepository: ApiRepository, private val sharedPrefRepository: SharedPrefRepository) :
    BaseViewModel() {




    val username = MutableLiveData("")
    val password = MutableLiveData("")

    private val _loginUserResponse = MutableLiveData<Resource<LoginResponse>>()
    val loginUserResponse: LiveData<Resource<LoginResponse>>
        get() = _loginUserResponse

    init {
        _isShowLoading.value = false
    }

    fun loginUser() {
        _isShowLoading.value = true
        viewModelScope.launch {
                _loginUserResponse.value = apiRepository.loginUser(
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