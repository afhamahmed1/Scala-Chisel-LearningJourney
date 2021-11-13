package lab3_Task1

import chisel3._
import chisel3.util
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
import scala.util.Random
import BR_OP._


class Branch_Test extends FreeSpec with ChiselScalatestTester{
    "Branch Test" in{
        test(new lab3_Task1()){c=>

            for ( i <- 0 until 100){
                //val ran = Random.nextLong() && 0x7
                 val ran = Random.nextInt(7)
                 val src_a = Random.nextLong() & 0xFFFFFFFFL
                 val src_b = Random.nextLong() & 0xFFFFFFFFL
                 var result = true.B
                 val br = true.B

                 if (ran == 0){
                     result = (src_a == src_b).B
                 }else if (ran == 1){
                     result = (src_a != src_b).B
                 }else if (ran == 4){
                     result = (src_a < src_b).B
                 }else if (ran == 5){
                     result = (src_a >= src_b).B
                 }else if (ran == 6){
                     result = (src_a < src_b).B
                 }else if (ran == 7){
                     result = (src_a >= src_b).B
                 }else{
                     result = false.B
                 }
                 println(s"a: $src_a")
                 println(s"b: $src_b")
                 println(s"ran:$ran")
                 println(s"result: $result")

                //  when (ran.asInstanceOf[Int] === BEQ){
                //      result := (src_a === src_b).asInstanceOf[Bool]
                //  }.whenelse(ran.asInstanceOf[Int] === BNE){
                //      result := (src_a =/= src_b).asInstanceOf[Bool]
                //  }.whenelse(ran.asInstanceOf[Int] === BLT){
                //      result := (src_a < src_b).asInstanceOf[Bool]
                //  }.whenelse(ran.asInstanceOf[Int] === BGE){
                //      result := (src_a >= src_b).asInstanceOf[Bool]
                //  }.whenelse(ran.asInstanceOf[Int] === BLTU){
                //      result := (src_a <= src_b).asInstanceOf[Bool]
                //  }.whenelse(ran.asInstanceOf[Int] === BGEU){
                //      result := (src_a.asSInt >= src_b.asSInt).asInstanceOf[Bool]
                //  }.otherwise{
                //      result := false.B
                //  }

                c.io.fnct3.poke(ran.U)
                c.io.branch.poke(true.B)
                c.io.arg_x.poke(src_a.U)
                c.io.arg_y.poke(src_b.U)
                c.io.br_taken.expect(result)
                val a = c.io.br_taken.peek()
                val b = c.io.fnct3.peek()
                val d = c.io.arg_x.peek()
                val e = c.io.arg_y.peek()
                println(s"arg x: $d")
                println(s"arg y: $e")
                println(s"br_taken: $a")
                println(s"fnct3: $b")
            
                c.clock.step(1)


            }
            c.clock.step(2)
        }
    }
}