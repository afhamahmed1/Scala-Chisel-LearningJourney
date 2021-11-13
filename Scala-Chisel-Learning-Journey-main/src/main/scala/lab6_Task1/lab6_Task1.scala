package lab6
import chisel3._
import chisel3.util._


class shftRegPL (val len : Int = 3 ) extends Module {
    val io = IO (new Bundle {
        val out = Vec ( len , Output (Bool()))
        val load_in = Vec ( len , Input (Bool()))
        val in = Input (Bool())
        val load = Input (Bool())
    })
    // Start Coding here
    val m1 = Mux(io.load,io.load_in(0),io.in)
    val m2 = Mux(io.load,io.load_in(1),io.out(0))
    val m3 = Mux(io.load,io.load_in(2),io.out(1))

    val reg1 =  RegInit ( 1.U ( 32.W))
    val reg2 = RegInit ( 1.U ( 32.W ))
    val reg3 = RegInit( 1.U ( 32.W ) )

    val state1 = ( reg1 << 1) | m1
    val state2 = ( reg2 << 1) | m2
    val state3 = ( reg3 << 1) | m3

    reg1 := state1
    reg2 := state2
    reg3 := state3

    io.out(0) := reg1
    io.out(1) := reg2
    io.out(2) := reg3


    // End your code here
    // Well , you can actually write classes too . So , technically you have no
    // limit ; )
}