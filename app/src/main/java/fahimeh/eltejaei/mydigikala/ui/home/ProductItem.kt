package fahimeh.eltejaei.mydigikala.ui.home

import com.xwray.groupie.databinding.BindableItem
import fahimeh.eltejaei.mydigikala.R
import fahimeh.eltejaei.mydigikala.databinding.ItemProductBinding
import fahimeh.eltejaei.mydigikala.network.dataModel.product.Product
import kotlinx.android.synthetic.main.item_product.view.*

class ProductItem (val product: Product, val onClick: (Int) -> Unit): BindableItem<ItemProductBinding>(){
    override fun bind(dataBinding: ItemProductBinding, position: Int) {
        dataBinding.product = product
        dataBinding.cardProduct.setOnClickListener {
            onClick.invoke(product.id ?: 0)
        }
    }

    override fun getLayout()= R.layout.item_product
}