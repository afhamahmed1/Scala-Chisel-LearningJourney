package lab3_Task2
import chisel3._
import chiseltest._
import org.scalatest._
import chisel3.util._

class testtest extends FreeSpec with ChiselScalatestTester{
    "lab" in{
        test(new test()){ c=>
        c.io.input.poke(2.U)
        c.io.output.expect("b00001".U)
        }
    }
}