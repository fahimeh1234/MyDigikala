package fahimeh.eltejaei.mydigikala.network.dataModel.comment


import com.squareup.moshi.Json

data class sendCommentRequest(
    @Json(name = "body")
    val body: String?,
    @Json(name = "rate")
    val rate: Int?,
    @Json(name = "title")
    val title: String?
)