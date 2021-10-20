package fahimeh.eltejaei.mydigikala.ui.detail

import com.xwray.groupie.databinding.BindableItem
import fahimeh.eltejaei.mydigikala.R
import fahimeh.eltejaei.mydigikala.databinding.ItemCommentBinding
import fahimeh.eltejaei.mydigikala.network.dataModel.comment.ProductComment
import fahimeh.eltejaei.mydigikala.network.dataModel.comment.ResponseProductComment

class CommentItem (val comment: ProductComment, val onClick: (Int) -> Unit): BindableItem<ItemCommentBinding>(){
    override fun bind(dataBinding: ItemCommentBinding, position: Int) {
        dataBinding.comment = comment
        dataBinding.cardComment.setOnClickListener {
//            onClick.invoke(comment. ?: 0)
        }
    }

    override fun getLayout()= R.layout.item_comment
}