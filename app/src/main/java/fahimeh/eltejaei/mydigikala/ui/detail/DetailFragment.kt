package fahimeh.eltejaei.mydigikala.ui.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.databinding.BindableItem
import dagger.hilt.android.AndroidEntryPoint
import fahimeh.eltejaei.mydigikala.R
import fahimeh.eltejaei.mydigikala.databinding.DetailFragmentBinding
import fahimeh.eltejaei.mydigikala.network.GlobalNavigationHandler
import fahimeh.eltejaei.mydigikala.network.GlobalNavigator
import fahimeh.eltejaei.mydigikala.network.dataModel.comment.Data
import fahimeh.eltejaei.mydigikala.network.dataModel.comment.ProductComment
import fahimeh.eltejaei.mydigikala.network.dataModel.comment.ResponseProductComment
import fahimeh.eltejaei.mydigikala.network.errorHandling.Status
import fahimeh.eltejaei.mydigikala.utils.bases.BaseFragment
import fahimeh.eltejaei.mydigikala.utils.loadImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@AndroidEntryPoint
class DetailFragment : BaseFragment<DetailFragmentBinding, DetailViewModel>(R.layout.detail_fragment),
    GlobalNavigationHandler {

    override val viewModel: DetailViewModel by viewModels()

    override fun init() {
        val productId = DetailFragmentArgs.fromBundle(requireArguments()).productId
        viewModel.productId = productId
        viewModel.getProductDetail(productId.toString())
        viewModel.getComments(productId.toString())

    }

    override fun observeLiveData() {
        viewModel.productDetailResponse.observe(viewLifecycleOwner) {
            if (it.status == Status.ERROR) showMessage(it.message.orEmpty())
            else {
               val productDetail = it.data?.data
                binding.txtTitle.text = productDetail?.get(0)?.title
                binding.txtDescription.text = productDetail?.get(0)?.description
                binding.txtPrice.text = productDetail?.get(0)?.price.toString()
                binding.imgProduct.loadImage(productDetail?.get(0)?.imageUrl?:"")

            }
        }


        viewModel.commentResponse.observe(viewLifecycleOwner){
            if (it.status == Status.ERROR) showMessage(it.message.orEmpty())
            else {
                setRecycleViewData(it.data?.data)
            }
        }

        viewModel.sendCommentResponse.observe(viewLifecycleOwner) {

            if (it.status == Status.ERROR){
                if(it.code == 401) {
                    showMessage(it.message.orEmpty())
//                   findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToMainNav())
                }else{
                    showMessage(it.message.orEmpty())
                }
            }
            else {
                setRecycleViewData(it.data?.data)
            }
        }
    }

    private fun setRecycleViewData(data: Data?) {
        val adapter = GroupieAdapter()
        val CommentListItem = mutableListOf<BindableItem<*>>()
        data?.posts?.forEachIndexed { index, comment ->
            CommentListItem.add(CommentItem(comment = ProductComment(comment.id,comment.title)) {

            })
        }
        adapter.addAll(CommentListItem)
        binding.rvComments.adapter = adapter

    }

    override fun logout() {
        CoroutineScope(Dispatchers.Main).launch {
            showMessage("Must be go to login fragment")
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToLoginFragment2())

        }

    }

    override fun onStart() {
        super.onStart()
        GlobalNavigator.registerHandler(this)
    }

    override fun onStop() {
        super.onStop()
        GlobalNavigator.unregisterHandler()
    }
}