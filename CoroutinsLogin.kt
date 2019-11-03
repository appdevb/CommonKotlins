suspend fun login(username: String, password: String) : User {

    // code to fetch user

}

suspend fun homeFeed(id: String) : UserFeed {

    // code to fetch the home feed

}

fun inboxMessages(id: String) : List<Message> {

   // code to fetch the inbox messages

}

suspend fun main() = coroutineScope {

     val user = login("ahsensaeed", "12345")

     val homeFeedJob = async {

         homeFeed(user.id)

     }

     val inboxMessageJob = async {

         inboxMessages(user.id)

     }

     // Both homeFeedJob and inboxMessageJob are running in parallel. 

     val response = UserResponse(homeFeedJob.await(), inboxMessageJob.await())

         // handle user response

