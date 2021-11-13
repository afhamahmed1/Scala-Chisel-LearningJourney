//Exercise 2: Write Chisel code for a standard RISCV ALU using switch, is statements
package lab3_Ex2
import chisel3._
import chisel3.util._

trait Config {
    val WLEN = 32
    val ALUOP_SIG_LEN = 5
}
object ALUOP{
    val ALU_ADD = "b00000".U
    val ALU_SUB = "b01000".U
    val ALU_AND = "b00111".U
    val ALU_OR = "b00110".U
    val ALU_XOR = "b00100".U
    val ALU_SLT = "b00010".U
    val ALU_SLL = "b00001".U
    val ALU_SLTU = "b00011".U
    val ALU_SRL = "b00101".U
    val ALU_SRA = "b01100".U
    val ALU_COPY_A = "b01001".U
    val ALU_COPY_B = "b01010".U
    val ALU_FN_X = BitPat("b????")

    val ALU_BEQ = "b10000".U
    val ALU_BNE = "b10001".U
    val ALU_BLT = "b10100".U
    val ALU_BGE = "b10101".U
    val ALU_BLTU = "b10110".U
    val ALU_BGEU = "b10111".U
}
class interface extends Bundle with Config {
    val in_a = Input(UInt(WLEN.W))
    val in_b = Input(UInt(WLEN.W))
    val fun = Input(UInt(ALUOP_SIG_LEN.W))
    val out = Output(UInt(WLEN.W))
    val sum = Output(UInt(WLEN.W))
    val cmp = Output(UInt(WLEN.W))
}

class lab3_Ex2 extends Module with Config {
    val io = IO(new interface)
    
    io.out := 0.U
    io.sum := 0.U
    io.cmp := 0.U
    switch (io.fun){
        is (ALUOP.ALU_ADD ) {
            io.out := ((io.in_a).asSInt + (io.in_b).asSInt).asUInt
        }
        is (ALUOP.ALU_SUB){
            io.out := ((io.in_a).asSInt - (io.in_b).asSInt).asUInt
            io.sum := ((io.in_a).asSInt - (io.in_b).asSInt).asUInt
        }
        is (ALUOP.ALU_AND){
            io.out := ((io.in_a).asSInt & (io.in_b).asSInt).asUInt
        }
        is (ALUOP.ALU_OR){
            io.out := ((io.in_a).asSInt | (io.in_b).asSInt).asUInt
        }  
        is (ALUOP.ALU_XOR){
            io.out := ((io.in_a).asSInt ^ (io.in_b).asSInt).asUInt
        }  
        is (ALUOP.ALU_SLT){
            io.out := ((io.in_a).asSInt < (io.in_b).asSInt).asUInt
        }  
        is (ALUOP.ALU_SLL){
            io.out := ((io.in_a).asSInt << io.in_b(4,0)).asUInt
        }  
        is (ALUOP.ALU_SLTU){
            io.out := io.in_a < io.in_b
        }     
         is (ALUOP.ALU_SRL){
             io.out := ((io.in_a).asSInt >> io.in_b(4,0)).asUInt
        }  
        is (ALUOP.ALU_SRA){
            io.out := ((io.in_a).asSInt >> io.in_b(4,0)).asUInt
        }  
        is (ALUOP.ALU_BEQ){
            io.out := (0.S +& (io.in_a === io.in_b).asSInt).asUInt
            io.cmp := (0.S +& (io.in_a === io.in_b).asSInt).asUInt
        }
        is (ALUOP.ALU_BNE){
            io.out := (0.S +& (io.in_a =/= io.in_b).asSInt).asUInt
            io.cmp := (0.S +& (io.in_a =/= io.in_b).asSInt).asUInt
        }
        is (ALUOP.ALU_BLT){
            io.out := (0.S +& (io.in_a < io.in_b).asSInt).asUInt
            io.cmp := (0.S +& (io.in_a < io.in_b).asSInt).asUInt
        }
        is (ALUOP.ALU_BGE){
            io.out := (0.S +& (io.in_a >= io.in_b).asSInt).asUInt
            io.cmp := (0.S +& (io.in_a >= io.in_b).asSInt).asUInt
        }
        is (ALUOP.ALU_BLTU){
            io.out := 0.U +& (io.in_a < io.in_b)
            io.cmp := 0.U +& (io.in_a < io.in_b)
        }
        is (ALUOP.ALU_BGEU){
            io.out := 0.U +& (io.in_a >= io.in_b)
            io.cmp := 0.U +& (io.in_a >= io.in_b)
        }
        is (ALUOP.ALU_COPY_A){
            io.out := io.in_a
        }
        is (ALUOP.ALU_COPY_B){
            io.out := io.in_b
        }
        
        
    }
}