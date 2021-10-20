package fahimeh.eltejaei.mydigikala.network.dataModel.product


import com.squareup.moshi.Json

data class Product(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "mainImage")
    val mainImage: String?,
    @Json(name = "oldPrice")
    val oldPrice: Int?,
    @Json(name = "price")
    val price: Int?,
    @Json(name = "rate")
    val rate: Int?,
    @Json(name = "title")
    val title: String?
)