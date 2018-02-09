package pl.nyczanbutan.dzwonionko
import com.google.gson.Gson

class JsonHandler {
    fun convertToJson(toConvert:HashMap<String, String>): String{
        var jsonString = "{\"secret\": \"SecretToken\","
        for ((key, value) in toConvert) {
            jsonString = "$jsonString\"$key\": \"$value\", "
        }
        jsonString = jsonString.dropLast(2)
        jsonString = "$jsonString}"
        return jsonString
    }

    fun convertFromJson(toConvert: String) : ArrayList<HashMap<String, String>>{
        var product = ArrayList<HashMap<String, String>>()
        if( toConvert != "[]") {
            var list: List<String> = toConvert.split(Regex("""\}, \{"""))
            var outputList = ArrayList<String>()
            for(el in list){
                outputList.add("{$el}")
            }
            outputList[0] = outputList[0].substring(2)
            outputList[outputList.lastIndex] = outputList[outputList.lastIndex].dropLast(2)
            val type = HashMap<String, String>().javaClass
            val gson = Gson()
            for (el in outputList){
                product.add(gson.fromJson(el, type))
            }
        }
        return product
    }
}