package Lab7

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum
import chiseltest._
import org.scalatest._
import scala.util.Random

class TestFSM extends FreeSpec with ChiselScalatestTester{
    "FSM" in{
        test(new FSM()){z =>
        for(i <- 0 until 100){
            val f1 = Random.nextBoolean().B
            val f2 = Random.nextBoolean().B
            val r1 = Random.nextBoolean().B
            val r2 = Random.nextBoolean().B

            z.io.f1.poke(f1)
            z.io.f2.poke(f2)
            z.io.r1.poke(r1)
            z.io.r2.poke(r2)
            z.clock.step(1)
        }}
    }
}