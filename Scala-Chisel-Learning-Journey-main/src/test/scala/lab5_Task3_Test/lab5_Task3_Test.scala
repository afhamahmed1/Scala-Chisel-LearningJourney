package lab5_Task3

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class eMux_Test extends FreeSpec with ChiselScalatestTester{
    "EMux Test" in {
        test(new eMux(32)){c =>
            c.io.in1.poke(32.U)
            c.io.in2.poke(23.S)
            c.io.sel.poke(true.B)
            c.io.out.expect(23.S)    
        }
    }
}