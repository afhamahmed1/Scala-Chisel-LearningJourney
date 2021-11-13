package practise

import org.scalatest._
import chiseltest._
import chisel3._

class NotTest extends FreeSpec with ChiselScalatestTester{
    "Not Gate Test" in {
        test(new Not()){ c=>
        c.io.c.poke(1.U)
        c.clock.step(1)
        c.io.output.expect(0.U)
        }
    }
}