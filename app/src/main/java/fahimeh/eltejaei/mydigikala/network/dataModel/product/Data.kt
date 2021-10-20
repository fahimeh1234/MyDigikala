package fahimeh.eltejaei.mydigikala.network.dataModel.product


import com.squareup.moshi.Json

data class Data(
    @Json(name = "posts")
    val posts: List<Product>?
)