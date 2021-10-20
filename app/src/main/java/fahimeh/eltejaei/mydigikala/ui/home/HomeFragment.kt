package fahimeh.eltejaei.mydigikala.ui.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.databinding.BindableItem
import dagger.hilt.android.AndroidEntryPoint
import fahimeh.eltejaei.mydigikala.R
import fahimeh.eltejaei.mydigikala.databinding.HomeFragmentBinding
import fahimeh.eltejaei.mydigikala.network.dataModel.product.Product
import fahimeh.eltejaei.mydigikala.network.errorHandling.Status
import fahimeh.eltejaei.mydigikala.utils.bases.BaseFragment

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>(R.layout.home_fragment) {
    override val viewModel: HomeViewModel by viewModels()


    override fun init() {
    }

    override fun observeLiveData() {
        viewModel.productResponse.observe(viewLifecycleOwner) {
            if (it.status == Status.ERROR) showMessage(it.message.orEmpty())
            else {
                it.data?.data?.posts?.let { productlist ->
                    createRecyclerView(productlist)
                }

            }
        }
    }

    private fun createRecyclerView(productlist: List<Product>) {
        val adapter = GroupieAdapter()
//        val productListItem = productlist.map{
//            ProductItem(it)
//        }

        val ProductListItem = mutableListOf<BindableItem<*>>()
        productlist.forEachIndexed { index, product ->

            if (index == 3) {
                ProductListItem.add(getPopularProductList(productlist))
            }
            ProductListItem.add(ProductItem(product) {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(it.toString()))
            })
        }
//        val productListItem = productlist.map{
//            ProductItem(it)
//        }
        adapter.addAll(ProductListItem)
        binding.rvProducts.adapter = adapter
    }

    private fun getPopularProductList(productlist: List<Product>): PopularProductItem {
        val list = productlist.filter { it.rate ?: 0 >= 4 }
        return PopularProductItem(list)

    }


}