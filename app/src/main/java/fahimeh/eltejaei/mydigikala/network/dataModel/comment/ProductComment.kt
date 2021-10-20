package fahimeh.eltejaei.mydigikala.network.dataModel.comment

import com.squareup.moshi.Json

data class ProductComment (
    @Json(name = "id")
    val id: Int?,
    @Json(name = "title")
    val title: String?
)