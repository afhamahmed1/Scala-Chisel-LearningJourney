// package lab6_Ex3

// import chisel3._
// import chisel3.util._

// class Interface(val max : Int = 10, val min : Int = 0) extends Bundle{

// }

// class Two_Shot_Timer(val max : Int = 10, val min : Int = 0) extends Module{
//         val io = IO(new Bundle{
//             val reload = Input(Bool())
//             val out = Output(UInt(log2Ceil(max).W))
//             val out_on = Output(Bool())
//             val out_off = Output(Bool())
//     })
//     val counter = RegInit(min.U(log2Ceil(max)))
//     io.out_off := 1.B
//     io.out_on := 0.B
//     when(max.U === counter){
//         io.out_off := ~(io.out_off)
//         io.out_on := ~(io.out_on)
//         counter := 0.U
//         io.out := counter
//     }
//     .otherwise{
//         val next = counter + 1.U
//         counter := next
//         io.out := counter
//     }
// }
