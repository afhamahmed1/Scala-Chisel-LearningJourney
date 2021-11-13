package lab5_Task1

import chisel3._
import chisel3.util._

class Adder(parameter: UInt) extends Module{
    
    val io = IO(new Bundle{
        val in0 = Input(parameter.cloneType)
        val in1 = Input(parameter.cloneType)
        val out = Output(parameter.cloneType)
    })

    io.out := (io.in1 + io.in0)

}