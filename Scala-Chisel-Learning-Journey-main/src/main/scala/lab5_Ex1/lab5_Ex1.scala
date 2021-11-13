package lab5_Ex1
import chisel3._
import chisel3.util._



class ALU_Module1(width_parameter: Int) extends Module{
    val io = IO(new Interface(width_parameter))
    val index = log2Ceil(width_parameter)

    when(io.alu_oper === 0.U){
        io.alu_out := io.arg_x & io.arg_y
    }
    .elsewhen(io.alu_oper === 1.U){
        io.alu_out := io.arg_x | io.arg_y
    }
    .elsewhen(io.alu_oper === 2.U){
        io.alu_out := io.arg_x + io.arg_y
    }
    .elsewhen( io.alu_oper === 6.U){
        io.alu_out := io.arg_x - io.arg_y
    }
    .elsewhen( io.alu_oper === 3.U){
        io.alu_out := io.arg_x ^ io.arg_y
    }
    .elsewhen (io.alu_oper === 4.U){
        io.alu_out := io.arg_x << io.arg_y(index - 1, 0)
    }
    .elsewhen(io.alu_oper === 5.U){
        io.alu_out := io.arg_x >> io.arg_y ( index -1 , 0)
    }
    .elsewhen(io.alu_oper === 7.U){
        io.alu_out :=  (io.arg_x.asSInt >> io.arg_y ( index -1 , 0) ).asUInt
    }
    .elsewhen(io.alu_oper === 8.U){
        io.alu_out := (io.arg_x.asSInt < io.arg_y.asSInt).asUInt
    }
    .elsewhen(io.alu_oper === 9.U){
        io.alu_out := io.arg_x < io.arg_y
    }.otherwise{
        io.alu_out := 0.U
    }
}
class Interface(width_parameter : Int) extends Bundle {
    val arg_x = Input(UInt(width_parameter.W))
    val arg_y = Input(UInt(width_parameter.W))
    val alu_oper = Input(UInt(width_parameter.W))
    val alu_out = Output(UInt(width_parameter.W))
}
