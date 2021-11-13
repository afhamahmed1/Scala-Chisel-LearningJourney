package lab5_Task3

import chisel3._
import chisel3.util._

class eMux(width : Int) extends Module{
    val io = IO(new Bundle{
        val in1 = Input(UInt(width.W))
        val in2 = Input(SInt(width.W))
        val sel = Input(Bool())
        val out = Output(SInt(width.W))


    })
    io.out := Mux(io.sel, io.in2, io.in1.asSInt)
}