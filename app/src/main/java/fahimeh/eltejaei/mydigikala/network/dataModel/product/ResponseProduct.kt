package fahimeh.eltejaei.mydigikala.network.dataModel.product


import com.squareup.moshi.Json

data class ResponseProduct(
    @Json(name = "data")
    val `data`: Data?,
    @Json(name = "message")
    val message: String?,
    @Json(name = "status")
    val status: String?
)