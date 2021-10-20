package fahimeh.eltejaei.mydigikala.network.dataModel.detail


import com.squareup.moshi.Json

data class Data(
    @Json(name = "comments")
    val comments: List<Any>?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image_url")
    val imageUrl: String?,
    @Json(name = "oldPrice")
    val oldPrice: Int?,
    @Json(name = "price")
    val price: Int?,
    @Json(name = "rate")
    val rate: Int?,
    @Json(name = "title")
    val title: String?
)