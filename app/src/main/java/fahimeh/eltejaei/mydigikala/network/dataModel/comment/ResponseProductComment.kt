package fahimeh.eltejaei.mydigikala.network.dataModel.comment


import com.squareup.moshi.Json

data class ResponseProductComment(
    @Json(name = "data")
    val `data`: Data?,
    @Json(name = "message")
    val message: String?,
    @Json(name = "status")
    val status: String?
)