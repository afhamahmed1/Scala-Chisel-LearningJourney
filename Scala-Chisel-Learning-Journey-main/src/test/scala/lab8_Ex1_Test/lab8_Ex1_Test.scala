package Lab8

import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class Forwarding_Test extends FreeSpec with ChiselScalatestTester{
    "Forwarding Test" in  {
        test (new Forwarding){c=>
        c.io.enable.poke(1.B)
        c.io.write.poke(1.B)
        c.io.addr.poke(6.U)
        c.io.mask.poke(0.U)
    
        c.io.data_in.poke(555.U)
        
        c.clock.step(50)
        }
    }
}