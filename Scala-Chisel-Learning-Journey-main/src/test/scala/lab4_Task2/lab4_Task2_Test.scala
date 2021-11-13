package lab3_Task2
import chisel3._
import chiseltest._
import org.scalatest._
import chisel3.util._
import scala.util.Random

class immediate_Test extends FreeSpec with ChiselScalatestTester {
    "Immediate test" in{ 
        test(new lab3_Task2) { c =>
            val array = Array("0110011", "0111011", "0000011", "0001111", "0011011", "1100111", "1110011", "0100011", "1100011", "0010111", "0110111", "1101111")
            
            for(i<-0 until 100){
                val src = Random.nextLong() & 0xFFFFFFFFFFL
                val src_cast = src.toBinaryString.substring(0,25)
                val opr = array(Random.nextInt(12))
                //println(src_cast)
                //println(opr)
                val value = src_cast+ opr
                val opcode = value.substring(0,7)
                var result = 0
                println(opcode)
                println((value))
                
                // if opcode === "0110011" || opcode === "0111011"){
                //     result = 0

                // }else if (opcode === "0000011" || opcode === "0001111" || opcode === "0010011" || opcode === "0011011" || opcode === "1100111" || opcode === "1110011"){
                //     result = (value(31, 20)).asSInt
                // }else if(opcode === "0100011"){
                //     result = (Cat(value(31, 25), value(11, 7))).asSInt
                // }else if(opcode === "1100011" ){
                //     result = (Cat(value(31),value(7),value(30, 25),value(11,8), "b0".U)).asSInt
                // }else if(  opcode === "b0010111".U || opcode === "b0110111".U){
                //     result = Cat(value(31, 12), "b000000000000".U).asSInt
                // }else if(opcode === "b1101111".U){
                //     result = Cat(value(31),value(19, 12),value(20),value(30, 21), "b0".U).asSInt
                // }else{
                //     result = 0
                // }

                // c.io.input.poke(value.U)
                // c.io.imm_se.expect(result.S)


            



            }

            
        }
    }
}