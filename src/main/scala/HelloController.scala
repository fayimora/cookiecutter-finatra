import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.finatra.request._
import com.twitter.finatra.validation._

case class HelloRequest(@NotEmpty @QueryParam name: Option[String])

class HelloController extends Controller {

  get("/") { request: Request =>
    response.ok.json("Welcome, please visit /hello")
  }

  get("/hello") { req: HelloRequest =>
    val name = req.name.getOrElse("Human")
    response.ok.json(Map("msg" -> s"Hi there ${name}!"))
  }
}
