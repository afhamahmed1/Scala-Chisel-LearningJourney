// package lab3_Task1

// import chisel3._
// import chisel3.util
// import org.scalatest._
// import chiseltest._
// import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotation
// import scala.util.Random
// import BR_OP._


// class Branch_Test extends FreeSpec with ChiselScalatestTester{
//     "Branch Test" in{
//         test(new lab3_Task1()){c=>

//             for ( i <- 0 until 100){
//                 val ran = Random.nextInt(8)
//                 val result = WireInit(Bool())
//                 when (ran === BEQ){
//                     result := io.arg_x === io.arg_y
//                 }.elsewhen(ran === BNE){
//                     result := io.arg_x =/= io.arg_y
//                 }.elsewhen(ran === BNE){
//                     result := io.arg_x < io.arg_y
//                 }.elsewhen(ran === BNE){
//                     result := io.arg_x >= io.arg_y
//                 }.elsewhen(ran === BNE){
//                     result := io.arg_x <= io.arg_y
//                 }.elsewhen(ran === BNE){
//                     result := io.arg_x.asSInt >= io.arg_y.asSInt
//                 }.otherwise{
//                     result := false.B
//                 }
                 
                

//             }
//             c.io.arg
//         }
//     }
// }