//Task 1: In a standard RISC-V ALU whenever we have a branch instruction, the ALU computes it and tells the PC whether or not to jump to the immediate value. Implement the conditional branch module of a standard RV32I using combinational circuits and control constructs. A skeleton code is given in Listing 3.10, start coding in it. Block level diagram of conditional branch module is shown in Figure 3.6.

package lab3_Task1
import chisel3._
import chisel3.util._

class interface extends Bundle{
    val fnct3 = Input(UInt(3.W))
    val branch = Input(Bool())
    val arg_x = Input(UInt(32.W))
    val arg_y = Input(UInt(32.W))
    val br_taken = Output(Bool())
}
object BR_OP {
    val BEQ = "b000".U
    val BNE = "b001".U
    val BLT = "b100".U
    val BGE = "b101".U
    val BLTU = "b110".U
    val BGEU = "b111".U
}
import BR_OP._

class lab3_Task1 extends Module{
    val io = IO(new interface)

    when (io.branch === true.B){
       
        when (io.fnct3 === "b000".U){
            io.br_taken := io.arg_x === io.arg_y
            
        }.elsewhen(io.fnct3 === "b001".U){
            io.br_taken := io.arg_x =/= io.arg_y

        }.elsewhen(io.fnct3 === "b100".U){
            io.br_taken := io.arg_x < io.arg_y

        }.elsewhen(io.fnct3 === "b101".U){
            io.br_taken := io.arg_x >= io.arg_y

        }.elsewhen(io.fnct3 === "b110".U){
            io.br_taken := io.arg_x <= io.arg_y

        }.elsewhen(io.fnct3 === "b111".U){
            io.br_taken := io.arg_x.asSInt >= io.arg_y.asSInt
        }.otherwise{
            io.br_taken := false.B
        }

        
    }.otherwise{
        io.br_taken := false.B
    }




}