package lab6_Ex1

import chisel3._
import chisel3.util._

class Shift_Register(val Init: Int = 1) extends Module{
    val io = IO(new Bundle{
        val in = Input(UInt(4.W))//Flipped(Decoupled(UInt(4.W)))
        val sel = Input(Bool())
        val out = Output(UInt(4.W))
        
        
    })
    
    when (io.sel === true.B){
        val state = RegInit(0.U(4.W))
        io.out := state | io.in
        
    }.otherwise{
        
        val state = RegInit(Init.U(4.W))
        
        io.out := (state << 1) | io.in(0)
    }

}