package lab6_Ex1
import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class Shift_Register_Test extends FreeSpec with ChiselScalatestTester{
    "Shift Register Test" in {
        test(new Shift_Register) { c=>
            c.io.in.poke("b1000".U)
            c.io.sel.poke(false.B)
            println(c.io.out.peek())
                
        }
    }
}
