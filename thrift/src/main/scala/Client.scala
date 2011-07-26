import org.apache.thrift._
import org.apache.thrift.protocol._
import org.apache.thrift.server._
import org.apache.thrift.transport._

object Client {
  def main(args: Array[String]): Unit = {
    val transport = new TSocket("localhost", 8080)
    val protocol = new TBinaryProtocol(transport)
    // サーバに接続
    transport.open()
    val foo = new Foo.Client(protocol)
    // サービス呼び出し
    println("[Client] foo.sum(%s, %s)".format(1.1, 2.2))
    val res = foo.sum(1.1, 2.2)
    println("[Client] %s".format(res))
  }
}
