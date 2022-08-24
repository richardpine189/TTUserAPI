package com.user.db

import org.ktorm.database.Database

//local
object DatabaseConnection {
    val database = Database.connect(
        url = "jdbc:mysql://127.0.0.1:3306/user",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "root"
    )
}

val db = DatabaseConnection.database


//remote
/*object DatabaseConnection {
    val database = Database.connect(
        url = "jdbc:mysql://r98du2bxwqkq3shg.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/cy9ewqegtl96km6d",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "h6p5beml4d5nycfr",
        password = "of855uiqmpfwzhy2"
    )
}
*/
/* DATOS DE BD
mysql://h6p5beml4d5nycfr:of855uiqmpfwzhy2@r98du2bxwqkq3shg.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/cy9ewqegtl96km6d

 jdbc:  //alternativa para antes de mysql
 */