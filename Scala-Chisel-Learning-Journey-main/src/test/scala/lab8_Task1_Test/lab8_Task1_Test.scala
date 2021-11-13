package Lab8
import org.scalatest._
import chiseltest._
import chisel3._

class mem_assign_test extends FreeSpec with ChiselScalatestTester{
    "Memory assignment" in  {
        test (new mem_assign){c=>
        c.io.requestor(0).bits.poke(2.U)
        c.io.requestor(1).bits.poke(4.U)
        c.io.requestor(2).bits.poke(2.U)
        c.io.requestor(3).bits.poke(1.U)

        c.io.requestor(0).valid.poke(1.B)
        c.io.requestor(1).valid.poke(1.B)
        c.io.requestor(2).valid.poke(1.B)
        c.io.requestor(3).valid.poke(1.B)
        c.io.readaddr.poke(8.U)
        c.io.writeaddr.poke(8.U)
        c.io.write_en.poke(1.B)
        c.io.memory_out.ready.poke(1.B)
        
        c.clock.step(50)}}}