package lab3_Task1
import chisel3._
import org.scalatest._
import chiseltest._
import chisel3.util._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class lab3_Task1_Test extends FreeSpec with ChiselScalatestTester {
    "lab3 Task1 test" in{ 
        test(new lab3_Task1){ c=> 
            c.io.fnct3.poke("b111".U)
            c.io.branch.poke(true.B)
            c.io.arg_x.poke(32.U)
            c.io.arg_y.poke(32.U)
        }
    }
}