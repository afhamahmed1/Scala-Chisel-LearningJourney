package lab6_Ex2

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class counter_Test extends FreeSpec with ChiselScalatestTester{
    "counter Test" in {
        test(new counter(10)) { c => 
            println(c.io.out.peek())
            c.clock.step()
            println(c.io.out.peek())
            c.clock.step()
            println(c.io.out.peek())
            c.clock.step()
            println(c.io.out.peek())
            c.clock.step()
            println(c.io.out.peek())
            c.clock.step()
            println(c.io.out.peek())
            c.clock.step()
            println(c.io.out.peek())
            c.clock.step()
            println(c.io.out.peek())
            c.clock.step()
            println(c.io.out.peek())
            c.clock.step()
            println(c.io.out.peek())
            c.clock.step()
            println(c.io.out.peek())
            c.clock.step()
            println(c.io.out.peek())
            c.clock.step()
            println(c.io.out.peek())
            c.clock.step()
            println(c.io.out.peek())
            c.clock.step()
            println(c.io.out.peek())
            c.clock.step()
            println(c.io.out.peek())
            c.clock.step()
        }
    }
}