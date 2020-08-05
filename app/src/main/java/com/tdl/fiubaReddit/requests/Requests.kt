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

        val url = "http://192.168.0.125:8080/post";
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

        val posts = arrayListOf<Post>(unPost, otroPost, rePost)

        fun addComment(comment: UserComment, postId: Int) {
            posts[postId].comments.add(comment)
        }

        fun getPostComments(postId: Int) : Vector<UserComment> {
            return posts[postId].comments
        }

        fun getPostsOFFLINE() : ArrayList<Post> {
            posts[0].comments.add(
                UserComment(
                    "anonimo",
                    "hi",
                    "https://www.pinclipart.com/picdir/big/193-1931067_pixel-clipart-finn-50-x-50-px-png.png"
                )
            )
            posts[0].comments.add(
                UserComment(
                    "anonimo",
                    "holis",
                    "https://www.pinclipart.com/picdir/big/193-1931067_pixel-clipart-finn-50-x-50-px-png.png"
                )
            )
            posts[0].comments.add(
                UserComment(
                    "anonimo",
                    "aloha",
                    "https://www.pinclipart.com/picdir/big/193-1931067_pixel-clipart-finn-50-x-50-px-png.png"
                )
            )

            return posts;
        }


        public fun postPost(context: Context, title: String, text: String, image: String ) {
            Fuel.post(url, listOf("title" to title, "text" to text, "image" to image))
                .response { request, response, result ->
                    println(request)
                    println(response)
                    val (bytes, error) = result
                    println(error)
                    if (bytes != null) {
                        println("[response bytes] ${String(bytes)}")
                    }
                }
        }

        public fun getPosts(context: Context): ArrayList<Post> {

            val posts = arrayListOf<Post>()



            Fuel.get(url)
                .response { request, response, result ->
                println(request)
                println(response)
                val (bytes, error) = result
                println(error)
                if (bytes != null) {
                    println("[response bytes] ${String(bytes)}")
                    val parser: Parser = Parser.default()
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

        @JvmStatic fun createPost(title: String, body: String, image: String) {

            val newId = posts.size
            val newPost = Post(title, body, image, newId)
            posts.add(newPost)
        }
    }
}