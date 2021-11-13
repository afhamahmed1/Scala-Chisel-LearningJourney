//Exercise 2: Write Chisel code for a standard RISCV ALU using switch, is statements
package lab4_Ex2
import chisel3._
import chisel3.util._

trait Config {
    val WLEN = 32
    val ALUOP_SIG_LEN = 5
}
object ALUOP{
    val ALU_ADD = 0.U(4.W)
    val ALU_SUB = 1.U(4.W)
    val ALU_AND = 2.U(4.W)
    val ALU_OR  = 3.U(4.W)
    val ALU_XOR = 4.U(4.W)
    val ALU_SLT = 5.U(4.W)
    val ALU_SLL = 6.U(4.W)
    val ALU_SLTU= 7.U(4.W)
    val ALU_SRL = 8.U(4.W)
    val ALU_SRA = 9.U(4.W)
    val ALU_COPY_A = 10.U(4.W)
    val ALU_COPY_B = 11.U(4.W)
    val ALU_XXX = 12.U(4.W) 
}
class interface extends Bundle with Config {
    val in_A = Input(UInt(WLEN.W))
    val in_B = Input(UInt(WLEN.W))
    val alu_Op = Input(UInt(ALUOP_SIG_LEN.W))
    val out = Output(UInt(WLEN.W))
    val sum = Output(UInt(WLEN.W))

}

class lab4_Ex2 extends Module with Config {
    val io = IO(new interface)
    
    io.out := 0.U
    io.sum := 0.U
    
    switch (io.alu_Op){
        is (ALUOP.ALU_ADD ) {
            io.out := io.in_A + io.in_B
        }
        is (ALUOP.ALU_SUB){
            io.out := io.in_A - io.in_B
            io.sum := io.in_A - io.in_B
        }
        is (ALUOP.ALU_AND){
            io.out := io.in_A & io.in_B
        }
        is (ALUOP.ALU_OR){
            io.out := io.in_A | io.in_B
        }  
        is (ALUOP.ALU_XOR){
            io.out := io.in_A ^ io.in_B
        }  
        is (ALUOP.ALU_SLT){
            //((io.in_A).asSInt < (io.in_B).asSInt).asUInt
            when ((io.in_A).asSInt < (io.in_B).asSInt){
                io.out := 1.U(32.W)
            }.otherwise{
                io.out := 0.U(32.W)
            }
        }  
        is (ALUOP.ALU_SLL){
            io.out := io.in_A << io.in_B(4,0)
        }  
        is (ALUOP.ALU_SLTU){
            when (io.in_A < io.in_B){
                io.out := 1.U(32.W)
            }.otherwise{
                io.out := 0.U(32.W)
            }
        }     
         is (ALUOP.ALU_SRL){
             io.out := io.in_A >> io.in_B(4,0)
        }  
        is (ALUOP.ALU_SRA){
            io.out := ((io.in_A).asSInt >> io.in_B(4,0)).asUInt
        }  

        is (ALUOP.ALU_COPY_A){
            io.out := io.in_A
        }
        is (ALUOP.ALU_COPY_B){
            io.out := io.in_B
        }
        is (ALUOP.ALU_XXX){
            io.out := 0.U
        }
        
        
    }
}