package lab5_Ex3

import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import scala.util.Random

class Test_Operator extends FreeSpec with ChiselScalatestTester{
    "Test Operator" in { 
        test(new Operator(4, UInt(4.W))(_ + _)){ c =>
            c.io.in(0).poke(1.U)
            c.io.in(1).poke(2.U)
            c.io.in(2).poke(3.U)
            c.io.in(3).poke(4.U)
            c.io.out(0).expect(10.U)
            c.io.out(1).expect(10.U)
            c.io.out(2).expect(10.U)
            c.io.out(3).expect(10.U)
        }
        
    }
}