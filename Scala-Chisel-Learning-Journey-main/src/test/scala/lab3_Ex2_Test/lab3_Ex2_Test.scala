package lab3_Ex2
import chisel3._
import chiseltest._
import org.scalatest._
import chisel3.util._

class lab3_Ex2_Test extends FreeSpec with ChiselScalatestTester{
    "lab3 Ex2" in{
        test(new lab3_Ex2) {c=>
        c.io.in_a.poke(32.U)
        c.io.in_b.poke(32.U)
        c.io.fun.poke("b01000".U)
        c.io.out.expect(0.U)
        
        
        //println("Last output value :" + c.io.out.peek().litValue)
        }
    }
} 