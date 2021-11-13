// //Exercise 1: In Listing 2.5, ﬁnd a way to use combinational hardware instead of the pre-deﬁned Mux module as done in Listing 2.4. The IO bundle must remain the same. (Hint: See Listing 2.2 for how to manipulate bits.)

// package lab2_Ex1
// import chisel3._
// import chisel3.util._

// class Mux_2to1_IO extends Bundle{
//     val in_A = Input(UInt(32.W))
//     val in_B = Input(UInt(32.W))
//     val sel = Input(Bool())
//     val output = Output(UInt())
// }

// class Mux_2t01 extends Module{
//     val io = IO(new Mux_2to1_IO)
     
//     io.output := io.in_A & io.sel | io.in_B & (~io.sel)
// }