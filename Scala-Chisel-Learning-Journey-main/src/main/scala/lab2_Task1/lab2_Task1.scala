// //Task 1: Write Chisel code for a 5-to-1 multiplexer with speciﬁcations given in Table 2.3. A skeleton code is also given in Listing 2.13; use it as a starting point and remember: only write your code is the space speciﬁed.


// package lab2_Task1
// import chisel3._
// import chisel3.util._

// class interface extends Bundle{
//     val s1 = Input(Bool())
//     val s2 = Input(Bool())
//     val s3 = Input(Bool())
//     val output = Output(UInt(32.W))
// }

// class lab2_Task1 extends Module{
//     val io = IO(new interface)
//     var sel = WireInit(Cat(s3, s2, s1).U)
//     io.output := MuxCase(false.B, Array(
//         (sel === "b000" )-> 0.U
//         (sel === "b001") -> 8.U
//         (sel === "b010") -> 16.U
//         (sel === "b011") -> 25.U
//         (sel === BitPat("b1??")) -> 32.U
//     ))
// }