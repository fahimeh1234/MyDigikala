package fahimeh.eltejaei.mydigikala.network.dataModel.login

import com.squareup.moshi.Json

data class LoginRequest(
    @Json(name = "username")
    val username:String?
    ,
    @Json(name = "password")
    val password:String?)
