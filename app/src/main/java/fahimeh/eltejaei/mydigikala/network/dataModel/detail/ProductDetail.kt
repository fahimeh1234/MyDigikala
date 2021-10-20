package fahimeh.eltejaei.mydigikala.network.dataModel.detail


import com.squareup.moshi.Json

data class ProductDetail(
    @Json(name = "data")
    val `data`: List<Data>?,
    @Json(name = "message")
    val message: String?,
    @Json(name = "status")
    val status: String?
)