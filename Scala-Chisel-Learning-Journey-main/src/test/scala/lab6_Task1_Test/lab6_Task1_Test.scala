
package lab6
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class shftregPLtest extends FreeSpec with ChiselScalatestTester{
    "shift Register PL."  in {
     test (new shftRegPL){ c =>
        c.io.load_in(0).poke(1.B)
        c.io.load_in(1).poke(1.B)
        c.io.load_in(2).poke(1.B)
        c.io.in.poke(1.B)
        c.io.load.poke(0.B)
        c.clock.step(50)
        }
    }
}