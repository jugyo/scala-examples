import blueeyes.{BlueEyesServer, BlueEyesServiceBuilder}
import blueeyes.concurrent.Future
import blueeyes.core.http.combinators.HttpRequestCombinators
import blueeyes.core.http.MimeTypes._
import blueeyes.core.http.HttpResponse
import blueeyes.core.data.BijectionsChunkString

trait MyService extends BlueEyesServiceBuilder with HttpRequestCombinators with BijectionsChunkString {
  val foo = service("foo", "0.1.0") { context =>
    request {
      path("/") {
        produce(text/plain) {
          get { request =>
            Future.sync(HttpResponse[String](content = Some("foo")))
          }
        }
      }
    }
  }
}

object Main extends BlueEyesServer with MyService
