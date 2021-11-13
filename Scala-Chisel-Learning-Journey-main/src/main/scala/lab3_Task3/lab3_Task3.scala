//Task 3: To understand the concept of Valid interface, write a code of 2 to 4 Decoder and wrap the output in Valid construct. Skeleton code for this task is available in Listing 3.12. Block level diagram of immediate extension is shown in Figure 3.8.

package lab3_Task3 
import chisel3._
import chisel3.util._

class interface extends Bundle {
    val in = Input(UInt(2.W))
    val out = Valid(Output(UInt(4.W)))
}
class lab3_Task3 extends Module{
    val io = IO(new interface)
    io.out.bits := 0.U
    io.out.valid := 0.U
    switch (io.in){
        is ("b00".U){
            io.out.bits := "b0001".U
            io.out.valid := 1.U
        }
        is ("b01".U){
            io.out.bits := "b0010".U
            io.out.valid := 1.U
        }
        is ("b10".U){
            io.out.bits := "b0100".U
            io.out.valid := 1.U
        }
        is ("b11".U){
            io.out.bits := "b1000".U
            io.out.valid := 1.U
        }
    }

}