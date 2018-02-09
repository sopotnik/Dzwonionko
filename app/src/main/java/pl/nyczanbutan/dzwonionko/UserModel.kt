package pl.nyczanbutan.dzwonionko

class UserModel(map: HashMap<String, String>) {
    var id = map["id"].toString()
    var login = map["login"].toString()
    var password = map["password"].toString()
    var email = map["email"].toString()
    var phonenumber = map["phonenumber"].toString()
    var name = map["name"].toString()
    var surname = map["surname"].toString()
    var birthdate = map["birthdate"].toString()
    var sex = map["sex"].toString()

}