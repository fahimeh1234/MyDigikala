package fahimeh.eltejaei.mydigikala.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import fahimeh.eltejaei.mydigikala.R
import fahimeh.eltejaei.mydigikala.databinding.SplashFragmentBinding
import fahimeh.eltejaei.mydigikala.utils.bases.BaseFragment

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashFragmentBinding,SplashViewModel>(R.layout.splash_fragment) {

    override val viewModel: SplashViewModel by viewModels()

    override fun init() {

    }

    override fun observeLiveData() {
        viewModel.isTimerFinished.observe(viewLifecycleOwner){
           if(it){
               if(viewModel.isTokenValid.value == true){
                   openHomeFragment()
               }else{
                   openLoginFragment()
               }
           }

        }

//        viewModel.isTokenValid.observe(viewLifecycleOwner){
//            if(it) openHomeFragment()
//        }
    }



    private fun openHomeFragment() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeNav())
    }

    private fun openLoginFragment() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMainNav())
    }


}