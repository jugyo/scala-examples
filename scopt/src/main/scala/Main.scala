import scopt.OptionParser

object Main extends App {
  object config {
    var action:String = "start"
    var host:String = "localhost"
    var port:Int = 8080
  }

  val parser = new OptionParser("foo") {
    arg("<action>", "action", {v: String => config.action = v})
    intOpt("p", "port", "port number", {v: Int => config.port = v})
    opt("h", "host", "nostname", {v: String => config.host = v})
  }
  if (parser.parse(args)) {
     println(config.action)
     println(config.host)
     println(config.port)
  }
}
