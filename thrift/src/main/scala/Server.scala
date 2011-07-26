import org.apache.thrift._
import org.apache.thrift.protocol._
import org.apache.thrift.server._
import org.apache.thrift.transport._

/**
* Foo の実装
*/
class FooImpl extends Foo.Iface {
  override def sum(param1: Double, param2: Double): Double = {
    println("[Server] sum(%s, %s)".format(param1, param2))
    param1 + param2
  }
}

object Server {
  def main(args: Array[String]): Unit = {
    // サーバー起動に必要なパラメータたち
    val st = new TServerSocket(8080)
    val processor = new Foo.Processor(new FooImpl())
    val arg = new TThreadPoolServer.Args(st)
    arg.processor(processor)

    val server = new TThreadPoolServer(arg)
    // サーバー起動
    server.serve()
  }
}
