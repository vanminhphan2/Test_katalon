package rio.demo.myapplication.data.serializer


//import androidx.datastore.core.CorruptionException
//import androidx.datastore.core.Serializer
//import com.google.protobuf.InvalidProtocolBufferException
//import java.io.InputStream
//import java.io.OutputStream
//
//object UserPreferencesSerializer : Serializer<UserPreferences> {
//    override fun readFrom(input: InputStream): UserPreferences {
//        try {
//            return UserPreferences.parseFrom(input)
//        } catch (exception: InvalidProtocolBufferException) {
//            throw CorruptionException("Cannot read proto.", exception)
//        }
//    }
//
//    override fun writeTo(t: UserPreferences, output: OutputStream) = t.writeTo(output)
//}