package fahimeh.eltejaei.mydigikala.network.dataModel.comment


import com.squareup.moshi.Json

data class Data(
    @Json(name = "posts")
    val posts: List<ProductComment>?
)