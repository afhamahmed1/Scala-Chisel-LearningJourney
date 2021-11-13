// //Exercise 1: Refer to Listing 3.3, implement 4 to 2 encoder using switch-is statements.
// package lab3_Ex1
// import chisel3._
// import chisel3.util._

// class interface extends Bundle{
//     val in = Input(UInt(4.W))
//     val out = Output(UInt(2.W))
// }
// class lab3_Ex1 extends Module{
//     val io = IO(new interface)
//     io.out = 0.U
//     switch (io.in){
//         is ("b0000".U){
//             io.out := "b00".U
//         }
//         is ("b0010".U){
//             io.out := "b01".U
//         }
//         is ("b0100".U){
//             io.out := "b10".U
//         }
//         is ("b1000".U){
//             io.out := "b11".U
//         }
//     }
// }