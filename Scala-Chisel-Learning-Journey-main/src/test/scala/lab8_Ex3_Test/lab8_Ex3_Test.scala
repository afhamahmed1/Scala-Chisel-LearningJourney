package Lab8
import org.scalatest._
import chiseltest._
import chisel3._

class I_Mem_test extends FreeSpec with ChiselScalatestTester{
    "I Mem" in  {
        test (new I_Mem){c=>
        
        c.io.addr.poke(1.U)
        c.io.inst.expect(2323.U)
        c.clock.step(50)
        }
    }
}