// package lab2_Ex1
// import chisel3._
// import org.scalatest._
// import chiseltest._
// import chisel3.util._


// class lab2_Ex1_Test extends FreeSpec with ChiselScalatestTester {
//     "Lab2 Ex.1 test" in {
//         test(new Mux_2t01()){ c =>
//             c.io.in_A.poke(32.U)
//             c.io.in_B.poke(32.U)
//             c.io.sel.poke(1. B)
//             c.clock.step(30)
//         }
//     }
// }