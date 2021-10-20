package fahimeh.eltejaei.mydigikala.network.dataModel.login

import com.squareup.moshi.Json

data class LoginResponse( @Json(name = "token")
                          val token:String?)
