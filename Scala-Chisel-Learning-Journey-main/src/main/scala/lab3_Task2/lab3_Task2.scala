//Task 2: Immediate extension is a key part of decode stage and needs to provide sign extended immediate to the execute stage. Implement an RV32I standard immediate extension module using skeleton code available in Listing 3.11. Block level diagram of immediate extension is shown in Figure 3.7.

package lab3_Task2
import chisel3._
import chisel3.util._

class interface extends Bundle{
    val input = Input(UInt(32.W))
    val imm_se = Output(SInt(32.W))
}

class lab3_Task2 extends Module{
    val io = IO(new interface)

    
    when (io.input(7,0) === "b0110011".U || io.input(7,0) === "b0111011".U){
        io.imm_se := 0.S
    }
    .elsewhen( io.input(7,0) === "b0000011".U || io.input(7,0) === "b0001111".U || io.input(7,0) === "b0010011".U || io.input(7,0) === "b0011011".U || io.input(7,0) === "b1100111".U || io.input(7,0) === "b1110011".U){ // I Type
        
        io.imm_se := (io.input(31, 20)).asSInt
    }
    .elsewhen( io.input(7,0) === "b0100011".U){ // S Type
        
        io.imm_se := (Cat(io.input(31, 25), io.input(11, 7))).asSInt
    }
    .elsewhen( io.input(7,0) === "b1100011".U){ // SB Type
        
        io.imm_se := (Cat(io.input(31),io.input(7),io.input(30, 25),io.input(11,8), "b0".U)).asSInt
    }
    .elsewhen( io.input(7,0) === "b0010111".U || io.input(7,0) === "b0110111".U){ // U Type
        
        io.imm_se := Cat(io.input(31, 12), "b000000000000".U).asSInt
    }
    .elsewhen( io.input(7,0) === "b1101111".U){ // UJ Type
        
        io.imm_se := Cat(io.input(31),io.input(19, 12),io.input(20),io.input(30, 21), "b0".U).asSInt
    }.otherwise{
        io.imm_se := 0.S
    }

    
}
