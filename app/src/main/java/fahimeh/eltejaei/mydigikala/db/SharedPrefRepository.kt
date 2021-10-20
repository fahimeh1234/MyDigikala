package fahimeh.eltejaei.mydigikala.db

interface SharedPrefRepository {
    fun saveToken(token: String)
    fun getToken():String?
}