import android.content.Context
import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.github.kittinunf.fuel.Fuel
import com.tdl.fiubaReddit.post.Post
import com.tdl.fiubaReddit.post.UserComment
import java.util.*
import kotlin.collections.ArrayList

class Requests {

    companion object {
        val server = "localhost:8080";

        val posts = arrayListOf<Post>()

        val unPost = Post(
            "Un gatito",
            "Esta es una foto de un gatito OwO",
            "https://i.imgur.com/F0cpTWT.jpg",
            0
        )

        val otroPost = Post(
            "Otro gatito",
            "Esta es otra foto de un gatito OwO",
            "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/cute-cat-captions-1563551865.jpg?crop=0.668xw:1.00xh;0.199xw,0&resize=480:*",
            1
        )

        val rePost = Post(
            "Un gatito",
            "Esta es una foto de un gatito OwO",
            "https://i.imgur.com/F0cpTWT.jpg",
            2
        )

        fun addComment(comment: UserComment, postId: Int) {
            posts[postId].comments.add(comment)
        }

        fun getPostComments(postId: Int) : Vector<UserComment> {
            return posts[postId].comments
        }

        fun getPostsOFFLINE() : ArrayList<Post> {
            unPost.comments.add(
                UserComment(
                    "anonimo",
                    "hi",
                    "https://www.pinclipart.com/picdir/big/193-1931067_pixel-clipart-finn-50-x-50-px-png.png"
                )
            )
            unPost.comments.add(
                UserComment(
                    "anonimo",
                    "hi",
                    "https://www.pinclipart.com/picdir/big/193-1931067_pixel-clipart-finn-50-x-50-px-png.png"
                )
            )
            unPost.comments.add(
                UserComment(
                    "anonimo",
                    "hi",
                    "https://www.pinclipart.com/picdir/big/193-1931067_pixel-clipart-finn-50-x-50-px-png.png"
                )
            )

            posts.add(unPost)
            posts.add(otroPost)
            posts.add(rePost)

            return posts;
        }


        public fun getPosts(context: Context): ArrayList<Post> {

            val url = "http://192.168.0.125:8080/post";

            val posts = arrayListOf<Post>()

            Fuel.get(url)
                .response { request, response, result ->
                println(request)
                println(response)
                val (bytes, error) = result
                println(error)
                if (bytes != null) {
                    println("[response bytes] ${String(bytes)}")
                    //val list: List<Post> = JSON.parse(Post.serializer().list, bytes)
                    val parser: Parser = Parser.default()
                    // val stringBuilder: StringBuilder = StringBuilder("{\"name\":\"Cedric Beust\", \"age\":23}")
                    val array = parser.parse(StringBuilder(String(bytes))) as JsonArray<JsonObject>

                    val titles = array.string("title")
                    val texts = array.string("text")
                    val images = array.string("image")

                    for (i in 0..titles.size-1){
                        val post = Post(titles[i].toString(), texts[i], images[i], i)
                        posts.add(post)
                    }
                }

            }

            return posts;
        }
    }
}