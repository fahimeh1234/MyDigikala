package fahimeh.eltejaei.mydigikala.ui.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import fahimeh.eltejaei.mydigikala.R
import fahimeh.eltejaei.mydigikala.databinding.SignUpFragmentBinding
import fahimeh.eltejaei.mydigikala.network.errorHandling.Status
import fahimeh.eltejaei.mydigikala.ui.login.LoginFragmentDirections
import fahimeh.eltejaei.mydigikala.utils.bases.BaseFragment

@AndroidEntryPoint
class SignUpFragment : BaseFragment<SignUpFragmentBinding,SignUpViewModel>(R.layout.sign_up_fragment) {



    override fun init() {

    }

    override val viewModel: SignUpViewModel by viewModels()

    override fun observeLiveData() {
        viewModel.signUpUserResponse.observe(viewLifecycleOwner){
            if(it.status == Status.ERROR){
//                if(it.code == 400) showMessage("user or password is not correct")
                showMessage(it.message.orEmpty())
            }else{
                if(it.data != null && !it.data.token.isNullOrBlank()){
                    openHomeFragment()
                    viewModel.saveToken(it.data.token)
                }
            }
        }
    }

    private fun openHomeFragment() {
        findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToHomeNav())
    }


}