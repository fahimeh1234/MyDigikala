package fahimeh.eltejaei.mydigikala.ui.home

import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.databinding.BindableItem
import fahimeh.eltejaei.mydigikala.R
import fahimeh.eltejaei.mydigikala.databinding.ItemPopularProductsBinding
import fahimeh.eltejaei.mydigikala.network.dataModel.product.Product

class PopularProductItem (private val productlist: List<Product>): BindableItem<ItemPopularProductsBinding>(){
    override fun bind(dataBinding: ItemPopularProductsBinding, position: Int) {
        val adapter = GroupieAdapter()
//        val productItems = productlist.map(::ProductItem2)
        val productItems = productlist.map{
            ProductItem2(it) {
                dataBinding.root.findNavController().navigate(
                    fahimeh.eltejaei.mydigikala.ui.home.HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                        it.toString()
                    )
                )
            }
        }
        adapter.addAll(productItems)
        dataBinding.rvPopularProducts.adapter = adapter
    }

    override fun getLayout()= R.layout.item_popular_products
}