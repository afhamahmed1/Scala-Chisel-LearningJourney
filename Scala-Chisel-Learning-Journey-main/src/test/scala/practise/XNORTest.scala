package practise

import org.scalatest._
import chiseltest._
import chisel3._

class XNORTest extends FreeSpec with ChiselScalatestTester{
    "XNOR Gate Test" in {
        test(new XNOR()){ c=>
        c.io.a.poke(1.U)
        c.io.b.poke(1.U)
        c.clock.step(1)
        c.io.output.expect(1.U)
        }
    }
}