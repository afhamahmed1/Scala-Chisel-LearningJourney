package lab3_Task3
import chisel3._
import chiseltest._
import org.scalatest._
import chisel3.util._

class lab3_Task3_Test extends FreeSpec with ChiselScalatestTester{
    "lab3 Task 3" in{
        test(new lab3_Task3) { c=>
        c.io.in.poke("b01".U)
        }
    }
}