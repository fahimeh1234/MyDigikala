package fahimeh.eltejaei.mydigikala.ui.login

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import fahimeh.eltejaei.mydigikala.R
import fahimeh.eltejaei.mydigikala.databinding.LoginFragmentBinding
import fahimeh.eltejaei.mydigikala.db.SharedPrefRepository
import fahimeh.eltejaei.mydigikala.network.errorHandling.Status
import fahimeh.eltejaei.mydigikala.ui.splash.SplashFragmentDirections
import fahimeh.eltejaei.mydigikala.utils.bases.BaseFragment
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginFragmentBinding,LoginViewModel>(R.layout.login_fragment) {
    override val viewModel: LoginViewModel by viewModels()




    override fun init() {
     binding.viewModel = viewModel
        binding.btnSignUp.setOnClickListener{
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
        }
    }

//    @Inject
//    lateinit var sharedPreferences: SharedPreferences

    override fun observeLiveData() {
        viewModel.loginUserResponse.observe(viewLifecycleOwner){
            if(it.status == Status.ERROR){
                if(it.code == 400) showMessage("user or password is not correct")
                showMessage(it.message.orEmpty())
            }else{
                if(it.data != null && !it.data.token.isNullOrBlank()){
                    openHomeFragment()
                    viewModel.saveToken(it.data.token)
//                showMessage(sharedPreferences.getString("token","") ?: "")
                }
            }
        }
    }

    private fun openHomeFragment() {
     findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeNav())
    }

}