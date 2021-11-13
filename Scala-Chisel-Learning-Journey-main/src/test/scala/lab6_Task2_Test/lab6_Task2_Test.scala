package lab6
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class updowntest extends FreeSpec with ChiselScalatestTester{
    "up down"  in {
     test (new updown){ c =>
        c.io.set.poke(0.B)
        c.clock.step(50)
        }
    }
}