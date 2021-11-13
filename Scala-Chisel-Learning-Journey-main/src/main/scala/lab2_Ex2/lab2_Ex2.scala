// // Exercise 2: In Listing 2.6, an 8-to-1 mux is created using mux tree or nested muxes while Listing 2.9 does the same but with MuxLookup. Try to alter Listing 2.9 by using nested MuxLookups. The ﬁrst MuxLookup will contain only two branches each of which will contain another MuxLookup. These next MuxLookups will contain four branches each.

// package lab2_Ex2
// import chisel3._
// import chisel3.util._

// class interface extends Bundle {
//     val inputs = Input(vec(8, (UInt(32.W))))
//     val selectab = Input(vec(2, (Bool())))
//     val selectc = Input(Bool())
//     val output = Output(UInt(32.W))
// }

// class lab2_Ex2 extends Module {
//     val io = IO(new interface)


//     val Mux_a = MuxLookup(io.selectab, false.B, Array(
//         (0.U) ->  io.inputs(0)
//         (1.U) ->  io.inputs(1)
//         (2.U) ->  io.inputs(2)
//         (3.U) ->  io.inputs(3)
//     ))
//     val Mux_b = MuxLookup(io.selectab, false.B, Array(
//         (0.U) ->  io.inputs(4)
//         (1.U) ->  io.inputs(5)
//         (2.U) ->  io.inputs(6)
//         (3.U) ->  io.inputs(7)        
//     ))

//     io.output := Muxlookup(io.selectc, false.C, Array(
//         (0.U) -> Mux_a
//         (1.U) -> Mux_b
//     ))
// }