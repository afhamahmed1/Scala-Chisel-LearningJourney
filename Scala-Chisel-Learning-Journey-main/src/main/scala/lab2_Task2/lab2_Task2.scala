// //Task 2: Write Chisel code of 4-bit Barrel shifter shown in Figure 2.5.

// package lab2_Task2
// import chisel3._
// import chisel3.util._

// class interface extends Bundle{
//     val in = Vec(4, Input(Bool()))
//     val sel = Vec(2, Input(Bool()))
//     val shift_type = Input(Bool())
//     val out = Vec(4, Output(Bool()))
// }
// class 4_to_1_Mux extends Module{
//     val io = IO(new Bundle{
//         val in1 = Input(Bool())
//         val in2 = Input(Bool())
//         val in3 = Input(Bool())
//         val in4 = Input(Bool())
//         val select = Vec(2, Input(Bool()))
//         val output = Output(Bool())
//     })
//     val sel = (Cat(select(0), select(1))).U
//     io.output := MuxCase(false.B, Array(
//         (sel(1) === 0.U) -> in1
//         (sel(1) === 1.U) -> in2
//         (sel(1) === 2.U) -> in3
//         (sel(1) === 3.U) -> in4
//     ))
// }

// class lab2_Task2 extends Module{
//     val io = IO(new interface)
//     io.out(1) := 4_to_1_Mux(io.input(1), io.input(2), io.input(3), io.input(4), io.sel(1))
//     io.out(2) := 4_to_1_Mux(io.input(1), io.input(2), io.input(3), Mux(io.shift_type, io.input(4), 0), io.sel(1))
//     io.out(3) := 4_to_1_Mux(io.input(1), io.input(2), Mux(io.shift_type, io.input(3), 0), Mux(io.shift_type, io.input(4), 0), io.sel(1))
//     io.out(4) := 4_to_1_Mux(io.input(1), Mux(io.shift_type, io.input(2), 0), Mux(io.shift_type, io.input(3), 0), Mux(io.shift_type, io.input(4), 0), io.sel(1))
// }