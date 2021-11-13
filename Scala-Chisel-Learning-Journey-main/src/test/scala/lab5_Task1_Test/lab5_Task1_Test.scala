package lab5_Task1

import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._

class Adder_Test extends FreeSpec with ChiselScalatestTester{
    "Adder Test" in {
        test(new Adder(UInt(32.W))){ c =>
            c.io.in0.poke(3.U)
            c.io.in1.poke(1.U)
            c.io.out.expect(4.U)
        }
    }
}