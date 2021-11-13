package practise
import chisel3._

class FullAdder extends Module {
    val io = IO(new Bundle{
        val a = Input(UInt(1.W))
        val b = Input(UInt(1.W))
        val cin = Input(UInt(1.W))
        val sum = Output(UInt(1.W))
        val carry = Output(UInt(1.W))
    })
    io.sum := (io.a ^ io.b) ^ io.cin
    io.carry := (io.a & io.b) + (io.a & io.cin) + (io.b & io.cin)
}