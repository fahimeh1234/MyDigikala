package fahimeh.eltejaei.mydigikala.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fahimeh.eltejaei.mydigikala.db.SharedPrefRepository
import fahimeh.eltejaei.mydigikala.utils.SPLASH_DELAY
import fahimeh.eltejaei.mydigikala.utils.bases.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(val sharedPrefRepository: SharedPrefRepository) : BaseViewModel() {

    private val _isTimerFinished = MutableLiveData(false)
     val isTimerFinished: LiveData<Boolean>
        get() = _isTimerFinished

    private val _isTokenValid = MutableLiveData(false)
    val isTokenValid: LiveData<Boolean>
        get() = _isTokenValid

    init {
        startTimer()
        checkToken()
    }


    private fun checkToken(){
           _isTokenValid.value = !sharedPrefRepository.getToken().isNullOrBlank()
    }

    private fun startTimer() {
        viewModelScope.launch {
            delay(SPLASH_DELAY)
            _isTimerFinished.value = true

        }
    }


}