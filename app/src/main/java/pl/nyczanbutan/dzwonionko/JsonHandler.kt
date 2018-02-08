package pl.nyczanbutan.dzwonionko


class JsonHandler {
    public fun convertToJson(toConvert:HashMap<String, String>, method: String): String{
        var jsonString = "{"
        if (method == "POST"){
            jsonString = "$jsonString\"secret\": \"SecretToken\","
        }

        for ((key, value) in toConvert) {
            jsonString = "$jsonString\"$key\": \"$value\", "
        }
        jsonString = jsonString.dropLast(2)
        jsonString = "$jsonString}"
        return jsonString
    }
}