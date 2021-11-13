package lab3_Task2
import chisel3._
import chiseltest._
import org.scalatest._
import chisel3.util._

class lab3_Task2_Test extends FreeSpec with ChiselScalatestTester {
    "lab3 task2 test" in{ 
    test(new lab3_Task2){ c =>
        c.io.input.poke("b00000000000000000000000001100011".U)
        }
    }
}