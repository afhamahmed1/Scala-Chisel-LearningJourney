package lab5_Ex1

import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import scala.util.Random


class alu_test extends FreeSpec with ChiselScalatestTester{
    "alu test" in {
        test(new ALU_Module1(32)) { c=>
            c.io.arg_x.poke(32.U)
            c.io.arg_y.poke(32.U)
            c.io.alu_oper.poke(2.U)
            c.io.alu_out.expect(64.U)

        }
    }
}


