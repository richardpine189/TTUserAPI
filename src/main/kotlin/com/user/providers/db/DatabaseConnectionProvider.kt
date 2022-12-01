package com.user.providers.db

import org.ktorm.database.Database

//local
object DatabaseConnectionProvider {
    val localDatabase = Database.connect(
        url = "jdbc:mysql://127.0.0.1:3306/user",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "root"
    )

    //Heroku
    /*val remoteDatabase = Database.connect(
        url = "jdbc:mysql://r98du2bxwqkq3shg.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/cy9ewqegtl96km6d",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "h6p5beml4d5nycfr",
        password = "of855uiqmpfwzhy2"
    )*/

    //DonWeb

}




/* DATOS DE BD
mysql://h6p5beml4d5nycfr:of855uiqmpfwzhy2@r98du2bxwqkq3shg.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/cy9ewqegtl96km6d

 jdbc:  //alternativa para antes de mysql
 */