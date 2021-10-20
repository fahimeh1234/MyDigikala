package fahimeh.eltejaei.mydigikala.ui.home

import com.xwray.groupie.databinding.BindableItem
import fahimeh.eltejaei.mydigikala.R
import fahimeh.eltejaei.mydigikala.databinding.ItemProduct2Binding
import fahimeh.eltejaei.mydigikala.databinding.ItemProductBinding
import fahimeh.eltejaei.mydigikala.network.dataModel.product.Product
import kotlinx.android.synthetic.main.item_product.view.*

class ProductItem2 (val product: Product, val onClick: (Int) -> Unit): BindableItem<ItemProduct2Binding>(){
    override fun bind(dataBinding: ItemProduct2Binding, position: Int) {
        dataBinding.product = product
        dataBinding.cardProduct2.setOnClickListener {
            onClick.invoke(product.id ?: 0)
        }
    }

    override fun getLayout()= R.layout.item_product2
}