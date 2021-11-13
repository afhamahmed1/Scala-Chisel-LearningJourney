
package lab5_Ex2

import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import scala.util.Random

class eMux_Test extends FreeSpec with ChiselScalatestTester {
    "EMUX Test" in {
        test(new eMux()){ c=>
            c.io.in_a.poke(2.U)
            c.io.in_b.poke(3.U)
            c.io.sel.poke(true.B)
            c.io.output.expect(2.U)

        }
    }
}