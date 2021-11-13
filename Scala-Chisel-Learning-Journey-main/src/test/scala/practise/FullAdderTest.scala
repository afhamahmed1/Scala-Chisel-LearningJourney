package practise

import org.scalatest._
import chiseltest._
import chisel3._

class FullAdderTest extends FreeSpec with ChiselScalatestTester{
    "FullAdder Gate Test" in {
        test(new FullAdder()){ c=>
        c.io.a.poke(0.U)
        c.io.b.poke(0.U)
        c.io.cin.poke(0.U)
        c.clock.step(1)
        c.io.carry.expect(0.U)
        c.io.sum.expect(0.U)
        }
    }
}