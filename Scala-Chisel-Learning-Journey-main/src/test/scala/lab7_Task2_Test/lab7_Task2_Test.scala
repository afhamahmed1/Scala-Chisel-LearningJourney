package lab7
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3 . util . _

class Manchester_Encoding_test extends FreeSpec with ChiselScalatestTester{
    "manchester" in  {
        test (new Manchester_Encoding){c=>
        c.io.in.poke(1.U)
        c.io.start.poke(1.B)
        c.clock.step(50)
        }
    }
}