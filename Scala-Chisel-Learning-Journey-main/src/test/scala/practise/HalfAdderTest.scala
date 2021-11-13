package practise

import org.scalatest._
import chiseltest._
import chisel3._

class HalfAdderTest extends FreeSpec with ChiselScalatestTester{
    "HalfAdder Gate Test" in {
        test(new HalfAdder()){ c=>
        c.io.a.poke(1.U)
        c.io.b.poke(0.U)
        c.clock.step(1)
        c.io.carry.expect(0.U)
        c.io.sum.expect(1.U)
        }
    }
}