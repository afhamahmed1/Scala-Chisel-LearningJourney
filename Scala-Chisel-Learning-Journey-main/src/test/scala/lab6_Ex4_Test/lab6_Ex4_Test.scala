package lab6_Ex4

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._
class Test_MyQueue extends FreeSpec with ChiselScalatestTester{
    "test MY Queue" in {
        test(new MyQueue){ c=>
            
            c.io.in.valid.poke(true.B)
            c.io.out.ready.poke(true.B)
            c.io.in.bits.poke("b11111".U)
            println(c.io.out.bits.peek())
            c.clock.step()
            println(c.io.out.bits.peek())
            c.clock.step()
            println(c.io.out.bits.peek())
            c.clock.step()
            println(c.io.out.bits.peek())
            c.clock.step()
            println(c.io.out.bits.peek())
            c.clock.step()
            println(c.io.out.bits.peek())
            c.clock.step()
            println(c.io.out.bits.peek())
            c.clock.step()
            println(c.io.out.bits.peek())
            c.clock.step()
            println(c.io.out.bits.peek())
            c.clock.step()

        }
    }
}